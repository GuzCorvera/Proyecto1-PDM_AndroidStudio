package sv.ues.fia.eisi.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Departamento{

    private String idDepartamento;
    private String nomDepartamento;

    public Departamento() {
    }

    public Departamento(String idDepartamento, String nomDepartamento) {
        this.idDepartamento = idDepartamento;
        this.nomDepartamento = nomDepartamento;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNomDepartamento() {
        return nomDepartamento;
    }

    public void setNomDepartamento(String nomDepartamento) {
        this.nomDepartamento = nomDepartamento;
    }
}