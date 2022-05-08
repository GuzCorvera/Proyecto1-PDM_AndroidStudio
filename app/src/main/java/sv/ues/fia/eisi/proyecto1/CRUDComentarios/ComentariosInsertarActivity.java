package sv.ues.fia.eisi.proyecto1.CRUDComentarios;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class ComentariosInsertarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdComentario;
    EditText editIdUsuarioComentario;
    EditText editIdLocalComentario;
    EditText editTextComentario;
    EditText editFechaComentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios_insertar);
        helper = new BD_Controlador(this);
        editIdComentario = (EditText) findViewById(R.id.editIdComentario);
        editIdUsuarioComentario = (EditText) findViewById(R.id.editIdUsuarioComentario);
        editIdLocalComentario = (EditText) findViewById(R.id.editIdLocalComentario);
        editTextComentario = (EditText) findViewById(R.id.editTextComentario);
        editFechaComentario = (EditText) findViewById(R.id.editFechaComentario);
    }

    public void insertarComentarios(View v){
        if(!editIdComentario.getText().toString().equals("") & !editIdUsuarioComentario.getText().toString().equals("") &
        !editIdLocalComentario.getText().toString().equals("") & editTextComentario.getText().toString().equals("") &
        editFechaComentario.getText().toString().equals("")){
            Comentarios comentarios = new Comentarios(
                    editIdComentario.getText().toString(),
                    editIdUsuarioComentario.getText().toString(),
                    editIdLocalComentario.getText().toString(),
                    editTextComentario.getText().toString(),
                    editFechaComentario.getText().toString()
            );
            helper.abrir();
            String insertar = helper.insertar(comentarios);
            helper.cerrar();
            Toast.makeText(context, insertar, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Datos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdComentario.setText("");
        editIdUsuarioComentario.setText("");
        editIdLocalComentario.setText("");
        editTextComentario.setText("");
        editFechaComentario.setText("");
    }
}