package sv.ues.fia.eisi.proyecto1.CRUDEmpresa;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class EmpresaInsertarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdEmpresa;
    EditText editIdTipoEmpresa;
    EditText editNomLegalEmpresa;
    EditText editNitEmpresa;
    EditText editGiroEmpresa;
    EditText editNrcEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_insertar);
        helper = new BD_Controlador(this);
        editIdEmpresa = (EditText) findViewById(R.id.editIdEmpresa);
        editIdTipoEmpresa = (EditText) findViewById(R.id.editIdTipoEmpresa);
        editNomLegalEmpresa = (EditText) findViewById(R.id.editNomLegalEmpresa);
        editNitEmpresa = (EditText) findViewById(R.id.editNitEmpresa);
        editGiroEmpresa = (EditText) findViewById(R.id.editGiroEmpresa);
        editNrcEmpresa = (EditText) findViewById(R.id.editNrcEmpresa);
    }

    public void insertarEmpresa(View v){
        if(!editIdEmpresa.getText().toString().equals("") & !editIdTipoEmpresa.getText().toString().equals("")
        & !editNomLegalEmpresa.getText().toString().equals("") &!editNitEmpresa.getText().toString().equals("")
        & !editGiroEmpresa.getText().toString().equals("") & !editNrcEmpresa.getText().toString().equals("")){
            Empresa empresa = new Empresa();
            empresa.setIdEmpresa(editIdEmpresa.getText().toString());
            empresa.setIdTipoEmpresa(editIdTipoEmpresa.getText().toString());
            empresa.setNomLegalEmpresa(editNomLegalEmpresa.getText().toString());
            empresa.setNitEmpresa(editNitEmpresa.getText().toString());
            empresa.setGiroEmpresa(editGiroEmpresa.getText().toString());
            empresa.setNrcEmpresa(editNrcEmpresa.getText().toString());
            helper.abrir();
            String insert = helper.insertar(empresa);
            helper.cerrar();
            Toast.makeText(context, insert, Toast.LENGTH_SHORT).show();

        }else Toast.makeText(context, "Datos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdEmpresa.setText("");
        editIdTipoEmpresa.setText("");
        editNomLegalEmpresa.setText("");
        editNitEmpresa.setText("");
        editGiroEmpresa.setText("");
        editNrcEmpresa.setText("");
    }
}