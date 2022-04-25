package sv.ues.fia.eisi.proyecto1;

public class Tipo_Usuario {

    private String idTipoUsuario;
    private String desTipoUsuario;

    public Tipo_Usuario() {
    }

    public Tipo_Usuario(String idTipoUsuario, String desTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
        this.desTipoUsuario = desTipoUsuario;
    }

    public String getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(String idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getDesTipoUsuario() {
        return desTipoUsuario;
    }

    public void setDesTipoUsuario(String desTipoUsuario) {
        this.desTipoUsuario = desTipoUsuario;
    }
}