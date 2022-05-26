package sv.ues.fia.eisi.proyecto1.CRUDLocal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class LocalEliminarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_eliminar);
        helper = new BD_Controlador(this);
        editIdLocal = (EditText) findViewById(R.id.editIdLocal);
    }

    public void eliminarLocal(View v){
        if (!editIdLocal.getText().toString().equals("")){
            Local local = new Local(editIdLocal.getText().toString());
            helper.abrir();
            String eliminar = helper.eliminar(local);
            helper.cerrar();
            Toast.makeText(context, eliminar, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Campo idLocal vacío", Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v){
        editIdLocal.setText("");
    }
}