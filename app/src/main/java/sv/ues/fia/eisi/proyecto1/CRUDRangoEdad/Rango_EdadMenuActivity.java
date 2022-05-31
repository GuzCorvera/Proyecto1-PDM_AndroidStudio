package sv.ues.fia.eisi.proyecto1.CRUDRangoEdad;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Rango_EdadMenuActivity extends ListActivity {
    String[] menu = {"Insertar Rango de Edad", "Eliminar Rango de Edad", "Consultar Rango de Edad", "Actualizar Rango de Edad","Insertar Rango Edad WS"};
    String[] activities = {"Rango_EdadInsertarActivity", "Rango_EdadEliminarActivity", "Rango_EdadConsultarActivity", "Rango_EdadActualizarActivity", "Rango_EdadInsertar_wsActivity"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
            Class<?> clase = Class.forName("sv.ues.fia.eisi.proyecto1.CRUDRangoEdad." + nombreValue);
            Intent inte = new Intent(this, clase);
            this.startActivity(inte);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}