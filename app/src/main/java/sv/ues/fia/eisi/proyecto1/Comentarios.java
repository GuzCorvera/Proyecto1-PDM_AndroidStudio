package sv.ues.fia.eisi.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Date;

public class Comentarios  {

    private String idComentarios;
    private String idUsuario;
    private String idLocal;
    private String textComentario;
    private Date fechaComentario;

    public Comentarios() {
    }

    public Comentarios(String idComentarios, String idUsuario, String idLocal, String textComentario, Date fechaComentario) {
        this.idComentarios = idComentarios;
        this.idUsuario = idUsuario;
        this.idLocal = idLocal;
        this.textComentario = textComentario;
        this.fechaComentario = fechaComentario;
    }

    public String getIdComentarios() {
        return idComentarios;
    }

    public void setIdComentarios(String idComentarios) {
        this.idComentarios = idComentarios;
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

    public String getTextComentario() {
        return textComentario;
    }

    public void setTextComentario(String textComentario) {
        this.textComentario = textComentario;
    }

    public Date getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(Date fechaComentario) {
        this.fechaComentario = fechaComentario;
    }
}