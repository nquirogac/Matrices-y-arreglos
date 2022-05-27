package com.example.uncomedor.Data;
public class Cola {
  private Nodo front;
  private Nodo rear;
  String elementos ="";
  
  public Cola(){
    front = null;
    rear= null;
  }
  public void enque(Turno item){
    
    Nodo newp = new Nodo(item);
    
    newp.siguiente = null;
    if(front == null){
      rear = newp;
      front = newp;
    }else{
      rear.setNext(newp);
      rear=newp;
      }
    //System.out.println("Cola "+rear.data.toString());
    }
  public Turno deque(){
    Turno ret=null;
    if(!Empty()){
      ret = (Turno) front.data; 
      front = front.siguiente;
      if(front==rear){
        rear=null;
        front=null;
          
      }     
      
    }
    return ret;
    }
    
  public boolean Empty(){
    return ((front == null)&&(rear==null));
  }
  public void imprimirCola(){
    Nodo ref = front;
    System.out.println("---Cola en el comedor---");
    while(ref!=null){
      elementos += ref.data.toString() + "\n";
      ref = ref.siguiente;
    }
    System.out.println(elementos);
    
    elementos="";
  }
    
}


