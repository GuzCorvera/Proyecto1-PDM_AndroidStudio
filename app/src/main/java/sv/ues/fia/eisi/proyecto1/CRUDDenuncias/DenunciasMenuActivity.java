package sv.ues.fia.eisi.proyecto1.CRUDDenuncias;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DenunciasMenuActivity extends ListActivity {
    String[] menu = {"Insertar Denuncia", "Eliminar Denuncia", "Consultar Denuncia", "Actualizar Denuncia"};
    String[] activities = {"DenunciasInsertarActivity", "DenunciasEliminarActivity", "DenunciasConsultarActivity", "DenunciasActualizarActivity"};

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
            Class<?> clase = Class.forName("sv.ues.fia.eisi.proyecto1.CRUDDenuncias." + nombreValue);
            Intent inte = new Intent(this, clase);
            this.startActivity(inte);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}