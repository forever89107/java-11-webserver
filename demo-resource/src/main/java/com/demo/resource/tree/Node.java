package com.demo.resource.tree;


import lombok.Getter;
import lombok.Setter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class Node<T extends BaseNode> {
    protected T data;
    protected Node<T> parent;
    protected List<Node<T>> children;
    protected int level;

    /**
     * root Node construct
     */
    public Node() {
    }

    /**
     * Node construct
     */
    private Node(T data, Node parent) {
        this.data = data;
        this.children = new LinkedList<>();
    }

    /**
     * Add Next level Node
     */
    public Node<T> addChild(T data) {
        Node<T> childNode = new Node(data, this);
        childNode.data = data;
        childNode.parent = this;
        childNode.level = this.level + 1;
        this.children.add(childNode);

        return childNode;
    }

    /**
     * Get Next level Node
     */
    public Node getChild(T data) {
        if (!isLeaf()) {
            Iterator<Node<T>> it = children.iterator();
            while (it.hasNext()) {
                Node child = it.next();
                if (child.data.equals(data)) {
                    return child;
                }
            }
        }
        return null;
    }

    /**
     * Delete Next level Node
     */
    public void deleteChild(Node node) {
        if (!isLeaf()) {
            Iterator<Node<T>> it = children.iterator();
            while (it.hasNext()) {
                Node child = it.next();
                if (child.equals(node)) {
                    children.remove(child);
                    break;
                }
            }
        }
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        return this.children.size() == 0;
    }
}
