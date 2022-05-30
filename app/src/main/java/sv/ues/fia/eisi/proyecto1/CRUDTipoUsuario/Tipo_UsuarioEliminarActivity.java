package sv.ues.fia.eisi.proyecto1.CRUDTipoUsuario;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class Tipo_UsuarioEliminarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdTipoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_usuario_eliminar);
        helper = new BD_Controlador(this);
        editIdTipoUsuario = (EditText) findViewById(R.id.editIdTipoUsuario);
    }


    public void eliminarTipoUsuario(View v){
        if (!editIdTipoUsuario.getText().toString().equals("") ){
            Tipo_Usuario tipoUsuario = new Tipo_Usuario();
            tipoUsuario.setIdTipoUsuario(editIdTipoUsuario.getText().toString());
            helper.abrir();
            String eliminar = helper.eliminar(tipoUsuario);
            helper.cerrar();
            Toast.makeText(context, eliminar, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Campo idTipoUsuario vacío", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdTipoUsuario.setText("");
    }
}