package simuladorcuartofrioindustrial;

public class SensorPresion extends Sensor {

    public SensorPresion(String id, String nombre, double limiteInferior, double limiteSuperior) throws ParametroFueraDeRangoException {
        super(id, nombre, limiteInferior, limiteSuperior);
    }

//----------------------------------------------------------------------------------------------
    @Override
    public void procesarLectura(double valor) {
        try {
            setValorActual(valor);
            System.out.println("Presion registrada: " + valor + " Pa");
        } catch (ParametroFueraDeRangoException e) {
            System.out.println("ERROR, " + e.getMessage());
        }
    }

//----------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "SensorPresion " + super.toString();
    }
}
