package sv.ues.fia.eisi.proyecto1.CRUDCliente;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class ClienteConsultarActivity extends Activity {
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
        setContentView(R.layout.activity_cliente_consultar);
        helper = new BD_Controlador(this);
        editIdCliente = (EditText) findViewById(R.id.editIdCliente);
        editIdRangoEdad = (EditText) findViewById(R.id.editIdRangoEdad);
        editIdUsuario = (EditText) findViewById(R.id.editIdUsuario);
        editIdSexo = (EditText) findViewById(R.id.editIdSexo);
        editNomCliente = (EditText) findViewById(R.id.editNomCliente);
        editTelefonoCliente = (EditText) findViewById(R.id.editTelefonoCliente);
    }

    public void consultarCliente (View v){
        if(!editIdCliente.getText().toString().equals("")){
            helper.abrir();
            Cliente cliente = helper.consultarCliente(editIdCliente.getText().toString());
            helper.cerrar();
            if(cliente!=null){
                editIdRangoEdad.setText(cliente.getIdRangoEdad());
                editIdUsuario.setText(cliente.getIdUsuario());
                editIdSexo.setText(cliente.getIdSexo());
                editNomCliente.setText(cliente.getNomcliente());
                editTelefonoCliente.setText(cliente.getTelefonoCliente());
            }else Toast.makeText(context, "No existe N°="+editIdCliente.getText().toString(), Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Datos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdCliente.setText("");
        editIdRangoEdad.setText("");
        editIdUsuario.setText("");
        editIdUsuario.setText("");
        editIdSexo.setText("");
        editNomCliente.setText("");
        editTelefonoCliente.setText("");
    }
}