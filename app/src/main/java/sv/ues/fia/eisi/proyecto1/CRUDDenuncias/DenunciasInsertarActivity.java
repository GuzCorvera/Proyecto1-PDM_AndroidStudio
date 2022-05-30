package sv.ues.fia.eisi.proyecto1.CRUDDenuncias;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class DenunciasInsertarActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdDenuncia;
    EditText editIdUsuarioDenuncia;
    EditText editIdLocalDenuncia;
    EditText editTextDenuncia;
    EditText editFechaDenuncia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denuncias_insertar);
        helper = new BD_Controlador(this);
        editIdDenuncia = (EditText) findViewById(R.id.editIdDenuncia);
        editIdUsuarioDenuncia = (EditText) findViewById(R.id.editIdUsuarioDenuncia);
        editIdLocalDenuncia = (EditText) findViewById(R.id.editIdLocalDenuncia);
        editTextDenuncia = (EditText) findViewById(R.id.editTextDenuncia);
        editFechaDenuncia = (EditText) findViewById(R.id.editFechaDenuncia);
    }

    public void insertarDenuncias(View v){
        if(!editIdDenuncia.getText().toString().equals("")
                & !editIdUsuarioDenuncia.getText().toString().equals("")
                & !editIdLocalDenuncia.getText().toString().equals("")
                & !editTextDenuncia.getText().toString().equals("")
                & !editFechaDenuncia.getText().toString().equals("")){
            Denuncia denuncia = new Denuncia(
                    editIdDenuncia.getText().toString(),
                    editIdUsuarioDenuncia.getText().toString(),
                    editIdLocalDenuncia.getText().toString(),
                    editTextDenuncia.getText().toString(),
                    editFechaDenuncia.getText().toString()
            );
            helper.abrir();
            String insertar = helper.insertar(denuncia);
            helper.cerrar();
            Toast.makeText(context, insertar, Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Campos vacíos", Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdDenuncia.setText("");
        editIdLocalDenuncia.setText("");
        editIdUsuarioDenuncia.setText("");
        editTextDenuncia.setText("");
        editFechaDenuncia.setText("");
    }
}