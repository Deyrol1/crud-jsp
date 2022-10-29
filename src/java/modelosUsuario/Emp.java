package modelosUsuario;

public class Emp {
 private int cedula;
 private String nombre, cargo;

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Emp{" + "cedula=" + cedula + ", nombre=" + nombre + ", cargo=" + cargo + '}';
    }
    
}


 
 

        
