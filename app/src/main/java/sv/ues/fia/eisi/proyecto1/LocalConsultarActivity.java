package sv.ues.fia.eisi.proyecto1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LocalConsultarActivity extends Activity {
    BD_Controlador helper;
    EditText editIdLocal;
    EditText editIdEmpresa;
    EditText editIdSector;
    EditText editIdMunicipio;
    EditText editNombreLocal;
    EditText editDescripLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_consultar);
        helper = new BD_Controlador(this);
        editIdLocal = (EditText) findViewById(R.id.editIdLocal);
        editIdEmpresa = (EditText) findViewById(R.id.editIdEmpresa);
        editIdSector = (EditText) findViewById(R.id.editIdSector);
        editIdMunicipio = (EditText) findViewById(R.id.editIdMunicipio);
        editNombreLocal = (EditText) findViewById(R.id.editNombreLocal);
        editDescripLocal = (EditText) findViewById(R.id.editDescripLocal);
    }

    public void consultarLocal(View v){

    }

    public void limpiarTexto(View v){

    }
}