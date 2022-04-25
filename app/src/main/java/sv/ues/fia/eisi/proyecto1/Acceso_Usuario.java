package sv.ues.fia.eisi.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Acceso_Usuario  {

    private String idUsuario;
    private String idOpcion;

    public Acceso_Usuario() {
    }

    public Acceso_Usuario(String idUsuario, String idOpcion) {
        this.idUsuario = idUsuario;
        this.idOpcion = idOpcion;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(String idOpcion) {
        this.idOpcion = idOpcion;
    }
}