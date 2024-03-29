package sv.ues.fia.eisi.proyecto1.CRUDLocal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class LocalInsertarActivity extends Activity {
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
        setContentView(R.layout.activity_local_insertar);
        helper = new BD_Controlador(this);
        editIdLocal = (EditText) findViewById(R.id.editIdLocal);
        editIdEmpresa = (EditText) findViewById(R.id.editIdEmpresa);
        editIdSector = (EditText) findViewById(R.id.editIdSector);
        editIdMunicipio = (EditText) findViewById(R.id.editIdMunicipio);
        editNombreLocal = (EditText) findViewById(R.id.editNombreLocal);
        editDescripLocal = (EditText) findViewById(R.id.editDescripLocal);
    }

    public void insertarLocal(View v){
        if(!editIdLocal.getText().toString().equals("") & !editIdEmpresa.getText().toString().equals("")
        & !editIdSector.getText().toString().equals("") & !editIdMunicipio.getText().toString().equals("")
        & !editNombreLocal.getText().toString().equals("") & !editDescripLocal.getText().toString().equals("")){
            Local local = new Local(
                    editIdLocal.getText().toString(),
                    editIdEmpresa.getText().toString(),
                    editIdSector.getText().toString(),
                    editIdMunicipio.getText().toString(),
                    editNombreLocal.getText().toString(),
                    editDescripLocal.getText().toString()
                    );
            helper.abrir();
            String insertar = helper.insertar(local);
            helper.cerrar();
            Toast.makeText(context, insertar, Toast.LENGTH_SHORT).show();
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