package sv.ues.fia.eisi.proyecto1.CRUDSugerenciasApp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class Sugerencias_AppEliminarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdSugerenciasApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerencias_app_eliminar_actitvity);
        helper = new BD_Controlador(this);
        editIdSugerenciasApp = (EditText) findViewById(R.id.editIdSugerenciasApp);
    }

    public void eliminarSugerenciasApp(View v){
        if(!editIdSugerenciasApp.getText().toString().equals("")){
            Sugerencias_App sugerencias_app = new Sugerencias_App(editIdSugerenciasApp.getText().toString());
            helper.abrir();
            String eliminar = helper.eliminar(sugerencias_app);
            helper.cerrar();
            Toast.makeText(context, eliminar, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Campo idSugerenciaApp vacío", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdSugerenciasApp.setText("");
    }
}