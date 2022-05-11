package sv.ues.fia.eisi.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button bIniciar;
    EditText etUsuario, etPassword;
    Context context = this;
    BD_Controlador helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bIniciar = (Button) findViewById(R.id.bIniciar);
        etUsuario = (EditText) findViewById(R.id.editUsuario);
        etPassword = (EditText) findViewById(R.id.editPassword);
        helper = new BD_Controlador(this);

    }

    public void onClick(View view) {
        if(!etUsuario.getText().toString().equals("") & !etPassword.getText().toString().equals("")){
            helper.abrir();
            UsuarioTemp usuarioTemp = helper.consultarUsuario(etUsuario.getText().toString(),etPassword.getText().toString());
            helper.cerrar();
            if(usuarioTemp!=null){
                helper.abrir();
                helper.eliminarUsuarioTemporal();
                helper.insertar(usuarioTemp);
                helper.cerrar();
                startActivity(new Intent(this, MainActivity.class));
            }else Toast.makeText(context, "Error usuario o contraseña", Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "Datos vacíos", Toast.LENGTH_SHORT).show();
    }
}