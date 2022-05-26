package sv.ues.fia.eisi.proyecto1.CRUDRangoEdad;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class Rango_EdadInsertarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdRangoEdad;
    EditText editNombreRangoEdad;
    EditText editEdadMenor;
    EditText editEdadMayor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rango_edad_insertar);
        helper = new BD_Controlador(this);
        editIdRangoEdad = (EditText) findViewById(R.id.editIdRangoEdad);
        editNombreRangoEdad = (EditText) findViewById(R.id.editNombreRangoEdad);
        editEdadMenor = (EditText) findViewById(R.id.editEdadMenor);
        editEdadMayor = (EditText) findViewById(R.id.editEdadMayor);
    }

    public void insertarRangoEdad(View v){
        Rango_Edad rango_edad = new Rango_Edad();
        if(!editIdRangoEdad.getText().toString().equals("")&!editNombreRangoEdad.getText().toString().equals("")&
        !editEdadMenor.getText().toString().equals("")&!editEdadMayor.getText().toString().equals("")){
            rango_edad.setIdRangoEdad(editIdRangoEdad.getText().toString());
            rango_edad.setNomRangoEdad(editNombreRangoEdad.getText().toString());
            rango_edad.setEdadMenor(Float.parseFloat(editEdadMenor.getText().toString()));
            rango_edad.setEdadMayor(Float.parseFloat(editEdadMayor.getText().toString()));
            helper.abrir();
            String reg = helper.insertar(rango_edad);
            helper.cerrar();
            Toast.makeText(context, reg, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Campos vacios", Toast.LENGTH_SHORT).show();

    }

    public void limpiarTexto(View v){
        editIdRangoEdad.setText("");
        editNombreRangoEdad.setText("");
        editEdadMenor.setText("");
        editEdadMayor.setText("");

    }
}