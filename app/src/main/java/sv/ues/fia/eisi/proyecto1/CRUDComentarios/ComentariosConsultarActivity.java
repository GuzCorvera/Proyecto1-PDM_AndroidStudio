package sv.ues.fia.eisi.proyecto1.CRUDComentarios;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class ComentariosConsultarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdComentario;
    EditText editIdUsuarioComentario;
    EditText editIdLocal;
    EditText editTextComentario;
    EditText editFechaComentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios_consultar);
        helper = new BD_Controlador(this);
        editIdComentario = (EditText) findViewById(R.id.editIdComentario);
        editIdUsuarioComentario = (EditText) findViewById(R.id.editIdUsuarioComentario);
        editIdLocal = (EditText) findViewById(R.id.editIdLocalComentario);
        editTextComentario = (EditText) findViewById(R.id.editTextComentario);
        editFechaComentario = (EditText) findViewById(R.id.editFechaComentario);
    }

    public void consultarComentario(View v){

    }

    public void limpiarTexto(View v){

    }
}