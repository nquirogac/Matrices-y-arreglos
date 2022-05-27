package com.example.uncomedor.Data;

class Array<T>{
    public int size;
    public int capacidad; 
    public T[] arreglo;
    public Array(){
      size =0;
      capacidad=5;
      arreglo= (T[]) new Object[5];
    }
    public T get(int i){
      if(i<0 || i>= size){
        throw new RuntimeException("El elemento no esta en el arreglo");
      }
      return arreglo[i];
    }
    public void set(int i,T valor){
      if(i<0 || i>= size){
        throw new RuntimeException("El elemento no esta en el arreglo");
      }
    arreglo[i]=valor;  
    }
  
    public void pushBack(T val){
      if(size == capacidad){
        T[] arregloN = (T[]) new Object[capacidad*2];
        for(int i =0;i<size;i++){
          arregloN[i]=arreglo[i];
        }
        arreglo=arregloN;
        capacidad=capacidad*2;
      }
      arreglo[size]=val;
      size++;
    }
    public void remove(int i){
      if(i<0 || i>= size){
        throw new RuntimeException("El elemento no esta en el arreglo");
      }
      for(int j=i;j<size-1;j++){
        arreglo[j]=arreglo[j+1];
      }
      size--;
    }
    public int size(){
      return size;
    }
    public void imprimir(){
      for(int i =0;i<size;i++){
        System.out.print(arreglo[i]+"-");
        
      }
      
    }
  }