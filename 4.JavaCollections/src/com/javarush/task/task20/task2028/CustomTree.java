package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable{
    Entry<String> root = new Entry<>("");
    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }
    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }
    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }
    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }
    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean add(String newElement) {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> currentNode = queue.poll();
            currentNode.checkChildren();
            if (currentNode.isAvailableToAddChildren()) {
                if (currentNode.availableToAddLeftChildren){
                    currentNode.leftChild = new Entry<>(newElement);
                    currentNode.leftChild.parent = currentNode;
                    return true;
                } else if (currentNode.availableToAddRightChildren) {
                    currentNode.rightChild = new Entry<>(newElement);
                    currentNode.rightChild.parent = currentNode;
                    return true;
                }
            } else {
                if (currentNode.leftChild != null){
                    queue.offer(currentNode.leftChild);
                }
                if (currentNode.rightChild != null){
                    queue.offer(currentNode.rightChild);
                }
            }
        }
        return false;
    }
    @Override
    public boolean remove(Object s) {
        Entry<String> currentEntry = this.root;
        Queue<Entry<String>> queue = new LinkedList<>();
        while (!currentEntry.elementName.equals(s)) {
            if (currentEntry.leftChild != null) {
                queue.add(currentEntry.leftChild);
            }
            if (currentEntry.rightChild != null) {
                queue.add(currentEntry.rightChild);
            }
            currentEntry = queue.poll();
        }
        if (currentEntry.parent.leftChild.elementName.equals(s)) {
            currentEntry.parent.leftChild = null;
            currentEntry.parent = null;
            return true;
        } else if (currentEntry.parent.rightChild.elementName.equals(s)) {
            currentEntry.parent.rightChild = null;
            currentEntry.parent = null;
            return true;
        }
        return false;
    }

    String getParent(String entryName){
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> currentNode = queue.poll();
            if (currentNode.elementName.equals(entryName)){
                return currentNode.parent.elementName;
            } else {
                if (currentNode.leftChild != null) {
                    queue.offer(currentNode.leftChild);
                }
                if (currentNode.rightChild != null) {
                    queue.offer(currentNode.rightChild);
                }
            }
        }
        return null;
    }
    static class Entry<T> implements Serializable{
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;
        public Entry(String name) {
            this.elementName = name;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }
        void checkChildren() {
            if (leftChild != null) {
                this.availableToAddLeftChildren = false;
            } else {
                this.availableToAddLeftChildren = true;
            }
            if (rightChild != null){
                this.availableToAddRightChildren = false;
            } else {
                this.availableToAddRightChildren = true;
            }
        }
        boolean isAvailableToAddChildren() {
            return (availableToAddLeftChildren || availableToAddRightChildren);
        }
    }
    @Override
    public int size() {
        Entry<String> currentEntry = this.root;
        Queue<Entry<String>> queue = new LinkedList<>();
        int sizeOfElements = 0;
        while (currentEntry != null) {
            if (currentEntry.leftChild != null) {
                queue.add(currentEntry.leftChild);
                sizeOfElements++;
            }
            if (currentEntry.rightChild != null) {
                queue.add(currentEntry.rightChild);
                sizeOfElements++;
            }
            currentEntry = queue.poll();
        }
        return sizeOfElements;
    }

    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 17; i++) {
            list.add(String.valueOf(i));
        }
        //System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        System.out.println(list.size());
        ((CustomTree) list).remove("2");
        System.out.println(list.size());
    }
}