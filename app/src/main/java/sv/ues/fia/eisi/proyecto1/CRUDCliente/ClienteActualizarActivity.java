package sv.ues.fia.eisi.proyecto1.CRUDCliente;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class ClienteActualizarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdCliente;
    EditText editIdRangoEdad;
    EditText editIdUsuario;
    EditText editIdSexo;
    EditText editNomcliente;
    EditText editTelefonoCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_actualizar);
        helper = new BD_Controlador(this);
        editIdCliente = (EditText) findViewById(R.id.editIdCliente);
        editIdRangoEdad = (EditText) findViewById(R.id.editIdRangoEdad);
        editIdUsuario = (EditText) findViewById(R.id.editIdUsuario);
        editIdSexo = (EditText) findViewById(R.id.editIdSexo);
        editNomcliente = (EditText) findViewById(R.id.editNomCliente);
        editTelefonoCliente = (EditText) findViewById(R.id.editTelefonoCliente);
    }

    public void actualizarCliente (View v){

    }

    public void limpiarTexto(View v){

    }
}