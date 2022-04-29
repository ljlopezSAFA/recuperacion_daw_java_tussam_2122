package modelos;

import java.util.List;
import java.util.Objects;

public class Recorrido {

    private int id;
    private List<Parada> paradas;


    public Recorrido(int id, List<Parada> paradas) {
        this.id = id;
        this.paradas = paradas;
    }

    public Recorrido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Parada> getParadas() {
        return paradas;
    }

    public void setParadas(List<Parada> paradas) {
        this.paradas = paradas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recorrido recorrido = (Recorrido) o;
        return id == recorrido.id && Objects.equals(paradas, recorrido.paradas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paradas);
    }



}
