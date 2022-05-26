package sv.ues.fia.eisi.proyecto1.CRUDTipoUsuario;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class Tipo_UsuarioConsultarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdTipoUsuario;
    EditText editDesTipoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_usuario_consultar);
        helper = new BD_Controlador(this);
        editIdTipoUsuario = (EditText) findViewById(R.id.editIdTipoUsuario);
        editDesTipoUsuario = (EditText) findViewById(R.id.editDesTipoUsuario);
    }

    public void consultarTipoUsuario(View v){
        if (!editIdTipoUsuario.getText().toString().equals("")){
            helper.abrir();
            Tipo_Usuario tipoUsuario = helper.consultarTipoUsuario(editIdTipoUsuario.getText().toString());
            helper.cerrar();
            if(tipoUsuario != null)
                editDesTipoUsuario.setText(tipoUsuario.getDesTipoUsuario());
            else Toast.makeText(context, "No existe el idTipoUsuario: "+editIdTipoUsuario.getText().toString(), Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Campos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdTipoUsuario.setText("");
        editDesTipoUsuario.setText("");
    }
}