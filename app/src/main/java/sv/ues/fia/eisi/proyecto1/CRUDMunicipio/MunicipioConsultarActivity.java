package sv.ues.fia.eisi.proyecto1.CRUDMunicipio;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class MunicipioConsultarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdMunicipio;
    EditText editIdDepartamento;
    EditText editNomMunicipio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipio_consultar);
        helper = new BD_Controlador(this);
        editIdMunicipio = (EditText) findViewById(R.id.editIdMunicipio);
        editIdDepartamento = (EditText) findViewById(R.id.editIdDepartamento);
        editNomMunicipio = (EditText) findViewById(R.id.editNomMunicipio);
    }

    public void consultarMunicipio(View v){
        if(!editIdMunicipio.getText().toString().equals("")){
            helper.abrir();
            Municipio municipio = helper.consultarMunicipio(editIdMunicipio.getText().toString());
            helper.cerrar();
            if(municipio!= null){
                editIdDepartamento.setText(municipio.getIdDepartamento());
                editNomMunicipio.setText(municipio.getNomMunicipio());
            }else Toast.makeText(context, "No existe N°="+editIdMunicipio.getText().toString(), Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Datos vacíos", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiarTexto(View v){
        editIdDepartamento.setText("");
        editIdMunicipio.setText("");
        editNomMunicipio.setText("");
    }
}