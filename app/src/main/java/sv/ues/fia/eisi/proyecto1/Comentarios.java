package sv.ues.fia.eisi.proyecto1;

import java.util.Date;

public class Comentarios  {

    private String idComentario;
    private String idUsuario;
    private String idLocal;
    private String textComentario;
    private Date fechaComentario;

    public Comentarios() {
    }

    public Comentarios(String idComentario, String idUsuario, String idLocal, String textComentario, Date fechaComentario) {
        this.idComentario = idComentario;
        this.idUsuario = idUsuario;
        this.idLocal = idLocal;
        this.textComentario = textComentario;
        this.fechaComentario = fechaComentario;
    }

    public String getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(String idComentario) {
        this.idComentario = idComentario;
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