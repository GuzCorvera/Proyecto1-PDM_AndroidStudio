package sv.ues.fia.eisi.proyecto1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SectorEliminarActivity extends Activity {
    BD_Controlador helper;
    EditText editIdSector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector_eliminar);
        helper = new BD_Controlador(this);
        editIdSector = (EditText) findViewById(R.id.editIdSector);
    }

    public void eliminarSector(View v){

    }

    public void limpiarTexto(View v){

    }
}