package sv.ues.fia.eisi.proyecto1.CRUDRangoEdad;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.R;


import org.json.JSONObject;
@SuppressLint("NewApi")
public class Rango_EdadInsertar_wsActivity extends Activity {
    BD_Controlador helper;
    Context context = this;
    EditText editIdRangoEdad_ws;
    EditText editNombreRangoEdad_ws;
    EditText editEdadMenor_ws;
    EditText editEdadMayor_ws;

    private final String urlHostingGratuito = "https://proyecto-pdm-ws.000webhostapp.com//ws_rangoEdad_insertar.php";
    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rango_edad_insertar_ws);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //helper = new BD_Controlador(this);
        editIdRangoEdad_ws = (EditText) findViewById(R.id.editIdRangoEdad_ws);
        editNombreRangoEdad_ws = (EditText) findViewById(R.id.editNombreRangoEdad_ws);
        editEdadMenor_ws = (EditText) findViewById(R.id.editEdadMenor_ws);
        editEdadMayor_ws = (EditText) findViewById(R.id.editEdadMayor_ws);
    }

    public void insertarRangoEdad_ws(View v){
        String idRangoEdad=editIdRangoEdad_ws.getText().toString();
        String nombreRangoEdad=editNombreRangoEdad_ws.getText().toString();
        String edadMenor=editEdadMenor_ws.getText().toString();
        String edadMayor=editEdadMayor_ws.getText().toString();

        String url = null;
        JSONObject datosNota = new JSONObject();
        JSONObject nota = new JSONObject();
        switch (v.getId()) {
            case R.id.btn_insertarRangoEdad_ws:
                url = urlHostingGratuito+ "?idRangoEdad=" + idRangoEdad + "&nombreRangoEdad="
                        + nombreRangoEdad + "&edadMenor=" + Float.parseFloat(edadMenor) + "&edadMayor=" + Float.parseFloat(edadMayor);
                ControladorServicio.insertarEmpleadoExterno(url, this);
                break;
        }
    }

    public void limpiarTexto_ws(View v){
        editIdRangoEdad_ws.setText("");
        editNombreRangoEdad_ws.setText("");
        editEdadMenor_ws.setText("");
        editEdadMayor_ws.setText("");

    }
}