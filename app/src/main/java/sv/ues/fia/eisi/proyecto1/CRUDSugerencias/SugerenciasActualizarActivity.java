package sv.ues.fia.eisi.proyecto1.CRUDSugerencias;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class SugerenciasActualizarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdSugerencia;
    EditText editIdUsuarioSugerencia;
    EditText editIdLocalSugerencia;
    EditText editTextSugerencia;
    EditText editFechaSugerencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerencias_actualizar);
        helper = new BD_Controlador(this);
        editIdSugerencia = (EditText) findViewById(R.id.editIdSugerencia);
        editIdUsuarioSugerencia = (EditText) findViewById(R.id.editNomTipoEmpresa);
        editIdLocalSugerencia = (EditText) findViewById(R.id.editIdLocalSugerencia);
        editTextSugerencia = (EditText) findViewById(R.id.editTextSugerencia);
        editFechaSugerencia = (EditText) findViewById(R.id.editFechaSugerencia);
    }

    public void actualizarSugerencias(View v){
        if(!editIdSugerencia.getText().toString().equals("") & !editIdLocalSugerencia.getText().toString().equals("") &
                !editIdUsuarioSugerencia.getText().toString().equals("") & !editTextSugerencia.getText().toString().equals("") &
                !editFechaSugerencia.getText().toString().equals("")){
            Sugerencias sugerencias = new Sugerencias(
                    editIdSugerencia.getText().toString(),
                    editIdUsuarioSugerencia.getText().toString(),
                    editIdLocalSugerencia.getText().toString(),
                    editTextSugerencia.getText().toString(),
                    editFechaSugerencia.getText().toString()
            );
            helper.abrir();
            String actualizar =  helper.actualizar(sugerencias);
            helper.cerrar();
            Toast.makeText(context, actualizar, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Datos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdSugerencia.setText("");
        editIdLocalSugerencia.setText("");
        editIdUsuarioSugerencia.setText("");
        editTextSugerencia.setText("");
        editFechaSugerencia.setText("");
    }
}