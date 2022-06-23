package com.demo.resource;

import com.demo.resource.tree.Node;
import com.demo.resource.tree.Tree;
import com.demo.resource.tree.TreeUtils;
import org.springframework.stereotype.Component;

@Component
public class Companny {

//    @PostConstruct
    public void initCompanny() {
        Employee employee1 = Employee.builder().
                employeeId(1).employeeName("林董").
                build();
        Employee employee2 = Employee.builder().
                employeeId(2).employeeName("金山").
                build();
        Employee employee3 = Employee.builder().employeeId(3).employeeName("Bevis").
                build();
        Employee employee4 = Employee.builder().
                employeeId(4).employeeName("Cody").
                build();
        Employee employee5 = Employee.builder().
                employeeId(5).employeeName("阿鼠").
                build();
        Employee employee6 = Employee.builder().
                employeeId(6).employeeName("Aron").
                build();
        Tree 林董 = new Tree(employee1);
        林董.getRoot().addChild(employee2);
        Node 金山 = 林董.getRoot().getChild(employee2);
        金山.addChild(employee3);
        金山.addChild(employee4);
        金山.addChild(employee5);
        Node Bevis = 金山.getChild(employee3);
        Bevis.addChild(employee6);
        new TreeUtils().NLR(林董.getRoot());

    }

    public String getEmpolyee(){
        return "跨謀組呼叫成功";
    }
}
