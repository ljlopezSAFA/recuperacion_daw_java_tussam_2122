package utilidades;

import modelos.Autobus;
import modelos.Linea;
import modelos.Parada;
import modelos.Recorrido;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UtilidadesAutobus {

    public UtilidadesAutobus() {
    }

    /**
     * Ejercicio 1A (1 punto)
     *
     * Obtiene todos los autobuses cuya lista de paradas contenga alguna de las que se pasan como parámetro
     *
     * @param autobuses
     * @param paradas
     * @return
     */
    public static List<Autobus> getAutobusConParadas(List<Autobus> autobuses , List<Parada> paradas){

        return autobuses.stream().filter(a-> !Collections.disjoint(a.getRecorrido().getParadas(),paradas)).collect(Collectors.toList());
    }


    /**
     * Ejercicio 1B (1 punto)
     *
     * Obtiene un mapa de los autobuses agrupados por Linea
     *
     * @param autobuses
     * @return
     */
    public static Map<Linea, List<Autobus>> getAutobusesPorLinea(List<Autobus> autobuses){
        return autobuses.stream().collect(Collectors.groupingBy(Autobus::getLinea));
    }



    /**
     * Ejercicio 1C (1 punto)
     *
     * Dado dos recorridos devuelves las paradas que coinciden en esos dos recorridos
     *
     * @param recorrido1,recorrido2
     * @return
     */
    public static List<Parada> getParadasCoincidentes(Recorrido recorrido1, Recorrido recorrido2){

        List<Parada> paradas = new ArrayList<>(recorrido1.getParadas());
        paradas.retainAll(recorrido2.getParadas());
        return  paradas;
    }


}
