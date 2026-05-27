package simuladorcuartofrioindustrial;

import java.util.ArrayList;

public class GestorSensores {

    private ArrayList<Sensor> sensores;

    public GestorSensores() {
        sensores = new ArrayList<>();
    }

    public void agregarSensor(Sensor sensor) {
        sensores.add(sensor);
    }
}
