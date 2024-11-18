package modelo;

public class Session {
    private static String usuarioActual;
    private static int IdUsuario;

    public static String getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(String usuario) {
        usuarioActual = usuario;
    }
    public static void setIdUsuario(int usuario) {

        IdUsuario=usuario;
    }
    public static int getUsuarioId() {
        return IdUsuario;
    }
}