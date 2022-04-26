package sv.ues.fia.eisi.proyecto1.CRUDCliente;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class ClienteEliminarActivity extends Activity {
    BD_Controlador helper;
    EditText editIdCliente;
    EditText editIdRangoEdad;
    EditText editIdUsuario;
    EditText editIdSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_eliminar);
        helper = new BD_Controlador(this);
        editIdCliente = (EditText) findViewById(R.id.editIdCliente);
        editIdRangoEdad = (EditText) findViewById(R.id.editIdRangoEdad);
        editIdUsuario = (EditText) findViewById(R.id.editIdUsuario);
        editIdSexo = (EditText) findViewById(R.id.editIdSexo);
    }

    public void eliminarCliente(View v){

    }
}