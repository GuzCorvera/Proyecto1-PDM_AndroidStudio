package sv.ues.fia.eisi.proyecto1;

public class BaseDatos {
    public static final String TABLE_CLIENTE = "CLIENTE";
    public static final String TABLE_RANGO_EDAD = "RANGO_EDAD";
    public static final String TABLE_TIPO_SATISFACCION = "TIPO_SATISFACCION";
    public static final String TABLE_COMENTARIOS = "COMENTARIOS";
    public static final String TABLE_DENUNCIA = "DENUNCIAS";
    public static final String TABLE_DEPARTAMENTO = "DEPARTAMENTO";
    public static final String TABLE_EMPRESA = "EMPRESA";
    public static final String TABLE_EVALUACION = "EVALUACION";
    public static final String TABLE_LOCAL = "LOCAL";
    public static final String TABLE_MUNICIPIO = "MUNICIPIO";
    public static final String TABLE_SECTOR = "SECTOR";
    public static final String TABLE_SEXO = "SEXO";
    public static final String TABLE_SUGERENCIAS = "SUGERENCIAS";
    public static final String TABLE_SUGERENCIAS_APP = "SUGERENCIAS_APP";
    public static final String TABLE_TIPO_EMPRESA = "TIPO_EMPRESA";
    public static final String TABLE_TIPO_USUARIO = "TIPO_USUARIO";
    public static final String TABLE_USUARIO = "USUARIO";
    public static final String TABLE_USUARIO_TEMP = "USUARIO_TEMP";

    public static final String[] camposCliente = new String[]{"idCliente","idRangoEdad","idUsuario","idSexo","nomcliente","telefonoCliente"};
    public static final String[] camposComentarios = new String[]{"idComentarios","idUsuario","idLocal","textComentario","fechaComentario"};
    public static final String[] camposDenuncia = new String[]{"idDenuncias","idUsuario","idLocal","textDenuncia","fechaDenuncia"};
    public static final String[] camposDepartamento = new String[]{"idDepartamento","nomDepartamento"};
    public static final String[] camposEmpresa = new String[]{"idEmpresa","idTipoEmpresa","nomLegalEmpresa","nitEmpresa","giroEmpresa","nrcEmpresa"};
    public static final String[] camposEvaluacion = new String[]{"idEvaluacion","idLocal","idCliente","idTipoSatisfaccion","notaEvaCliente", "justificacionEvaCliente"};
    public static final String[] camposLocal = new String[]{"idLocal","idEmpresa","idSector","idMunicipio","nombreLocal","descripLocal"};
    public static final String[] camposMunicipio = new String[]{"idMunicipio","idDepartamento","nomMunicipio"};
    public static final String[] camposRangoEdad = new String[]{"idRangoEdad","nomRangoEdad","edadMenor","edadMayor"};
    public static final String[] camposSector = new String[]{"idSector","tipoSector"};
    public static final String[] camposSexo = new String[]{"idSexo","nomSexo","abreviaturaSexo"};
    public static final String[] camposSugerencias = new String[]{"idSugerencia","idUsuario","idLocal","textSugerencia","fechaSugerencia"};
    public static final String[] camposSugerencias_App = new String[]{"idSugerenciasApp","idUsuario","txtSugerenciasApp"};
    public static final String[] camposTipoEmpresa = new String[]{"idTipoEmpresa","nomTipoEmpresa"};
    public static final String[] camposTipoSatisfaccion = new String[]{"idTipoSatisfaccion","nomTipoSatisfaccion","notaMenor","notaMayor"};
    public static final String[] camposTipoUsuario = new String[]{"idTipoUsuario","desTipoUsuario"};
    public static final String[] camposUsuario = new String[]{"idUsuario","idTipoUsuario","idEmpresa","nomUsuario","contraUsuario","correoUsuario"};
    public static final String[] camposUsuarioTemp = new String[]{"idUsuarioTemp","idTipoUsuario"};
}
