package sv.ues.fia.eisi.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Sexo {

    private String idSexo;
    private String nomSexo;
    private String abreviaturaSexo;

    public Sexo() {
    }

    public Sexo(String idSexo, String nomSexo, String abreviaturaSexo) {
        this.idSexo = idSexo;
        this.nomSexo = nomSexo;
        this.abreviaturaSexo = abreviaturaSexo;
    }

    public String getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(String idSexo) {
        this.idSexo = idSexo;
    }

    public String getNomSexo() {
        return nomSexo;
    }

    public void setNomSexo(String nomSexo) {
        this.nomSexo = nomSexo;
    }

    public String getAbreviaturaSexo() {
        return abreviaturaSexo;
    }

    public void setAbreviaturaSexo(String abreviaturaSexo) {
        this.abreviaturaSexo = abreviaturaSexo;
    }
}