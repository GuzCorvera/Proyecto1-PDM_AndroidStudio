package sv.ues.fia.eisi.proyecto1.CRUDSugerencias;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class SugerenciasConsultarActivity extends Activity {
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
        setContentView(R.layout.activity_sugerencias_consultar);
        helper = new BD_Controlador(this);
        editIdSugerencia = (EditText) findViewById(R.id.editIdSugerencia);
        editIdUsuarioSugerencia = (EditText) findViewById(R.id.editNomTipoEmpresa);
        editIdLocalSugerencia = (EditText) findViewById(R.id.editIdLocalSugerencia);
        editTextSugerencia = (EditText) findViewById(R.id.editTextSugerencia);
        editFechaSugerencia = (EditText) findViewById(R.id.editFechaSugerencia);
    }

    public void consultarSugerencias(View v){
        if(!editIdSugerencia.getText().toString().equals("")){
            helper.abrir();
            Sugerencias sugerencia =  helper.consultarSugerencia(editIdSugerencia.getText().toString());
            helper.cerrar();
            if(sugerencia!=null){
                editIdUsuarioSugerencia.setText(sugerencia.getIdUsuario());
                editIdLocalSugerencia.setText(sugerencia.getIdLocal());
                editTextSugerencia.setText(sugerencia.getTextSugerencia());
                editFechaSugerencia.setText(sugerencia.getFechaSugerencia());
            }else Toast.makeText(context, "No existe el idSugerencias: "+editIdSugerencia.getText().toString(), Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Campos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdSugerencia.setText("");
        editIdLocalSugerencia.setText("");
        editIdUsuarioSugerencia.setText("");
        editTextSugerencia.setText("");
        editFechaSugerencia.setText("");
    }
}