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

        JornadaLaboral jornadaLaboral  = new JornadaLaboral();

        jornadaLaboral.setId(1);
        jornadaLaboral.setFecha(LocalDate.now());
        jornadaLaboral.setConductor(conductor);
        jornadaLaboral.setAutobuses_num_itinerarios(autobuses_num_itinerarios);


        //NUMPARADASTOTALES
        jornadaLaboral.setNum_paradas_totales(autobuses_num_itinerarios.keySet().stream().mapToInt(a-> a.getRecorrido().getParadas().size()).sum());

        //SALARIO
        double salario = 0.0;

        for(Autobus a : autobuses_num_itinerarios.keySet()){

            Integer numVecesRecorrido = autobuses_num_itinerarios.get(a);
            double sumValoresParada = 0.0;

            for(Parada p : a.getRecorrido().getParadas()){
                double valorParada = p.getBonificacion_parada();
                sumValoresParada += valorParada;

            }

            double totalGanadoAutobus = sumValoresParada * numVecesRecorrido;
            salario += totalGanadoAutobus;
        }

        jornadaLaboral.setSalario(salario);

        return jornadaLaboral;
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


        List<Parada> paradasOrdenadas = new ArrayList<>();

        //METER TODAS LAS PARADOS ORDENADAS EN LA LISTA (paradasOrdenadas)
        for(Autobus a: autobuses){
            paradasOrdenadas.addAll(a.getRecorrido().getParadas());
        }

        Parada paradaFinal = null;

        for(Parada p: paradasOrdenadas){

            double coste =  p.getBonificacion_parada();

            if(importe_restante - coste >=0){
                paradaFinal = p;
                importe_restante -= coste;
            }
        }

       return paradaFinal;

    }







}
