package sv.ues.fia.eisi.proyecto1.CRUDSector;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class SectorConsultarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
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
        if(!editIdSector.getText().toString().equals("") ){
            helper.abrir();
            Sector sector = helper.consultarSector(editIdSector.getText().toString());
            helper.cerrar();
            if(sector != null)
                editTipoSector.setText(sector.getTipoSector());
            else Toast.makeText(context, "No existe el idSector: "+editIdSector.getText().toString(), Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Campos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdSector.setText("");
        editTipoSector.setText("");
    }
}