package utilidades;

import modelos.Autobus;
import modelos.Conductor;
import modelos.JornadaLaboral;
import modelos.Parada;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UtilidadesConductor {

    public UtilidadesConductor() {
    }


    /**
     * Ejercicio 3A (3 puntos)
     *
     * Dado un conductor y los itinerarios recorridos en un día de trabajo devuelve el resumen de su jornada laboral
     *
     * @param
     * @return
     */
    public static JornadaLaboral terminarJornadaLaboral(Conductor conductor, Map<Autobus,Integer> autobuses_num_itinerarios){
        JornadaLaboral jornadaLaboral = new JornadaLaboral();
        jornadaLaboral.setId(1);
        jornadaLaboral.setConductor(conductor);
        jornadaLaboral.setAutobuses_num_itinerarios(autobuses_num_itinerarios);
        jornadaLaboral.setNum_paradas_totales(autobuses_num_itinerarios.keySet()
                .stream().mapToInt(a-> a.getRecorrido().getParadas().size()).sum());
        jornadaLaboral.setFecha(LocalDate.now());
        jornadaLaboral.setSalario(autobuses_num_itinerarios.keySet().stream()
                .mapToDouble(a-> a.getRecorrido().getParadas()
                        .stream().mapToDouble(Parada::getBonificacion_parada).sum() * autobuses_num_itinerarios.get(a)).sum());
        return  jornadaLaboral;
    }


    /**
     * Ejercicio 3B (2 puntos)
     *
     * Dado un importe restante de un bono de autobús y una Lista de Autobuses, devuelve la parada en la que quedará sin
     * saldo un viajero de los itinerario de autobuses por orden
     *
     * @param
     * @return
     */
    public static Parada getParadaPosible(Double importe_restante, List<Autobus> autobuses){

        Parada paradaPosible = null;
        List<Parada> paradasARecorrer = new ArrayList<>();
        autobuses.forEach(a-> paradasARecorrer.addAll(a.getRecorrido().getParadas()));

        for(Parada p : paradasARecorrer){
            if(importe_restante - p.getBonificacion_parada() > 0.0){
                paradaPosible = p;
            }
            importe_restante -= p.getBonificacion_parada();

            if(importe_restante< 0.0){
                break;
            }

        }

        return  paradaPosible;
    }







}
