package sv.ues.fia.eisi.proyecto1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BD_Controlador {
    //private static final String[] camposAccesoUsuario = new String[]{""};
    private static final String[] camposCliente = new String[]{"idCliente","idRangoEdad","idUsuario","idSexo","nomcliente","telefonoCliente"};
    private static final String[] camposComentarios = new String[]{"idComentarios","idUsuario","idLocal","textComentario","fechaComentario"};
    private static final String[] camposDenuncias = new String[]{"idDenuncias","idUsuario","idLocal","textDenuncia","fechaDenuncia"};
    private static final String[] camposDepartamento = new String[]{"idDepartamento","nomDepartamento"};
    private static final String[] camposEmpresa = new String[]{"idEmpresa","idTipoEmpresa","nomLegalEmpresa","nitEmpresa","giroEmpresa","nrcEmpresa"};
    private static final String[] camposEvaluacion = new String[]{"idLocal","idCliente","idTipoSatisfaccion","notaEvaCliente"};
    private static final String[] camposLocal = new String[]{"idLocal","idEmpresa","idSector","idMunicipio","nombreLocal","descripLocal"};
    private static final String[] camposMunicipio = new String[]{"idMunicipio","idDepartamento","nomMunicipio"};
    //private static final String[] camposOpcionCrud = new String[]{""};
    private static final String[] camposRangoEdad = new String[]{"idRangoEdad","nomRangoEdad","edadMenor","edadMayor"};
    private static final String[] camposSector = new String[]{"idSector","tipoSector"};
    private static final String[] camposSexo = new String[]{"idSexo","nomSexo","abreviaturaSexo"};
    private static final String[] camposSugerencias = new String[]{"idSugerencia","idUsuario","idLocal","textSugerencia","fechaSugerencia"};
    private static final String[] camposSugerencias_App = new String[]{"idSugerenciasApp","idUsuario","txtSugerenciasApp"};
    private static final String[] camposSTipoEmpresa= new String[]{"idTipoEmpresa","nomTipoEmpresa"};
    private static final String[] camposTipoSatisfaccion = new String[]{"idTipoSatisfaccion","nomTipoSatisfaccion","notaMenor","notaMayor"};
    private static final String[] camposTipoUsuario = new String[]{"idTipoUsuario","desTipoUsuario"};
    private static final String[] camposUsuario = new String[]{"idUsuario","idTipoUsuario","idEmpresa","nomUsuario","contraUsuario","correoUsuario"};

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
                db.execSQL("CREATE TABLE ACCESOUSUARIO (IDUSUARIO VARCHAR2(8), IDOPCION VARCHAR2(8));");
                db.execSQL("CREATE TABLE CLIENTE (IDCLIENTE VARCHAR2(8) not null, IDRANGOEDAD VARCHAR2(8), IDUSUARIO VARCHAR2(8),IDSEXO VARCHAR2(8), NOMCLIENTE VARCHAR2(300) not null, TELEFONOCLIENTE VARCHAR2(20) not null, constraint PK_CLIENTE primary key (IDCLIENTE));");
                db.execSQL("CREATE TABLE COMENTARIOS (IDCOMENTARIO VARCHAR2(8) not null, IDUSUARIO VARCHAR2(8), IDLOCAL VARCHAR2(8),TEXTCOMENTARIO VARCHAR2(300) not null, FECHACOMENTARIO VARCHAR2(10) not null, constraint PK_COMENTARIOS primary key (IDCOMENTARIO));");
                db.execSQL("CREATE TABLE DENUNCIAS (IDDENUNCIAS VARCHAR2(8) not null, IDLOCAL VARCHAR2(8), IDUSUARIO VARCHAR2(8), TEXTDENUNCIAS VARCHAR2(300) not null, FECHADENUNCIAS VARCHAR2(10) not null, constraint PK_DENUNCIAS primary key (IDDENUNCIAS));");
                db.execSQL("CREATE TABLE DEPARTAMENTO (IDDEPARTAMENTO VARCHAR2(8) not null, NOMDEPARTAMENTO VARCHAR2(30) not null, constraint PK_DEPARTAMENTO primary key (IDDEPARTAMENTO));");
                db.execSQL("CREATE TABLE EMPRESA (IDEMPRESA VARCHAR2(8) not null, IDTIPOEMPRESA VARCHAR2(8), NOMLEGALEMPRESA VARCHAR2(100) not null, NITEMPRESA VARCHAR2(20) not null, GIROEMPRESA VARCHAR2(100) not null, NRCEMPRESA VARCHAR2(30) not null, constraint PK_EMPRESA primary key (IDEMPRESA));");
                db.execSQL("CREATE TABLE EVALUACION (IDEVALUACION VARCHAR2(8) not null, IDLOCAL VARCHAR2(8), IDCLIENTE VARCHAR2(8), IDTIPOSASTIFACCION VARCHAR2(8), NOTAEVACLIENTE FLOAT not null, constraint PK_EVALUACION primary key (IDEVALUACION));");
                db.execSQL("CREATE TABLE LOCAL (IDLOCAL VARCHAR2(8) not null, IDEMPRESA VARCHAR2(8), IDSECTOR VARCHAR2(8), IDMUNICIPIO VARCHAR2(8), NOMBRELOCAL VARCHAR2(100) not null, DESCRIPLOCAL VARCHAR2(100) not null, constraint PK_LOCAL primary key (IDLOCAL));");
                db.execSQL("CREATE TABLE MUNICIPIO (IDMUNICIPIO VARCHAR2(8) not null, IDDEPARTAMENTO VARCHAR2(8), NOMMUNICIPIO VARCHAR2(30) not null, constraint PK_MUNICIPIO primary key (IDMUNICIPIO));");
                db.execSQL("CREATE TABLE OPCIONCRUD (IDOPCION VARCHAR2(8) not null, DESCOPCION VARCHAR2(30) not null, NUMCRUD INTEGER not null, constraint PK_OPCIONCRUD primary key (IDOPCION));");
                db.execSQL("CREATE TABLE RANGO_EDAD (IDRANGOEDAD VARCHAR2(8) not null, NOMBRERANGOEDAD VARCHAR2(100) not null, EDADMENOR FLOAT not null, EDADMAYOR FLOAT not null, constraint PK_RANGO_EDAD primary key (IDRANGOEDAD));");
                db.execSQL("CREATE TABLE SECTOR (IDSECTOR VARCHAR2(8) not null, TIPOSECTOR VARCHAR2(30) not null, constraint PK_SECTOR primary key (IDSECTOR));");
                db.execSQL("CREATE TABLE SEXO (IDSEXO VARCHAR2(8) not null, NOMSEXO VARCHAR2(30) not null, ABREVIATURASEXO CHAR(2) not null, constraint PK_SEXO primary key (IDSEXO));");
                db.execSQL("CREATE TABLE SUGERECIAS (IDSUGERENCIAS VARCHAR2(8) not null, IDLOCAL VARCHAR2(8), IDUSUARIO VARCHAR2(8), TEXTSUGERENCIA VARCHAR2(300) not null, FECHASUGERENCIA VARCHAR2(10) not null, constraint PK_SUGERECIAS primary key (IDSUGERENCIAS));");
                db.execSQL("CREATE TABLE SUGERENCIAS_APP (IDSUGERENCIASAPP VARCHAR2(8) not null, IDUSUARIO VARCHAR2(8), TXTSUGERENCIASAPP VARCHAR2(500) not null, constraint PK_SUGERENCIAS_APP primary key (IDSUGERENCIASAPP));");
                db.execSQL("CREATE TABLE TIPO_EMPRESA (IDTIPOEMPRESA VARCHAR2(8) not null, NOMTIPOEMPRESA VARCHAR2(100) not null, constraint PK_TIPO_EMPRESA primary key (IDTIPOEMPRESA));");
                db.execSQL("CREATE TABLE TIPO_SATISFACION (IDTIPOSASTIFACCION VARCHAR2(8) not null, NOMTIPOSASTIFACCION  VARCHAR2(300) not null,NOTAMENOR FLOAT not null, NOTAMAYOR FLOAT not null, constraint PK_TIPO_SATISFACION primary key (IDTIPOSASTIFACCION));");
                db.execSQL("CREATE TABLE TIPO_USUARIO (IDTIPOUSUARIO VARCHAR2(8) not null, DESTIPOUSUARIO VARCHAR2(30) not null, constraint PK_TIPO_USUARIO primary key (IDTIPOUSUARIO));");
                db.execSQL("CREATE TABLE USUARIO (IDUSUARIO VARCHAR2(8) not null, IDTIPOUSUARIO VARCHAR2(8), IDEMPRESA VARCHAR2(8), NOMUSUARIO VARCHAR2(30) not null, CONTRAUSUARIO VARCHAR2(50) not null, CORREOUSUARIO VARCHAR2(50) not null, constraint PK_USUARIO primary key (IDUSUARIO));");
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

    //Aquí comienza lo chidori xD

    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    public String insertar(Cliente cliente) {
        return null;
    }
    public String actualizar(Cliente cliente) {
        return null;
    }

    public String eliminar(Cliente cliente) {
        return null;
    }

    public Cliente consultarCliente(String idCliente) {
        return null;
    }
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */


}