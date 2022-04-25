package sv.ues.fia.eisi.proyecto1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DenunciasActualizarActivity extends Activity {
    BD_Controlador helper;
    EditText editIdDenuncia;
    EditText editIdUsuarioDenuncia;
    EditText editIdLocalDenuncia;
    EditText editTextDenuncia;
    EditText editFechaDenuncia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denuncias_actualizar);
        helper = new BD_Controlador(this);
        editIdDenuncia = (EditText) findViewById(R.id.editIdDenuncia);
        editIdUsuarioDenuncia = (EditText) findViewById(R.id.editIdUsuarioDenuncia);
        editIdLocalDenuncia = (EditText) findViewById(R.id.editIdLocalDenuncia);
        editTextDenuncia = (EditText) findViewById(R.id.editTextDenuncia);
        editFechaDenuncia = (EditText) findViewById(R.id.editFechaDenuncia);
    }

    public void actualizarDenuncias(View v){

    }

    public void limpiarTexto(View v){

    }
}