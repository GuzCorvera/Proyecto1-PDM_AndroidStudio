package sv.ues.fia.eisi.proyecto1.CRUDTipoEmpresa;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class Tipo_EmpresaEliminarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdTipoEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_empresa_eliminar);
        helper = new BD_Controlador(this);
        editIdTipoEmpresa = (EditText) findViewById(R.id.editIdTipoEmpresa);
    }

    public void eliminarTipoEmpresa(View v){
        if(!editIdTipoEmpresa.getText().toString().equals("")){
            Tipo_Empresa tipoEmpresa = new Tipo_Empresa();
            tipoEmpresa.setIdTipoEmpresa(editIdTipoEmpresa.getText().toString());
            helper.abrir();
            String eliminar = helper.eliminar(tipoEmpresa);
            helper.cerrar();
            Toast.makeText(context, eliminar, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Datos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdTipoEmpresa.setText("");
    }
}