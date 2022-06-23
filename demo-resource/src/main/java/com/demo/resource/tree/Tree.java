package com.demo.resource.tree;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Getter
@Setter
public class Tree<T extends BaseNode> {
    protected Node<T> root;

    /**
     * root Node
     */
    public Tree(T rootData) {
        root = new Node<>();
        root.data = rootData;
        root.children = new ArrayList<>();
        root.level = 0;
    }

}
