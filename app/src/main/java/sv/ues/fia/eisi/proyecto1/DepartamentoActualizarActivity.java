package sv.ues.fia.eisi.proyecto1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DepartamentoActualizarActivity extends Activity {
    BD_Controlador helper;
    EditText editIdDepartamento;
    EditText editNomDepartamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departamento_actualizar);
        helper = new BD_Controlador(this);
        editIdDepartamento = (EditText) findViewById(R.id.editIdDepartamento);
        editNomDepartamento = (EditText) findViewById(R.id.editNomDepartamento);
    }

    public void actualizarDepartamento(View v){

    }

    public void limpiarTexto(View v){

    }
}