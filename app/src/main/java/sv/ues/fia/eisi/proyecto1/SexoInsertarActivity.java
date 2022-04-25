package sv.ues.fia.eisi.proyecto1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SexoInsertarActivity extends Activity {
    BD_Controlador helper;
    EditText editIdSexo;
    EditText editNomSexo;
    EditText editAbreviaturaSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sexo_insertar);
        helper = new BD_Controlador(this);
        editIdSexo = (EditText) findViewById(R.id.editIdSexo);
        editNomSexo = (EditText) findViewById(R.id.editNomSexo);
        editAbreviaturaSexo = (EditText) findViewById(R.id.editAbreviaturaSexo);
    }

    public void insertarSexo(View v){

    }

    public void limpiarTexto(View v){

    }
}