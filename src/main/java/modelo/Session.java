package modelo;

public class Session {
    private static Usuario usuarioActual;
    private static int IdUsuario;

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }
    
    public static void setUsuarioLogueado(Usuario usuarioLogueado) {
        Session.usuarioActual = usuarioLogueado;
    }

    /*public static void setUsuarioActual(Usuario usuario) {
        usuarioActual = usuario;
    }*/
    public static void setIdUsuario(int usuario) {

        IdUsuario=usuario;
    }
    public static int getUsuarioId() {
        return IdUsuario;
    }
    
}