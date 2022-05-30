package sv.ues.fia.eisi.proyecto1.CRUDSugerencias;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class SugerenciasEliminarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdSugerencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerencias_eliminar);
        helper = new BD_Controlador(this);
        editIdSugerencia = (EditText) findViewById(R.id.editIdSugerencia);
    }

    public void eliminarSugerencias(View v){
        if(!editIdSugerencia.getText().toString().equals("")){
            Sugerencias sugerencias = new Sugerencias(editIdSugerencia.getText().toString());
            helper.abrir();
            String eliminar =  helper.eliminar(sugerencias);
            helper.cerrar();
            Toast.makeText(context, eliminar, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Campo idSugerencias vacío", Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v){
        editIdSugerencia.setText("");
    }
}