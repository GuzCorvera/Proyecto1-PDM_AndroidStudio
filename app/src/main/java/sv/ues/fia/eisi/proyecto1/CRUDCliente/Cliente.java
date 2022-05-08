package sv.ues.fia.eisi.proyecto1.CRUDCliente;

public class Cliente  {

    private String idCliente;
    private String idRangoEdad;
    private String idUsuario;
    private String idSexo;
    private String nomcliente;
    private String telefonoCliente;

    public Cliente() {
    }

    public Cliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(String idCliente, String idRangoEdad, String idUsuario, String idSexo, String nomcliente, String telefonoCliente) {
        this.idCliente = idCliente;
        this.idRangoEdad = idRangoEdad;
        this.idUsuario = idUsuario;
        this.idSexo = idSexo;
        this.nomcliente = nomcliente;
        this.telefonoCliente = telefonoCliente;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdRangoEdad() {
        return idRangoEdad;
    }

    public void setIdRangoEdad(String idRangoEdad) {
        this.idRangoEdad = idRangoEdad;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(String idSexo) {
        this.idSexo = idSexo;
    }

    public String getNomcliente() {
        return nomcliente;
    }

    public void setNomcliente(String nomcliente) {
        this.nomcliente = nomcliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }
}