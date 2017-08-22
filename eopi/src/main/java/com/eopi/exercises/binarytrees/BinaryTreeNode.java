package com.eopi.exercises.binarytrees;

class BinaryTreeNode<T> {
    public String id;
    public T data;
    public BinaryTreeNode<T> leftChild;
    public BinaryTreeNode<T> rightChild;

    public BinaryTreeNode (T data, String id) {
        this.data = data;
        this.id = id;
    }

    @Override
    public String toString() {
        String retVal = "BinaryTreeNode{" +
                "id='" + id + '\'' +
                ", data=" + data +
                ", leftChild=";
        if (leftChild == null) {
            retVal += "null";
        } else {
            retVal += leftChild.data;
        }
        retVal += ", rightChild=";
        if (rightChild == null) {
            retVal += "null";
        } else {
            retVal += rightChild.data;
        }
        retVal += '}';
        return retVal;
    }
}
