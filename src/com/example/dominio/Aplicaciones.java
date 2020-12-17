/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dominio;
import java.util.Date;

/**
 *
 * @author Gonzalo
 */
public class Aplicaciones {
    private int app_id;
    private String nombreApp;
    private String detalleApp;
    private float precioApp;
    private Date fechaAltaApp;
    private int idCategoria;
    private int idUsuario;
    private String imagen;

    public Aplicaciones(String nombreApp, String detalleApp, float precioApp, Date fechaAltaApp, int idCategoria, int idUsuario, String imagen) {
        this.nombreApp = nombreApp;
        this.detalleApp = detalleApp;
        this.precioApp = precioApp;
        this.fechaAltaApp = fechaAltaApp;
        this.idCategoria = idCategoria;
        this.idUsuario = idUsuario;
        this.imagen = imagen;
        
    }

    public Aplicaciones(int app_id, String nombreApp, String detalleApp, float precioApp, Date fechaAltaApp, int idCategoria, int idUsuario, String imagen) {
        this.app_id = app_id;
        this.nombreApp = nombreApp;
        this.detalleApp = detalleApp;
        this.precioApp = precioApp;
        this.fechaAltaApp = fechaAltaApp;
        this.idCategoria = idCategoria;
        this.idUsuario = idUsuario;
        this.imagen = imagen;
    }
    
    
    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public String getNombreApp() {
        return nombreApp;
    }

    public void setNombreApp(String nombreApp) {
        this.nombreApp = nombreApp;
    }

    public String getDetalleApp() {
        return detalleApp;
    }

    public void setDetalleApp(String detalleApp) {
        this.detalleApp = detalleApp;
    }

    public float getPrecioApp() {
        return precioApp;
    }

    public void setPrecioApp(float precioApp) {
        this.precioApp = precioApp;
    }

    public Date getFechaAltaApp() {
        return fechaAltaApp;
    }

    public void setFechaAltaApp(Date fechaAltaApp) {
        this.fechaAltaApp = fechaAltaApp;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

        
    @Override
    public String toString() {
        return "Aplicaciones{" + "app_id=" + app_id + ", nombreApp=" + nombreApp + ", detalleApp=" + detalleApp + ", precioApp=" + precioApp + ", fechaAltaApp=" + fechaAltaApp + ", idUsuario=" + idUsuario + ", idCategoria=" + idCategoria + '}';
    }
    
    
}
