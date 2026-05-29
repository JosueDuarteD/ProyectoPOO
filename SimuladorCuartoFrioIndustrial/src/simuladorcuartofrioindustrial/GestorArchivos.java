package simuladorcuartofrioindustrial;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class GestorArchivos {

    private String archivo;

    public GestorArchivos(String archivo) {
        this.archivo = archivo;
    }

    public void escribirEnArchivo(String mensaje) {
        try {
            FileWriter escritor = new FileWriter(archivo, true);
            java.time.format.DateTimeFormatter formatoPersonalizado = java.time.format.DateTimeFormatter.ofPattern("'Fecha:' yyyy-MM-dd 'Hora:'HH:mm:ss");
            String fechaHoraConFormato = java.time.LocalDateTime.now().format(formatoPersonalizado);
            escritor.write(fechaHoraConFormato + " -> " + mensaje + "\n");
            escritor.close();
        } catch (IOException e) {
            System.out.println("ERROR AL ESCRIBIR");
        }
    }

    public ArrayList<String> leerArchivos() {
        ArrayList<String> archivos = new ArrayList<>();
        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = lector.readLine()) != null) {
                archivos.add(linea);
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("ERROR AL LEER EL ARCHIVO");
        }
        return archivos;
    }

    public String getArchivo() {
        return archivo;
    }
}
