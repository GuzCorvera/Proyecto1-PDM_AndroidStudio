package sv.ues.fia.eisi.proyecto1.CRUDRangoEdad;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class Rango_EdadEliminarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdRangoEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rango_edad_eliminar);
        helper = new BD_Controlador(this);
        editIdRangoEdad = (EditText) findViewById(R.id.editIdRangoEdad);
    }

    public void eliminarRangoEdad(View v){
        if(!editIdRangoEdad.getText().toString().equals("")){
            Rango_Edad rango_edad = new Rango_Edad(editIdRangoEdad.getText().toString());
            helper.abrir();
            String eliminar = helper.eliminar(rango_edad);
            helper.cerrar();
            Toast.makeText(context, eliminar, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Ingrese el ID", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdRangoEdad.setText("");
    }
}