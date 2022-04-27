package sv.ues.fia.eisi.proyecto1.CRUDTipoEmpresa;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class Tipo_EmpresaInsertarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdTipoEmpresa;
    EditText editNomTipoEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_empresa_insertar);
        helper = new BD_Controlador(this);
        editIdTipoEmpresa = (EditText) findViewById(R.id.editIdTipoEmpresa);
        editNomTipoEmpresa = (EditText) findViewById(R.id.editNomTipoEmpresa);
    }

    public void insertarTipoEmpresa(View v){
        if(!editIdTipoEmpresa.getText().toString().equals("") & !editNomTipoEmpresa.getText().toString().equals("")){
            Tipo_Empresa tipoEmpresa = new Tipo_Empresa();
            tipoEmpresa.setIdTipoEmpresa(editIdTipoEmpresa.getText().toString());
            tipoEmpresa.setNomTipoEmpresa(editNomTipoEmpresa.getText().toString());
            helper.abrir();
            String insert = helper.insertar(tipoEmpresa);
            helper.cerrar();
            Toast.makeText(context, insert, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Datos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdTipoEmpresa.setText("");
        editNomTipoEmpresa.setText("");
    }
}