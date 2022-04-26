package sv.ues.fia.eisi.proyecto1.CRUDTipoSatisfaccion;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class Tipo_SatisfaccionInsertarActivity extends Activity {
    BD_Controlador helper;
    EditText editIdTipoSatisfaccion;
    EditText editNomTipoSatisfaccion;
    EditText editNotaMenor;
    EditText editNotaMayor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_satisfaccion_insertar);
        helper = new BD_Controlador(this);
        editIdTipoSatisfaccion = (EditText) findViewById(R.id.editIdTipoSatisfaccion);
        editNomTipoSatisfaccion = (EditText) findViewById(R.id.editNomTipoSatisfaccion);
        editNotaMenor = (EditText) findViewById(R.id.editNotaMenor);
        editNotaMayor = (EditText) findViewById(R.id.editNotaMayor);
    }

    public void insertarTipoSatisfaccion(View v){

    }

    public void limpiarTexto(View v){

    }
}