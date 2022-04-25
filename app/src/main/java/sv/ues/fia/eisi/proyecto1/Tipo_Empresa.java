package sv.ues.fia.eisi.proyecto1;

public class Tipo_Empresa {

        private String idTipoEmpresa;
        private String nomTipoEmpresa;

    public Tipo_Empresa() {
    }

    public Tipo_Empresa(String idTipoEmpresa, String nomTipoEmpresa) {
        this.idTipoEmpresa = idTipoEmpresa;
        this.nomTipoEmpresa = nomTipoEmpresa;
    }

    public String getIdTipoEmpresa() {
        return idTipoEmpresa;
    }

    public void setIdTipoEmpresa(String idTipoEmpresa) {
        this.idTipoEmpresa = idTipoEmpresa;
    }

    public String getNomTipoEmpresa() {
        return nomTipoEmpresa;
    }

    public void setNomTipoEmpresa(String nomTipoEmpresa) {
        this.nomTipoEmpresa = nomTipoEmpresa;
    }
}