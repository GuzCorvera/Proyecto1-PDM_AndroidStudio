package sv.ues.fia.eisi.proyecto1.CRUDRangoEdad;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class Rango_EdadConsultarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdRangoEdad;
    EditText editNombreRangoEdad;
    EditText editEdadMenor;
    EditText editEdadMayor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rango_edad_consultar);
        helper = new BD_Controlador(this);
        editIdRangoEdad = (EditText) findViewById(R.id.editIdRangoEdad);
        editNombreRangoEdad = (EditText) findViewById(R.id.editNombreRangoEdad);
        editEdadMenor = (EditText) findViewById(R.id.editEdadMenor);
        editEdadMayor = (EditText) findViewById(R.id.editEdadMayor);
    }

    public void consultarRangoEdad(View v){
        if(!editIdRangoEdad.getText().toString().equals("")){
            helper.abrir();
            Rango_Edad rango_edad = helper.consultarRangoEdad(editIdRangoEdad.getText().toString());
            helper.cerrar();
            if(rango_edad != null){
                editNombreRangoEdad.setText(rango_edad.getNomRangoEdad());
                editEdadMenor.setText(String.valueOf(rango_edad.getEdadMenor()));
                editEdadMayor.setText(String.valueOf(rango_edad.getEdadMayor()));
            }else
                Toast.makeText(context, "No existe el idRangoEdad: "+editIdRangoEdad.getText().toString(), Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Campos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdRangoEdad.setText("");
        editNombreRangoEdad.setText("");
        editEdadMenor.setText("");
        editEdadMayor.setText("");
    }
}