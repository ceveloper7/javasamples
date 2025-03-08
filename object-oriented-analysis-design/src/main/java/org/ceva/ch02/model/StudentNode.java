package org.ceva.ch02.model;

/**
 * Una linked list consta de nodes, cada uno de los nodos almacena la direccion del siguiente elemento
 */
public class StudentNode {
    private Student data;
    private StudentNode next;

    public StudentNode(Student student, StudentNode initialLink) {
        this.data = student;
        next = initialLink;
    }

    public Student getData() {
        return data;
    }

    public void setData(Student student) {
        this.data = student;
    }

    public StudentNode getNext() {
        return next;
    }

    public void setNext(StudentNode node) {
        next = node;
    }
}
