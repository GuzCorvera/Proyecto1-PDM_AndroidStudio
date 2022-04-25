package sv.ues.fia.eisi.proyecto1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EvaluacionEliminarActivity extends Activity {
    BD_Controlador helper;
    EditText editIdLocal;
    EditText editIdCliente;
    EditText editIdTipoSatisfaccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluacion_eliminar);
        helper = new BD_Controlador(this);
        editIdLocal = (EditText) findViewById(R.id.editIdLocal);
        editIdCliente = (EditText) findViewById(R.id.editIdCliente);
        editIdTipoSatisfaccion = (EditText) findViewById(R.id.editIdTipoSatisfaccion);
    }

    public void eliminarEvaluacion(View v){

    }
    public void limpiarTexto(View v){

    }
}