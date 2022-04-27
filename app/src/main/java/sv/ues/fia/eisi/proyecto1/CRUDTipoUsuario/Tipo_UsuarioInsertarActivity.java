package sv.ues.fia.eisi.proyecto1.CRUDTipoUsuario;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

    }

    public void limpiarTexto(View v){

    }
}