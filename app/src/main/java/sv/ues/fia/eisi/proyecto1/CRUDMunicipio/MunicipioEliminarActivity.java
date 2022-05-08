package sv.ues.fia.eisi.proyecto1.CRUDMunicipio;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class MunicipioEliminarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdMunicipio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipio_eliminar);
        helper = new BD_Controlador(this);
        editIdMunicipio = (EditText) findViewById(R.id.editIdMunicipio);
    }

    public void eliminarMunicipio(View v){
        if(!editIdMunicipio.getText().toString().equals("")){
            Municipio municipio = new Municipio();
            municipio.setIdMunicipio(editIdMunicipio.getText().toString());
            helper.abrir();
            String eliminar = helper.eliminar(municipio);
            helper.cerrar();
            Toast.makeText(context, eliminar, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Datos vacíos", Toast.LENGTH_SHORT).show();
        }
    }
    public void limpiarTexto(View v){
        editIdMunicipio.setText("");
    }
}