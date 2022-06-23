package com.demo.resource.tree;

import com.demo.resource.Employee;

import java.util.List;

public class TreeUtils {

    /**
     * Pre-order Traversal
     */
    public void NLR(Node node) {
        if (node == null) return;
        Node parent = node.getParent();
        List<Node> childs = node.getChildren();
        String msg = String.format("level:%d，name:%s，parent:%s，childs:%d",
                node.getLevel(),
                ((Employee) node.getData()).getEmployeeName(),
                parent == null ? "null" : ((Employee) node.getParent().getData()).getEmployeeName(),
                childs == null ? 0 : childs.size());
        System.out.println(msg);
        childs.forEach(n -> {
            NLR(n);
        });
    }
}
