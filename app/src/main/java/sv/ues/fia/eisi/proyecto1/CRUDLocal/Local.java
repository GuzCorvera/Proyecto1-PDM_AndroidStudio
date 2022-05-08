package sv.ues.fia.eisi.proyecto1.CRUDLocal;

public class Local {

    private String idLocal;
    private String idEmpresa;
    private String idSector;
    private String idMunicipio;
    private String nombreLocal;
    private String descripLocal;

    public Local() {
    }

    public Local(String idLocal) {
        this.idLocal = idLocal;
    }

    public Local(String idLocal, String idEmpresa, String idSector, String idMunicipio, String nombreLocal, String descripLocal) {
        this.idLocal = idLocal;
        this.idEmpresa = idEmpresa;
        this.idSector = idSector;
        this.idMunicipio = idMunicipio;
        this.nombreLocal = nombreLocal;
        this.descripLocal = descripLocal;
    }

    public String getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(String idLocal) {
        this.idLocal = idLocal;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getIdSector() {
        return idSector;
    }

    public void setIdSector(String idSector) {
        this.idSector = idSector;
    }

    public String getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(String idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    public String getDescripLocal() {
        return descripLocal;
    }

    public void setDescripLocal(String descripLocal) {
        this.descripLocal = descripLocal;
    }
}