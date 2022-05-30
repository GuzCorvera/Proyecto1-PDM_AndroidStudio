package sv.ues.fia.eisi.proyecto1.CRUDLocal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class LocalConsultarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
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
        if(!editIdLocal.getText().toString().equals("")){
            helper.abrir();
            Local local = helper.consultarLocal(editIdLocal.getText().toString());
            helper.cerrar();
            if(local != null){
                editIdEmpresa.setText(local.getIdEmpresa());
                editIdSector.setText(local.getIdSector());
                editIdMunicipio.setText(local.getIdMunicipio());
                editNombreLocal.setText(local.getNombreLocal());
                editDescripLocal.setText(local.getDescripLocal());
            }else Toast.makeText(context,"No existe el idLocal: "+editIdLocal.getText().toString(),Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Campos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdLocal.setText("");
        editIdEmpresa.setText("");
        editIdSector.setText("");
        editIdMunicipio.setText("");
        editNombreLocal.setText("");
        editDescripLocal.setText("");
    }
}