package sv.ues.fia.eisi.proyecto1;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MainActivity extends ListActivity {
    Context context = this;
    String[] menu, activities;

    BD_Controlador helper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper=new BD_Controlador(context);
        helper.abrir();
        UsuarioTemp usuarioTemp = helper.consultarUsuarioTemporal();
        helper.cerrar();
        if(usuarioTemp!=null){
            switch (usuarioTemp.getTipoUsuarioTemp()){
                case "TP01":
                    menu = new String[]{
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
                    activities = new String[]{
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
                    break;
                case "TP02":
                    menu = new String[]{
                            "Tabla Comentarios",
                            "Tabla Denuncias",
                            "Tabla Evaluación",
                            "Tabla Local",
                            "Tabla Sector",
                            "Tabla Sugerencias",
                            "Tabla Sugerencias App"
                    };
                    activities = new String[]{
                            "CRUDComentarios.ComentarioMenuActivity",
                            "CRUDDenuncias.DenunciasMenuActivity",
                            "CRUDEvaluacion.EvaluacionMenuActivity",
                            "CRUDLocal.LocalMenuActivity",
                            "CRUDSector.SectorMenuActivity",
                            "CRUDSugerencias.SugerenciasMenuActivity",
                            "CRUDSugerenciasApp.SugerenciasAppMenuActivity"
                    };

                    break;
            }
        }

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));

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
                Toast.makeText(this, "Llenado de Base de Datos con EXITO", Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                Log.d("Log", e.getMessage());
                Toast.makeText(context, "Error al llenado de la Base de Datos", Toast.LENGTH_SHORT).show();
            }
        }
    }


}