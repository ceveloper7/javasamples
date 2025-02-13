package com.ceva.ch02.model;

/**
 *
 */
public class StudentLinkedList implements StudentList{

    private StudentNode head;

    // creamos un nuevo StudentNode y lo colocamos al principio de la lista
    @Override
    public void add(Student student) {
        head = new StudentNode(student, head);
    }

    @Override
    public void delete(String studentName) {
        // verificamos si la lista esta vacia
        if(head == null)
            return;

        // lista no vacia, verificamos el nombre del estudiante al inicio de la lista es el mismo que el nombre propocionado en el parametro
        if(head.getData().getName().equals(studentName)){
            // si coincide, el objeto student al inicio de la lista se elimina de la lista moviendo head al siguiente objeto
            head = head.getNext();
        }else{
            //Si el elemento al principio de la lista no es el que queremos, el bucle for examina todos los elementos comenzando en la segunda posicion
            // hasta llegar al final de la lista o hasta que se encuentre al student con el nombre dado
            for (StudentNode temp = head.getNext(), previous = head;
                 temp != null;
                 // objeto que precede (va antes o primero) al objeto al que hace referencia temp
                 previous = temp, temp = temp.getNext()) {
                if (temp.getData().getName().equals(studentName)) {
                    previous.setNext(temp.getNext());
                    return;
                }
            }
        }
    }

    @Override
    public void print() {
        System.out.println("List: ");
        for(StudentNode temp = head; temp != null; temp = temp.getNext()){
            System.out.println(temp.getData() + " ");
        }
        System.out.println();
    }
}
