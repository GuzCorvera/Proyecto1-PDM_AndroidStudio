package sv.ues.fia.eisi.proyecto1.CRUDDepartamento;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class DepartamentoEliminarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdDepartamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departamento_eliminar);
        helper = new BD_Controlador(this);
        editIdDepartamento = (EditText) findViewById(R.id.editIdDepartamento);
    }

    public void eliminarDepartamento(View v){
        if(!editIdDepartamento.getText().toString().equals("")){
            Departamento departamento = new Departamento(editIdDepartamento.getText().toString());
            helper.abrir();
            String eliminar = helper.eliminar(departamento);
            helper.cerrar();
            Toast.makeText(context, eliminar, Toast.LENGTH_SHORT).show();
            limpiarTexto(v);
        }else Toast.makeText(context, "Campo idDepartamento vacio", Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v){
        editIdDepartamento.setText("");
    }
}