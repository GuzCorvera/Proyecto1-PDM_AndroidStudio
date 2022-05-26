package sv.ues.fia.eisi.proyecto1.CRUDMunicipio;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class MunicipioInsertarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdMunicipio;
    EditText editIdDepartamento;
    EditText editNomMunicipio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipio_insertar);
        helper = new BD_Controlador(this);
        editIdMunicipio = (EditText) findViewById(R.id.editIdMunicipio);
        editIdDepartamento = (EditText) findViewById(R.id.editIdDepartamento);
        editNomMunicipio = (EditText) findViewById(R.id.editNomMunicipio);
    }

    public void insertarMunicipio(View v){
        if(!editIdMunicipio.getText().toString().equals("")&!editIdDepartamento.getText().toString().equals("")&
        !editNomMunicipio.getText().toString().equals("")){
            Municipio municipio = new Municipio();
            municipio.setIdMunicipio(editIdMunicipio.getText().toString());
            municipio.setIdDepartamento(editIdDepartamento.getText().toString());
            municipio.setNomMunicipio(editNomMunicipio.getText().toString());
            helper.abrir();
            String insert = helper.insertar(municipio);
            helper.cerrar();
            Toast.makeText(context, insert, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Campos vacíos", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiarTexto(View v){
        editIdDepartamento.setText("");
        editIdMunicipio.setText("");
        editNomMunicipio.setText("");
    }
}