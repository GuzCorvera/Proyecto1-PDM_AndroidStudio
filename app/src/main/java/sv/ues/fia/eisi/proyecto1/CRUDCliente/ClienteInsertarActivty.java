package sv.ues.fia.eisi.proyecto1.CRUDCliente;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class ClienteInsertarActivty extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdCliente;
    EditText editIdRangoEdad;
    EditText editIdUsuario;
    EditText editIdSexo;
    EditText editNomCliente;
    EditText editTelefonoCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_insertar_activty);
        helper = new BD_Controlador(this);
        editIdCliente = (EditText) findViewById(R.id.editIdCliente);
        editIdRangoEdad = (EditText) findViewById(R.id.editIdRangoEdad);
        editIdUsuario = (EditText) findViewById(R.id.editIdUsuario);
        editIdSexo = (EditText) findViewById(R.id.editIdSexo);
        editNomCliente = (EditText) findViewById(R.id.editNomCliente);
        editTelefonoCliente = (EditText) findViewById(R.id.editTelefonoCliente);
    }

    public void insertarCliente(View v){
        if(!editIdCliente.getText().toString().equals("") & !editIdRangoEdad.getText().toString() .equals("")
                & !editIdUsuario.getText().toString().equals("") & !editIdSexo.getText().toString().equals("")
        & !editNomCliente.getText().toString().equals("") & !editTelefonoCliente.getText().toString().equals("")){
            Cliente cliente = new Cliente(
                    editIdCliente.getText().toString(),
                    editIdRangoEdad.getText().toString(),
                    editIdUsuario.getText().toString(),
                    editIdSexo.getText().toString(),
                    editNomCliente.getText().toString(),
                    editTelefonoCliente.getText().toString()
            );
            helper.abrir();
            String insertar = helper.insertar(cliente);
            helper.cerrar();
            Toast.makeText(context, insertar, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Datos vacíos", Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v){
        editIdCliente.setText("");
        editIdRangoEdad.setText("");
        editIdUsuario.setText("");
        editIdSexo.setText("");
        editNomCliente.setText("");
        editTelefonoCliente.setText("");
    }
}