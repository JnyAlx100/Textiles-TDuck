/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Serratia Marcesens
 */
public class UsuarioSistema {
    private int idUsuarioSistema;
    private String idGenerado;
    private String nombre;
    private String telefono;
    private String correo;
    private int isAdmin;
    private String password;

    public UsuarioSistema(int idUsuarioSistema, String idGenerado, String nombre, String telefono, String correo, int isAdmin, String password) {
        this.idUsuarioSistema = idUsuarioSistema;
        this.idGenerado = idGenerado;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.isAdmin = isAdmin;
        this.password = password;
    }

    public UsuarioSistema() {
    }

    public int getIdUsuarioSistema() {
        return idUsuarioSistema;
    }

    public void setIdUsuarioSistema(int idUsuarioSistema) {
        this.idUsuarioSistema = idUsuarioSistema;
    }

    public String getIdGenerado() {
        return idGenerado;
    }

    public void setIdGenerado(String idGenerado) {
        this.idGenerado = idGenerado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
