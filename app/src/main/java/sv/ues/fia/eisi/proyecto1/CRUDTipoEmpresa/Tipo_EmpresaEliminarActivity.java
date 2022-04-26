package sv.ues.fia.eisi.proyecto1.CRUDTipoEmpresa;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class Tipo_EmpresaEliminarActivity extends Activity {
    BD_Controlador helper;
    EditText editIdTipoEmpresa;
    EditText editIdUsuarioSugerencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_empresa_eliminar);
        helper = new BD_Controlador(this);
        editIdTipoEmpresa = (EditText) findViewById(R.id.editIdTipoEmpresa);
        editIdUsuarioSugerencia = (EditText) findViewById(R.id.editIdUsuarioSugerencia);
    }

    public void eliminarTipoEmpresa(View v){

    }

    public void limpiarTexto(View v){

    }
}