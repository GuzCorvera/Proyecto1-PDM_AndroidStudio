package sv.ues.fia.eisi.proyecto1.CRUDEmpresa;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class EmpresaConsultarActivity extends Activity {
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
        setContentView(R.layout.activity_empresa_consultar);
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
            }else Toast.makeText(context, "No existe: "+editIdEmpresa.getText().toString(), Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Datos vacios", Toast.LENGTH_SHORT).show();
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