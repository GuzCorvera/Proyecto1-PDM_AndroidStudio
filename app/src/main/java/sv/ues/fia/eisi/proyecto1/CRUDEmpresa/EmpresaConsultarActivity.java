package sv.ues.fia.eisi.proyecto1.CRUDEmpresa;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

    }
    public void limpiarTexto(View v){

    }
}