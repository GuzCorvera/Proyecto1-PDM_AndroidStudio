package sv.ues.fia.eisi.proyecto1;

import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_DEPARTAMENTO;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_SECTOR;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_SEXO;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_SUGERENCIAS;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_SUGERENCIAS_APP;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_TIPO_EMPRESA;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_TIPO_SATISFACCION;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_TIPO_USUARIO;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_USUARIO;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_USUARIO_TEMP;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposDepartamento;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_CLIENTE;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_COMENTARIOS;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_DENUNCIA;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_EMPRESA;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_EVALUACION;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_LOCAL;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_MUNICIPIO;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.TABLE_RANGO_EDAD;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposCliente;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposComentarios;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposDenuncia;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposEmpresa;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposEvaluacion;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposLocal;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposMunicipio;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposRangoEdad;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposTipoEmpresa;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposSector;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposSexo;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposSugerencias;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposSugerencias_App;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposTipoSatisfaccion;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposTipoUsuario;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposUsuario;
import static sv.ues.fia.eisi.proyecto1.BaseDatos.camposUsuarioTemp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import sv.ues.fia.eisi.proyecto1.CRUDCliente.Cliente;
import sv.ues.fia.eisi.proyecto1.CRUDComentarios.Comentarios;
import sv.ues.fia.eisi.proyecto1.CRUDDenuncias.Denuncia;
import sv.ues.fia.eisi.proyecto1.CRUDDepartamento.Departamento;
import sv.ues.fia.eisi.proyecto1.CRUDEmpresa.Empresa;
import sv.ues.fia.eisi.proyecto1.CRUDEvaluacion.Evaluacion;
import sv.ues.fia.eisi.proyecto1.CRUDLocal.Local;
import sv.ues.fia.eisi.proyecto1.CRUDMunicipio.Municipio;
import sv.ues.fia.eisi.proyecto1.CRUDRangoEdad.Rango_Edad;
import sv.ues.fia.eisi.proyecto1.CRUDSector.Sector;
import sv.ues.fia.eisi.proyecto1.CRUDSexo.Sexo;
import sv.ues.fia.eisi.proyecto1.CRUDSugerencias.Sugerencias;
import sv.ues.fia.eisi.proyecto1.CRUDSugerenciasApp.Sugerencias_App;
import sv.ues.fia.eisi.proyecto1.CRUDTipoEmpresa.Tipo_Empresa;
import sv.ues.fia.eisi.proyecto1.CRUDTipoSatisfaccion.Tipo_Satisfaccion;
import sv.ues.fia.eisi.proyecto1.CRUDTipoUsuario.Tipo_Usuario;
import sv.ues.fia.eisi.proyecto1.CRUDUsuario.Usuario;

public class BD_Controlador {

    private final Context context;
    private final DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public BD_Controlador(Context ctx) {
        this.context = ctx;
        dbHelper = new DatabaseHelper(context);
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
                //db.execSQL("CREATE TABLE ACCESOUSUARIO (IDUSUARIO VARCHAR2(8), IDOPCION VARCHAR2(8));");
                db.execSQL("CREATE TABLE "+TABLE_CLIENTE+" ("+camposCliente[0]+" VARCHAR2(8) not null, "+camposCliente[1]+" VARCHAR2(8), "+camposCliente[2]+" VARCHAR2(8), "+camposCliente[3]+" VARCHAR2(8), "+camposCliente[4]+" VARCHAR2(300) not null, "+camposCliente[5]+" VARCHAR2(20) not null, constraint PK_CLIENTE primary key ("+camposCliente[0]+"));");
                db.execSQL("CREATE TABLE "+TABLE_COMENTARIOS+" ("+camposComentarios[0]+" VARCHAR2(8) not null, "+camposComentarios[1]+" VARCHAR2(8), "+camposComentarios[2]+" VARCHAR2(8),"+camposComentarios[3]+" VARCHAR2(300) not null, "+camposComentarios[4]+" VARCHAR2(10) not null, constraint PK_COMENTARIOS primary key ("+camposComentarios[0]+"));");
                db.execSQL("CREATE TABLE "+ TABLE_DENUNCIA +" ("+ camposDenuncia[0]+" VARCHAR2(8) not null, "+ camposDenuncia[1]+" VARCHAR2(8), "+ camposDenuncia[2]+" VARCHAR2(8), "+ camposDenuncia[3]+" VARCHAR2(300) not null, "+ camposDenuncia[4]+" VARCHAR2(10) not null, constraint PK_DENUNCIAS primary key ("+ camposDenuncia[0]+"));");
                db.execSQL("CREATE TABLE "+TABLE_DEPARTAMENTO+" ("+camposDepartamento[0]+" VARCHAR2(8) not null, "+camposDepartamento[1]+" VARCHAR2(30) not null, constraint PK_DEPARTAMENTO primary key ("+camposDepartamento[0]+"));");
                db.execSQL("CREATE TABLE "+TABLE_EMPRESA+" ("+camposEmpresa[0]+" VARCHAR2(8) not null, "+camposEmpresa[1]+" VARCHAR2(8), "+camposEmpresa[2]+" VARCHAR2(100) not null, "+camposEmpresa[3]+" VARCHAR2(20) not null, "+camposEmpresa[4]+" VARCHAR2(100) not null, "+camposEmpresa[5]+" VARCHAR2(30) not null, constraint PK_EMPRESA primary key ("+camposEmpresa[0]+"));");
                db.execSQL("CREATE TABLE "+TABLE_EVALUACION+" ("+camposEvaluacion[0]+" VARCHAR2(8) not null, "+camposEvaluacion[1]+" VARCHAR2(8), "+camposEvaluacion[2]+" VARCHAR2(8), "+camposEvaluacion[3]+" VARCHAR2(8), "+camposEvaluacion[4]+" FLOAT not null, "+camposEvaluacion[5]+" VARCHAR2(300),constraint PK_EVALUACION primary key ("+camposEvaluacion[0]+"));");
                db.execSQL("CREATE TABLE "+TABLE_LOCAL+" ("+camposLocal[0]+" VARCHAR2(8) not null, "+camposLocal[1]+" VARCHAR2(8), "+camposLocal[2]+" VARCHAR2(8), "+camposLocal[3]+" VARCHAR2(8), "+camposLocal[4]+" VARCHAR2(100) not null, "+camposLocal[5]+" VARCHAR2(100) not null, constraint PK_LOCAL primary key ("+camposLocal[0]+"));");
                db.execSQL("CREATE TABLE "+TABLE_MUNICIPIO+" ("+camposMunicipio[0]+" VARCHAR2(8) not null, "+camposMunicipio[1]+" VARCHAR2(8), "+camposMunicipio[2]+" VARCHAR2(30) not null, constraint PK_MUNICIPIO primary key ("+camposMunicipio[0]+"));");
                db.execSQL("CREATE TABLE OPCIONCRUD (IDOPCION VARCHAR2(8) not null, DESCOPCION VARCHAR2(30) not null, NUMCRUD INTEGER not null, constraint PK_OPCIONCRUD primary key (IDOPCION));");
                db.execSQL("CREATE TABLE "+TABLE_RANGO_EDAD+" ("+camposRangoEdad[0]+" VARCHAR2(8) not null, "+camposRangoEdad[1]+" VARCHAR2(100) not null, "+camposRangoEdad[2]+" FLOAT not null, "+camposRangoEdad[3]+" FLOAT not null, constraint PK_RANGO_EDAD primary key ("+camposRangoEdad[0]+"));");
                db.execSQL("CREATE TABLE "+TABLE_SECTOR+" ("+camposSector[0]+" VARCHAR2(8) not null, "+camposSector[1]+" VARCHAR2(30) not null, constraint PK_SECTOR primary key ("+camposSector[0]+"));");
                db.execSQL("CREATE TABLE "+TABLE_SUGERENCIAS+" ("+camposSugerencias[0]+" VARCHAR2(8) not null, "+camposSugerencias[1]+" VARCHAR2(8), "+camposSugerencias[2]+" VARCHAR2(8), "+camposSugerencias[3]+" VARCHAR2(300) not null, "+camposSugerencias[4]+" VARCHAR2(10) not null, constraint PK_SUGERECIAS primary key ("+camposSugerencias[0]+"));");
                db.execSQL("CREATE TABLE "+TABLE_SUGERENCIAS_APP+" ("+camposSugerencias_App[0]+" VARCHAR2(8) not null, "+camposSugerencias_App[1]+" VARCHAR2(8), "+camposSugerencias_App[2]+" VARCHAR2(500) not null, constraint PK_SUGERENCIAS_APP primary key ("+camposSugerencias_App[0]+"));");
                db.execSQL("CREATE TABLE "+TABLE_TIPO_EMPRESA+" ("+ camposTipoEmpresa[0]+" VARCHAR2(8) not null, "+ camposTipoEmpresa[1]+" VARCHAR2(100) not null, constraint PK_TIPO_EMPRESA primary key ("+ camposTipoEmpresa[0]+"));");
                db.execSQL("CREATE TABLE "+TABLE_TIPO_SATISFACCION+" ("+camposTipoSatisfaccion[0]+" VARCHAR2(8) not null, "+camposTipoSatisfaccion[1]+"  VARCHAR2(300) not null,"+camposTipoSatisfaccion[2]+" FLOAT not null, "+camposTipoSatisfaccion[3]+" FLOAT not null, constraint PK_TIPO_SATISFACION primary key ("+camposTipoSatisfaccion[0]+"));");
                db.execSQL("CREATE TABLE "+TABLE_TIPO_USUARIO+" ("+camposTipoUsuario[0]+" VARCHAR2(8) not null, "+camposTipoUsuario[1]+" VARCHAR2(30) not null, constraint PK_TIPO_USUARIO primary key ("+camposTipoUsuario[0]+"));");
                db.execSQL("CREATE TABLE "+TABLE_USUARIO+" ("+camposUsuario[0]+" VARCHAR2(8) not null, "+camposUsuario[1]+" VARCHAR2(8), "+camposUsuario[2]+" VARCHAR2(8), "+camposUsuario[3]+" VARCHAR2(30) not null, "+camposUsuario[4]+" VARCHAR2(50) not null, "+camposUsuario[5]+" VARCHAR2(50) not null, constraint PK_USUARIO primary key ("+camposUsuario[0]+"));");
                db.execSQL("CREATE TABLE "+TABLE_SEXO+" ("+camposSexo[0]+" VARCHAR2(8) not null, "+camposSexo[1]+" VARCHAR2(30) not null, "+camposSexo[2]+" CHAR(2) not null, constraint PK_SEXO primary key ("+camposSexo[0]+"));");
                db.execSQL("CREATE TABLE "+TABLE_USUARIO_TEMP+" ("+camposUsuarioTemp[0]+" VARCHAR2(8) not null, "+camposUsuarioTemp[1]+" VARCHAR2(30) not null, constraint PK_USUARIO_TEMP primary key ("+camposUsuarioTemp[0]+"));");

                db.execSQL("Insert into "+TABLE_USUARIO+" values('U0000', 'TP01','', 'admin','admin','admin@admin.com')");

                /*--------------------------------------------------------TRIGGERS-------------------------------------------------------------*/

                //TABLE EMPRESA
                db.execSQL("CREATE TRIGGER fk_INSERT_"+TABLE_EMPRESA+
                        " before insert on "+TABLE_EMPRESA+" begin "+
                        "select case when(select "+camposTipoEmpresa[0]+" from "+TABLE_TIPO_EMPRESA+" where "+camposTipoEmpresa[0]+"=new."+camposEmpresa[1]+") is null\n" +
                        "then raise (abort, 'Error de integridad referencial') end; end;");
                db.execSQL("CREATE TRIGGER fk_UPDATE_"+TABLE_EMPRESA+
                        " before update on "+TABLE_EMPRESA+" for each row begin "+
                        "select case when(select "+camposTipoEmpresa[0]+" from "+TABLE_TIPO_EMPRESA+" where "+camposTipoEmpresa[0]+"=new."+camposEmpresa[1]+") is null " +
                        "then raise (abort, 'Error de integridad referencial') end; end;");
                db.execSQL("CREATE TRIGGER fk_delete_"+TABLE_EMPRESA+
                        " before delete on "+TABLE_EMPRESA+" for each row begin " +
                        "select case when (select "+camposLocal[1]+" from "+TABLE_LOCAL+" where "+camposLocal[1]+"=old."+camposEmpresa[0]+") is not null or " +
                        "(select "+camposUsuario[2]+" from "+TABLE_USUARIO+" where "+camposUsuario[2]+"=old."+camposEmpresa[0]+") is not null " +
                        "then raise(abort, 'Error de integridad referecial') end; end;");

                //TABLE TIPO_EMPRESA
                db.execSQL("CREATE TRIGGER fk_DELETE_"+TABLE_TIPO_EMPRESA+
                        " before delete on "+TABLE_TIPO_EMPRESA+" for each row begin "+
                        "select case when(select "+camposEmpresa[1]+" from "+TABLE_EMPRESA+" where "+camposEmpresa[1]+"=old."+camposTipoEmpresa[0]+") is not null\n" +
                        "then raise (abort, 'Error de integridad referencial') end; end;");

                //TABLE SECTOR
                db.execSQL("CREATE TRIGGER fk_DELETE_"+TABLE_SECTOR+
                        " before delete on "+TABLE_SECTOR+" for each row begin "+
                        "select case when(select "+camposSector[0]+" from "+TABLE_LOCAL+" where "+camposSector[0]+"=old."+camposSector[0]+") is not null\n" +
                        "then raise (abort, 'Error de integridad referencial') end; end;");

                //TABLE MUNICIPIO
                db.execSQL("CREATE TRIGGER fk_INSERT_"+TABLE_MUNICIPIO+
                        " before insert on "+TABLE_MUNICIPIO+" begin " +
                        "select case when(select "+camposDepartamento[0]+" from "+TABLE_DEPARTAMENTO+" where "+camposDepartamento[0]+" = new."+camposMunicipio[1]+") is null " +
                        "then raise(abort,'Error de integridad') end; end;");
                db.execSQL("CREATE TRIGGER fk_UPDATE_"+TABLE_MUNICIPIO+
                        " before update on "+TABLE_MUNICIPIO+" begin " +
                        "select case when(select "+camposDepartamento[0]+" from "+TABLE_DEPARTAMENTO+" where "+camposDepartamento[0]+"=new."+camposMunicipio[1]+") is null " +
                        "then raise(abort, 'Error de integridad referencial') end; end;");
                db.execSQL("CREATE TRIGGER fk_DELETE_"+TABLE_MUNICIPIO+
                        " before delete on "+TABLE_MUNICIPIO+" for each row begin "+
                        "select case when(select "+camposLocal[3]+" from "+TABLE_LOCAL+" where "+camposLocal[3]+"=old."+camposLocal[3]+") is not null\n" +
                        "then raise (abort, 'Error de integridad referencial') end; end;");

                //TABLE DEPARTAMENTO
                db.execSQL("CREATE TRIGGER fk_DELETE_"+TABLE_DEPARTAMENTO+
                        " before delete on "+TABLE_DEPARTAMENTO+" for each row begin "+
                        " select case when(select "+camposDepartamento[0]+" from "+TABLE_MUNICIPIO+" where "+camposDepartamento[0]+" =old."+camposDepartamento[0]+") is not null " +
                        "then raise(abort, 'Error de integridad') end; end;");

                //TABLE LOCAL
                db.execSQL("CREATE TRIGGER fk_INSERT_"+TABLE_LOCAL+
                        " before insert on "+TABLE_LOCAL+" begin " +
                        "select case when(select "+camposEmpresa[0]+" from "+TABLE_EMPRESA+" where "+camposEmpresa[0]+"=new."+camposEmpresa[0]+") is null or " +
                        "(select "+camposMunicipio[0]+" from "+TABLE_MUNICIPIO+" where "+camposMunicipio[0]+"=new."+camposMunicipio[0]+") is null or " +
                        "(select "+camposSector[0]+" from "+TABLE_SECTOR+" where "+camposSector[0]+"=new."+camposSector[0]+") is null " +
                        "then raise(abort, 'Error de integridad') end; end;");
                db.execSQL("CREATE TRIGGER fk_UPDATE_"+TABLE_LOCAL+
                        " before update on "+TABLE_LOCAL+" begin " +
                        "select case when(select "+camposEmpresa[0]+" from "+TABLE_EMPRESA+" where "+camposEmpresa[0]+"=new."+camposEmpresa[0]+") is null or " +
                        "(select "+camposMunicipio[0]+" from "+TABLE_MUNICIPIO+" where "+camposMunicipio[0]+"=new."+camposMunicipio[0]+") is null or " +
                        "(select "+camposSector[0]+" from "+TABLE_SECTOR+" where "+camposSector[0]+"=new."+camposSector[0]+") is null " +
                        "then raise(abort, 'Error de integridad') end; end;");
                db.execSQL("CREATE TRIGGER fk_DELETE_"+TABLE_LOCAL+
                        " before delete on "+TABLE_LOCAL+" for each row begin "+
                        " select case when(select "+camposLocal[0]+" from "+TABLE_COMENTARIOS+" where "+camposLocal[0]+" =old."+camposLocal[0]+") is not null or " +
                        "(select "+camposLocal[0]+" from "+TABLE_SUGERENCIAS+" where "+camposLocal[0]+"=old."+camposLocal[0]+") is not null or " +
                        "(select "+camposLocal[0]+" from "+ TABLE_DENUNCIA +" where "+camposLocal[0]+"=old."+camposLocal[0]+") is not null or "+
                        "(select "+camposLocal[0]+" from "+ TABLE_DENUNCIA +" where "+camposLocal[0]+"=old."+camposLocal[0]+") is not null or "+
                        "(select "+camposLocal[0]+" from "+TABLE_EVALUACION+" where "+camposLocal[0]+"=old."+camposLocal[0]+") is not null "+
                        "then raise(abort, 'Error de integridad') end; end;");

                //TABLE SEXO
                db.execSQL("CREATE TRIGGER fk_DELETE_"+TABLE_SEXO+
                        " before delete on "+TABLE_SEXO+" for each row begin "+
                        " select case when(select "+camposSexo[0]+" from "+TABLE_CLIENTE+" where "+camposSexo[0]+" =old."+camposSexo[0]+") is not null " +
                        "then raise(abort, 'Error de integridad') end; end;");

                //TABLE RANGO_EDAD
                db.execSQL("CREATE TRIGGER fk_DELETE_"+TABLE_RANGO_EDAD+
                        " before delete on "+ TABLE_RANGO_EDAD+" for each row begin "+
                        " select case when(select "+camposRangoEdad[0]+" from "+TABLE_CLIENTE+" where "+camposRangoEdad[0]+" =old."+camposRangoEdad[0]+") is not null " +
                        "then raise(abort, 'Error de integridad') end; end;");

                //TABLE TIPO_SATISFACCION
                db.execSQL("CREATE TRIGGER fk_DELETE_"+TABLE_TIPO_SATISFACCION+
                        " before delete on "+TABLE_TIPO_SATISFACCION+" for each row begin "+
                        " select case when(select "+camposTipoSatisfaccion[0]+" from "+TABLE_EVALUACION+" where "+camposTipoSatisfaccion[0]+" =old."+camposTipoSatisfaccion[0]+") is not null " +
                        "then raise(abort, 'Error de integridad') end; end;");

                //TABLE CLIENTE
                db.execSQL("CREATE TRIGGER fk_INSERT_"+TABLE_CLIENTE+
                        " before insert on "+TABLE_CLIENTE+" begin " +
                        "select case when(select "+camposSexo[0]+" from "+TABLE_SEXO+" where "+camposSexo[0]+"=new."+camposSexo[0]+") is null or " +
                        "(select "+camposRangoEdad[0]+" from "+TABLE_RANGO_EDAD+" where "+camposRangoEdad[0]+"=new."+camposRangoEdad[0]+") is null or " +
                        "(select "+camposUsuario[0]+" from "+TABLE_USUARIO+" where "+camposUsuario[0]+"=new."+camposUsuario[0]+") is null " +
                        "then raise(abort, 'Error de integridad') end; end;");
                db.execSQL("CREATE TRIGGER fk_UPDATE_"+TABLE_CLIENTE+
                        " before update on "+TABLE_CLIENTE+" begin " +
                        "select case when(select "+camposSexo[0]+" from "+TABLE_CLIENTE+" where "+camposSexo[0]+"=new."+camposSexo[0]+") is null or " +
                        "(select "+camposRangoEdad[0]+" from "+TABLE_RANGO_EDAD+" where "+camposRangoEdad[0]+"=new."+camposRangoEdad[0]+") is null or " +
                        "(select "+camposUsuario[0]+" from "+TABLE_USUARIO+" where "+camposUsuario[0]+"=new."+camposUsuario[0]+") is null " +
                        "then raise(abort, 'Error de integridad') end; end;");
                db.execSQL("CREATE TRIGGER fk_DELETE_"+TABLE_CLIENTE+
                        " before delete on "+TABLE_CLIENTE+" for each row begin "+
                        " select case when(select "+camposCliente[0]+" from "+TABLE_EVALUACION+" where "+camposCliente[0]+" =old."+camposCliente[0]+") is not null " +
                        "then raise(abort, 'Error de integridad') end; end;");

                //TABLE EVALUACION
                db.execSQL("CREATE TRIGGER fk_INSERT_"+TABLE_EVALUACION+
                        " before insert on "+TABLE_EVALUACION+" begin " +
                        "select case when(select "+camposCliente[0]+" from "+TABLE_CLIENTE+" where "+camposCliente[0]+"=new."+camposCliente[0]+") is null or " +
                        "(select "+camposTipoSatisfaccion[0]+" from "+TABLE_TIPO_SATISFACCION+" where "+camposTipoSatisfaccion[0]+"=new."+camposTipoSatisfaccion[0]+") is null or " +
                        "(select "+camposLocal[0]+" from "+TABLE_LOCAL+" where "+camposLocal[0]+"=new."+camposLocal[0]+") is null " +
                        "then raise(abort, 'Error de integridad') end; end;");
                db.execSQL("CREATE TRIGGER fk_UPDATE_"+TABLE_EVALUACION+
                        " before update on "+TABLE_EVALUACION+" begin " +
                        "select case when(select "+camposCliente[0]+" from "+TABLE_CLIENTE+" where "+camposCliente[0]+"=new."+camposCliente[0]+") is null or " +
                        "(select "+camposTipoSatisfaccion[0]+" from "+TABLE_TIPO_SATISFACCION+" where "+camposTipoSatisfaccion[0]+"=new."+camposTipoSatisfaccion[0]+") is null or " +
                        "(select "+camposLocal[0]+" from "+TABLE_LOCAL+" where "+camposLocal[0]+"=new."+camposLocal[0]+") is null " +
                        "then raise(abort, 'Error de integridad') end; end;");

                //TABLE DENUNCIAS
                db.execSQL("CREATE TRIGGER fk_INSERT_"+ TABLE_DENUNCIA +
                        " before insert on "+ TABLE_DENUNCIA +" begin " +
                        "select case when(select "+camposUsuario[0]+" from "+TABLE_USUARIO+" where "+camposUsuario[0]+"=new."+camposUsuario[0]+") is null or " +
                        "(select "+camposLocal[0]+" from "+TABLE_LOCAL+" where "+camposLocal[0]+"=new."+camposLocal[0]+") is null " +
                        "then raise(abort, 'Error de integridad') end; end;");
                db.execSQL("CREATE TRIGGER fk_UPDATE_"+ TABLE_DENUNCIA +
                        " before update on "+ TABLE_DENUNCIA +" begin " +
                        "select case when(select "+camposUsuario[0]+" from "+TABLE_USUARIO+" where "+camposUsuario[0]+"=new."+camposUsuario[0]+") is null or " +
                        "(select "+camposLocal[0]+" from "+TABLE_LOCAL+" where "+camposLocal[0]+"=new."+camposLocal[0]+") is null " +
                        "then raise(abort, 'Error de integridad') end; end;");

                //TABLE SUGERENCIAS
                db.execSQL("CREATE TRIGGER fk_INSERT_"+TABLE_SUGERENCIAS+
                        " before insert on "+TABLE_SUGERENCIAS+" begin " +
                        "select case when(select "+camposUsuario[0]+" from "+TABLE_USUARIO+" where "+camposUsuario[0]+"=new."+camposUsuario[0]+") is null or " +
                        "(select "+camposLocal[0]+" from "+TABLE_LOCAL+" where "+camposLocal[0]+"=new."+camposLocal[0]+") is null " +
                        "then raise(abort, 'Error de integridad') end; end;");
                db.execSQL("CREATE TRIGGER fk_UPDATE_"+TABLE_SUGERENCIAS+
                        " before update on "+TABLE_SUGERENCIAS+" begin " +
                        "select case when(select "+camposUsuario[0]+" from "+TABLE_USUARIO+" where "+camposUsuario[0]+"=new."+camposUsuario[0]+") is null or " +
                        "(select "+camposLocal[0]+" from "+TABLE_LOCAL+" where "+camposLocal[0]+"=new."+camposLocal[0]+") is null " +
                        "then raise(abort, 'Error de integridad') end; end;");

                //TABLE COMENTARIOS
                db.execSQL("CREATE TRIGGER fk_INSERT_"+TABLE_COMENTARIOS+
                        " before insert on "+TABLE_COMENTARIOS+" begin " +
                        "select case when(select "+camposUsuario[0]+" from "+TABLE_USUARIO+" where "+camposUsuario[0]+"=new."+camposUsuario[0]+") is null or " +
                        "(select "+camposLocal[0]+" from "+TABLE_LOCAL+" where "+camposLocal[0]+"=new."+camposLocal[0]+") is null " +
                        "then raise(abort, 'Error de integridad') end; end;");
                db.execSQL("CREATE TRIGGER fk_UPDATE_"+TABLE_COMENTARIOS+
                        " before update on "+TABLE_COMENTARIOS+" begin " +
                        "select case when(select "+camposUsuario[0]+" from "+TABLE_USUARIO+" where "+camposUsuario[0]+"=new."+camposUsuario[0]+") is null or " +
                        "(select "+camposLocal[0]+" from "+TABLE_LOCAL+" where "+camposLocal[0]+"=new."+camposLocal[0]+") is null " +
                        "then raise(abort, 'Error de integridad') end; end;");

                //TABLE TIPO_USUARIO
                db.execSQL("CREATE TRIGGER fk_DELETE_"+TABLE_TIPO_USUARIO+
                        " before delete on "+TABLE_TIPO_USUARIO+" for each row begin "+
                        " select case when(select "+camposUsuario[0]+" from "+TABLE_USUARIO+" where "+camposUsuario[0]+" =old."+camposUsuario[0]+") is not null " +
                        "then raise(abort, 'Error de integridad') end; end;");

                //TABLE USUARIO
                db.execSQL("CREATE TRIGGER fk_INSERT_"+TABLE_USUARIO+
                        " before insert on "+TABLE_USUARIO+" begin " +
                        "select case when(select "+camposTipoUsuario[0]+" from "+TABLE_TIPO_USUARIO+" where "+camposTipoUsuario[0]+"=new."+camposTipoUsuario[0]+") is null or " +
                        "(select "+camposEmpresa[0]+" from "+TABLE_EMPRESA+" where "+camposEmpresa[0]+"=new."+camposEmpresa[0]+") is null " +
                        "then raise(abort, 'Error de integridad') end; end;");
                db.execSQL("CREATE TRIGGER fk_UPDATE_"+TABLE_USUARIO+
                        " before update on "+TABLE_USUARIO+" begin " +
                        "select case when(select "+camposTipoUsuario[0]+" from "+TABLE_TIPO_USUARIO+" where "+camposTipoUsuario[0]+"=new."+camposTipoUsuario[0]+") is null or " +
                        "(select "+camposEmpresa[0]+" from "+TABLE_EMPRESA+" where "+camposEmpresa[0]+"=new."+camposEmpresa[0]+") is null " +
                        "then raise(abort, 'Error de integridad') end; end;");
                db.execSQL("CREATE TRIGGER fk_DELETE_"+TABLE_USUARIO+
                        " before delete on "+TABLE_USUARIO+" for each row begin "+
                        " select case when(select "+camposUsuario[0]+" from "+TABLE_COMENTARIOS+" where "+camposUsuario[0]+" =old."+camposUsuario[0]+") is not null or " +
                        "(select "+camposUsuario[0]+" from "+TABLE_CLIENTE+" where "+camposUsuario[0]+"=old."+camposUsuario[0]+") is not null or " +
                        "(select "+camposUsuario[0]+" from "+TABLE_SUGERENCIAS+" where "+camposUsuario[0]+"=old."+camposUsuario[0]+") is not null or "+
                        "(select "+ camposUsuario[0]+" from "+ TABLE_DENUNCIA +" where "+ camposUsuario[0]+"=old."+ camposUsuario[0]+") is not null "+
                        "then raise(abort, 'Error de integridad') end; end;");

                //TABLA SUGERENCIAS_APP
                db.execSQL("CREATE TRIGGER fk_INSERT_"+TABLE_SUGERENCIAS_APP+
                        " before insert on "+TABLE_SUGERENCIAS_APP+" begin "+
                        "select case when(select "+camposUsuario[0]+" from "+TABLE_USUARIO+" where "+camposUsuario[0]+"=new."+camposUsuario[0]+") is null\n" +
                        "then raise (abort, 'Error de integridad referencial') end; end;");

                db.execSQL("CREATE TRIGGER fk_UPDATE_"+TABLE_SUGERENCIAS_APP+
                        " before update on "+TABLE_SUGERENCIAS_APP+" begin "+
                        "select case when(select "+camposUsuario[0]+" from "+TABLE_USUARIO+" where "+camposUsuario[0]+"=new."+camposUsuario[0]+") is null\n" +
                        "then raise (abort, 'Error de integridad referencial') end; end;");

                /*--------------------------------------------------------FIN TRIGGERS-------------------------------------------------------------*/

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
        db = dbHelper.getWritableDatabase();
        return;
    }
    public void cerrar() {
        dbHelper.close();
    }

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
        String[] id = {rango_edad.getIdRangoEdad()};
        ContentValues cv = new ContentValues();
        cv.put(camposRangoEdad[0], rango_edad.getIdRangoEdad());
        cv.put(camposRangoEdad[1], rango_edad.getNomRangoEdad());
        cv.put(camposRangoEdad[2], rango_edad.getEdadMenor());
        cv.put(camposRangoEdad[3], rango_edad.getEdadMayor());
        long cont = 0;
        cont = db.update(TABLE_RANGO_EDAD, cv, camposRangoEdad[0] + "=?", id);
        if(cont == 0 || cont ==-1)
            return "Registro con id = "+rango_edad.getIdRangoEdad()+" no existe";
        else return "Registro actualizado correctamente";
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

        String[] id = {sexo.getIdSexo()};
        ContentValues cv = new ContentValues();
        cv.put(camposSexo[0], sexo.getIdSexo());
        cv.put(camposSexo[1], sexo.getNomSexo());
        cv.put(camposSexo[2], sexo.getAbreviaturaSexo());
        try {
            db.update(TABLE_SEXO, cv, camposSexo[0] + "=?",
                    id);
            return "Registro actualizado correctamente";
        }catch (SQLException e){
            return "Registro con id = "+sexo.getIdSexo()+" no existe";
        }
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
        String[] id = {departamento.getIdDepartamento()};
        ContentValues cv = new ContentValues();
        cv.put(camposDepartamento[0], departamento.getIdDepartamento());
        cv.put(camposDepartamento[1], departamento.getNomDepartamento());
        try {
            db.update(TABLE_DEPARTAMENTO, cv, camposDepartamento[0] + "=?", id);
            return "Registro actualizado correctamente";
        }catch (SQLException e){
            return "Registro con id = "+departamento.getIdDepartamento()+" no existe";
        }
    }

    public String eliminar(Departamento departamento) {
        String registrosAfectados = "Filas afectadas = ";
        int cont = 0;
        try{
            cont+= db.delete(TABLE_DEPARTAMENTO,
                    camposDepartamento[0]+"='"+departamento.getIdDepartamento()+"'", null);
            registrosAfectados+= cont;
            return registrosAfectados;
        }catch (SQLException e){
            return "Error, Integridad comprometida por referencia ";
        }
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
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - TIPO_SATISFACCION*/
    public String insertar(Tipo_Satisfaccion satisfaccion) {
        String regInsertados = "Registro insertado N°= ";
        long cont = 0;
        ContentValues cv = new ContentValues();
        cv.put(camposTipoSatisfaccion[0],satisfaccion.getIdTipoSatisfaccion());
        cv.put(camposTipoSatisfaccion[1],satisfaccion.getNomTipoSatisfaccion());
        cv.put(camposTipoSatisfaccion[2], satisfaccion.getNotaMenor());
        cv.put(camposTipoSatisfaccion[3], satisfaccion.getNotaMayor());

        cont = db.insert(TABLE_TIPO_SATISFACCION, null, cv);
        if(cont == -1 || cont == 0)
            regInsertados = "Error al insertar el registro, Registro duplicado. Verificar insercción";
        else regInsertados += cont;
        return regInsertados;
    }
    public String actualizar(Tipo_Satisfaccion satisfaccion) {
        String[] id = {satisfaccion.getIdTipoSatisfaccion()};
        ContentValues cv = new ContentValues();
        cv.put(camposTipoSatisfaccion[0], satisfaccion.getIdTipoSatisfaccion());
        cv.put(camposTipoSatisfaccion[1], satisfaccion.getNomTipoSatisfaccion());
        cv.put(camposTipoSatisfaccion[2], satisfaccion.getNotaMenor());
        cv.put(camposTipoSatisfaccion[3], satisfaccion.getNotaMayor());
        try {
            db.update(TABLE_TIPO_SATISFACCION, cv, camposTipoSatisfaccion[0]+"=?",
                    id);
            return "Registro actualizado correctamente";
        }catch (SQLException e) {
            return "Registro con id = "+satisfaccion.getIdTipoSatisfaccion()+" no existe";
        }
    }

    public String eliminar(Tipo_Satisfaccion satisfaccion) {
        String registrosAfectados = "Filas afectadas = ";
        int cont = 0;
        cont+= db.delete(TABLE_TIPO_SATISFACCION,
                camposTipoSatisfaccion[0]+"='"+satisfaccion.getIdTipoSatisfaccion()+"'", null);
        registrosAfectados+= cont;
        return registrosAfectados;
    }

    public Tipo_Satisfaccion consultarTipoSatisfaccion(String idTipoSatisfaccion) {
        String[] id = {idTipoSatisfaccion};
        Cursor cursor = db.query(TABLE_TIPO_SATISFACCION, camposTipoSatisfaccion,
                camposTipoSatisfaccion[0]+" =?",id, null,null,null);
        if(cursor.moveToFirst()){
            Tipo_Satisfaccion satisfaccion = new Tipo_Satisfaccion();
            satisfaccion.setIdTipoSatisfaccion(cursor.getString(0));
            satisfaccion.setNomTipoSatisfaccion(cursor.getString(1));
            satisfaccion.setNotaMenor(cursor.getFloat(2));
            satisfaccion.setNotaMayor(cursor.getFloat(3));
            return satisfaccion;
        }else return null;
    }
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - SECTOR*/
    public String insertar(Sector sector) {
        String regInsertados = "Registro insertado N°= ";
        long cont = 0;
        ContentValues cv = new ContentValues();
        cv.put(camposSector[0],sector.getIdSector());
        cv.put(camposSector[1],sector.getTipoSector());

        cont = db.insert(TABLE_SECTOR, null, cv);
        if(cont == -1 || cont == 0)
            regInsertados = "Error al insertar el registro, Registro duplicado. Verificar insercción";
        else regInsertados += cont;
        return regInsertados;
    }
    public String actualizar(Sector sector) {
        String[] id = {sector.getIdSector()};
        ContentValues cv = new ContentValues();
        cv.put(camposSector[0], sector.getIdSector());
        cv.put(camposSector[1], sector.getTipoSector());
        try{
            db.update(TABLE_SECTOR, cv, camposSector[0]+"=?",
                    id);
            return "Registro actualizado correctamente";
        }catch (SQLException e){
            return "Registro con id = "+sector.getIdSector()+" no existe";
        }
    }

    public String eliminar(Sector sector) {
        String registrosAfectados = "Filas afectadas = ";
        int cont = 0;
        cont+= db.delete(TABLE_SECTOR,
                camposSector[0]+"='"+sector.getIdSector()+"'", null);
        registrosAfectados+= cont;
        return registrosAfectados;
    }

    public Sector consultarSector(String idSector) {
        String[] id = {idSector};
        Cursor cursor = db.query(TABLE_SECTOR, camposSector,
                camposSector[0]+" =?",id, null,null,null);
        if(cursor.moveToFirst()){
            Sector sector = new Sector();
            sector.setIdSector(cursor.getString(0));
            sector.setTipoSector(cursor.getString(1));
            return sector;
        }else return null;
    }
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - TIPO_EMPRESA*/
    public String insertar(Tipo_Empresa tipoEmpresa) {
        String regInsertados = "Registro insertado N°= ";
        long cont = 0;
        ContentValues cv = new ContentValues();
        cv.put(camposTipoEmpresa[0],tipoEmpresa.getIdTipoEmpresa());
        cv.put(camposTipoEmpresa[1],tipoEmpresa.getNomTipoEmpresa());

        cont = db.insert(TABLE_TIPO_EMPRESA, null, cv);
        if(cont == -1 || cont == 0)
            regInsertados = "Error al insertar el registro, Registro duplicado. Verificar insercción";
        else regInsertados += cont;
        return regInsertados;
    }
    public String actualizar(Tipo_Empresa tipoEmpresa) {
        String[] id = {tipoEmpresa.getIdTipoEmpresa()};
        ContentValues cv = new ContentValues();
        cv.put(camposTipoEmpresa[0], tipoEmpresa.getIdTipoEmpresa());
        cv.put(camposTipoEmpresa[1], tipoEmpresa.getNomTipoEmpresa());
        try {
            db.update(TABLE_TIPO_EMPRESA, cv, camposTipoEmpresa[0]+"=?",
                    id);
            return "Registro actualizado correctamente";
        }catch (SQLException e) {
            return "Registro con id = "+tipoEmpresa.getIdTipoEmpresa()+" no existe";
        }
    }

    public String eliminar(Tipo_Empresa tipoEmpresa) {
        String registrosAfectados = "Filas afectadas = ";
        int cont = 0;
        try {
            cont += db.delete(TABLE_TIPO_EMPRESA,
                    camposTipoEmpresa[0] + "='" + tipoEmpresa.getIdTipoEmpresa() + "'", null);
        }catch (SQLException e){
            return "Trigger, Error, hay tablas que hacen referencia a "+tipoEmpresa.getIdTipoEmpresa();
        }
        registrosAfectados+= cont;
        return registrosAfectados;
    }

    public Tipo_Empresa consultarTipoEmpresa(String idTipoEmpresa) {
        String[] id = {idTipoEmpresa};
        Cursor cursor = db.query(TABLE_TIPO_EMPRESA, camposTipoEmpresa,
                camposTipoEmpresa[0]+" =?",id, null,null,null);
        if(cursor.moveToFirst()){
            Tipo_Empresa tipoEmpresa = new Tipo_Empresa();
            tipoEmpresa.setIdTipoEmpresa(cursor.getString(0));
            tipoEmpresa.setNomTipoEmpresa(cursor.getString(1));
            return tipoEmpresa;
        }else return null;
    }
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - TIPO_USUARIO*/
    public String insertar(Tipo_Usuario tipoUsuario) {
        String regInsertados = "Registro insertado N°= ";
        long cont = 0;
        ContentValues cv = new ContentValues();
        cv.put(camposTipoUsuario[0],tipoUsuario.getIdTipoUsuario());
        cv.put(camposTipoUsuario[1],tipoUsuario.getDesTipoUsuario());

        cont = db.insert(TABLE_TIPO_USUARIO, null, cv);
        if(cont == -1 || cont == 0)
            regInsertados = "Error al insertar el registro, Registro duplicado. Verificar insercción";
        else regInsertados += cont;
        return regInsertados;
    }
    public String actualizar(Tipo_Usuario tipoUsuario) {
        String[] id = {tipoUsuario.getIdTipoUsuario()};
        ContentValues cv = new ContentValues();
        cv.put(camposTipoUsuario[0], tipoUsuario.getIdTipoUsuario());
        cv.put(camposTipoUsuario[1], tipoUsuario.getDesTipoUsuario());
        try{
            db.update(TABLE_TIPO_USUARIO, cv, camposTipoUsuario[0]+"=?",
                    id);
            return "Registro actualizado correctamente";
        }catch (SQLException e){
            return "Registro con id = "+tipoUsuario.getIdTipoUsuario()+" no existe";
        }
    }

    public String eliminar(Tipo_Usuario tipoUsuario) {
        String registrosAfectados = "Filas afectadas = ";
        int cont = 0;
        cont+= db.delete(TABLE_TIPO_USUARIO,
                camposTipoUsuario[0]+"='"+tipoUsuario.getIdTipoUsuario()+"'", null);
        registrosAfectados+= cont;
        return registrosAfectados;
    }

    public Tipo_Usuario consultarTipoUsuario(String idTipoUsuario) {
        String[] id = {idTipoUsuario};
        Cursor cursor = db.query(TABLE_TIPO_USUARIO, camposTipoUsuario,
                camposTipoUsuario[0]+" =?",id, null,null,null);
        if(cursor.moveToFirst()){
            Tipo_Usuario tipoUsuario = new Tipo_Usuario();
            tipoUsuario.setIdTipoUsuario(cursor.getString(0));
            tipoUsuario.setDesTipoUsuario(cursor.getString(1));
            return tipoUsuario;
        }else return null;
    }
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - EMPRESA*/

    public String insertar(Empresa empresa) {
        String regInsertados = "Registro insertado N°= ";

        long cont = 0;
        ContentValues cv = new ContentValues();
        cv.put(camposEmpresa[0],empresa.getIdEmpresa());
        cv.put(camposEmpresa [1],empresa.getIdTipoEmpresa());
        cv.put(camposEmpresa[2], empresa.getNomLegalEmpresa());
        cv.put(camposEmpresa[3], empresa.getNitEmpresa());
        cv.put(camposEmpresa[4], empresa.getGiroEmpresa());
        cv.put(camposEmpresa[5], empresa.getNrcEmpresa());

        try {
            cont = db.insert(TABLE_EMPRESA, null, cv);
            if(cont == -1 || cont == 0)
                regInsertados = "Error al insertar el registro, Registro duplicado o Error de integridad referencial. Verificar insercción";
            else regInsertados += cont;
        }catch (SQLException e){
            regInsertados = "Error al insertar el registro, No existe el TipoEmpresa. Verificar inserccion";
        }
        return regInsertados;
    }

    public String actualizar(Empresa empresa) {
        String[] id = {empresa.getIdEmpresa()};
        ContentValues cv = new ContentValues();
        cv.put(camposEmpresa[0], empresa.getIdEmpresa());
        cv.put(camposEmpresa[1], empresa.getIdTipoEmpresa());
        cv.put(camposEmpresa[2], empresa.getNomLegalEmpresa());
        cv.put(camposEmpresa[3], empresa.getNitEmpresa());
        cv.put(camposEmpresa[4], empresa.getGiroEmpresa());
        cv.put(camposEmpresa[5], empresa.getNrcEmpresa());
        try {
            long cont = db.update(TABLE_EMPRESA, cv, camposEmpresa[0] + "=?",
                    id);
            if(cont==-1 || cont==0)
                return "Registro con id = "+empresa.getIdEmpresa()+" no existe";
            else return "Registro actualizado correctamente";
        }catch (SQLException e){
            return "Error de integridad referencial, no existe "+camposEmpresa[1]+"="+empresa.getIdTipoEmpresa();
        }
    }

    public String eliminar(Empresa empresa) {
        String registrosAfectados = "Filas afectadas = ";
        int cont = 0;
        cont+= db.delete(TABLE_EMPRESA,
                camposEmpresa[0]+"='"+empresa.getIdEmpresa()+"'", null);
        registrosAfectados+= cont;
        return registrosAfectados;
    }

    public Empresa consultarEmpresa(String idEmpresa) {
        String[] id = {idEmpresa};
        Cursor cursor = db.query(TABLE_EMPRESA, camposEmpresa,
                camposEmpresa[0]+" =?",id, null,null,null);
        if(cursor.moveToFirst()){
            Empresa empresa = new Empresa();
            empresa.setIdEmpresa(cursor.getString(0));
            empresa.setIdTipoEmpresa(cursor.getString(1));
            empresa.setNomLegalEmpresa(cursor.getString(2));
            empresa.setNitEmpresa(cursor.getString(3));
            empresa.setGiroEmpresa(cursor.getString(4));
            empresa.setNrcEmpresa(cursor.getString(5));
            return empresa;
        }else return null;
    }
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - MUNICIPIO*/

    public String insertar(Municipio municipio) {
        String regInsertados = "Registro insertado N°= ";

        long cont = 0;
        ContentValues cv = new ContentValues();
        cv.put(camposMunicipio[0],municipio.getIdMunicipio());
        cv.put(camposMunicipio[1],municipio.getIdDepartamento());
        cv.put(camposMunicipio[2], municipio.getNomMunicipio());

        try {
            cont = db.insert(TABLE_MUNICIPIO, null, cv);
            if(cont == -1 || cont == 0)
                regInsertados = "Error al insertar el registro, Registro duplicado o Error de integridad referencial. Verificar insercción";
            else regInsertados += cont;
        }catch (SQLException e){
            regInsertados = "Error al insertar el registro, No existe el "+camposMunicipio[1]+"="+municipio.getIdDepartamento()+". Verificar inserccion";
        }
        return regInsertados;
    }

    public String actualizar(Municipio municipio) {
        String[] id = {municipio.getIdMunicipio()};
        ContentValues cv = new ContentValues();
        cv.put(camposMunicipio[0], municipio.getIdMunicipio());
        cv.put(camposMunicipio[1], municipio.getIdDepartamento());
        cv.put(camposMunicipio[2], municipio.getNomMunicipio());
        try {
            long cont = db.update(TABLE_MUNICIPIO, cv, camposMunicipio[0] + "=?",
                    id);
            if(cont==-1 || cont==0)
                return "Registro con id = "+municipio.getIdMunicipio()+" no existe";
            else return "Registro actualizado correctamente";
        }catch (SQLException e){
            return "Error de integridad referencial, no existe "+camposMunicipio[1]+"="+municipio.getIdDepartamento();
        }
    }

    public String eliminar(Municipio municipio) {
        String registrosAfectados = "Filas afectadas = ";
        int cont = 0;
        cont+= db.delete(TABLE_MUNICIPIO,
                camposMunicipio[0]+"='"+municipio.getIdMunicipio()+"'", null);
        registrosAfectados+= cont;
        return registrosAfectados;
    }

    public Municipio consultarMunicipio(String idMunicipio) {
        String[] id = {idMunicipio};
        Cursor cursor = db.query(TABLE_MUNICIPIO, camposMunicipio,
                camposMunicipio[0]+" =?",id, null,null,null);
        if(cursor.moveToFirst()){
            Municipio municipio = new Municipio();
            municipio.setIdMunicipio(cursor.getString(0));
            municipio.setIdDepartamento(cursor.getString(1));
            municipio.setNomMunicipio(cursor.getString(2));
            return municipio;
        }else return null;
    }
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - LOCAL*/
    public String insertar(Local local) {
        String regInsertados = "Registro insertado N°= ";

        long cont = 0;
        ContentValues cv = new ContentValues();
        cv.put(camposLocal[0],local.getIdLocal());
        cv.put(camposLocal[1],local.getIdEmpresa());
        cv.put(camposLocal[2], local.getIdSector());
        cv.put(camposLocal[3], local.getIdMunicipio());
        cv.put(camposLocal[4], local.getNombreLocal());
        cv.put(camposLocal[5], local.getDescripLocal());

        try {
            cont = db.insert(TABLE_MUNICIPIO, null, cv);
            if(cont == -1 || cont == 0)
                regInsertados = "Error al insertar el registro. Registro duplicado. Verificar insercción";
            else regInsertados += cont;
        }catch (SQLException e){
            regInsertados = "Error al insertar el registro. Error de integridad referencial";
        }
        return regInsertados;
    }

    public String actualizar(Local local) {
        String[] id = {local.getIdLocal()};
        ContentValues cv = new ContentValues();
        cv.put(camposLocal[0], local.getIdLocal());
        cv.put(camposLocal[1], local.getIdEmpresa());
        cv.put(camposLocal[2], local.getIdSector());
        cv.put(camposLocal[3], local.getIdMunicipio());
        cv.put(camposLocal[4], local.getNombreLocal());
        cv.put(camposLocal[5], local.getDescripLocal());
        try {
            long cont = db.update(TABLE_LOCAL, cv, camposLocal[0] + "=?",
                    id);
            if(cont==-1 || cont==0)
                return "Registro con id = "+local.getIdLocal()+" no existe";
            else return "Registro actualizado correctamente";
        }catch (SQLException e){
            return "Error de integridad referencial";
        }
    }

    public String eliminar(Local local) {
        String registrosAfectados = "Filas afectadas = ";
        int cont = 0;
        cont+= db.delete(TABLE_LOCAL,
                camposLocal[0]+"='"+local.getIdLocal()+"'", null);
        registrosAfectados+= cont;
        return registrosAfectados;
    }

    public Local consultarLocal(String idLocal) {
        String[] id = {idLocal};
        Cursor cursor = db.query(TABLE_LOCAL, camposLocal,
                camposLocal[0]+" =?",id, null,null,null);
        if(cursor.moveToFirst()){
            Local local = new Local();
            local.setIdLocal(cursor.getString(0));
            local.setIdEmpresa(cursor.getString(1));
            local.setIdSector(cursor.getString(2));
            local.setIdMunicipio(cursor.getString(3));
            local.setNombreLocal(cursor.getString(4));
            local.setDescripLocal(cursor.getString(5));
            return local;
        }else return null;
    }
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - CLIENTE*/
    public String insertar(Cliente cliente) {
        String regInsertados = "Registro insertado N°= ";

        long cont = 0;
        ContentValues cv = new ContentValues();
        cv.put(camposCliente[0],cliente.getIdCliente());
        cv.put(camposCliente[1], cliente.getIdRangoEdad());
        cv.put(camposCliente[2], cliente.getIdUsuario());
        cv.put(camposCliente[3], cliente.getIdSexo());
        cv.put(camposCliente[4], cliente.getNomcliente());
        cv.put(camposCliente[5], cliente.getTelefonoCliente());

        try {
            cont = db.insert(TABLE_CLIENTE, null, cv);
            if(cont == -1 || cont == 0)
                regInsertados = "Error al insertar el registro. Registro duplicado. Verificar insercción";
            else regInsertados += cont;
        }catch (SQLException e){
            regInsertados = "Error al insertar el registro. Error de integridad referencial";
        }
        return regInsertados;
    }

    public String actualizar(Cliente cliente) {
        String[] id = {cliente.getIdCliente()};
        ContentValues cv = new ContentValues();
        cv.put(camposCliente[0], cliente.getIdCliente());
        cv.put(camposCliente[1], cliente.getIdRangoEdad());
        cv.put(camposCliente[2], cliente.getIdUsuario());
        cv.put(camposCliente[3], cliente.getIdSexo());
        cv.put(camposCliente[4], cliente.getNomcliente());
        cv.put(camposCliente[5], cliente.getTelefonoCliente());
        try {
            long cont = db.update(TABLE_CLIENTE, cv, camposCliente[0] + "=?",
                    id);
            if(cont==-1 || cont==0)
                return "Registro con id = "+cliente.getIdCliente()+" no existe";
            else return "Registro actualizado correctamente";
        }catch (SQLException e){
            return "Error de integridad referencial";
        }
    }

    public String eliminar(Cliente cliente) {
        String registrosAfectados = "Filas afectadas = ";
        int cont = 0;
        cont+= db.delete(TABLE_CLIENTE,
                camposCliente[0]+"='"+cliente.getIdCliente()+"'", null);
        registrosAfectados+= cont;
        return registrosAfectados;
    }

    public Cliente consultarCliente(String idCliente) {
        String[] id = {idCliente};
        Cursor cursor = db.query(TABLE_CLIENTE, camposCliente,
                camposCliente[0]+" =?",id, null,null,null);
        if(cursor.moveToFirst()){
            Cliente cliente = new Cliente(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)
            );
            return cliente;
        }else return null;
    }
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - EVALUACION*/
    public String insertar(Evaluacion evaluacion) {
        String regInsertados = "Registro insertado N°= ";

        long cont = 0;
        ContentValues cv = new ContentValues();
        cv.put(camposEvaluacion[0],evaluacion.getIdEvaluacion());
        cv.put(camposEvaluacion[1], evaluacion.getIdLocal());
        cv.put(camposEvaluacion[2], evaluacion.getIdCliente());
        cv.put(camposEvaluacion[3], evaluacion.getIdTipoSatisfaccion());
        cv.put(camposEvaluacion[4], evaluacion.getNotaEvaCliente());
        cv.put(camposEvaluacion[5], evaluacion.getJustificacionCliente());

        try {
            cont = db.insert(TABLE_EVALUACION, null, cv);
            if(cont == -1 || cont == 0)
                regInsertados = "Error al insertar el registro. Registro duplicado. Verificar insercción";
            else regInsertados += cont;
        }catch (SQLException e){
            regInsertados = "Error al insertar el registro. Error de integridad referencial";
        }
        return regInsertados;
    }

    public String actualizar(Evaluacion evaluacion) {
        String[] id = {evaluacion.getIdEvaluacion()};
        ContentValues cv = new ContentValues();
        cv.put(camposEvaluacion[0],evaluacion.getIdEvaluacion());
        cv.put(camposEvaluacion[1], evaluacion.getIdLocal());
        cv.put(camposEvaluacion[2], evaluacion.getIdCliente());
        cv.put(camposEvaluacion[3], evaluacion.getIdTipoSatisfaccion());
        cv.put(camposEvaluacion[4], evaluacion.getNotaEvaCliente());
        cv.put(camposEvaluacion[5], evaluacion.getJustificacionCliente());
        try {
            long cont = db.update(TABLE_EVALUACION, cv, camposEvaluacion[0] + "=?",
                    id);
            if(cont==-1 || cont==0)
                return "Registro con id = "+evaluacion.getIdEvaluacion()+" no existe";
            else return "Registro actualizado correctamente";
        }catch (SQLException e){
            return "Error de integridad referencial";
        }
    }

    public String eliminar(Evaluacion evaluacion) {
        String registrosAfectados = "Filas afectadas = ";
        int cont = 0;
        cont+= db.delete(TABLE_EVALUACION,
                camposEvaluacion[0]+"='"+evaluacion.getIdEvaluacion()+"'", null);
        registrosAfectados+= cont;
        return registrosAfectados;
    }

    public Evaluacion consultarEvaluacion(String idEvaluacion) {
        String[] id = {idEvaluacion};
        Cursor cursor = db.query(TABLE_EVALUACION, camposEvaluacion,
                camposEvaluacion[0]+" =?",id, null,null,null);
        if(cursor.moveToFirst()){
            Evaluacion evaluacion = new Evaluacion(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getFloat(4),
                    cursor.getString(5)
            );
            return evaluacion;
        }else return null;
    }
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - DENUNCIA*/
    public String insertar(Denuncia denuncia) {
        String regInsertados = "Registro insertado N°= ";

        long cont = 0;
        ContentValues cv = new ContentValues();
        cv.put(camposDenuncia[0], denuncia.getIdDenuncia());
        cv.put(camposDenuncia[1], denuncia.getIdLocal());
        cv.put(camposDenuncia[2], denuncia.getIdUsuario());
        cv.put(camposDenuncia[3], denuncia.getTextDenuncia());
        cv.put(camposDenuncia[4], denuncia.getFechaDenuncia());

        try {
            cont = db.insert(TABLE_DENUNCIA, null, cv);
            if(cont == -1 || cont == 0)
                regInsertados = "Error al insertar el registro. Registro duplicado. Verificar insercción";
            else regInsertados += cont;
        }catch (SQLException e){
            regInsertados = "Error al insertar el registro. Error de integridad referencial";
        }
        return regInsertados;
    }

    public String actualizar(Denuncia denuncia) {
        String[] id = {denuncia.getIdDenuncia()};
        ContentValues cv = new ContentValues();
        cv.put(camposDenuncia[0], denuncia.getIdDenuncia());
        cv.put(camposDenuncia[1], denuncia.getIdLocal());
        cv.put(camposDenuncia[2], denuncia.getIdUsuario());
        cv.put(camposDenuncia[3], denuncia.getTextDenuncia());
        cv.put(camposDenuncia[4], denuncia.getFechaDenuncia());
        try {
            long cont = db.update(TABLE_DENUNCIA, cv, camposDenuncia[0] + "=?",
                    id);
            if(cont==-1 || cont==0)
                return "Registro con id = "+denuncia.getIdDenuncia()+" no existe";
            else return "Registro actualizado correctamente";
        }catch (SQLException e){
            return "Error de integridad referencial";
        }
    }

    public String eliminar(Denuncia denuncia) {
        String registrosAfectados = "Filas afectadas = ";
        int cont = 0;
        cont+= db.delete(TABLE_DENUNCIA,
                camposDenuncia[0]+"='"+denuncia.getIdDenuncia()+"'", null);
        registrosAfectados+= cont;
        return registrosAfectados;
    }

    public Denuncia consultarDenuncia(String idDenuncia) {
        String[] id = {idDenuncia};
        Cursor cursor = db.query(TABLE_DENUNCIA, camposDenuncia,
                camposDenuncia[0]+" =?",id, null,null,null);
        if(cursor.moveToFirst()){
            Denuncia denuncia = new Denuncia(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
            );
            return denuncia;
        }else return null;
    }
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - SUGERENCIAS*/
    public String insertar(Sugerencias sugerencias) {
        String regInsertados = "Registro insertado N°= ";

        long cont = 0;
        ContentValues cv = new ContentValues();
        cv.put(camposSugerencias[0], sugerencias.getIdSugerencia());
        cv.put(camposSugerencias[1], sugerencias.getIdLocal());
        cv.put(camposSugerencias[2], sugerencias.getIdUsuario());
        cv.put(camposSugerencias[3], sugerencias.getTextSugerencia());
        cv.put(camposSugerencias[4], sugerencias.getFechaSugerencia());

        try {
            cont = db.insert(TABLE_SUGERENCIAS, null, cv);
            if(cont == -1 || cont == 0)
                regInsertados = "Error al insertar el registro. Registro duplicado. Verificar insercción";
            else regInsertados += cont;
        }catch (SQLException e){
            regInsertados = "Error al insertar el registro. Error de integridad referencial";
        }
        return regInsertados;
    }

    public String actualizar(Sugerencias sugerencias) {
        String[] id = {sugerencias.getIdSugerencia()};
        ContentValues cv = new ContentValues();
        cv.put(camposSugerencias[0], sugerencias.getIdSugerencia());
        cv.put(camposSugerencias[1], sugerencias.getIdLocal());
        cv.put(camposSugerencias[2], sugerencias.getIdUsuario());
        cv.put(camposSugerencias[3], sugerencias.getTextSugerencia());
        cv.put(camposSugerencias[4], sugerencias.getFechaSugerencia());
        try {
            long cont = db.update(TABLE_SUGERENCIAS, cv, camposSugerencias[0] + "=?",
                    id);
            if(cont==-1 || cont==0)
                return "Registro con id = "+sugerencias.getIdSugerencia()+" no existe";
            else return "Registro actualizado correctamente";
        }catch (SQLException e){
            return "Error de integridad referencial";
        }
    }

    public String eliminar(Sugerencias sugerencias) {
        String registrosAfectados = "Filas afectadas = ";
        int cont = 0;
        cont+= db.delete(TABLE_SUGERENCIAS,
                camposSugerencias[0]+"='"+sugerencias.getIdSugerencia()+"'", null);
        registrosAfectados+= cont;
        return registrosAfectados;
    }

    public Sugerencias consultarSugerencia(String idSugerencia) {
        String[] id = {idSugerencia};
        Cursor cursor = db.query(TABLE_SUGERENCIAS, camposSugerencias,
                camposSugerencias[0]+" =?",id, null,null,null);
        if(cursor.moveToFirst()){
            Sugerencias sugerencia = new Sugerencias(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
            );
            return sugerencia;
        }else return null;
    }
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - COMENTARIOS*/
    public String insertar(Comentarios comentarios) {
        String regInsertados = "Registro insertado N°= ";

        long cont = 0;
        ContentValues cv = new ContentValues();
        cv.put(camposComentarios[0], comentarios.getIdComentario());
        cv.put(camposComentarios[1], comentarios.getIdUsuario());
        cv.put(camposComentarios[2], comentarios.getIdLocal());
        cv.put(camposComentarios[3], comentarios.getTextComentario());
        cv.put(camposComentarios[4], comentarios.getTextComentario());

        try {
            cont = db.insert(TABLE_COMENTARIOS, null, cv);
            if(cont == -1 || cont == 0)
                regInsertados = "Error al insertar el registro. Registro duplicado. Verificar insercción";
            else regInsertados += cont;
        }catch (SQLException e){
            regInsertados = "Error al insertar el registro. Error de integridad referencial";
        }
        return regInsertados;
    }

    public String actualizar(Comentarios comentarios) {
        String[] id = {comentarios.getIdComentario()};
        ContentValues cv = new ContentValues();
        cv.put(camposComentarios[0], comentarios.getIdComentario());
        cv.put(camposComentarios[1], comentarios.getIdUsuario());
        cv.put(camposComentarios[2], comentarios.getIdLocal());
        cv.put(camposComentarios[3], comentarios.getTextComentario());
        cv.put(camposComentarios[4], comentarios.getTextComentario());
        try {
            long cont = db.update(TABLE_COMENTARIOS, cv, camposComentarios[0] + "=?",
                    id);
            if(cont==-1 || cont==0)
                return "Registro con id = "+comentarios.getIdComentario()+" no existe";
            else return "Registro actualizado correctamente";
        }catch (SQLException e){
            return "Error de integridad referencial";
        }
    }

    public String eliminar(Comentarios comentarios) {
        String registrosAfectados = "Filas afectadas = ";
        int cont = 0;
        cont+= db.delete(TABLE_COMENTARIOS,
                camposComentarios[0]+"='"+comentarios.getIdComentario()+"'", null);
        registrosAfectados+= cont;
        return registrosAfectados;
    }

    public Comentarios consultarComentario(String idComentario) {
        String[] id = {idComentario};
        Cursor cursor = db.query(TABLE_COMENTARIOS, camposComentarios,
                camposComentarios[0]+" =?",id, null,null,null);
        if(cursor.moveToFirst()){
            Comentarios comentarios = new Comentarios(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
            );
            return comentarios;
        }else return null;
    }
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - USUARIO*/
    public String insertar(Usuario usuario) {
        String regInsertados = "Registro insertado N°= ";

        long cont = 0;
        ContentValues cv = new ContentValues();
        cv.put(camposUsuario[0], usuario.getIdUsuario());
        cv.put(camposUsuario[1], usuario.getIdTipoUsuario());
        cv.put(camposUsuario[2], usuario.getIdEmpresa());
        cv.put(camposUsuario[3], usuario.getNomUsuario());
        cv.put(camposUsuario[4], usuario.getContraUsuario());
        cv.put(camposUsuario[5], usuario.getCorreoUsuario());

        try {
            cont = db.insert(TABLE_USUARIO, null, cv);
            if(cont == -1 || cont == 0)
                regInsertados = "Error al insertar el registro. Registro duplicado. Verificar insercción";
            else regInsertados += cont;
        }catch (SQLException e){
            regInsertados = "Error al insertar el registro. Error de integridad referencial";
        }
        return regInsertados;
    }

    public String actualizar(Usuario usuario) {
        String[] id = {usuario.getIdUsuario()};
        ContentValues cv = new ContentValues();
        cv.put(camposUsuario[0], usuario.getIdUsuario());
        cv.put(camposUsuario[1], usuario.getIdTipoUsuario());
        cv.put(camposUsuario[2], usuario.getIdEmpresa());
        cv.put(camposUsuario[3], usuario.getNomUsuario());
        cv.put(camposUsuario[4], usuario.getContraUsuario());
        cv.put(camposUsuario[5], usuario.getCorreoUsuario());
        try {
            long cont = db.update(TABLE_USUARIO, cv, camposUsuario[0] + "=?",
                    id);
            if(cont==-1 || cont==0)
                return "Registro con id = "+usuario.getIdUsuario()+" no existe";
            else return "Registro actualizado correctamente";
        }catch (SQLException e){
            return "Error de integridad referencial";
        }
    }

    public String eliminar(Usuario usuario) {
        String registrosAfectados = "Filas afectadas = ";
        int cont = 0;
        cont+= db.delete(TABLE_USUARIO,
                camposUsuario[0]+"='"+usuario.getIdUsuario()+"'", null);
        registrosAfectados+= cont;
        return registrosAfectados;
    }

    public Usuario consultarUsuario(String idUsuario) {
        String[] id = {idUsuario};
        Cursor cursor = db.query(TABLE_USUARIO, camposUsuario,
                camposUsuario[0]+" =?",id, null,null,null);
        if(cursor.moveToFirst()){
            Usuario usuario = new Usuario(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)
            );
            return usuario;
        }else return null;
    }
    public UsuarioTemp consultarUsuario(String username, String contraseña) {
        String[] campos = {username, contraseña};
        Cursor cursor = db.query(TABLE_USUARIO, camposUsuario,
                camposUsuario[3]+" =? and "+camposUsuario[4]+"=?",campos, null,null,null);
        if(cursor.moveToFirst()){
            UsuarioTemp usuarioTemp = new UsuarioTemp(
                    cursor.getString(0),
                    cursor.getString(1)
            );
            return usuarioTemp;
        }else return null;
    }
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - USUARIO_TEMPORAL*/
    public String insertar(UsuarioTemp usuarioTemp) {
        String regInsertados = "Registro insertado N°= ";

        long cont = 0;
        ContentValues cv = new ContentValues();
        cv.put(camposUsuarioTemp[0], usuarioTemp.getIdUsuarioTemp());
        cv.put(camposUsuarioTemp[1], usuarioTemp.getTipoUsuarioTemp());

        try {
            cont = db.insert(TABLE_USUARIO_TEMP, null, cv);
            if(cont == -1 || cont == 0)
                regInsertados = "Error al insertar el registro. Registro duplicado. Verificar insercción";
            else regInsertados += cont;
        }catch (SQLException e){
            regInsertados = "Error al insertar el registro. Error de integridad referencial";
        }
        return regInsertados;
    }

    public String eliminarUsuarioTemporal() {
        String registrosAfectados = "Filas afectadas = ";
        int cont = 0;
        cont+= db.delete(TABLE_USUARIO_TEMP,null, null);
        registrosAfectados+= cont;
        return registrosAfectados;
    }
    public UsuarioTemp consultarUsuarioTemporal() {
        Cursor cursor = db.query(TABLE_USUARIO_TEMP, camposUsuarioTemp,
                null,null, null,null,null);
        if(cursor.moveToFirst()){
            UsuarioTemp usuarioTemp = new UsuarioTemp(
                    cursor.getString(0),
                    cursor.getString(1)
            );
            return usuarioTemp;
        }else return null;
    }
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - Sugerencias App*/
    public String insertar(Sugerencias_App sugerencias_app) {
        String regInsertados = "Registro insertado N°= ";

        long cont = 0;
        ContentValues cv = new ContentValues();
        cv.put(camposSugerencias_App[0], sugerencias_app.getIdSugerenciasApp());
        cv.put(camposSugerencias_App[1], sugerencias_app.getIdUsuario());
        cv.put(camposSugerencias_App[2], sugerencias_app.getTxtSugerenciasApp());

        try {
            cont = db.insert(TABLE_SUGERENCIAS_APP, null, cv);
            if(cont == -1 || cont == 0)
                regInsertados = "Error al insertar el registro. Registro duplicado. Verificar insercción";
            else regInsertados += cont;
        }catch (SQLException e){
            regInsertados = "Error al insertar el registro. Error de integridad referencial";
        }
        return regInsertados;
    }

    public String actualizar(Sugerencias_App sugerencias_app) {
        String[] id = {sugerencias_app.getIdSugerenciasApp()};
        ContentValues cv = new ContentValues();
        cv.put(camposSugerencias_App[0], sugerencias_app.getIdSugerenciasApp());
        cv.put(camposSugerencias_App[1], sugerencias_app.getIdUsuario());
        cv.put(camposSugerencias_App[2], sugerencias_app.getTxtSugerenciasApp());
        try {
            long cont = db.update(TABLE_SUGERENCIAS_APP, cv, camposSugerencias_App[0] + "=?",
                    id);
            if(cont==-1 || cont==0)
                return "Registro con id = "+sugerencias_app.getIdSugerenciasApp()+" no existe";
            else return "Registro actualizado correctamente";
        }catch (SQLException e){
            return "Error de integridad referencial";
        }
    }

    public String eliminar(Sugerencias_App sugerencias_app) {
        String registrosAfectados = "Filas afectadas = ";
        int cont = 0;
        cont+= db.delete(TABLE_SUGERENCIAS_APP,
                camposSugerencias_App[0]+"='"+sugerencias_app.getIdSugerenciasApp()+"'", null);
        registrosAfectados+= cont;
        return registrosAfectados;
    }

    public Sugerencias_App consultarSugerenciasApp(String idSugerenciasApp) {
        String[] id = {idSugerenciasApp};
        Cursor cursor = db.query(TABLE_SUGERENCIAS_APP, camposSugerencias_App,
                camposSugerencias_App[0]+" =?",id, null,null,null);
        if(cursor.moveToFirst()){
            Sugerencias_App sugerencias_app = new Sugerencias_App(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2)
            );
            return sugerencias_app;
        }else return null;
    }
    /*- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

    public void llenarBD(){
        db.execSQL("delete from "+TABLE_SUGERENCIAS_APP);
        db.execSQL("delete from "+TABLE_COMENTARIOS);
        db.execSQL("delete from "+TABLE_SUGERENCIAS);
        db.execSQL("delete from "+TABLE_DENUNCIA);
        db.execSQL("delete from "+TABLE_EVALUACION);
        db.execSQL("delete from "+TABLE_DENUNCIA);
        db.execSQL("delete from "+TABLE_CLIENTE);
        db.execSQL("delete from "+TABLE_USUARIO);
        db.execSQL("delete from "+TABLE_LOCAL);
        db.execSQL("delete from "+TABLE_EMPRESA);
        db.execSQL("delete from "+TABLE_MUNICIPIO);
        db.execSQL("delete from "+TABLE_TIPO_EMPRESA);
        db.execSQL("delete from "+TABLE_RANGO_EDAD);
        db.execSQL("delete from "+TABLE_TIPO_SATISFACCION);
        db.execSQL("delete from "+TABLE_SEXO);
        db.execSQL("delete from "+TABLE_SECTOR);
        db.execSQL("delete from "+TABLE_DEPARTAMENTO);

        /*Ordenado de BD - DEPENDENCIA*/

        /* - - - PRIMARIAS - - - */
        //TABLA RANGO_EDAD
        insertar(new Rango_Edad("RE001", "Adolescente", 16,20));
        insertar(new Rango_Edad("RE002", "Adulto joven", 21,25));
        insertar(new Rango_Edad("RE003", "Adulto", 26,30));
        insertar(new Rango_Edad("RE004", "Mediana Edad", 31,35));

        //TABLA TIPO_SATISFACCION
        insertar(new Tipo_Satisfaccion("TS001", "Malo", 0,3));
        insertar(new Tipo_Satisfaccion("TS002", "Bueno", 4,6));
        insertar(new Tipo_Satisfaccion("TS003", "Muy bueno", 7,8));
        insertar(new Tipo_Satisfaccion("TS004", "Excelente", 9,10));

        //TABLA DEPARTAMENTO
        insertar(new Departamento("D01", "La Paz"));
        insertar(new Departamento("D02", "Santa Ana"));
        insertar(new Departamento("D03", "San Salvador"));
        insertar(new Departamento("D04", "San Miguel"));

        //TABLA TIPO_EMPRESA
        insertar(new Tipo_Empresa("TE01", "Empresa Privada"));
        insertar(new Tipo_Empresa("TE02", "Empresa Pública"));

        //TABLA SECTOR
        insertar(new Sector("SE01","Centro Comercial"));
        insertar(new Sector("SE02","Farmacias"));
        insertar(new Sector("SE03","Gasolinera"));
        insertar(new Sector("SE04","Supermercados"));
        insertar(new Sector("SE05","Banca"));

        //TABLA_SEXO
        insertar(new Sexo("S01", "Masculino", "M"));
        insertar(new Sexo("S02", "Femenino", "F"));

        //TABLA_TIPO_USUARIO
        insertar(new Tipo_Usuario("TP01","Administrador"));
        insertar(new Tipo_Usuario("TP02","Usuario normal"));



        /* - - - NO PRIMARIAS XD - - - */

        //TABLA MUNICIPIO
        insertar(new Municipio("M001", "D03", "Apopa"));
        insertar(new Municipio("M002", "D01", "Cuyultitan"));
        insertar(new Municipio("M003", "D04", "Ciudad Barios"));
        insertar(new Municipio("M004", "D02", "El Congo"));

        //TABLA EMPRESA
        insertar(new Empresa("E0001", "TE01", "Calleja, S.A. de C.V.", "0614-234567-123-1", "Venta de productos previamiente clasificados", "2345-0"));
        insertar(new Empresa("E0002", "TE01", "Farmacia Lupita, S.A. de C.V.", "0801-432145-104-0", "Venta y distribucion de medicamentos", "34212-1"));
        insertar(new Empresa("E0003", "TE01", "Grupo Roble, S.A. de C.V.", "0614-291270-102-1", "Administracion de centros comerciales y renta de imobiliarios", "7654-1"));
        insertar(new Empresa("E0004", "TE01", "Bandesal", "0342-234423-423-54", "Actividades bancarias y financieras", "3452-1"));

        //TABLA LOCAL
        insertar(new Local("L0001", "E0001", "SE04", "M001", "Super Selectos Apopa", "Supermercado, sucursal de Apopa, San Salvador"));
        insertar(new Local("L0002", "E0002", "SE02", "M002", "Farmacia Lupita 3", "Servicio de farmacia, sucursal de  Cuyultitan"));
        insertar(new Local("L0003", "E0003", "SE01", "M003", "Metrocentro Santa Ana", "Centro Comercial, sucursal de Santa Ana"));
        insertar(new Local("L0004", "E0004", "SE05", "M004", "Bandesal Ciudad Barrios", "Banco de Desarrollo Salvadoreño, sucursal de Ciudad Barrios, San Miguel"));

        //TABLA USUARIO
        insertar(new Usuario("U0000", "TP01","E0001","admin","admin","admin@admin.com"));
        insertar(new Usuario("U0001", "TP01", "E0001", "Antonio_98", "arcoiris2022", "JP17003@UES.EDU.SV"));
        insertar(new Usuario("U0002", "TP02", "E0004", "arturoMtz", "manzanas123", "arturomartinez@gmail.com"));
        insertar(new Usuario("U0003", "TP02", "E0002", "rivera78", "rivera78lol", "rivera78@gmail.com"));
        insertar(new Usuario("U0004", "TP02", "E0003", "Castillo22", "cas1234", "castillolopez@gmail.com"));

        //TABLA COMENTARIOS
        insertar(new Comentarios("C0001", "U0003", "L0001", "Siempre suena buena musica en los pasillos","24/04/2022"));
        insertar(new Comentarios("C0002", "U0002", "L0002", "Muy bien organizadao, es facil encontrar los productos","10/04/2022"));
        insertar(new Comentarios("C0003", "U0003", "L0003", "Las remoledaciones estan muy bien, pero espero terminen pronto","15/04/2022"));
        insertar(new Comentarios("C0004", "U0004", "L0004", "Muy buen servicio para los clientes","17/04/2021"));

        //TABLA SUGERENCIAS
        insertar(new Sugerencias("S0001", "U0004", "L0002", "Que creen servicio a domicilio", "24/04/2022"));
        insertar(new Sugerencias("S0002", "U0002", "L0001", "Ya no ponen Alcohol gel", "23/03/2022"));
        insertar(new Sugerencias("S0003", "U0003", "L0003", "Que pongan mas personal de seguridad", "15/03/2022"));
        insertar(new Sugerencias("S0004", "U0003", "L0002", "Que exista personal nocturno", "12/04/2022"));

        //TABLA DENUNCIAS
        insertar(new Denuncia("D0001", "U0002", "L0003","Me robaron frente a un Guardia","17/04/2021"));
        insertar(new Denuncia("D0002", "U0002", "L0001","Falta personal en las cajas","15/04/2022"));
        insertar(new Denuncia("D0003", "U0002", "L0002","Una empleada era muy pésima","24/04/2022"));
        insertar(new Denuncia("D0004", "U0004", "L0001","Muchas de las cajas están cerradas","10/04/2022"));


        //TABLA CLIENTE
        insertar(new Cliente("CL0001", "RE002","U0001","S01","Antonio Valladar", "76243870"));
        insertar(new Cliente("CL0002", "RE004","U0004","S02","Marina Castillo Lopez", "23451234"));
        insertar(new Cliente("CL0003", "RE001","U0002","S01","Arturo Martinez", "78534112"));
        insertar(new Cliente("CL0004", "RE003","U0003","S02","Margarita Rivera", "72345678"));

        //TABLA EVALUACION
        insertar(new Evaluacion("E0001", "L0002", "CL0001", "TS003", 7, "Justificación W"));
        insertar(new Evaluacion("E0002", "L0003", "CL0004", "TS002", 5, "Justificación X"));
        insertar(new Evaluacion("E0003", "L0001", "CL0003", "TS001", 3, "Justificación Y"));
        insertar(new Evaluacion("E0004", "L0004", "CL0002", "TS004", 9, "Justificación Z"));


        //TABLA SUGERENCIAS_APP
        insertar(new Sugerencias_App("SU0001", "U0001", "Mejorar la administracion de los comentarios"));
        insertar(new Sugerencias_App("SU0002", "U0002", "Podrían hacer el diseño mas llamativo"));
        insertar(new Sugerencias_App("SU0003", "U0003", "Incorporar mas sectores para poder evaluar"));
        insertar(new Sugerencias_App("SU0004", "U0004", "Sería interesante compartir fotos de los establecimientos"));


    }
}