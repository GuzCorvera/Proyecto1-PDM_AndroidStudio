package sv.ues.fia.eisi.proyecto1.CRUDSector;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.UsuarioTemp;

public class SectorMenuActivity extends ListActivity {
    String[] menu, activities;
    BD_Controlador helper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper = new BD_Controlador(this);
        helper.abrir();
        UsuarioTemp usuarioTemp = helper.consultarUsuarioTemporal();
        helper.cerrar();
        if(usuarioTemp!=null){
            switch (usuarioTemp.getTipoUsuarioTemp()){
                case "TP01":
                    menu = new String[]{"Insertar Sector", "Eliminar Sector", "Consultar Sector", "Actualizar Sector"};
                    activities = new String[]{"SectorInsertarActivity", "SectorEliminarActivity", "SectorConsultarActivity", "SectorActualizarActivity"};
                    break;
                case "TP02":
                    menu = new String[]{"Consultar Sector"};
                    activities = new String[]{"SectorConsultarActivity"};
                    break;
            }
        }
        ListView listView = getListView();
        listView.setBackgroundColor(Color.rgb(0, 0, 255));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu);
        setListAdapter(adapter);
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String nombreValue = activities[position];
        l.getChildAt(position).setBackgroundColor(Color.rgb(128, 128, 255));

        try {
            Class<?> clase = Class.forName("sv.ues.fia.eisi.proyecto1.CRUDSector." + nombreValue);
            Intent inte = new Intent(this, clase);
            this.startActivity(inte);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}