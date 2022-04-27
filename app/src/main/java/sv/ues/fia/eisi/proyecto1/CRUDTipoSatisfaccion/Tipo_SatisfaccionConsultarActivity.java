package sv.ues.fia.eisi.proyecto1.CRUDTipoSatisfaccion;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class Tipo_SatisfaccionConsultarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdTipoSatisfaccion;
    EditText editNomTipoSatisfaccion;
    EditText editNotaMenor;
    EditText editNotaMayor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_satisfaccion_consultar);
        helper = new BD_Controlador(this);
        editIdTipoSatisfaccion = (EditText) findViewById(R.id.editIdTipoSatisfaccion);
        editNomTipoSatisfaccion = (EditText) findViewById(R.id.editNomTipoSatisfaccion);
        editNotaMenor = (EditText) findViewById(R.id.editNotaMenor);
        editNotaMayor = (EditText) findViewById(R.id.editNotaMayor);
    }

    public void consultarTipoSatisfaccion(View v){
        if(!editIdTipoSatisfaccion.getText().equals("")){
            helper.abrir();
            Tipo_Satisfaccion satisfaccion = helper.consultarTipoSatisfaccion(editIdTipoSatisfaccion.getText().toString());
            helper.cerrar();
            if(satisfaccion != null){
                editNomTipoSatisfaccion.setText(satisfaccion.getNomTipoSatisfaccion());
                editNotaMenor.setText(String.valueOf(satisfaccion.getNotaMenor()));
                editNotaMayor.setText(String.valueOf(satisfaccion.getNotaMayor()));
            }else Toast.makeText(context, "No existe: "+editIdTipoSatisfaccion.getText(), Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Datos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdTipoSatisfaccion.setText("");
        editNomTipoSatisfaccion.setText("");
        editNotaMenor.setText("");
        editNotaMayor.setText("");
    }
}