package modelos;

import java.util.Objects;

public class Parada {

    private int id;
    private String ubicacion;
    private int num_parada;
    private double bonificacion_parada;

    public Parada(int id, String ubicacion, int num_parada, double bonificacion_parada) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.num_parada = num_parada;
        this.bonificacion_parada = bonificacion_parada;
    }

    public Parada() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getNum_parada() {
        return num_parada;
    }

    public void setNum_parada(int num_parada) {
        this.num_parada = num_parada;
    }

    public double getBonificacion_parada() {
        return bonificacion_parada;
    }

    public void setBonificacion_parada(double bonificacion_parada) {
        this.bonificacion_parada = bonificacion_parada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parada parada = (Parada) o;
        return id == parada.id && num_parada == parada.num_parada && Double.compare(parada.bonificacion_parada, bonificacion_parada) == 0 && Objects.equals(ubicacion, parada.ubicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ubicacion, num_parada, bonificacion_parada);
    }


    @Override
    public String toString() {
        return "Parada{" +
                "id=" + id +
                ", ubicacion='" + ubicacion + '\'' +
                ", num_parada=" + num_parada +
                ", bonificacion_parada=" + bonificacion_parada +
                '}';
    }
}
