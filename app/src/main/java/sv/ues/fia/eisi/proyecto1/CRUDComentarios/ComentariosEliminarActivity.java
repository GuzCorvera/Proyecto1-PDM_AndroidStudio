package sv.ues.fia.eisi.proyecto1.CRUDComentarios;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class ComentariosEliminarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdComentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios_eliminar);
        helper = new BD_Controlador(this);
        editIdComentario = (EditText) findViewById(R.id.editIdComentario);
    }

    public void eliminarComentarios(View v){
        if(!editIdComentario.getText().toString().equals("")){
            Comentarios comentarios = new Comentarios(editIdComentario.getText().toString());
            helper.abrir();
            String eliminar = helper.eliminar(comentarios);
            helper.cerrar();
            Toast.makeText(context, eliminar, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Campo idComentario vacío", Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v){
        editIdComentario.setText("");
    }
}