package sv.ues.fia.eisi.proyecto1.CRUDDenuncias;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class DenunciasEliminarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdDenuncia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denuncias_eliminar);
        helper = new BD_Controlador(this);
        editIdDenuncia = (EditText) findViewById(R.id.editIdDenuncia);
    }

    public void eliminarDenuncias(View v){

    }
}