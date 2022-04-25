package sv.ues.fia.eisi.proyecto1;

public class Tipo_Satisfaccion {

    private String idTipoSatisfaccion;
    private String nomTipoSatisfaccion;
    private float notaMenor;
    private float notaMayor;

    public Tipo_Satisfaccion() {
    }

    public Tipo_Satisfaccion(String idTipoSatisfaccion, String nomTipoSatisfaccion, float notaMenor, float notaMayor) {
        this.idTipoSatisfaccion = idTipoSatisfaccion;
        this.nomTipoSatisfaccion = nomTipoSatisfaccion;
        this.notaMenor = notaMenor;
        this.notaMayor = notaMayor;
    }

    public String getIdTipoSatisfaccion() {
        return idTipoSatisfaccion;
    }

    public void setIdTipoSatisfaccion(String idTipoSatisfaccion) {
        this.idTipoSatisfaccion = idTipoSatisfaccion;
    }

    public String getNomTipoSatisfaccion() {
        return nomTipoSatisfaccion;
    }

    public void setNomTipoSatisfaccion(String nomTipoSatisfaccion) {
        this.nomTipoSatisfaccion = nomTipoSatisfaccion;
    }

    public float getNotaMenor() {
        return notaMenor;
    }

    public void setNotaMenor(float notaMenor) {
        this.notaMenor = notaMenor;
    }

    public float getNotaMayor() {
        return notaMayor;
    }

    public void setNotaMayor(float notaMayor) {
        this.notaMayor = notaMayor;
    }
}