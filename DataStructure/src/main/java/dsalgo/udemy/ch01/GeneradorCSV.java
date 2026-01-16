package dsalgo.udemy.ch01;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GeneradorCSV {

    public static void main(String[] args) {
        String archivoTSV = "datos_bolsa.csv"; // El nombre del archivo ahora termina en .tsv
        int numRegistros = 1000;
        String delimitador = "\t"; // Usamos el carácter de tabulación como delimitador

        try (FileWriter writer = new FileWriter(archivoTSV)) {
            // Escribir el encabezado del archivo
            writer.append("year" + delimitador + "date" + delimitador + "shares" + delimitador + "trades" + delimitador + "dollars\n");

            Random random = new Random();
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Calendar calendar = Calendar.getInstance();
            calendar.set(2010, Calendar.JANUARY, 4);

            for (int i = 0; i < numRegistros; i++) {
                // Generar año
                int year = calendar.get(Calendar.YEAR);

                // Generar fecha
                String date = dateFormat.format(calendar.getTime());

                // Generar datos aleatorios para shares, trades y dollars
                long shares = (long) (random.nextDouble() * 4_000_000_000L) + 1_000_000_000L;
                long trades = (long) (random.nextDouble() * 4_000_000L) + 3_000_000L;
                long dollars = (long) (random.nextDouble() * 20_000_000_000L) + 30_000_000_000L;

                // Formatear el valor de dollars con el signo "$"
                String dollarsFormatted = String.format("$%,d", dollars);

                // Escribir la línea completa usando el delimitador de tabulación
                writer.append(String.format("%d%s%s%s%d%s%d%s%s\n",
                        year,
                        delimitador,
                        date,
                        delimitador,
                        shares,
                        delimitador,
                        trades,
                        delimitador,
                        dollarsFormatted));

                // Incrementar la fecha en un día
                calendar.add(Calendar.DAY_OF_YEAR, 1);
            }

            System.out.println("El archivo '" + archivoTSV + "' ha sido generado con éxito.");

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo TSV: " + e.getMessage());
        }
    }
}