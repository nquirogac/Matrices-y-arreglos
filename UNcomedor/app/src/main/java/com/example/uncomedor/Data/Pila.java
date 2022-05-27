package com.example.uncomedor.Data;
public class Pila<T> {
    private Nodo top;
    public Pila() {
        top = null;
    }
    public void push(T item) {
        Nodo newp = new Nodo(item);
        newp.setNext(top);
        top = newp;
    }
    public T pop() {
        int item=-1;
        Nodo anterior = top;
        top = top.siguiente;

        return (T) anterior;
        // insert code
    }
    public boolean empty() {
        return top == null;
        // insert code
    }
}