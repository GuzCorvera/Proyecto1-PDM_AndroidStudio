package sv.ues.fia.eisi.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Evaluacion {

    private String idEvaluacion;
    private String idLocal;
    private String idCliente;
    private String idTipoSatisfaccion;
    private float notaEvaCliente;

    public Evaluacion() {
    }

    public Evaluacion(String idEvaluacion, String idLocal, String idCliente, String idTipoSatisfaccion, float notaEvaCliente) {
        this.idEvaluacion = idEvaluacion;
        this.idLocal = idLocal;
        this.idCliente = idCliente;
        this.idTipoSatisfaccion = idTipoSatisfaccion;
        this.notaEvaCliente = notaEvaCliente;
    }

    public String getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(String idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public String getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(String idLocal) {
        this.idLocal = idLocal;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdTipoSatisfaccion() {
        return idTipoSatisfaccion;
    }

    public void setIdTipoSatisfaccion(String idTipoSatisfaccion) {
        this.idTipoSatisfaccion = idTipoSatisfaccion;
    }

    public float getNotaEvaCliente() {
        return notaEvaCliente;
    }

    public void setNotaEvaCliente(float notaEvaCliente) {
        this.notaEvaCliente = notaEvaCliente;
    }
}