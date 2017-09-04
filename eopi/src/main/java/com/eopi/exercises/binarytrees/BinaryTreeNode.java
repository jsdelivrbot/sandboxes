package com.eopi.exercises.binarytrees;

public class BinaryTreeNode<T> {
    public String id;
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode<T> parent;

    public BinaryTreeNode (T data, String id) {
        this.data = data;
        this.id = id;
    }

    public BinaryTreeNode (T data, String id, BinaryTreeNode<T> parent) {
        this(data, id);

        this.parent = parent;
    }

    @Override
    public String toString() {
        String retVal = "BinaryTreeNode{" +
                "id='" + id + '\'' +
                ", data=" + data +
                ", left=";
        if (left == null) {
            retVal += "null";
        } else {
            retVal += left.data;
        }
        retVal += ", right=";
        if (right == null) {
            retVal += "null";
        } else {
            retVal += right.data;
        }
        retVal += '}';
        return retVal;
    }
}
