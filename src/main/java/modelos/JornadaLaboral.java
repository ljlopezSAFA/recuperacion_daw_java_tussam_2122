package modelos;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

public class JornadaLaboral {

    private int id;
    private LocalDate fecha;
    private Conductor conductor;
    private Map<Autobus, Integer> autobuses_num_itinerarios;
    private int num_paradas_totales;
    private double salario;

    public JornadaLaboral() {
    }

    public JornadaLaboral(int id, LocalDate fecha, Conductor conductor, Map<Autobus, Integer> autobuses_num_itinerarios, int num_paradas_totales, double salario) {
        this.id = id;
        this.fecha = fecha;
        this.conductor = conductor;
        this.autobuses_num_itinerarios = autobuses_num_itinerarios;
        this.num_paradas_totales = num_paradas_totales;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public Map<Autobus, Integer> getAutobuses_num_itinerarios() {
        return autobuses_num_itinerarios;
    }

    public void setAutobuses_num_itinerarios(Map<Autobus, Integer> autobuses_num_itinerarios) {
        this.autobuses_num_itinerarios = autobuses_num_itinerarios;
    }

    public int getNum_paradas_totales() {
        return num_paradas_totales;
    }

    public void setNum_paradas_totales(int num_paradas_totales) {
        this.num_paradas_totales = num_paradas_totales;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JornadaLaboral that = (JornadaLaboral) o;
        return id == that.id && num_paradas_totales == that.num_paradas_totales && Double.compare(that.salario, salario) == 0 && Objects.equals(fecha, that.fecha) && Objects.equals(conductor, that.conductor) && Objects.equals(autobuses_num_itinerarios, that.autobuses_num_itinerarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha, conductor, autobuses_num_itinerarios, num_paradas_totales, salario);
    }


    @Override
    public String toString() {
        return "JornadaLaboral{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", conductor=" + conductor +
                ", autobuses_num_itinerarios=" + autobuses_num_itinerarios +
                ", num_paradas_totales=" + num_paradas_totales +
                ", salario=" + salario +
                '}';
    }
}
