package utilidades;

import modelos.Autobus;
import modelos.Linea;
import modelos.Parada;
import modelos.Recorrido;

import java.util.*;
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

        List<Autobus> autobusesPosibles = new ArrayList<>();

        for(Autobus a: autobuses){

            List<Parada> paradasAutobus = new ArrayList<>(a.getRecorrido().getParadas());
            paradasAutobus.retainAll(paradas);

            if(! paradasAutobus.isEmpty()){
                autobusesPosibles.add(a);
            }
        }

        return autobusesPosibles;
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
        return autobuses
                .stream()
                .collect(Collectors.groupingBy(Autobus::getLinea));
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

          List<Parada> paradasCoincidentes = new ArrayList<>();

          //AÑADIMOS LAS PARADAS DEL RECORRIDO 1
          paradasCoincidentes.addAll(recorrido1.getParadas());

          //QUITAMOS LAS PARADAS QUE NO COINCIDAN CON LAS DEL RECORRIDO 2
          paradasCoincidentes.retainAll(recorrido2.getParadas());

          return paradasCoincidentes;
    }


}
