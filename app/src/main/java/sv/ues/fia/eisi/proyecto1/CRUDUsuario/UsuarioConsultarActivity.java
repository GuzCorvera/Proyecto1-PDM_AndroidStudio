package sv.ues.fia.eisi.proyecto1.CRUDUsuario;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class UsuarioConsultarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdUsuario;
    EditText editIdTipoUsuario;
    EditText editIdEmpresa;
    EditText editNomUsuario;
    EditText editContraUsuario;
    EditText editCorreoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_consultar);
        helper = new BD_Controlador(this);
        editIdUsuario = (EditText) findViewById(R.id.editIdUsuario);
        editIdTipoUsuario = (EditText) findViewById(R.id.editIdTipoUsuario);
        editIdEmpresa = (EditText) findViewById(R.id.editIdEmpresa);
        editNomUsuario = (EditText) findViewById(R.id.editNomUsuario);
        editContraUsuario = (EditText) findViewById(R.id.editContraUsuario);
        editCorreoUsuario = (EditText) findViewById(R.id.editCorreoUsuario);
    }

    public void consultarUsuario(View v){
        if(!editIdUsuario.getText().toString().equals("")){
            helper.abrir();
            Usuario usuario = helper.consultarUsuario(editIdUsuario.getText().toString());
            helper.cerrar();
            if(usuario!= null){
                editIdTipoUsuario.setText(usuario.getIdTipoUsuario());
                editIdEmpresa.setText(usuario.getIdEmpresa());
                editNomUsuario.setText(usuario.getIdEmpresa());
                editContraUsuario.setText(usuario.getContraUsuario());
                editCorreoUsuario.setText(usuario.getCorreoUsuario());
            }else Toast.makeText(context, "No existe el idUsuario: "+editIdUsuario.getText().toString(), Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Campos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdUsuario.setText("");
        editIdTipoUsuario.setText("");
        editIdEmpresa.setText("");
        editNomUsuario.setText("");
        editContraUsuario.setText("");
        editCorreoUsuario.setText("");
    }
}