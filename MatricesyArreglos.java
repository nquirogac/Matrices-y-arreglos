package matricesyarreglos;

/**
 *
 * @author nataliaquiroga
 */
public class MatricesyArreglos {

    public static void main(String[] args) {
        //Ejercicio 1
        System.out.println("Ejercicio 1 \n");
        int [][] matriz1 = {{4,8,12},{5,10,15},{6,12,18}};
        int[] diagonal = new int[3];
    
        System.out.println("La matriz inicial es: ");
    
        for(int i = 0; i < 3;i++){
            diagonal[i] = matriz1[i][i];
            System.out.println("["+matriz1[i][0]+","+matriz1[i][1]+","+matriz1[i][2]+"]");
        }
        
        System.out.println("\nEl arreglo con la diagonal de la matriz 1 es:\n["+diagonal[0]+","+diagonal[1]+","+diagonal[2]+"]");
    
        //Ejercicio 2
        System.out.println("\nEjercicio 2 \n");
        char [][] matriz2 = {{'a','b','c','d'},{'e','f','g','h'},{'i','j','k','l'},{'m','n','ñ','o'}}; 
        char [] diagonal2 = new char[4];
        int j = 0;
        System.out.println("La matriz inicial es: ");
        
        for(int i = 3; i >=0 ;i--){
            diagonal2[i] = matriz2[j][i];
            System.out.println("["+matriz2[j][0]+","+matriz2[j][1]+","+matriz2[j][2]+","+matriz2[j][3]+"]");
            j++;
        }
        System.out.println("\nEl arreglo con la diagonal de la matriz 2 es:\n["+diagonal2[0]+","+diagonal2[1]+","+diagonal2[2]+","+diagonal2[3]+"]");
    
        
    }
    
}
