package sv.ues.fia.eisi.proyecto1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MunicipioActualizarActivity extends Activity {
    BD_Controlador helper;
    EditText editIdMunicipio;
    EditText editIdDepartamento;
    EditText editNomMunicipio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipio_actualizar);
        helper = new BD_Controlador(this);
        editIdMunicipio = (EditText) findViewById(R.id.editIdMunicipio);
        editIdDepartamento = (EditText) findViewById(R.id.editIdDepartamento);
        editNomMunicipio = (EditText) findViewById(R.id.editNomMunicipio);
    }

    public void actualizarMunicipio(View v){

    }

    public void limpiarTexto(View v){

    }
}