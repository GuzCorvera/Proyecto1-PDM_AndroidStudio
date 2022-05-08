package sv.ues.fia.eisi.proyecto1.CRUDUsuario;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class UsuarioEliminarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_eliminar);
        helper = new BD_Controlador(this);
        editIdUsuario = (EditText) findViewById(R.id.editIdUsuario);
    }

    public void eliminarUsuario(View v){
        if(!editIdUsuario.getText().toString().equals("")){
            Usuario usuario = new Usuario(editIdUsuario.getText().toString());
            helper.abrir();
            String eliminar = helper.eliminar(usuario);
            helper.cerrar();
            Toast.makeText(context, eliminar, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Datos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdUsuario.setText("");
    }
}