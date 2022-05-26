package sv.ues.fia.eisi.proyecto1.CRUDCliente;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class ClienteEliminarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_eliminar);
        helper = new BD_Controlador(this);
        editIdCliente = (EditText) findViewById(R.id.editIdCliente);
    }

    public void eliminarCliente(View v){
        if(!editIdCliente.getText().toString().equals("")){
            Cliente cliente = new Cliente(editIdCliente.getText().toString());
            helper.abrir();
            String eliminar = helper.eliminar(cliente);
            helper.cerrar();
            Toast.makeText(context, eliminar, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Campo idCliente vacio", Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v){
        editIdCliente.setText("");
    }
}