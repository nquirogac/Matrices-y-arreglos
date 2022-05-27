package com.example.uncomedor.Data;

public class ListaEnlazada {
    Nodo head;
   

  public ListaEnlazada(){
    head = null;
    
  }
  public void pushBack(Usuario usuario){
    Nodo n =new Nodo(usuario);
    n.siguiente = null;
    Nodo l;
    l=head;
    if(head==null){
      head=n;
    }else{
      while(l.siguiente!=null){
          l=l.siguiente;
      }
      l.siguiente = n;
    }
  }
  
  public void search(int idUsuario){
    Nodo prev, l;
    l=head;
    
    Usuario usuario = (Usuario) l.data;
    prev = null;
    while(l !=null && Integer.parseInt(usuario.getIdUsuario()) != idUsuario){
      prev=l;
      l=l.siguiente;
      if(l != null){
        usuario = (Usuario) l.data;
      }
      
    }
    if(l==null){
      System.out.println("\n El usuario no se encuentra en la base de datos \n");
    }else{
      System.out.println("Usuario encontrado \n \n Nombre: "+usuario.nombre
                          +"\n Id: "+usuario.getIdUsuario()
                          +"\n Apollo completo: "+usuario.getTipoApoyo()
                          +"\n usuario: "+usuario.getUsuario()+"\n");
    }
    
  }

  public void printRecursive() {
    System.out.print("List Recursive: ");
    printR(head);
    System.out.println();
  }
  private void printR(Nodo p) {
  if(p != null) {
    System.out.print(p.data+" ");
    printR(p.siguiente);
    }
  }

 public void pushfront(int item){
     Nodo prev, l;
     l=head;
     prev = null;
     while(l !=null){
       prev=l;
       l=l.siguiente;
     }
     if(l==null){
       Nodo n =new Nodo(item);
       n.siguiente=l;
       if(prev!=null){
         prev.siguiente=n;
       }else{
         head = n;
       }
       
     }
}
}



