package simuladorcuartofrioindustrial;

public class SensorTemperatura extends Sensor {

    public SensorTemperatura(String id, String nombre, double limiteInferior, double limiteSuperior) throws ParametroFueraDeRangoException {
        super(id, nombre, limiteInferior, limiteSuperior);
    }

//----------------------------------------------------------------------------------------------
    @Override
    public void procesarLectura(double valor) {
        try {
            setValorActual(valor);
            System.out.println("Temperatura registrada: " + valor + " °C");
        } catch (ParametroFueraDeRangoException e) {
            System.out.println("ERROR, " + e.getMessage());
        }
    }

//----------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "SensorTemperatura " + super.toString();
    }

}
