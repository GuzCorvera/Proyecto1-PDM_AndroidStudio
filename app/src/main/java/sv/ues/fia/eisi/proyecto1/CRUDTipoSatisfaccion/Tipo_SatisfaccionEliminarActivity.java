package sv.ues.fia.eisi.proyecto1.CRUDTipoSatisfaccion;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class Tipo_SatisfaccionEliminarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdTipoSatisfaccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_satisfaccion_eliminar);
        helper = new BD_Controlador(this);
        editIdTipoSatisfaccion = (EditText) findViewById(R.id.editIdTipoSatisfaccion);
    }

    public void eliminarTipoSatisfaccion(View v){
        if(!editIdTipoSatisfaccion.getText().equals("")){
            Tipo_Satisfaccion satisfaccion = new Tipo_Satisfaccion(editIdTipoSatisfaccion.getText().toString());
            helper.abrir();
            String eliminar = helper.eliminar(satisfaccion);
            helper.cerrar();
            Toast.makeText(context, eliminar, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Datos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdTipoSatisfaccion.setText("");
    }
}