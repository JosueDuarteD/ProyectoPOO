package simuladorcuartofrioindustrial.Gestores;

import simuladorcuartofrioindustrial.Sensores.Sensor;
import java.util.ArrayList;

public class GestorSensores {

    private ArrayList<Sensor> listaSensores;

    public GestorSensores() {
        listaSensores = new ArrayList<>();
    }

    public void agregarSensor(Sensor sensor) {
        listaSensores.add(sensor);
    }
    
    public void actualizarListaSensores(ArrayList<Sensor> nuevaLista) {
        if (nuevaLista != null) {
            this.listaSensores = nuevaLista;
        }
    }

    public ArrayList<Sensor> getSensores() {
        return listaSensores;
    }

    public void setSensores(ArrayList<Sensor> listaSensores) {
        this.listaSensores = listaSensores;
    }

    public ArrayList<Sensor> getListaSensores() {
        return listaSensores;
    }
}
