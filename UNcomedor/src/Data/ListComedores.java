package Data;

import java.util.Scanner;

public class ListComedores {

    static Scanner scanner= new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        ListComedores Comedores = new ListComedores();

        while(true) {

            System.out.println("");
            menu();
            //menu
            int seleccion = selector();
            if (seleccion!=5){
                switch (seleccion) {
                    case 1:
                        scanner.nextLine();
                        boolean finish = false;
                        System.out.println("Ingrese los comedores");
                        while (finish != true) {
                            String cadena = scanner.nextLine();
                            if (cadena.charAt(0) != '-') {// entrar un - para terminar el ingreso de usuarios
                                String[] dataUser = cadena.split(",");
                                int capacidad = Integer.parseInt(dataUser[0]);
                                String nombreComedor = dataUser[1];
                                //Inserción en la lista
                                Comedores.insert(new Comedor(capacidad, nombreComedor));
                                System.out.println("");
                            } else {
                                System.out.println("Los datos han sido ingresados");
                                break;
                            }
                        }
                        break;

                    case 2:
                        scanner.nextLine();
                        System.out.println("Ingrese el nombre del comedor que quiere buscar");
                        String cadena = scanner.nextLine();
                        int capacidadBuscada = 1; //Solo se necesita el nombre, pero como pasamos un objeto, ponemos cualquier valor en capacidad
                        String nombreComedorBuscado = cadena;
                        Comedor queryBusqueda = new Comedor(capacidadBuscada, nombreComedorBuscado);
                        Comedores.search(queryBusqueda);
                        break;

                    case 3:
                        scanner.nextLine();
                        System.out.println("Ingrese el nombre del comedor que eliminar");
                        String eliminado = scanner.nextLine();
                        int capacidadEliminada = 1; //Solo se necesita el nombre, pero como pasamos un objeto, ponemos cualquier valor en capacidad
                        String nombreComedorEliminado = eliminado;
                        Comedor queryEliminado = new Comedor(capacidadEliminada, nombreComedorEliminado);
                        Comedores.delete(queryEliminado);
                        break;

                    case 4:
                        boolean comedoresEmpty = Comedores.empty();
                        if (comedoresEmpty){
                            System.out.println("No hay comedores");
                        }
                        else{
                            Comedores.output();
                        }
                        break;

                    default:
                        System.out.println("Ingrese una opción válida");
                        break;


                }
            }
        }

        /*
        Comedores.insert(new Comedor(2, "Central"));
        Comedores.insert(new Comedor(8, "Ecologia"));
        Comedores.insert(new Comedor(10, "veterinaria"));
        Comedores.output();*/

    }
    int N = 1024;
    Comedor larray[];

    private int position, count;

    public ListComedores() {
        count = 0;
        larray = new Comedor[N];
    }

    private boolean empty() {
        return count <= 0;
    }

    private boolean full() {
        return count >= N;
    }

    public boolean delete(Comedor item) {
        boolean deleted = false;
        if (!empty()) {
            if (search(item)) {
                System.out.println("Eliminando comedor");
                for (int j = position; j < count - 1; j++) {
                    larray[j] = larray[j + 1];
                }
                count--;
                deleted = true;
            } else {
                System.out.println("List is Empty");
            }
        }
        System.out.println("Comedor eliminado");
        return deleted;
    }

    public boolean insert(Comedor item) {
        boolean inserted = false;
        if (!full()) {

            for (int j = count; j > position; j--) {
                larray[j] = larray[j - 1];
            }
            larray[position] = item;
            count++;
            inserted = true;

        }
        else {
                System.out.println("List is Full");
            }
        return inserted;
    }

    private boolean search(Comedor item) {
        boolean found = false, stop = false;
        position = 0;
        String nombreEntrada = item.nombre.substring(0);
        int capacidadRespuesta=0;
        while (position < count && !stop) {

            if (larray[position].nombre.toString().equals(nombreEntrada)) { //&& larray[position].capacidad == item.capacidad
                stop = true;
                found = true;
                capacidadRespuesta=larray[position].capacidad;
            } else {
                position++;
            }

        }
        if (found){
            System.out.println("El comedor fue encontrado; tiene una capacidad de "+ capacidadRespuesta + " personas");
        }else {
            System.out.println("El comedor no fue encontrado :(");
        }
        return found;
    }

    public void output() {
        System.out.print("Comedores: "+"\n");
        int j = 0;
        while (j != count) {
            System.out.print(larray[j] + " "+ "Capacidad: "+ larray[j].capacidad+"\n");
            j++;
        }
        System.out.println();
    }

    public static void menu(){
        System.out.println("Güelcom tu ListComedores :D \nIngrese el número de la opción que desea \n1. Ingresar comedores\n2. Buscar un comedor\n3. Eliminar un comedor\n4. Mostrar comedores\n5. Salir");
    }

    public static int selector(){
        int select = scanner.nextInt();
        return select;
    }
}
