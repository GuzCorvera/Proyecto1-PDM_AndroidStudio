package sv.ues.fia.eisi.proyecto1.CRUDTipoSatisfaccion;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class Tipo_SatisfaccionInsertarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdTipoSatisfaccion;
    EditText editNomTipoSatisfaccion;
    EditText editNotaMenor;
    EditText editNotaMayor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_satisfaccion_insertar);
        helper = new BD_Controlador(context);

        editIdTipoSatisfaccion = (EditText) findViewById(R.id.editIdTipoSatisfaccion);
        editNomTipoSatisfaccion = (EditText) findViewById(R.id.editNomTipoSatisfaccion);
        editNotaMenor = (EditText) findViewById(R.id.editNotaMenor);
        editNotaMayor = (EditText) findViewById(R.id.editNotaMayor);
    }

    public void insertarTipoSatisfaccion(View v){
        if(!editIdTipoSatisfaccion.getText().toString().equals("") & !editNomTipoSatisfaccion.getText().toString().equals("") &
        !editNotaMenor.getText().toString().equals("") & !editNotaMayor.getText().toString().equals("")){
            Tipo_Satisfaccion satisfaccion = new Tipo_Satisfaccion(
                    editIdTipoSatisfaccion.getText().toString(),
                    editNomTipoSatisfaccion.getText().toString(),
                    Float.parseFloat(editNotaMenor.getText().toString()),
                    Float.parseFloat(editNotaMayor.getText().toString())
            );
            helper.abrir();
            Log.d("Log", "base abierta");
            String insert = helper.insertar(satisfaccion);
            helper.cerrar();
            Toast.makeText(context, insert, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Campos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdTipoSatisfaccion.setText("");
        editNomTipoSatisfaccion.setText("");
        editNotaMenor.setText("");
        editNotaMayor.setText("");
    }
}