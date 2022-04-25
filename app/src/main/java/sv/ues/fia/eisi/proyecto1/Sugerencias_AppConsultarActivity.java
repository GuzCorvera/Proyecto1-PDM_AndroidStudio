package sv.ues.fia.eisi.proyecto1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Sugerencias_AppConsultarActivity extends Activity {
    BD_Controlador helper;
    EditText editIdSugerenciasApp;
    EditText editIdUsuario;
    EditText editTxtSugerenciasApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerencias_app_consultar);
        helper = new BD_Controlador(this);
        editIdSugerenciasApp = (EditText) findViewById(R.id.editIdSugerenciasApp);
        editIdUsuario = (EditText) findViewById(R.id.editIdUsuario);
        editTxtSugerenciasApp = (EditText) findViewById(R.id.editTxtSugerenciasApp);
    }

    public void consultarSugerenciasApp(View v){

    }

    public void limpiarTexto(View v){

    }
}