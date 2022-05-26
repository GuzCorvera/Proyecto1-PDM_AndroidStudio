package sv.ues.fia.eisi.proyecto1.CRUDSexo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class SexoEliminarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sexo_eliminar);
        helper = new BD_Controlador(this);
        editIdSexo = (EditText) findViewById(R.id.editIdSexo);
    }

    public void eliminarSexo(View v){
        if(!editIdSexo.getText().toString().equals("") ){
            Sexo sexo = new Sexo(editIdSexo.getText().toString());
            helper.abrir();
            String eliminar = helper.eliminar(sexo);
            helper.cerrar();
            Toast.makeText(context, eliminar, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Dato idSexo vacío", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdSexo.setText("");
    }
}