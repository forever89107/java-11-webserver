package com.demo.resource;

import com.demo.resource.tree.BaseNode;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements BaseNode {
    public Integer employeeId;
    public String employeeName;
}
