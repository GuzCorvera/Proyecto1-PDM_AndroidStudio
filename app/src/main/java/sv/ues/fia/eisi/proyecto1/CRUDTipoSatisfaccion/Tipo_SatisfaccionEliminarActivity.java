package sv.ues.fia.eisi.proyecto1.CRUDTipoSatisfaccion;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class Tipo_SatisfaccionEliminarActivity extends Activity {
    BD_Controlador helper;
    EditText editIdTipoSatisfaccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_satisfaccion_eliminar);
        helper = new BD_Controlador(this);
        editIdTipoSatisfaccion = (EditText) findViewById(R.id.editIdTipoSatisfaccion);
    }

    public void eliminarTipoSatisfaccion(View v){

    }

    public void limpiarTexto(View v){

    }
}