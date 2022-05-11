package sv.ues.fia.eisi.proyecto1;

public class UsuarioTemp {
    private String idUsuarioTemp = "";
    private String tipoUsuarioTemp = "";

    public UsuarioTemp(){

    }
    public UsuarioTemp(String idUsuarioTemp) {
        this.idUsuarioTemp = idUsuarioTemp;
    }

    public UsuarioTemp(String idUsuarioTemp, String tipoUsuarioTemp) {
        this.idUsuarioTemp = idUsuarioTemp;
        this.tipoUsuarioTemp = tipoUsuarioTemp;
    }

    public String getIdUsuarioTemp() {
        return idUsuarioTemp;
    }

    public void setIdUsuarioTemp(String idUsuarioTemp) {
        this.idUsuarioTemp = idUsuarioTemp;
    }

    public String getTipoUsuarioTemp() {
        return tipoUsuarioTemp;
    }

    public void setTipoUsuarioTemp(String tipoUsuarioTemp) {
        this.tipoUsuarioTemp = tipoUsuarioTemp;
    }
}
