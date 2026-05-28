package simuladorcuartofrioindustrial;

import java.util.ArrayList;

public class GestorSensores {

    private ArrayList<Sensor> listaSensores;

    public GestorSensores() {
        listaSensores = new ArrayList<>();
    }

    public void agregarSensor(Sensor sensor) {
        listaSensores.add(sensor);
    }

    public ArrayList<Sensor> getSensores() {
        return listaSensores;
    }

    public void setSensores(ArrayList<Sensor> listaSensores) {
        this.listaSensores = listaSensores;
    }
}
