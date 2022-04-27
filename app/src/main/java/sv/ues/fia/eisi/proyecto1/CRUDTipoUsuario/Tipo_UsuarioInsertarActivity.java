package sv.ues.fia.eisi.proyecto1.CRUDTipoUsuario;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class Tipo_UsuarioInsertarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdTipoUsuario;
    EditText editDesTipoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_usuario_insertar);
        helper = new BD_Controlador(this);
        editIdTipoUsuario = (EditText) findViewById(R.id.editIdTipoUsuario);
        editDesTipoUsuario = (EditText) findViewById(R.id.editDesTipoUsuario);
    }

    public void insertarTipoUsuario(View v){
        if (!editIdTipoUsuario.getText().toString().equals("") & !editDesTipoUsuario.getText().toString().equals("")){
            Tipo_Usuario tipoUsuario = new Tipo_Usuario();
            tipoUsuario.setIdTipoUsuario(editIdTipoUsuario.getText().toString());
            tipoUsuario.setDesTipoUsuario(editDesTipoUsuario.getText().toString());
            helper.abrir();
            String insert = helper.insertar(tipoUsuario);
            helper.cerrar();
            Toast.makeText(context, insert, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Datos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdTipoUsuario.setText("");
        editDesTipoUsuario.setText("");
    }
}