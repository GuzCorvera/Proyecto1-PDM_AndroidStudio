package sv.ues.fia.eisi.proyecto1.CRUDEmpresa;

public class Empresa {

    private String idEmpresa;
    private String idTipoEmpresa;
    private String nomLegalEmpresa;
    private String nitEmpresa;
    private String giroEmpresa;
    private String nrcEmpresa;

    public Empresa() {
    }

    public Empresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Empresa(String idEmpresa, String idTipoEmpresa, String nomLegalEmpresa, String nitEmpresa, String giroEmpresa, String nrcEmpresa) {
        this.idEmpresa = idEmpresa;
        this.idTipoEmpresa = idTipoEmpresa;
        this.nomLegalEmpresa = nomLegalEmpresa;
        this.nitEmpresa = nitEmpresa;
        this.giroEmpresa = giroEmpresa;
        this.nrcEmpresa = nrcEmpresa;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getIdTipoEmpresa() {

        return idTipoEmpresa;
    }

    public void setIdTipoEmpresa(String idTipoEmpresa) {

        this.idTipoEmpresa = idTipoEmpresa;
    }

    public String getNomLegalEmpresa() {

        return nomLegalEmpresa;
    }

    public void setNomLegalEmpresa(String nomLegalEmpresa) {
        this.nomLegalEmpresa = nomLegalEmpresa;
    }

    public String getNitEmpresa() {

        return nitEmpresa;
    }

    public void setNitEmpresa(String nitEmpresa) {

        this.nitEmpresa = nitEmpresa;
    }

    public String getGiroEmpresa() {

        return giroEmpresa;
    }

    public void setGiroEmpresa(String giroEmpresa) {

        this.giroEmpresa = giroEmpresa;
    }

    public String getNrcEmpresa() {
        return nrcEmpresa;
    }

    public void setNrcEmpresa(String nrcEmpresa) {
        this.nrcEmpresa = nrcEmpresa;
    }
}