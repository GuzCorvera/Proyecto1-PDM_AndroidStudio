package sv.ues.fia.eisi.proyecto1.CRUDRangoEdad;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class Rango_EdadActualizarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdRangoEdad;
    EditText editNombreRangoEdad;
    EditText editEdadMenor;
    EditText editEdadMayor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rango_edad_actualizar);
        helper = new BD_Controlador(this);
        editIdRangoEdad = (EditText) findViewById(R.id.editIdRangoEdad);
        editNombreRangoEdad = (EditText) findViewById(R.id.editNombreRangoEdad);
        editEdadMenor = (EditText) findViewById(R.id.editEdadMenor);
        editEdadMayor = (EditText) findViewById(R.id.editEdadMayor);
    }

    public void actualizarRangoEdad(View v){
        if(!editIdRangoEdad.getText().toString().equals("")&!editNombreRangoEdad.getText().toString().equals("")&
                !editEdadMenor.getText().toString().equals("")&!editEdadMayor.getText().toString().equals("")){
            Rango_Edad rango_edad = new Rango_Edad(
                    editIdRangoEdad.getText().toString(),
                    editNombreRangoEdad.getText().toString(),
                    Float.parseFloat(editEdadMenor.getText().toString()),
                    Float.parseFloat(editEdadMayor.getText().toString())
            );
            helper.abrir();
            String actualizar = helper.actualizar(rango_edad);
            helper.cerrar();
            Toast.makeText(context, actualizar, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Datos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdRangoEdad.setText("");
        editNombreRangoEdad.setText("");
        editEdadMenor.setText("");
        editEdadMayor.setText("");
    }
}