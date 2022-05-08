package sv.ues.fia.eisi.proyecto1.CRUDEvaluacion;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class EvaluacionActualizarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdEvaluacion;
    EditText editIdLocal;
    EditText editIdCliente;
    EditText editIdTipoSatisfaccion;
    EditText editNotaEvaCliente;
    EditText editJustificacionCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluacion_actualizar);
        helper = new BD_Controlador(this);
        editIdEvaluacion = (EditText) findViewById(R.id.editIdEvaluacion);
        editIdLocal = (EditText) findViewById(R.id.editIdLocal);
        editIdCliente = (EditText) findViewById(R.id.editIdCliente);
        editIdTipoSatisfaccion = (EditText) findViewById(R.id.editIdTipoSatisfaccion);
        editNotaEvaCliente = (EditText) findViewById(R.id.editNotaEvaCliente);
        editJustificacionCliente = (EditText) findViewById(R.id.editJustificacionCliente);
    }

    public void actualizarEvaluacion(View v){
        if(!editIdEvaluacion.getText().toString().equals("") & !editIdLocal.getText().toString().equals("") &
                !editIdCliente.getText().toString().equals("") & !editIdTipoSatisfaccion.getText().toString().equals("") &
                !editNotaEvaCliente.getText().toString().equals("") & !editJustificacionCliente.getText().toString().equals("")){
            Evaluacion evaluacion = new Evaluacion(
                    editIdEvaluacion.getText().toString(),
                    editIdLocal.getText().toString(),
                    editIdCliente.getText().toString(),
                    editIdTipoSatisfaccion.getText().toString(),
                    Float.parseFloat(editNotaEvaCliente.getText().toString()),
                    editJustificacionCliente.getText().toString()
            );
            helper.abrir();
            String actualizar = helper.actualizar(evaluacion);
            helper.cerrar();
            Toast.makeText(context, actualizar, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Datos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdEvaluacion.setText("");
        editIdLocal.setText("");
        editIdCliente.setText("");
        editIdTipoSatisfaccion.setText("");
        editNotaEvaCliente.setText("");
        editJustificacionCliente.setText("");
    }
}