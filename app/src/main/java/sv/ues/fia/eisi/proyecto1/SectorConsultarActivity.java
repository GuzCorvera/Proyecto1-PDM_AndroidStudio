package sv.ues.fia.eisi.proyecto1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SectorConsultarActivity extends Activity {
    BD_Controlador helper;
    EditText editIdSector;
    EditText editTipoSector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector_consultar);
        helper = new BD_Controlador(this);
        editIdSector = (EditText) findViewById(R.id.editIdSector);
        editTipoSector = (EditText) findViewById(R.id.editTipoSector);
    }

    public void consultarSector(View v){

    }

    public void limpiarTexto(View v){

    }
}