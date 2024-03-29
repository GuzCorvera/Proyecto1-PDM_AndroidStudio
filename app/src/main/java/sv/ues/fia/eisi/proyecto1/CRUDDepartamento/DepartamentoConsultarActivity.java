package sv.ues.fia.eisi.proyecto1.CRUDDepartamento;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class DepartamentoConsultarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdDepartamento;
    EditText editNomDepartamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departamento_consultar);
        helper = new BD_Controlador(this);
        editIdDepartamento = (EditText) findViewById(R.id.editIdDepartamento);
        editNomDepartamento = (EditText) findViewById(R.id.editNomDepartamento);
    }

    public void consultarDepartamento(View v){
        if(!editIdDepartamento.getText().toString().equals("")){
            helper.abrir();
            Departamento departamento = helper.consultarDepartamento(editIdDepartamento.getText().toString());
            helper.cerrar();
            if(departamento != null)
                editNomDepartamento.setText(departamento.getNomDepartamento());
            else Toast.makeText(context, "No existe el idDepartamento: "+editIdDepartamento.getText().toString(), Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Campos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdDepartamento.setText("");
        editNomDepartamento.setText("");
    }
}