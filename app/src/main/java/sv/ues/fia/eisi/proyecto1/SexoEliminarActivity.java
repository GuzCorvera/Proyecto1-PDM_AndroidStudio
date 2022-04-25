package sv.ues.fia.eisi.proyecto1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SexoEliminarActivity extends Activity {
    BD_Controlador helper;
    EditText editIdSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sexo_eliminar);
        helper = new BD_Controlador(this);
        editIdSexo = (EditText) findViewById(R.id.editIdSexo);
    }

    public void eliminarSexo(View v){

    }

    public void limpiarTexto(View v){

    }
}