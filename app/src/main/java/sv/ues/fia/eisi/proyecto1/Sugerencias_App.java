package sv.ues.fia.eisi.proyecto1;

public class Sugerencias_App {

    private String idSugerenciasApp;
    private String idUsuario;
    private String txtSugerenciasApp;

    public Sugerencias_App() {
    }

    public Sugerencias_App(String idSugerenciasApp, String idUsuario, String txtSugerenciasApp) {
        this.idSugerenciasApp = idSugerenciasApp;
        this.idUsuario = idUsuario;
        this.txtSugerenciasApp = txtSugerenciasApp;
    }

    public String getIdSugerenciasApp() {
        return idSugerenciasApp;
    }

    public void setIdSugerenciasApp(String idSugerenciasApp) {
        this.idSugerenciasApp = idSugerenciasApp;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTxtSugerenciasApp() {
        return txtSugerenciasApp;
    }

    public void setTxtSugerenciasApp(String txtSugerenciasApp) {
        this.txtSugerenciasApp = txtSugerenciasApp;
    }
}