package sv.ues.fia.eisi.proyecto1.CRUDSugerenciasApp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class Sugerencias_AppEliminarActitvity extends Activity {
    BD_Controlador helper;
    EditText editIdSugerenciasApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerencias_app_eliminar_actitvity);
        helper = new BD_Controlador(this);
        editIdSugerenciasApp = (EditText) findViewById(R.id.editIdSugerenciasApp);
    }

    public void eliminarSugerenciasApp(View v){

    }

    public void limpiarTexto(View v){

    }
}