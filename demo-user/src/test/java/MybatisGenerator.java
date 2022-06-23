import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.Collections;

public class MybatisGenerator {

    public static void main(String args[]) {
        String database = "demo_enterprise";
//        String database = "demo";
        String dir = "/demo-user"; //module 設定
        //1、DB connection config
        FastAutoGenerator.create("jdbc:postgresql://192.168.0.39:5432/" + database, "postgres", "pgsqladm")
                //2、Global config
                .globalConfig(builder -> {
                    builder.author("MBG") // 设置作者名
                            .outputDir(System.getProperty("user.dir") + dir + "/src/main/java") //output dir config
                            .commentDate("yyyy-MM-dd hh:mm:ss")   //時間戳記
                            .dateType(DateType.ONLY_DATE)   //TIME_PACK=LocalDateTime;ONLY_DATE=Date;
                            .fileOverride()   //覆蓋之前的文件
                            .enableSwagger()   //開啟 swagger 模式
                            .disableOpenDir() //禁止打開輸出目錄
                            .build();
                })
                //3、package config
                .packageConfig(builder -> {
                    builder.parent("com.demo.user") // parent package config
//                            .moduleName("demo-user")   //package Name config
                            .entity("entity")   //pojo entity
                            .service("service") //Service 包名
                            .serviceImpl("serviceImpl") // ***ServiceImpl 包名
                            .xml("mapperXML")  //Mapper XML 包名
                            .mapper("mapper")   //Mapper 包名
                            .controller("controller") //Controller 包名
                            .other("utils")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, System.getProperty("user.dir") + dir + "/src/main/resources/mapper")) //指定某類型檔案生成至指定位置
                            .build();
                })
                //4、strategy config
                .strategyConfig(builder -> {
                    builder.addInclude("personal_leave_form") // include table
                            .enableSkipView()// skip view gen
                            .serviceBuilder() // Service Builder
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .entityBuilder() // Entity Builder
                            // （重要）主鍵模式，配合mysql的自增主鍵 or 選擇none->自行使用java uuid
                            .idType(IdType.ASSIGN_UUID)
                            // activeRecord模式，使用上来说就是可以直接在entity上执行insert、update等操作
                            .enableActiveRecord()
                            .enableLombok() //open lombok
                            .disableSerialVersionUID()
                            .logicDeleteColumnName("deleted")
                            .naming(NamingStrategy.underline_to_camel)
                            .columnNaming(NamingStrategy.underline_to_camel)
//                            .addTableFills(new Column("create_time", FieldFill.INSERT), new Column("modify_time", FieldFill.INSERT_UPDATE))
//                            .enableTableFieldAnnotation()
                            .controllerBuilder() // Controller Builder
                            .formatFileName("%sController")
                            .enableRestStyle()
                            .mapperBuilder() // Mapper Builder
                            .enableBaseColumnList()
                            .superClass(BaseMapper.class)
//                            .formatMapperFileName("%sMapper")
                            .enableMapperAnnotation()       //@mapper
//                            .formatXmlFileName("%sMapper")
                            .build();
                })
                //5、template engine
                .templateEngine(new VelocityTemplateEngine())
                //6、execute
                .execute();
    }
}
