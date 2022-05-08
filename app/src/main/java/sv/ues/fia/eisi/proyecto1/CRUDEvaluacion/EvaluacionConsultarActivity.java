package sv.ues.fia.eisi.proyecto1.CRUDEvaluacion;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class EvaluacionConsultarActivity extends Activity {
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
        setContentView(R.layout.activity_evaluacion_consultar);
        helper = new BD_Controlador(this);
        editIdEvaluacion = (EditText) findViewById(R.id.editIdEvaluacion);
        editIdLocal = (EditText) findViewById(R.id.editIdLocal);
        editIdCliente = (EditText) findViewById(R.id.editIdCliente);
        editIdTipoSatisfaccion = (EditText) findViewById(R.id.editIdTipoSatisfaccion);
        editNotaEvaCliente = (EditText) findViewById(R.id.editNotaEvaCliente);
        editJustificacionCliente = (EditText) findViewById(R.id.editJustificacionCliente);
    }

    public void consultarEvaluacion(View v){
        if(!editIdEvaluacion.getText().toString().equals("")){
            helper.abrir();
            Evaluacion evaluacion = helper.consultarEvaluacion(editIdEvaluacion.getText().toString());
            helper.cerrar();
            if(evaluacion!=null){
                editIdLocal.setText(evaluacion.getIdLocal());
                editIdCliente.setText(evaluacion.getIdCliente());
                editIdTipoSatisfaccion.setText(evaluacion.getIdTipoSatisfaccion());
                editNotaEvaCliente.setText(String.valueOf(evaluacion.getNotaEvaCliente()));
                editJustificacionCliente.setText(evaluacion.getJustificacionCliente());
            }else Toast.makeText(context, "No existe N°="+editIdEvaluacion.getText().toString(), Toast.LENGTH_SHORT).show();
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