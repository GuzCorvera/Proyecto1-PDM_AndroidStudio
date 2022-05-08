package sv.ues.fia.eisi.proyecto1.CRUDDenuncias;

public class Denuncia {

    private String idDenuncia;
    private String idUsuario;
    private String idLocal;
    private String textDenuncia;
    private String fechaDenuncia;

    public Denuncia() {
    }

    public Denuncia(String idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public Denuncia(String idDenuncia, String idUsuario, String idLocal, String textDenuncia, String fechaDenuncia) {
        this.idDenuncia = idDenuncia;
        this.idUsuario = idUsuario;
        this.idLocal = idLocal;
        this.textDenuncia = textDenuncia;
        this.fechaDenuncia = fechaDenuncia;
    }

    public String getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(String idDenuncia) {
        this.idDenuncia = idDenuncia;
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

    public String getFechaDenuncia() {
        return fechaDenuncia;
    }

    public void setFechaDenuncia(String fechaDenuncia) {
        this.fechaDenuncia = fechaDenuncia;
    }
}