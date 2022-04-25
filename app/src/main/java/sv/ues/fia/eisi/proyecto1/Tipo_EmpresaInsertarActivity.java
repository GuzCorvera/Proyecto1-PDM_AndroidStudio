package sv.ues.fia.eisi.proyecto1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Tipo_EmpresaInsertarActivity extends Activity {
    BD_Controlador helper;
    EditText editIdTipoEmpresa;
    EditText editIdUsuarioSugerencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_empresa_insertar);
        helper = new BD_Controlador(this);
        editIdTipoEmpresa = (EditText) findViewById(R.id.editIdTipoEmpresa);
        editIdUsuarioSugerencia = (EditText) findViewById(R.id.editIdUsuarioSugerencia);
    }

    public void insertarTipoEmpresa(View v){

    }

    public void limpiarTexto(View v){

    }
}