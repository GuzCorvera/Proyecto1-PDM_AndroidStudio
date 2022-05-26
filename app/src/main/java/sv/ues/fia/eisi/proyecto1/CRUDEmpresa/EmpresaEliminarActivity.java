package sv.ues.fia.eisi.proyecto1.CRUDEmpresa;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class EmpresaEliminarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_eliminar);
        helper = new BD_Controlador(this);
        editIdEmpresa = (EditText) findViewById(R.id.editIdEmpresa);
    }

    public void eliminarEmpresa(View v){
        if(!editIdEmpresa.getText().toString().equals("")){
            Empresa empresa = new Empresa(editIdEmpresa.getText().toString());
            helper.abrir();
            String eliminar = helper.eliminar(empresa);
            helper.cerrar();
            Toast.makeText(context, eliminar, Toast.LENGTH_SHORT).show();
            limpiarTexto(v);
        }else Toast.makeText(context,"Campo idEmpresa vacío", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdEmpresa.setText("");
    }
}