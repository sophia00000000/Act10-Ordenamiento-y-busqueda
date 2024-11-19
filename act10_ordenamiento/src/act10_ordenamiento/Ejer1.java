package act10_ordenamiento;
import java.util.*;

public class Ejer1 {
		public static int[] codigo = new int [6];
		public static String[] nombre = new String [6];
		public static double[][] notas = new double[6][4];
		
		public static void llenar() {
			
			for (int i = 0; i < codigo.length; i++) {
				codigo[i] = (int) (Math.random()*100) + 10;
				nombre[i] = "Est " + i;
				for(int j = 0; j <= 2; j++) {
					notas[i][j] = (int) (Math.random()*5) + 1;
				}
				notas[i][3] = notas[i][0]*0.3 + notas[i][1]*0.3 + notas[i][2]*0.4;
			}
			
			System.out.println(Arrays.toString(codigo));
			System.out.println(Arrays.toString(nombre));
			
			for (int i = 0; i < 6; i++) {
				
				for (int j = 0; j <= 3; j++) {
					System.out.print(notas[i][j] + "  ");
				}
				System.out.println("");
			}
			
			System.out.println(Arrays.deepToString(notas));
		}
		
		public static void ordenarPorSeleccionCodigo(int[] codigo, String[] nombre, double[][] notas) {
		    for (int i = 0; i < codigo.length - 1; i++) {
		        for (int j = i + 1; j < codigo.length; j++) {
		            if (codigo[i] > codigo[j]) {
		                // ...intercambiarlos, es decir, mover el actual a la derecha y el de la derecha al actual
		                int temporalCodigo = codigo[i];
		                String temporalNombre = nombre[i];
		                codigo[i] = codigo[j];
		                nombre[i] = nombre[j];
		                codigo[j] = temporalCodigo;
		                nombre[j] = temporalNombre;	                
		            	            
		            	double temporalNota1 = notas[i][0];
		                double temporalNota2 = notas[i][1];
		                double temporalNota3 = notas[i][2];
		                double temporalNota4 = notas[i][3];
		                notas[i][0]=notas[j][0];
		                notas[i][1]=notas[j][1];
		                notas[i][2]=notas[j][2];
		                notas[i][3]=notas[j][3];
		                notas[j][0]=temporalNota1;	
		                notas[j][1]=temporalNota2;
		                notas[j][2]=temporalNota3;
		                notas[j][3]=temporalNota4;
		                //notas[i][0] = notas[i+1][0] 
		                
					}
		        }
		        
		        
		    }
		    
		    System.out.println();
		    System.out.println("Estudiantes ordenados por código:");
		    System.out.println(Arrays.toString(codigo));
			System.out.println(Arrays.toString(nombre));
			for (int i = 0; i < 6; i++) {
				
				for (int j = 0; j <= 3; j++) {
					System.out.print(notas[i][j] + "  ");
				}
				System.out.println("");
			}
			
		}
		
		public static void ordenarPorSeleccionNotas(int[] codigo, String[] nombre, double[][] notas) {
	        for (int i = 0; i < codigo.length - 1; i++) {
	            for (int j = i + 1; j < codigo.length; j++) {
	                if (notas[i][3] < notas[j][3]) {

	                    int tempCodigo = codigo[i];
	                    String tempNombre = nombre[i];
	                    codigo[i] = codigo[j];
	                    nombre[i] = nombre[j];
	                    codigo[j] = tempCodigo;
	                    nombre[j] = tempNombre;

	                    double tempNota1 = notas[i][0];
	                    double tempNota2 = notas[i][1];
	                    double tempNota3 = notas[i][2];
	                    double tempNota4 = notas[i][3];
	                    notas[i][0] = notas[j][0];
	                    notas[i][1] = notas[j][1];
	                    notas[i][2] = notas[j][2];
	                    notas[i][3] = notas[j][3];
	                    notas[j][0] = tempNota1;
	                    notas[j][1] = tempNota2;
	                    notas[j][2] = tempNota3;
	                    notas[j][3] = tempNota4;
	                }
	            }
	        }
	        System.out.println(" ");
			System.out.println("Estudiantes ordenados por definitiva:");
	        System.out.println(Arrays.toString(codigo));
	        System.out.println(Arrays.toString(nombre));
	        for (int i = 0; i < 6; i++) {
	            System.out.println( nombre[i] + ": " + Arrays.toString(notas[i]));
	        }
	    }
		
		public static int BinarySearchRecursive(int[] codigo, int a, int b, int num){
		    if (a > b) {
		        return -1;
		    }
		    int n = a + (b - a) / 2;

		    if (codigo[n] == num)
		        return n;
		    else if (codigo[n] > num)
		        return BinarySearchRecursive(codigo, a, n - 1, num);
		    else
		        return BinarySearchRecursive(codigo, n + 1, b, num);
		}


		
		public static void ejecutar() {
			//llenar aleatorio
		    llenar();
		    //ordenar por codigo
		    ordenarPorSeleccionCodigo(codigo, nombre, notas);
		    
		    System.out.println("Código a buscar: ");
		    Scanner input = new Scanner(System.in);
		    int num = input.nextInt();
		    //buscar codigo
		    int result = BinarySearchRecursive(codigo, 0, codigo.length - 1, num);

		    if (result != -1) {
	            System.out.println("Estudiante encontrado");
	            System.out.println(nombre[result]);

	            for (int j = 0; j < notas[result].length - 1; j++) {
	                System.out.println("Nota " + (j + 1) + ": " + notas[result][j]);
	            }
	            System.out.println("Definitiva: " + notas[result][3]);
	        } else {
	            System.out.println("Código del estudiante " + num + " no encontrado.");
	        }
	        input.close();
	        
	        //ordenar por notas
	        ordenarPorSeleccionNotas(codigo, nombre, notas);
		}
}


