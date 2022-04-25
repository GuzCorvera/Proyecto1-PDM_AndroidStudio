package sv.ues.fia.eisi.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Date;

public class Sugerencias  {

    private String idSugerencia;
    private String idUsuario;
    private String idLocal;
    private String textSugerencia;
    private Date fechaSugerencia;

    public Sugerencias() {
    }

    public Sugerencias(String idSugerencia, String idUsuario, String idLocal, String textSugerencia, Date fechaSugerencia) {
        this.idSugerencia = idSugerencia;
        this.idUsuario = idUsuario;
        this.idLocal = idLocal;
        this.textSugerencia = textSugerencia;
        this.fechaSugerencia = fechaSugerencia;
    }

    public String getIdSugerencia() {
        return idSugerencia;
    }

    public void setIdSugerencia(String idSugerencia) {
        this.idSugerencia = idSugerencia;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(String idLocal) {
        this.idLocal = idLocal;
    }

    public String getTextSugerencia() {
        return textSugerencia;
    }

    public void setTextSugerencia(String textSugerencia) {
        this.textSugerencia = textSugerencia;
    }

    public Date getFechaSugerencia() {
        return fechaSugerencia;
    }

    public void setFechaSugerencia(Date fechaSugerencia) {
        this.fechaSugerencia = fechaSugerencia;
    }
}