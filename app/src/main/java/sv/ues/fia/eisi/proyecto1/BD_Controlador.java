package sv.ues.fia.eisi.proyecto1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BD_Controlador {
    private static final String[] camposCliente = new String[]{"idCliente","idRangoEdad","idUsuario","idSexo","nomcliente","telefonoCliente"};
    private static final String[] camposComentarios = new String[]{"idComentarios","idUsuario","idLocal","textComentario","fechaComentario"};
    private static final String[] camposDenuncias = new String[]{"idDenuncias","idUsuario","idLocal","textDenuncia","fechaDenuncia"};
    private static final String[] camposDepartamento = new String[]{"idDepartamento","nomDepartamento"};
    private static final String[] camposEmpresa = new String[]{"idEmpresa","idTipoEmpresa","nomLegalEmpresa","nitEmpresa","giroEmpresa","nrcEmpresa"};

    private static final String[] camposSugerencias = new String[]{"idSugerencia","idUsuario","idLocal","textSugerencia","fechaSugerencia"};

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public BD_Controlador(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String BASE_DATOS = "Proyecto1_PDM.s3db";
        private static final int VERSION = 1;

        public DatabaseHelper(Context context) {
            super(context, BASE_DATOS, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL("");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub
        }
    }

    public void abrir() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return;
    }

    public void cerrar() {
        DBHelper.close();
    }
}