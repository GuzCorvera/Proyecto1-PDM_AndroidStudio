package sv.ues.fia.eisi.proyecto1.CRUDDenuncias;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        if(!editIdDenuncia.getText().toString().equals("")){
            Denuncia denuncia = new Denuncia(editIdDenuncia.getText().toString());
            helper.abrir();
            String eliminar = helper.eliminar(denuncia);
            helper.cerrar();
            Toast.makeText(context, eliminar, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Datos vacíos", Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v){
        editIdDenuncia.setText("");
    }
}