package sv.ues.fia.eisi.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Date;

public class Denuncias  {

    private String idDenuncias;
    private String idUsuario;
    private String idLocal;
    private String textDenuncia;
    private Date fechaDenuncia;

    public Denuncias() {
    }

    public Denuncias(String idDenuncias, String idUsuario, String idLocal, String textDenuncia, Date fechaDenuncia) {
        this.idDenuncias = idDenuncias;
        this.idUsuario = idUsuario;
        this.idLocal = idLocal;
        this.textDenuncia = textDenuncia;
        this.fechaDenuncia = fechaDenuncia;
    }

    public String getIdDenuncias() {
        return idDenuncias;
    }

    public void setIdDenuncias(String idDenuncias) {
        this.idDenuncias = idDenuncias;
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

    public String getTextDenuncia() {
        return textDenuncia;
    }

    public void setTextDenuncia(String textDenuncia) {
        this.textDenuncia = textDenuncia;
    }

    public Date getFechaDenuncia() {
        return fechaDenuncia;
    }

    public void setFechaDenuncia(Date fechaDenuncia) {
        this.fechaDenuncia = fechaDenuncia;
    }
}