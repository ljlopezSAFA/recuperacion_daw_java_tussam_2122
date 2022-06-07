package modelos;

import java.util.Objects;

public class Autobus {

    private int id;
    private Linea linea;
    private String matricula;
    private Recorrido recorrido;

    public Autobus() {
    }

    public Autobus(int id, Linea linea, String matricula) {
        this.id = id;
        this.linea = linea;
        this.matricula = matricula;
    }

    public Autobus(int id, Linea linea, String matricula, Recorrido recorrido) {
        this.id = id;
        this.linea = linea;
        this.matricula = matricula;
        this.recorrido = recorrido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Linea getLinea() {
        return linea;
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Recorrido getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(Recorrido recorrido) {
        this.recorrido = recorrido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autobus autobus = (Autobus) o;
        return id == autobus.id && linea == autobus.linea && Objects.equals(matricula, autobus.matricula) && Objects.equals(recorrido, autobus.recorrido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, linea, matricula, recorrido);
    }

    @Override
    public String toString() {
        return "Autobus{" +
                "id=" + id +
                ", linea=" + linea +
                ", matricula='" + matricula + '\'' +
                ", recorrido=" + recorrido +
                '}';
    }
}
