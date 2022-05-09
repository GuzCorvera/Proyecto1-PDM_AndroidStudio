package sv.ues.fia.eisi.proyecto1;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    Context context = this;
    String[] menu = {
            "Tabla Cliente",
            "Tabla Comentarios",
            "Tabla Denuncias",
            "Tabla Departamento",
            "Tabla Empresa",
            "Tabla Evaluación",
            "Tabla Local",
            "Tabla Municipio",
            "Tabla Rango de Edad",
            "Tabla Sector",
            "Tabla Sexo",
            "Tabla Sugerencias",
            "Tabla Sugerencias App",
            "Tabla Tipo de Empresa",
            "Tabla Tipo de Satisfacción",
            "Tabla Tipo de Usuario",
            "Tabla Usuario",
            "Llenar base de datos"
    };
    String[] activities = {
            "CRUDCliente.ClienteMenuActivity",
            "CRUDComentarios.ComentarioMenuActivity",
            "CRUDDenuncias.DenunciasMenuActivity",
            "CRUDDepartamento.DepartamentoMenuActivity",
            "CRUDEmpresa.EmpresaMenuActivity",
            "CRUDEvaluacion.EvaluacionMenuActivity",
            "CRUDLocal.LocalMenuActivity",
            "CRUDMunicipio.MunicipioMenuActivity",
            "CRUDRangoEdad.Rango_EdadMenuActivity",
            "CRUDSector.SectorMenuActivity",
            "CRUDSexo.SexoMenuActivity",
            "CRUDSugerencias.SugerenciasMenuActivity",
            "CRUDSugerenciasApp.SugerenciasAppMenuActivity",
            "CRUDTipoEmpresa.Tipo_EmpresaMenuActivity",
            "CRUDTipoSatisfaccion.Tipo_SatisfaccionMenuActivity",
            "CRUDTipoUsuario.Tipo_UsuarioMenuActivity",
            "CRUDUsuario.UsuarioMenuActivity"
    };

    BD_Controlador helper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));
        helper=new BD_Controlador(context);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (position != 17) {// LA POSICION 16 SERIA LA OPCION LLENAR BASE DE DATOS
            String nombreValue = activities[position];
            try {
                Class<?> clase = Class.forName("sv.ues.fia.eisi.proyecto1." + nombreValue);
                Intent inte = new Intent(this, clase);
                this.startActivity(inte);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            //CODIGO PARA LLENAR BASE DE DATOS
            try {
                helper.abrir();
                helper.llenarBD();
                helper.cerrar();
                Toast.makeText(this, "Llenado correcto", Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                Log.d("Log", e.getMessage());
                Toast.makeText(context, "Error llenado", Toast.LENGTH_SHORT).show();
            }
        }
    }
}