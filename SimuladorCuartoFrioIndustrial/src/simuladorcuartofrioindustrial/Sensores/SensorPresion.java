package simuladorcuartofrioindustrial.Sensores;

import simuladorcuartofrioindustrial.Excepciones.ParametroFueraDeRangoException;
import simuladorcuartofrioindustrial.Excepciones.RangoVacioException;
import simuladorcuartofrioindustrial.Sensores.Sensor;

public class SensorPresion extends Sensor {

    public SensorPresion(String id, String nombre, double limiteInferior, double limiteSuperior) throws ParametroFueraDeRangoException {
        super(id, nombre, limiteInferior, limiteSuperior);
    }
    
    public SensorPresion(){
    }

//----------------------------------------------------------------------------------------------
    @Override
    public void procesarLectura(double valor) {
        try {
            validarValor(valor);
            setValorActual(valor);
            System.out.println("Presion registrada: " + valor + " Pa");
        } catch (RangoVacioException e) {
            System.out.println("ERROR, " + e.getMessage());
        }
    }

//----------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "SensorPresion " + super.toString();
    }
}
