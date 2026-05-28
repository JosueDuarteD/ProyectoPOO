package simuladorcuartofrioindustrial;

import java.io.Serializable;

public abstract class Sensor implements Serializable{

    private String id;
    private String nombre;
    private double valorActual;
    private double limiteInferior;
    private double limiteSuperior;

//----------------------------------------------------------------------------------------------
    public Sensor(String id, String nombre, double limiteInferior, double limiteSuperior) throws ParametroFueraDeRangoException {
        revisarLimites(limiteInferior, limiteSuperior);
        this.id = id;
        this.nombre = nombre;
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
    }

    public abstract void procesarLectura(double valor);

    public void validarRango(double valor) throws ParametroFueraDeRangoException {
        if ((valor < limiteInferior || valor > limiteSuperior)) {
            throw new ParametroFueraDeRangoException("El valor actual esta fuera de los limites");
        }
    }

    private void revisarLimites(double inferior, double superior) throws ParametroFueraDeRangoException {
        if (inferior >= superior) {
            throw new ParametroFueraDeRangoException(
                    "El límite inferior no puede ser mayor o igual al superior"
            );
        }
    }

//----------------------------------------------------------------------------------------------
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValorActual() {
        return valorActual;
    }

    public double getLimiteInferior() {
        return limiteInferior;
    }

    public double getLimiteSuperior() {
        return limiteSuperior;
    }

//----------------------------------------------------------------------------------------------
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setValorActual(double valorActual) throws ParametroFueraDeRangoException {
        validarRango(valorActual);
        this.valorActual = valorActual;
    }

    public void setLimiteInferior(double limiteInferior) throws ParametroFueraDeRangoException {
        revisarLimites(limiteInferior, this.limiteSuperior);
        this.limiteInferior = limiteInferior;
    }

    public void setLimiteSuperior(double limiteSuperior) throws ParametroFueraDeRangoException {
        revisarLimites(this.limiteInferior, limiteSuperior);
        this.limiteSuperior = limiteSuperior;
    }

//----------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return  "id: " + id + ", nombre: " + nombre + ", valorActual: " + valorActual + ", limiteInferior: " + limiteInferior + ", limiteSuperior: " + limiteSuperior + '}';
    }
}
