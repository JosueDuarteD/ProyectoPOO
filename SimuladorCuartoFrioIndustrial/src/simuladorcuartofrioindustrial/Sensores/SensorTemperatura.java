package simuladorcuartofrioindustrial.Sensores;

import simuladorcuartofrioindustrial.Excepciones.ParametroFueraDeRangoException;
import simuladorcuartofrioindustrial.Excepciones.RangoVacioException;
import simuladorcuartofrioindustrial.Sensores.Sensor;

public class SensorTemperatura extends Sensor {

    public SensorTemperatura(String id, String nombre, double limiteInferior, double limiteSuperior) throws ParametroFueraDeRangoException {
        super(id, nombre, limiteInferior, limiteSuperior);
    }
    
    public SensorTemperatura(){
    }
//----------------------------------------------------------------------------------------------
    @Override
    public void procesarLectura(double valor) {
        try {
            validarValor(valor);
            setValorActual(valor);
            System.out.println("Temperatura registrada: " + valor + " °C");
        } catch (RangoVacioException e) {
            System.out.println("ERROR, " + e.getMessage());
        }
    }

//----------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "SensorTemperatura " + super.toString();
    }

}
