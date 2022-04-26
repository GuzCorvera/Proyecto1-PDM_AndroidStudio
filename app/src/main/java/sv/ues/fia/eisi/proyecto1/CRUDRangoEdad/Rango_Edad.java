package sv.ues.fia.eisi.proyecto1.CRUDRangoEdad;

public class Rango_Edad {

    private String idRangoEdad;
    private String nomRangoEdad;
    private float edadMenor;
    private float edadMayor;

    public Rango_Edad() {
    }

    public Rango_Edad(String idRangoEdad) {
        this.idRangoEdad = idRangoEdad;
    }

    public Rango_Edad(String idRangoEdad, String nomRangoEdad, float edadMenor, float edadMayor) {
        this.idRangoEdad = idRangoEdad;
        this.nomRangoEdad = nomRangoEdad;
        this.edadMenor = edadMenor;
        this.edadMayor = edadMayor;
    }

    public String getIdRangoEdad() {
        return idRangoEdad;
    }

    public void setIdRangoEdad(String idRangoEdad) {
        this.idRangoEdad = idRangoEdad;
    }

    public String getNomRangoEdad() {
        return nomRangoEdad;
    }

    public void setNomRangoEdad(String nomRangoEdad) {
        this.nomRangoEdad = nomRangoEdad;
    }

    public float getEdadMenor() {
        return edadMenor;
    }

    public void setEdadMenor(float edadMenor) {
        this.edadMenor = edadMenor;
    }

    public float getEdadMayor() {
        return edadMayor;
    }

    public void setEdadMayor(float edadMayor) {
        this.edadMayor = edadMayor;
    }
}