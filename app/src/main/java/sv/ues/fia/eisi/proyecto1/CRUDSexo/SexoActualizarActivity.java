package sv.ues.fia.eisi.proyecto1.CRUDSexo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class SexoActualizarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdSexo;
    EditText editNomSexo;
    EditText editAbreviaturaSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sexo_actualizar);
        helper = new BD_Controlador(this);
        editIdSexo = (EditText) findViewById(R.id.editIdSexo);
        editNomSexo = (EditText) findViewById(R.id.editNomSexo);
        editAbreviaturaSexo = (EditText) findViewById(R.id.editAbreviaturaSexo);
    }

    public void consultarSexo(View v){
        if(!editIdSexo.getText().toString().equals("")){
            helper.abrir();
            Sexo sexo = helper.consultarSexo(editIdSexo.getText().toString());
            helper.cerrar();
            if(sexo != null){
                editNomSexo.setText(sexo.getNomSexo());
                editAbreviaturaSexo.setText(sexo.getAbreviaturaSexo());
            }else Toast.makeText(context, "No existe el idSexo: "+editIdSexo.getText().toString(), Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Campos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void actualizarSexo(View v){
        if(!editIdSexo.getText().toString().equals("") &
                !editNomSexo.getText().toString().equals("") & !editAbreviaturaSexo.getText().toString().equals("")){
            Sexo sexo = new Sexo(
                    editIdSexo.getText().toString(),
                    editNomSexo.getText().toString(),
                    editAbreviaturaSexo.getText().toString()
            );
            helper.abrir();
            String actualizar = helper.actualizar(sexo);
            helper.cerrar();
            Toast.makeText(context, actualizar, Toast.LENGTH_SHORT).show();
            limpiarTexto(v);
        }else Toast.makeText(context, "Datos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdSexo.setText("");
        editNomSexo.setText("");
        editAbreviaturaSexo.setText("");
    }
}