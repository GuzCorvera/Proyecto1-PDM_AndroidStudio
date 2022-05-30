package sv.ues.fia.eisi.proyecto1.CRUDTipoEmpresa;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class Tipo_EmpresaActualizarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdTipoEmpresa;
    EditText editNomTipoEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_empresa_actualizar);
        helper = new BD_Controlador(this);
        editIdTipoEmpresa = (EditText) findViewById(R.id.editIdTipoEmpresa);
        editNomTipoEmpresa = (EditText) findViewById(R.id.editNomTipoEmpresa);
    }

    public void consultarTipoEmpresa(View v){
        if(!editIdTipoEmpresa.getText().toString().equals("")){
            helper.abrir();
            Tipo_Empresa tipoEmpresa = helper.consultarTipoEmpresa(editIdTipoEmpresa.getText().toString());
            helper.cerrar();
            if(tipoEmpresa != null)
                editNomTipoEmpresa.setText(tipoEmpresa.getNomTipoEmpresa());
            else Toast.makeText(context, "No existe el idTipoEmpresa: "+editIdTipoEmpresa.getText().toString(), Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Campos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void actualizarTipoEmpresa(View v){
        if(!editIdTipoEmpresa.getText().toString().equals("") & !editNomTipoEmpresa.getText().toString().equals("")){
            Tipo_Empresa tipoEmpresa = new Tipo_Empresa();
            tipoEmpresa.setIdTipoEmpresa(editIdTipoEmpresa.getText().toString());
            tipoEmpresa.setNomTipoEmpresa(editNomTipoEmpresa.getText().toString());
            helper.abrir();
            String actualizar = helper.actualizar(tipoEmpresa);
            helper.cerrar();
            Toast.makeText(context, actualizar, Toast.LENGTH_SHORT).show();
            limpiarTexto(v);
        }else Toast.makeText(context, "Datos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdTipoEmpresa.setText("");
        editNomTipoEmpresa.setText("");
    }
}