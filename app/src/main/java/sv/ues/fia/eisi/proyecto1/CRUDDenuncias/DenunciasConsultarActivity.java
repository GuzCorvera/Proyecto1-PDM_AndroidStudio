package sv.ues.fia.eisi.proyecto1.CRUDDenuncias;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;

public class DenunciasConsultarActivity extends Activity {
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
        setContentView(R.layout.activity_denuncias_consultar);
        helper = new BD_Controlador(this);
        editIdDenuncia = (EditText) findViewById(R.id.editIdDenuncia);
        editIdUsuarioDenuncia = (EditText) findViewById(R.id.editIdUsuarioDenuncia);
        editIdLocalDenuncia = (EditText) findViewById(R.id.editIdLocalDenuncia);
        editTextDenuncia = (EditText) findViewById(R.id.editTextDenuncia);
        editFechaDenuncia = (EditText) findViewById(R.id.editFechaDenuncia);
    }

    public void consultarDenuncias(View v){
        if(!editIdDenuncia.getText().toString().equals("")){
            helper.abrir();
            Denuncia denuncia = helper.consultarDenuncia(editIdDenuncia.getText().toString());
            helper.cerrar();
            if(denuncia != null){
                editIdUsuarioDenuncia.setText(denuncia.getIdUsuario());
                editIdLocalDenuncia.setText(denuncia.getIdLocal());
                editTextDenuncia.setText(denuncia.getTextDenuncia());
                editFechaDenuncia.setText(denuncia.getFechaDenuncia());
            }else Toast.makeText(context, "No existe el idDenuncias: "+denuncia.getIdDenuncia(), Toast.LENGTH_SHORT).show();
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