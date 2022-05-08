package sv.ues.fia.eisi.proyecto1.CRUDEvaluacion;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class EvaluacionEliminarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdEvaluacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluacion_eliminar);
        helper = new BD_Controlador(this);
        editIdEvaluacion = (EditText) findViewById(R.id.editIdEvaluacion);
    }

    public void eliminarEvaluacion(View v){
        if(!editIdEvaluacion.getText().toString().equals("")){
            Evaluacion evaluacion = new Evaluacion(editIdEvaluacion.getText().toString());
            helper.abrir();
            String eliminar = helper.eliminar(evaluacion);
            helper.cerrar();
            Toast.makeText(context, eliminar, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Datos vacíos", Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v){
        editIdEvaluacion.setText("");
    }
}