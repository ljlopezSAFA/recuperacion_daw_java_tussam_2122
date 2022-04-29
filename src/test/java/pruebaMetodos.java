import modelos.*;
import org.junit.Before;
import org.junit.Test;
import utilidades.UtilidadesAutobus;
import utilidades.UtilidadesConductor;
import utilidades.UtilidadesFichero;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;

public class pruebaMetodos {

    List<Autobus> autobuses = new ArrayList<>();
    List<Parada> paradas = new ArrayList<>();
    List<Recorrido> recorridos = new ArrayList<>();


    @Before
    public void inicializadoDeDatos() throws Exception {

        //----------------------- AUTOBUSES -------------------------------------
        Autobus a1 = new Autobus(1, Linea.A1, "1234-AAA");
        Autobus a2 = new Autobus(2, Linea.A2, "1234-BBB");
        Autobus a3 = new Autobus(3, Linea.A3, "1234-CCC");
        Autobus a4 = new Autobus(4, Linea.A3, "1234-DDD");
        Autobus a5 = new Autobus(5, Linea.L1, "1234-EEE");
        Autobus a6 = new Autobus(6, Linea.L1, "1234-FFF");
        Autobus a7 = new Autobus(7, Linea.L1, "1234-GGG");
        Autobus a8 = new Autobus(8, Linea.C4, "1234-HHH");


        //---------------------- PARADAS -----------------------------------------
        Parada p1 = new Parada(1, "Avenida Reina Mercedes", 150 , 1.2);
        Parada p2 = new Parada(2, "Avenida La Palmera", 151 , 1.4);
        Parada p3 = new Parada(3, "Calle Calatrava", 152 , 1.5);
        Parada p4 = new Parada(4, "Calle Fresas", 153 , 1.6);
        Parada p5 = new Parada(5, "Alameda Hércules", 154 , 1.8);
        Parada p6 = new Parada(6, "Calle Torneo", 155 , 2.5);
        Parada p7 = new Parada(7, "Plaza de Armas", 156 , 1.1);



        Recorrido r1 = new Recorrido(1, List.of(p1,p2));
        Recorrido r2 = new Recorrido(2, List.of(p3,p4,p5));
        Recorrido r3 = new Recorrido(3, List.of(p6,p7));
        Recorrido r4 = new Recorrido(4, List.of(p3,p4,p1));


        a1.setRecorrido(r1);
        a2.setRecorrido(r2);
        a3.setRecorrido(r3);
        a4.setRecorrido(r1);
        a5.setRecorrido(r2);
        a6.setRecorrido(r3);
        a7.setRecorrido(r1);
        a8.setRecorrido(r2);

        autobuses.addAll(List.of(a1,a2,a3,a4,a5,a6,a7,a8));
        paradas.addAll(List.of(p1,p2,p3,p4,p5,p6,p7));
        recorridos.addAll(List.of(r1,r2,r3,r4));




    }




    //---------------------------------------------- TEST UTILIDADESAUTOBUS -----------------------------------------------------//

    @Test
    public void testGetAutobusesConParadas() {
        List<Parada> paradasEsperadas = List.of(paradas.get(1), paradas.get(3));
        List<Autobus> autobusesObtenidos = UtilidadesAutobus.getAutobusConParadas(autobuses,paradasEsperadas);
        List<Autobus> autobusesEsperados = List.of(autobuses.get(0), autobuses.get(1), autobuses.get(3),  autobuses.get(4),  autobuses.get(6),  autobuses.get(7));
        assertEquals(autobusesObtenidos,autobusesEsperados);
    }

    @Test
    public void testGetAutobusesPorLinea() {


        Map<Linea, List<Autobus>> mapaObtenido  =  UtilidadesAutobus.getAutobusesPorLinea(autobuses);

        Set<Linea> clavesEsperadas = new HashSet<>(Set.of(Linea.A1,Linea.A2,Linea.A3,Linea.L1,Linea.C4));
        Set<Linea> clavesObtenidas = mapaObtenido.keySet();

        List<Autobus> valuesEsperados = new ArrayList<>(List.of(autobuses.get(2), autobuses.get(3)));
        List<Autobus> valoresObtenidos = mapaObtenido.get(Linea.A3);


        assertEquals(clavesEsperadas, clavesObtenidas);
        assertEquals(valuesEsperados,valoresObtenidos);

    }

    @Test
    public void testgetParadasCoincidentes() {

        List<Parada> paradasObtenidada =  UtilidadesAutobus.getParadasCoincidentes(recorridos.get(1), recorridos.get(3));
        List<Parada> paradasEsperadas =  List.of(paradas.get(2),paradas.get(3));


        assertTrue(paradasEsperadas.containsAll(paradasObtenidada));
        assertTrue(paradasEsperadas.size() == paradasObtenidada.size());


    }


    //---------------------------------------------- TEST UTILIDADESFICHERO -----------------------------------------------------//

    @Test
    public void testLeerAutobusesConParadas() throws Exception {
        List<Recorrido> recorridoList = UtilidadesFichero.leerRecorridosConParadas();
        Integer tamanyoLista = recorridoList.size();
        Integer tamanyoListaEsperado = 3;

        List<Parada> paradas = new ArrayList<>();
        recorridoList.stream().filter(p->p.getParadas()!= null).forEach(p->paradas.addAll(p.getParadas()));
        Integer tamanyoListaParadas = paradas.size();
        Integer tamanyoListaParadasEsperadas = 7;

        //Comprobacion de recorridos
        assertEquals(tamanyoLista, tamanyoListaEsperado);
        recorridoList.forEach(p->{
            assertNotNull(p.getParadas());
        });

        //Comprobacion de recorridos
        assertEquals(tamanyoListaParadas,tamanyoListaParadasEsperadas);

    }


    //---------------------------------------------- TEST UTILIDADESCONDUCTOR -----------------------------------------------------//


    @Test
    public void testTerminarJornadaLaboral() {

        Conductor conductor = new Conductor(1,"Luis", "Lopez", "123456");
        Map<Autobus, Integer> mapa = new HashMap<>();
        mapa.put(autobuses.get(0), 2);
        mapa.put(autobuses.get(1), 3);
        JornadaLaboral jornadaLaboral = UtilidadesConductor.terminarJornadaLaboral(conductor,mapa);

        assertEquals(jornadaLaboral.getId() , 1);
        assertEquals(jornadaLaboral.getConductor() , conductor);
        assertEquals(jornadaLaboral.getNum_paradas_totales(), 5);
        assertEquals(jornadaLaboral.getFecha() , LocalDate.now());
        assertEquals(jornadaLaboral.getAutobuses_num_itinerarios(), mapa);
        assertTrue(jornadaLaboral.getSalario() ==  19.9);
    }


    @Test
    public void testGetParadaPosible() {
        Double importe = 5.0;
        Double importe2 = 10.0;
        List<Autobus> autobusesPrueba = List.of(autobuses.get(0),autobuses.get(1));
        Parada paradaEsperada1 = paradas.get(2);
        Parada paradaEsperada2 = paradas.get(4);
        Parada paradaObtenida1 = UtilidadesConductor.getParadaPosible(importe,autobusesPrueba);
        Parada paradaObtenida2 = UtilidadesConductor.getParadaPosible(importe2,autobusesPrueba);
        assertEquals(paradaEsperada1,paradaObtenida1);
        assertEquals(paradaEsperada2,paradaObtenida2);

    }







}








