package utilidades;

import com.opencsv.CSVReader;
import modelos.Parada;
import modelos.Recorrido;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class UtilidadesFichero {

    public static final char SEPARATOR = ',';
    public static final char QUOTE = '"';
    public static final String filePath = new File("").getAbsolutePath();

    public UtilidadesFichero() {
    }


    /**
     * Devuelve la lista de autobuses con sus paradas asignadas leyendo los dos ficheros
     *
     * @return
     */
    public static List<Recorrido> leerRecorridosConParadas() {


        List<Recorrido> recorridos = new ArrayList<>();
        CSVReader reader = null;


        try {
            reader = new CSVReader(new FileReader(filePath + "\\src\\main\\java\\archivos\\paradas.csv"), SEPARATOR, QUOTE);
            String[] nextLine = null;
            int count = 0;

            while ((nextLine = reader.readNext()) != null) {

                if (count > 0) {
                    String[] valores = nextLine;
                    int id_recorrido = Integer.parseInt(valores[0]);
                    Recorrido r = null;
                    if (recorridos.stream().anyMatch(p -> p.getId() == id_recorrido)) {
                        r = recorridos.stream().filter(p -> p.getId() == id_recorrido).findFirst().get();
                    } else {
                        r = new Recorrido();
                        r.setId(id_recorrido);
                        r.setParadas(new ArrayList<>());
                        recorridos.add(r);
                    }

                    Parada p = new Parada();
                    p.setId(Integer.parseInt(valores[1]));
                    p.setUbicacion(valores[2]);
                    p.setNum_parada(Integer.parseInt(valores[3]));
                    p.setBonificacion_parada(Double.parseDouble(valores[4]));
                    r.getParadas().add(p);

                }
                count++;
            }

            reader.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return recorridos;

    }

}


