package sv.ues.fia.eisi.proyecto1.CRUDRangoEdad;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class Rango_EdadInsertarActivity extends Activity {
    BD_Controlador helper;
    EditText editIdRangoEdad;
    EditText editNombreRangoEdad;
    EditText editEdadMenor;
    EditText editEdadMayor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rango_edad_insertar);
        helper = new BD_Controlador(this);
        editIdRangoEdad = (EditText) findViewById(R.id.editIdRangoEdad);
        editNombreRangoEdad = (EditText) findViewById(R.id.editNombreRangoEdad);
        editEdadMenor = (EditText) findViewById(R.id.editEdadMenor);
        editEdadMayor = (EditText) findViewById(R.id.editEdadMayor);
    }

    public void insertarRangoEdad(View v){

    }

    public void limpiarTexto(View v){

    }
}