package sv.ues.fia.eisi.proyecto1.CRUDSector;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class SectorEliminarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
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