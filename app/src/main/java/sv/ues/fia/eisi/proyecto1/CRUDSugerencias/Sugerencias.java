package sv.ues.fia.eisi.proyecto1.CRUDSugerencias;

public class Sugerencias  {

    private String idSugerencia;
    private String idUsuario;
    private String idLocal;
    private String textSugerencia;
    private String fechaSugerencia;

    public Sugerencias() {
    }

    public Sugerencias(String idSugerencia, String idUsuario, String idLocal, String textSugerencia, String fechaSugerencia) {
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

    public String getFechaSugerencia() {
        return fechaSugerencia;
    }

    public void setFechaSugerencia(String fechaSugerencia) {
        this.fechaSugerencia = fechaSugerencia;
    }
}