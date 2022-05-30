package sv.ues.fia.eisi.proyecto1.CRUDEmpresa;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class EmpresaActualizarActivity extends Activity {
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
        setContentView(R.layout.activity_empresa_actualizar);
        helper = new BD_Controlador(this);
        editIdEmpresa = (EditText) findViewById(R.id.editIdEmpresa);
        editIdTipoEmpresa = (EditText) findViewById(R.id.editIdTipoEmpresa);
        editNomLegalEmpresa = (EditText) findViewById(R.id.editNomLegalEmpresa);
        editNitEmpresa = (EditText) findViewById(R.id.editNitEmpresa);
        editGiroEmpresa = (EditText) findViewById(R.id.editGiroEmpresa);
        editNrcEmpresa = (EditText) findViewById(R.id.editNrcEmpresa);
    }

    public void consultarEmpresa(View v){
        if(!editIdEmpresa.getText().toString().equals("")){
            helper.abrir();
            Empresa empresa = helper.consultarEmpresa(editIdEmpresa.getText().toString());
            helper.cerrar();
            if(empresa != null){
                editIdTipoEmpresa.setText(empresa.getIdTipoEmpresa());
                editNomLegalEmpresa.setText(empresa.getNomLegalEmpresa());
                editNitEmpresa.setText(empresa.getNitEmpresa());
                editGiroEmpresa.setText(empresa.getGiroEmpresa());
                editNrcEmpresa.setText(empresa.getNrcEmpresa());
            }else Toast.makeText(context, "No existe el idEmpresa: "+editIdEmpresa.getText().toString(), Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Datos vacios", Toast.LENGTH_SHORT).show();
    }

    public void actualizarEmpresa(View v){
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
            String actualizar = helper.actualizar(empresa);
            helper.cerrar();
            Toast.makeText(context, actualizar, Toast.LENGTH_SHORT).show();
            limpiarTexto(v);
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