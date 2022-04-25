package sv.ues.fia.eisi.proyecto1;

public class Usuario {

    private String idUsuario;
    private String idTipoUsuario;
    private String idEmpresa;
    private String nomUsuario;
    private String contraUsuario;
    private String correoUsuario;

    public Usuario() {
    }

    public Usuario(String idUsuario, String idTipoUsuario, String idEmpresa, String nomUsuario, String contraUsuario, String correoUsuario) {
        this.idUsuario = idUsuario;
        this.idTipoUsuario = idTipoUsuario;
        this.idEmpresa = idEmpresa;
        this.nomUsuario = nomUsuario;
        this.contraUsuario = contraUsuario;
        this.correoUsuario = correoUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(String idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getContraUsuario() {
        return contraUsuario;
    }

    public void setContraUsuario(String contraUsuario) {
        this.contraUsuario = contraUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }
}