package sv.ues.fia.eisi.proyecto1.CRUDEvaluacion;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class EvaluacionInsertarActivity extends Activity {
    BD_Controlador helper;
    EditText editIdLocal;
    EditText editIdCliente;
    EditText editIdTipoSatisfaccion;
    EditText editNotaEvaCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluacion_insertar);
        helper = new BD_Controlador(this);
        editIdLocal = (EditText) findViewById(R.id.editIdLocal);
        editIdCliente = (EditText) findViewById(R.id.editIdCliente);
        editIdTipoSatisfaccion = (EditText) findViewById(R.id.editIdTipoSatisfaccion);
        editNotaEvaCliente = (EditText) findViewById(R.id.editNotaEvaCliente);
    }

    public void insertarEvaluacion(View v){

    }

    public void limpiarTexto(View v){

    }
}