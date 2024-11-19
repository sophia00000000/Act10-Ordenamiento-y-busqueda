package act10_ordenamiento;

public class Producto {
    int codigo;
    int cantidad;
    int precio;

    public Producto(int codigo, int cantidad, int precio) {
            super();
            this.codigo = codigo;
            this.cantidad = cantidad;
            this.precio = precio;
    }

    public int getCodigo() {
            return codigo;
    }

    public void setCodigo(int codigo) {
            this.codigo = codigo;
    }
    @Override
    
    public String toString() {
        return "Código: " + codigo + ", Cantidad: " + cantidad + ", Precio: " + precio;
    }
 }   
