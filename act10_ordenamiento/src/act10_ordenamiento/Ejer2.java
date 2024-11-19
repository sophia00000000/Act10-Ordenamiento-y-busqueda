package act10_ordenamiento;

import java.util.Arrays;
import java.util.Scanner;

public class Ejer2 {
	public static int num = 6;
    public static int[] id = new int[num];
    public static String[] nombre = new String[num];
    public static int[][] salario = new int[num][3];

    public static void llenar() {
        for (int i = 0; i < id.length; i++) {
            id[i] = (int) (Math.random() * 199) + 99;
            nombre[i] = "Emp " + (num - 1 - i);
            salario[i][0] = (int) (Math.random() * 1500000) + 1160000;
            salario[i][1] = (int) (Math.random() * 150000) + 95000;
            salario[i][2] = salario[i][0] - salario[i][1];
        }

        System.out.println("IDs: " + Arrays.toString(id));
        System.out.println("Nombres: " + Arrays.toString(nombre));

        for (int i = 0; i < 6; i++) {
            System.out.println(Arrays.toString(salario[i]));
        }
    }
    
    public static void ordenarPorIdentificacion(int[] identificacion, String[] nombre, int[][] salarios) {
	    for (int i = 0; i < identificacion.length - 1; i++) {
	        for (int j = i + 1; j < identificacion.length; j++) {
	            if (identificacion[i] > identificacion[j]) {
	                // ...intercambiarlos, es decir, mover el actual a la derecha y el de la derecha al actual
	            	int tempId = identificacion[i];
                    String tempNombre = nombre[i];
                    int[] tempSalarios = salarios[i];
                    identificacion[i] = identificacion[j];
                    identificacion[j] = tempId;                   
                    nombre[i] = nombre[j];
                    nombre[j] = tempNombre;                   
                    salarios[i] = salarios[j];
                    salarios[j] = tempSalarios;
	                
				}
	        }
	    }
    }

    public static void ordenarPorNombre(int[] identificacion, String[] nombre, int[][] salarios) {
        for (int i = 0; i < nombre.length - 1; i++) {
            for (int j = i + 1; j < nombre.length; j++) {
                if (nombre[i].compareTo(nombre[j]) > 0) {

                    int tempId = identificacion[i];
                    String tempNombre = nombre[i];
                    int[] tempSalarios = salarios[i];

                    identificacion[i] = identificacion[j];
                    identificacion[j] = tempId;                   
                    nombre[i] = nombre[j];
                    nombre[j] = tempNombre;                   
                    salarios[i] = salarios[j];
                    salarios[j] = tempSalarios;
                }
            }
        }
        System.out.println("Empleados ordenados por nombre:");
        System.out.println(Arrays.toString(identificacion));
        System.out.println(Arrays.toString(nombre));
        for (int i = 0; i < 6; i++) {
            System.out.println(nombre[i] + ": " + Arrays.toString(salarios[i]));
        }
    }

    public static int busquedaBinaria(int[] identificacion, int a, int b, int num) {
        if (a > b) {
            return -1;
        }
        int mid = a + (b - a) / 2;

        if (identificacion[mid] == num) {
            return mid;
        } else if (identificacion[mid] > num) {
            return busquedaBinaria(identificacion, a, mid - 1, num);
        } else {
            return busquedaBinaria(identificacion, mid + 1, b, num);
        }
    }

    public static void ejecutar(){
        llenar();
        ordenarPorIdentificacion(id, nombre, salario);

        Scanner input = new Scanner(System.in);
        System.out.print("\nDigite la identificación del empleado: ");
        int num = input.nextInt();
        int result = busquedaBinaria(id, 0, id.length - 1, num);

        if (result != -1) {
            System.out.println("Empleado encontrado:");
            System.out.println(nombre[result]);
            System.out.println("Salarios");
            System.out.println("sueldo básico: " + salario[result][0]);
            System.out.println("deducciones: " + salario[result][1]);
            System.out.println("Neto a pagar: " + salario[result][2]);
        } else {
            System.out.println("no está");
        }
        input.close();
        ordenarPorNombre(id, nombre, salario);
        
    }
}
