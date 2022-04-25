package sv.ues.fia.eisi.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class OpcionCrud {

    private String idOpcion;
    private String descOpcion;
    private Integer numCrud;

    public OpcionCrud() {
    }

    public OpcionCrud(String idOpcion, String descOpcion, Integer numCrud) {
        this.idOpcion = idOpcion;
        this.descOpcion = descOpcion;
        this.numCrud = numCrud;
    }

    public String getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(String idOpcion) {
        this.idOpcion = idOpcion;
    }

    public String getDescOpcion() {
        return descOpcion;
    }

    public void setDescOpcion(String descOpcion) {
        this.descOpcion = descOpcion;
    }

    public Integer getNomCrud() {
        return numCrud;
    }

    public void setNomCrud(Integer nomCrud) {
        this.numCrud = nomCrud;
    }
}