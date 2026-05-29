package simuladorcuartofrioindustrial;

import java.io.*;
import java.util.ArrayList;

public class GestorPersistenciaSensores {

    private String archivo;

    public GestorPersistenciaSensores(String archivo) {
        this.archivo = archivo;
    }

    public void guardarSensores(ArrayList<Sensor> sensores) {
        try {
            ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(archivo));
            escritor.writeObject(sensores);
            escritor.close();
        } catch (IOException e) {
            System.out.println("ERROR AL GUARDAR SENSORES");
        }
    }

    public ArrayList cargarSensores() throws ClassNotFoundException {
        ArrayList<Sensor> sensores = new ArrayList<>();
        try {
            ObjectInputStream lector = new ObjectInputStream(new FileInputStream(archivo));
            sensores = (ArrayList<Sensor>) lector.readObject();
            lector.close();
        } catch (IOException e) {
            System.out.println("ERROR AL LEER EL ARCHIVO");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: Eel archivo seleccionado no tiene los datos de los sensores");
        }
        return sensores;
    }

    public String getArchivo() {
        return archivo;
    }
}
