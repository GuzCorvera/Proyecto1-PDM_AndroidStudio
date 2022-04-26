package sv.ues.fia.eisi.proyecto1.CRUDDepartamento;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class DepartamentoEliminarActivity extends Activity {
    BD_Controlador helper;
    EditText editIdDepartamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departamento_eliminar);
        helper = new BD_Controlador(this);
        editIdDepartamento = (EditText) findViewById(R.id.editIdDepartamento);
    }

    public void eliminarDepartamento(View v){

    }
}