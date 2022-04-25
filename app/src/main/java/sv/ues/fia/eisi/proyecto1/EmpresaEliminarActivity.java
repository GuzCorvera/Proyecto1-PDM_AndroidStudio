package sv.ues.fia.eisi.proyecto1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EmpresaEliminarActivity extends Activity {
    BD_Controlador helper;
    EditText editIdEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_eliminar);
        helper = new BD_Controlador(this);
        editIdEmpresa = (EditText) findViewById(R.id.editIdEmpresa);
    }

    public void eliminarEmpresa(View v){

    }

    public void limpiarTexto(View v){

    }
}