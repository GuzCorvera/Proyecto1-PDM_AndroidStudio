package sv.ues.fia.eisi.proyecto1.CRUDSugerencias;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class SugerenciasEliminarActivity extends Activity {
    BD_Controlador helper;
    EditText editIdSugerencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerencias_eliminar);
        helper = new BD_Controlador(this);
        editIdSugerencia = (EditText) findViewById(R.id.editIdSugerencia);
    }

    public void eliminarSugerencias(View v){

    }
}