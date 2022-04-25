package sv.ues.fia.eisi.proyecto1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ComentariosEliminarActivity extends Activity {
    BD_Controlador helper;
    EditText editIdComentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios_eliminar);
        helper = new BD_Controlador(this);
        editIdComentario = (EditText) findViewById(R.id.editIdComentario);
    }

    public void eliminarComentarios(View v){

    }
}