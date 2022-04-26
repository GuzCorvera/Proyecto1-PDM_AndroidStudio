package sv.ues.fia.eisi.proyecto1.CRUDDepartamento;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class DepartamentoInsertarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdDepartamento;
    EditText editNomDepartamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departamento_insertar);
        helper = new BD_Controlador(this);
        editIdDepartamento = (EditText) findViewById(R.id.editIdDepartamento);
        editNomDepartamento = (EditText) findViewById(R.id.editNomDepartamento);
    }

    public void insertarDepartamento(View v){
        if(!editIdDepartamento.getText().toString().equals("") & !editNomDepartamento.getText().toString().equals("")){
            Departamento departamento = new Departamento(
                    editIdDepartamento.getText().toString(),
                    editNomDepartamento.getText().toString()
            );
            helper.abrir();
            String insert = helper.insertar(departamento);
            helper.cerrar();
            Toast.makeText(context, insert, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Datos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdDepartamento.setText("");
        editNomDepartamento.setText("");
    }
}