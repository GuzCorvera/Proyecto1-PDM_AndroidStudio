package sv.ues.fia.eisi.proyecto1;

public class Sector {

    private String idSector;
    private String tipoSector;

    public Sector(){

    }

    public Sector(String idSector, String tipoSector){
        this.idSector=idSector;
        this.tipoSector=tipoSector;
    }

    public String getIdSector() {
        return idSector;
    }

    public void setIdSector(String idSector) {
        this.idSector = idSector;
    }

    public String getTipoSector() {
        return tipoSector;
    }

    public void setTipoSector(String tipoSector) {
        this.tipoSector = tipoSector;
    }
}

