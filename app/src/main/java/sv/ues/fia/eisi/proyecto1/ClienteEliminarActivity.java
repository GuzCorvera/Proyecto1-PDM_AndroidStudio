package sv.ues.fia.eisi.proyecto1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ClienteEliminarActivity extends Activity {

    EditText editIdCliente;
    BD_Controlador controlhelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_eliminar);
        controlhelper = new BD_Controlador(this);
        editIdCliente = (EditText) findViewById(R.id.editIdCliente);
    }

    public void eliminarCliente(View v){

    }
}