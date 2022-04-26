package sv.ues.fia.eisi.proyecto1.CRUDSugerencias;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class SugerenciasConsultarActivity extends Activity {
    BD_Controlador helper;
    EditText editIdSugerencia;
    EditText editIdUsuarioSugerencia;
    EditText editIdLocalSugerencia;
    EditText editTextSugerencia;
    EditText editFechaSugerencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerencias_consultar);
        helper = new BD_Controlador(this);
        editIdSugerencia = (EditText) findViewById(R.id.editIdSugerencia);
        editIdUsuarioSugerencia = (EditText) findViewById(R.id.editIdUsuarioSugerencia);
        editIdLocalSugerencia = (EditText) findViewById(R.id.editIdLocalSugerencia);
        editTextSugerencia = (EditText) findViewById(R.id.editTextSugerencia);
        editFechaSugerencia = (EditText) findViewById(R.id.editFechaSugerencia);
    }

    public void consultarSugerencias(View v){

    }

    public void limpiarTexto(View v){

    }
}