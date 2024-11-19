package act10_ordenamiento;

import java.util.ArrayList;
//import java.util.Iterator;

public class Ejer3 {	
	
	static private ArrayList<Producto> ventasEntrada = new ArrayList<>();
    static private ArrayList<Producto> ventasSalida = new ArrayList<>();

	public static void llenarListaAleatorio() {
		for(int i=0; i<10;i++) {
			int codigo = (int) (Math.random() * 6) + 1000; // Genera valores entre 1000 y 1005
	        int cantidad = (int) (Math.random() * 10) + 1; // Genera valores entre 1 y 10
	        int precio = (int) (Math.random() * 40001) + 10000;
            ventasEntrada.add(new Producto(codigo, cantidad, precio));
		}
	}
	
	public static void mostrar() {
		System.out.println("productos vendidos (Entrada):");
        for (Producto p : ventasEntrada) {
            System.out.println(p);
        }
	}
	

    public static void ordenarPorSeleccion() {
        for (int i = 0; i < ventasEntrada.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < ventasEntrada.size(); j++) {
                if (ventasEntrada.get(j).codigo < ventasEntrada.get(minIndex).codigo) {
                    minIndex = j;
                }
            }
            // Intercambio de elementos
            Producto temp = ventasEntrada.get(i);
            ventasEntrada.set(i, ventasEntrada.get(minIndex));
            ventasEntrada.set(minIndex, temp);
        }
    }

    public static void totalizarProductos(){
        ordenarPorSeleccion();
        int i = 0;
        while (i < ventasEntrada.size()) {
            int codigoActual = ventasEntrada.get(i).codigo;
            int cantidadTotal = 0;
            int sumaPrecios = 0;
            int contador = 0;

            while (i < ventasEntrada.size() && ventasEntrada.get(i).codigo == codigoActual) {
                cantidadTotal += ventasEntrada.get(i).cantidad;
                sumaPrecios += ventasEntrada.get(i).precio;
                contador++;
                i++;
            }

            int precioPromedio = sumaPrecios / contador;
            ventasSalida.add(new Producto(codigoActual, cantidadTotal, precioPromedio));
        }
    }

    public static void mostrarListaSalida() {
        System.out.println("Lista de Productos Totalizada (Salida):");
        for (Producto p : ventasSalida) {
            System.out.println(p);
        }

        int totalCantidad = 0;
        double totalVentas = 0;
        for (Producto p : ventasSalida) {
            totalCantidad += p.cantidad;
            totalVentas += p.cantidad * p.precio;
        }
        System.out.println("Total de productos vendidos: " + totalCantidad);
        System.out.println("Total general de ventas: " + totalVentas);
    }

	public static void ejecutar(){
		llenarListaAleatorio();
        mostrar();
        totalizarProductos();
        mostrarListaSalida();

	}

}
