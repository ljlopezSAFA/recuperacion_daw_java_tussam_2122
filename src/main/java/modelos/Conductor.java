package modelos;

import java.util.Objects;

public class Conductor {

    private int id;
    private String nombre;
    private String apellidos;
    private String num_carnet_conducir;

    public Conductor() {
    }

    public Conductor(int id, String nombre, String apellidos, String num_carnet_conducir) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.num_carnet_conducir = num_carnet_conducir;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNum_carnet_conducir() {
        return num_carnet_conducir;
    }

    public void setNum_carnet_conducir(String num_carnet_conducir) {
        this.num_carnet_conducir = num_carnet_conducir;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conductor conductor = (Conductor) o;
        return id == conductor.id && Objects.equals(nombre, conductor.nombre) && Objects.equals(apellidos, conductor.apellidos) && Objects.equals(num_carnet_conducir, conductor.num_carnet_conducir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidos, num_carnet_conducir);
    }


    @Override
    public String toString() {
        return "Conductor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", num_carnet_conducir='" + num_carnet_conducir + '\'' +
                '}';
    }
}
