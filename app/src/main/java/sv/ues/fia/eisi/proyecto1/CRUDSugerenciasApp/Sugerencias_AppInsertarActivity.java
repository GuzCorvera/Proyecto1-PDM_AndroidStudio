package sv.ues.fia.eisi.proyecto1.CRUDSugerenciasApp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class Sugerencias_AppInsertarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdSugerenciasApp;
    EditText editIdUsuario;
    EditText editTxtSugerenciasApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerencias_app_insertar);
        helper = new BD_Controlador(this);
        editIdSugerenciasApp = (EditText) findViewById(R.id.editIdSugerenciasApp);
        editIdUsuario = (EditText) findViewById(R.id.editIdUsuario);
        editTxtSugerenciasApp = (EditText) findViewById(R.id.editTxtSugerenciasApp);
    }

    public void insertarSugerenciasApp(View v){
        if(!editIdSugerenciasApp.getText().toString().equals("") & !editIdUsuario.getText().toString().equals("") &
        !editTxtSugerenciasApp.getText().toString().equals("")){
            Sugerencias_App sugerencias_app = new Sugerencias_App(
                    editIdSugerenciasApp.getText().toString(),
                    editIdUsuario.getText().toString(),
                    editTxtSugerenciasApp.getText().toString()
            );
            helper.abrir();
            String insertar = helper.insertar(sugerencias_app);
            helper.cerrar();
            Toast.makeText(context, insertar, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Campos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdSugerenciasApp.setText("");
        editIdUsuario.setText("");
        editTxtSugerenciasApp.setText("");
    }
}