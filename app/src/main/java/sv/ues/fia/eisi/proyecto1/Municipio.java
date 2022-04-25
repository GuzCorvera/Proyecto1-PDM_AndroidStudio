package sv.ues.fia.eisi.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Municipio {

    private String idMunicipio;
    private String idDepartamento;
    private String nomMunicipio;


    public Municipio() {
    }

    public Municipio(String idMunicipio, String idDepartamento, String nomMunicipio) {
        this.idMunicipio = idMunicipio;
        this.idDepartamento = idDepartamento;
        this.nomMunicipio = nomMunicipio;
    }

    public String getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(String idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNomMunicipio() {
        return nomMunicipio;
    }

    public void setNomMunicipio(String nomMunicipio) {
        this.nomMunicipio = nomMunicipio;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
}