package simuladorcuartofrioindustrial;

public class SensorPuerta extends Sensor {

    public SensorPuerta(String id, String nombre) throws ParametroFueraDeRangoException {
        super(id, nombre, 0, 1);
    }

//----------------------------------------------------------------------------------------------
    @Override
    public void procesarLectura(double valor) {
        try {
            verificarRangoBinario(valor);
            setValorActual(valor);
            verificarPuertaAbierta(valor);
        } catch (ParametroFueraDeRangoException | PuertaAbiertaException e) {
            System.out.println("ERROR, " + e.getMessage());
        }
    }

    public void verificarPuertaAbierta(double valor) throws PuertaAbiertaException {
        if (valor == 1) {
            throw new PuertaAbiertaException("La puerta del cuarto frio esta abierta");
        }
    }

    public void verificarRangoBinario(double valor) throws ParametroFueraDeRangoException {
        if (valor != 0 && valor != 1) {
            throw new ParametroFueraDeRangoException("El sensor de puerta solo acepta " + "0 (cerrada) o 1 (abierta)");
        }
    }
//----------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        String estado = (getValorActual() == 1) ? "Abierta" : "Cerrada";
        return "SensorPuerta id: " + super.getId() + ", nombre: " + super.getNombre() + ", Estado puerta: " + estado;
    }
}
