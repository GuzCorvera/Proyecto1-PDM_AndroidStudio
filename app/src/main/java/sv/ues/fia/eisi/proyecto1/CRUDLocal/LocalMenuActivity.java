package sv.ues.fia.eisi.proyecto1.CRUDLocal;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import sv.ues.fia.eisi.proyecto1.BD_Controlador;
import sv.ues.fia.eisi.proyecto1.UsuarioTemp;

public class LocalMenuActivity extends ListActivity {
    BD_Controlador helper;
    String[] menu, activities;

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
                    menu = new String[]{"Insertar Local", "Eliminar Local", "Consultar Local", "Actualizar Local"};
                    activities = new String[]{"LocalInsertarActivity", "LocalEliminarActivity", "LocalConsultarActivity", "LocalActualizarActivity"};
                    break;
                case "TP02":
                    menu = new String[]{"Consultar Local"};
                    activities = new String[]{"LocalConsultarActivity"};
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
            Class<?> clase = Class.forName("sv.ues.fia.eisi.proyecto1.CRUDLocal." + nombreValue);
            Intent inte = new Intent(this, clase);
            this.startActivity(inte);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}