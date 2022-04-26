package sv.ues.fia.eisi.proyecto1;

import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_DEPARTAMENTO;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_SEXO;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_TIPO_SATISFACION;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposDepartamento;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_CLIENTE;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_COMENTARIOS;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_DENUNCIAS;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_EMPRESA;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_EVALUACION;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_LOCAL;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_MUNICIPIO;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_RANGO_EDAD;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposCliente;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposComentarios;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposDenuncias;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposEmpresa;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposEvaluacion;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposLocal;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposMunicipio;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposRangoEdad;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposSexo;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposTipoSatisfaccion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import sv.ues.fia.eisi.proyecto1.CRUDCliente.Cliente;
import sv.ues.fia.eisi.proyecto1.CRUDDepartamento.Departamento;
import sv.ues.fia.eisi.proyecto1.CRUDRangoEdad.Rango_Edad;
import sv.ues.fia.eisi.proyecto1.CRUDSexo.Sexo;

public class BD_Controlador {

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
                db.execSQL("CREATE TABLE "+TABLE_CLIENTE+" ("+camposCliente[0]+" VARCHAR2(8) not null, "+camposCliente[1]+" VARCHAR2(8), "+camposCliente[2]+" VARCHAR2(8), "+camposCliente[3]+" VARCHAR2(8), "+camposCliente[4]+" VARCHAR2(300) not null, "+camposCliente[5]+" VARCHAR2(20) not null, constraint PK_CLIENTE primary key ("+camposCliente[0]+"));");
                db.execSQL("CREATE TABLE "+TABLE_COMENTARIOS+" ("+camposComentarios[0]+" VARCHAR2(8) not null, "+camposComentarios[1]+" VARCHAR2(8), "+camposComentarios[2]+" VARCHAR2(8),"+camposComentarios[3]+" VARCHAR2(300) not null, "+camposComentarios[4]+" VARCHAR2(10) not null, constraint PK_COMENTARIOS primary key ("+camposComentarios[0]+"));");
                db.execSQL("CREATE TABLE "+TABLE_DENUNCIAS+" ("+camposDenuncias[0]+" VARCHAR2(8) not null, "+camposDenuncias[1]+" VARCHAR2(8), "+camposDenuncias[2]+" VARCHAR2(8), "+camposDenuncias[3]+" VARCHAR2(300) not null, "+camposDenuncias[4]+" VARCHAR2(10) not null, constraint PK_DENUNCIAS primary key ("+camposDenuncias[0]+"));");
                db.execSQL("CREATE TABLE "+TABLE_DEPARTAMENTO+" ("+camposDepartamento[0]+" VARCHAR2(8) not null, "+camposDepartamento[1]+" VARCHAR2(30) not null, constraint PK_DEPARTAMENTO primary key ("+camposDepartamento[0]+"));");
                db.execSQL("CREATE TABLE "+TABLE_EMPRESA+" ("+camposEmpresa[0]+" VARCHAR2(8) not null, "+camposEmpresa[1]+" VARCHAR2(8), "+camposEmpresa[2]+" VARCHAR2(100) not null, "+camposEmpresa[3]+" VARCHAR2(20) not null, "+camposEmpresa[4]+" VARCHAR2(100) not null, "+camposEmpresa[5]+" VARCHAR2(30) not null, constraint PK_EMPRESA primary key ("+camposEmpresa[0]+"));");
                db.execSQL("CREATE TABLE "+TABLE_EVALUACION+" ("+camposEvaluacion[0]+" VARCHAR2(8) not null, "+camposEvaluacion[1]+" VARCHAR2(8), "+camposEvaluacion[2]+" VARCHAR2(8), "+camposEvaluacion[3]+" VARCHAR2(8), "+camposEvaluacion[4]+" FLOAT not null, constraint PK_EVALUACION primary key ("+camposEvaluacion[0]+"));");
                db.execSQL("CREATE TABLE "+TABLE_LOCAL+" ("+camposLocal[0]+" VARCHAR2(8) not null, "+camposLocal[1]+" VARCHAR2(8), "+camposLocal[2]+" VARCHAR2(8), "+camposLocal[3]+" VARCHAR2(8), "+camposLocal[4]+" VARCHAR2(100) not null, "+camposLocal[5]+" VARCHAR2(100) not null, constraint PK_LOCAL primary key ("+camposLocal[0]+"));");
                db.execSQL("CREATE TABLE "+TABLE_MUNICIPIO+" ("+camposMunicipio[0]+" VARCHAR2(8) not null, "+camposMunicipio[1]+" VARCHAR2(8), "+camposMunicipio[2]+" VARCHAR2(30) not null, constraint PK_MUNICIPIO primary key ("+camposMunicipio[0]+"));");
                db.execSQL("CREATE TABLE OPCIONCRUD (IDOPCION VARCHAR2(8) not null, DESCOPCION VARCHAR2(30) not null, NUMCRUD INTEGER not null, constraint PK_OPCIONCRUD primary key (IDOPCION));");
                db.execSQL("CREATE TABLE "+TABLE_RANGO_EDAD+" ("+camposRangoEdad[0]+" VARCHAR2(8) not null, "+camposRangoEdad[1]+" VARCHAR2(100) not null, "+camposRangoEdad[2]+" FLOAT not null, "+camposRangoEdad[3]+" FLOAT not null, constraint PK_RANGO_EDAD primary key ("+camposRangoEdad[0]+"));");
                db.execSQL("CREATE TABLE SECTOR (IDSECTOR VARCHAR2(8) not null, TIPOSECTOR VARCHAR2(30) not null, constraint PK_SECTOR primary key (IDSECTOR));");
                db.execSQL("CREATE TABLE "+TABLE_SEXO+" ("+camposSexo[0]+" VARCHAR2(8) not null, "+camposSexo[1]+" VARCHAR2(30) not null, "+camposSexo[3]+" CHAR(2) not null, constraint PK_SEXO primary key ("+camposSexo[0]+"));");
                db.execSQL("CREATE TABLE SUGERECIAS (IDSUGERENCIAS VARCHAR2(8) not null, IDLOCAL VARCHAR2(8), IDUSUARIO VARCHAR2(8), TEXTSUGERENCIA VARCHAR2(300) not null, FECHASUGERENCIA VARCHAR2(10) not null, constraint PK_SUGERECIAS primary key (IDSUGERENCIAS));");
                db.execSQL("CREATE TABLE SUGERENCIAS_APP (IDSUGERENCIASAPP VARCHAR2(8) not null, IDUSUARIO VARCHAR2(8), TXTSUGERENCIASAPP VARCHAR2(500) not null, constraint PK_SUGERENCIAS_APP primary key (IDSUGERENCIASAPP));");
                db.execSQL("CREATE TABLE TIPO_EMPRESA (IDTIPOEMPRESA VARCHAR2(8) not null, NOMTIPOEMPRESA VARCHAR2(100) not null, constraint PK_TIPO_EMPRESA primary key (IDTIPOEMPRESA));");
                db.execSQL("CREATE TABLE "+TABLE_TIPO_SATISFACION+" ("+camposTipoSatisfaccion[0]+" VARCHAR2(8) not null, "+camposTipoSatisfaccion[1]+"  VARCHAR2(300) not null,"+camposTipoSatisfaccion[2]+" FLOAT not null, "+camposTipoSatisfaccion[3]+" FLOAT not null, constraint PK_TIPO_SATISFACION primary key ("+camposTipoSatisfaccion[0]+"));");
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

    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
    private boolean verificarIntegridad(Object dato, int relacion) throws SQLException{
        switch (relacion){
            case 1: //Verificar si existe RangoEdad
                Rango_Edad rango_edad = (Rango_Edad) dato;
                String[] id = {rango_edad.getIdRangoEdad()};
                abrir();
                Cursor c1 = db.query(TABLE_RANGO_EDAD, null,
                        camposRangoEdad[0]+"=?", id, null, null, null);
                if(c1.moveToFirst())
                    return true;
                return false;
            case 2: //Verificar si existe Sexo
                Sexo sexo = (Sexo) dato;
                String[] id2 = {sexo.getIdSexo()};
                abrir();
                Cursor c2 = db.query(TABLE_SEXO, null, camposSexo[0]+"=?",
                        id2, null, null,null);
                if(c2.moveToFirst())
                    return true;
                return false;
            case 3: //Verificar si existe Departamento
                Departamento departamento = (Departamento) dato;
                String[] id3 = {departamento.getIdDepartamento()};
                abrir();
                Cursor c3 = db.query(TABLE_DEPARTAMENTO, null, camposDepartamento[0]+"=?",
                        id3, null, null, null);
                if(c3.moveToFirst())
                    return true;
                return false;
            default: return false;
        }
    }
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - RANGO EDAD*/
    public String insertar(Rango_Edad rango_edad) {
        String regInsertados = "Registro insertado N°= ";
        long cont = 0;
        ContentValues cv = new ContentValues();
        cv.put(camposRangoEdad[0],rango_edad.getIdRangoEdad());
        cv.put(camposRangoEdad[1],rango_edad.getNomRangoEdad());
        cv.put(camposRangoEdad[2], rango_edad.getEdadMenor());
        cv.put(camposRangoEdad[3], rango_edad.getEdadMayor());
        cont = db.insert(TABLE_RANGO_EDAD, null, cv);
        if(cont == -1 || cont == 0)
            regInsertados = "Error al insertar el registro, Registro duplicado. Verificar insercción";
        else regInsertados += cont;
        return regInsertados;
    }
    public String actualizar(Rango_Edad rango_edad) {
        if(verificarIntegridad(rango_edad, 1)){
            String[] id = {rango_edad.getIdRangoEdad()};
            ContentValues cv = new ContentValues();
            cv.put(camposRangoEdad[0], rango_edad.getIdRangoEdad());
            cv.put(camposRangoEdad[1], rango_edad.getNomRangoEdad());
            cv.put(camposRangoEdad[2], rango_edad.getEdadMenor());
            cv.put(camposRangoEdad[3], rango_edad.getEdadMayor());
            db.update(TABLE_RANGO_EDAD, cv, camposRangoEdad[0]+"=?",
                    id);
            return "Registro actualizado correctamente";
        }else return "Registro con id = "+rango_edad.getIdRangoEdad()+" no existe";
    }

    public String eliminar(Rango_Edad rango_edad) {
        String registrosAfectados = "Filas afectadas = ";
        int cont = 0;
        cont+= db.delete(TABLE_RANGO_EDAD,
                camposRangoEdad[0]+"='"+rango_edad.getIdRangoEdad()+"'", null);
        registrosAfectados+= cont;
        return registrosAfectados;
    }

    public Rango_Edad consultarRangoEdad(String idRangoEdad) {
        String[] id = {idRangoEdad};
        Cursor cursor = db.query(TABLE_RANGO_EDAD, camposRangoEdad,
                camposRangoEdad[0]+" =?",id, null,null,null);
        if(cursor.moveToFirst()){
            Rango_Edad rango_edad = new Rango_Edad();
            rango_edad.setIdRangoEdad(cursor.getString(0));
            rango_edad.setNomRangoEdad(cursor.getString(1));
            rango_edad.setEdadMenor(cursor.getFloat(2));
            rango_edad.setEdadMayor(cursor.getFloat(3));
            return rango_edad;
        }else return null;
    }
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - SEXO*/
    public String insertar(Sexo sexo) {
        String regInsertados = "Registro insertado N°= ";
        long cont = 0;
        ContentValues cv = new ContentValues();
        cv.put(camposSexo[0],sexo.getIdSexo());
        cv.put(camposSexo[1],sexo.getNomSexo());
        cv.put(camposSexo[2], sexo.getAbreviaturaSexo());
        cont = db.insert(TABLE_SEXO, null, cv);
        if(cont == -1 || cont == 0)
            regInsertados = "Error al insertar el registro, Registro duplicado. Verificar insercción";
        else regInsertados += cont;
        return regInsertados;
    }
    public String actualizar(Sexo sexo) {
        if(verificarIntegridad(sexo, 2)){
            String[] id = {sexo.getIdSexo()};
            ContentValues cv = new ContentValues();
            cv.put(camposSexo[0], sexo.getIdSexo());
            cv.put(camposSexo[1], sexo.getNomSexo());
            cv.put(camposSexo[2], sexo.getAbreviaturaSexo());
            db.update(TABLE_SEXO, cv, camposSexo [0]+"=?",
                    id);
            return "Registro actualizado correctamente";
        }else return "Registro con id = "+sexo.getIdSexo()+" no existe";
    }

    public String eliminar(Sexo sexo) {
        String registrosAfectados = "Filas afectadas = ";
        int cont = 0;
        cont+= db.delete(TABLE_SEXO,
                camposSexo[0]+"='"+sexo.getIdSexo()+"'", null);
        registrosAfectados+= cont;
        return registrosAfectados;
    }

    public Sexo consultarSexo(String idSexo) {
        String[] id = {idSexo};
        Cursor cursor = db.query(TABLE_SEXO, camposSexo,
                camposSexo [0]+" =?",id, null,null,null);
        if(cursor.moveToFirst()){
            Sexo sexo = new Sexo();
            sexo.setIdSexo(cursor.getString(0));
            sexo.setNomSexo(cursor.getString(1));
            sexo.setAbreviaturaSexo(cursor.getString(2));
            return sexo;
        }else return null;
    }
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - DEPARTAMENTO*/
    public String insertar(Departamento departamento) {
        String regInsertados = "Registro insertado N°= ";
        long cont = 0;
        ContentValues cv = new ContentValues();
        cv.put(camposDepartamento[0],departamento.getIdDepartamento());
        cv.put(camposDepartamento[1],departamento.getNomDepartamento());

        cont = db.insert(TABLE_DEPARTAMENTO, null, cv);
        if(cont == -1 || cont == 0)
            regInsertados = "Error al insertar el registro, Registro duplicado. Verificar insercción";
        else regInsertados += cont;
        return regInsertados;
    }
    public String actualizar(Departamento departamento) {
        if(verificarIntegridad(departamento, 3)){
            String[] id = {departamento.getIdDepartamento()};
            ContentValues cv = new ContentValues();
            cv.put(camposDepartamento[0], departamento.getIdDepartamento());
            cv.put(camposDepartamento[1], departamento.getNomDepartamento());
            db.update(TABLE_DEPARTAMENTO, cv, camposDepartamento[0]+"=?",
                    id);
            return "Registro actualizado correctamente";
        }else return "Registro con id = "+departamento.getIdDepartamento()+" no existe";
    }

    public String eliminar(Departamento departamento) {
        String registrosAfectados = "Filas afectadas = ";
        int cont = 0;
        cont+= db.delete(TABLE_DEPARTAMENTO,
                camposDepartamento[0]+"='"+departamento.getIdDepartamento()+"'", null);
        registrosAfectados+= cont;
        return registrosAfectados;
    }

    public Departamento consultarDepartamento(String idDepartamento) {
        String[] id = {idDepartamento};
        Cursor cursor = db.query(TABLE_DEPARTAMENTO, camposDepartamento,
                camposDepartamento[0]+" =?",id, null,null,null);
        if(cursor.moveToFirst()){
            Departamento departamento = new Departamento();
            departamento.setIdDepartamento(cursor.getString(0));
            departamento.setNomDepartamento(cursor.getString(1));
            return departamento;
        }else return null;
    }
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */


}