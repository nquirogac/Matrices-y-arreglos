package com.example.uncomedor.Data;
public class Nodo<T> {
    public T data;
    public Nodo siguiente;
  
    public Nodo(T d){
      data = d;
      siguiente=null;
    }
    public void setNext(Nodo next) {
    this.siguiente = next;
  } 
}
