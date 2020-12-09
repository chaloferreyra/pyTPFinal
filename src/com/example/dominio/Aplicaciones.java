/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dominio;
import java.sql.Blob;
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
    private String imgApp;
    private Blob img;
      

    public Aplicaciones(String nombreApp, String detalleApp, float precioApp, Date fechaAltaApp, int idCategoria, int idUsuario, String imgApp) {
        this.nombreApp = nombreApp;
        this.detalleApp = detalleApp;
        this.precioApp = precioApp;
        this.fechaAltaApp = fechaAltaApp;
        this.idCategoria = idCategoria;
        this.idUsuario = idUsuario;
        this.imgApp = imgApp;
    }

    public Aplicaciones(int app_id, String nombreApp, String detalleApp, float precioApp, Date fechaAltaApp, int idCategoria, int idUsuario) {
        this.app_id = app_id;
        this.nombreApp = nombreApp;
        this.detalleApp = detalleApp;
        this.precioApp = precioApp;
        this.fechaAltaApp = fechaAltaApp;
        this.idCategoria = idCategoria;
        this.idUsuario = idUsuario;
    }

    public Aplicaciones(int app_id, String nombreApp, String detalleApp, float precioApp, Date fechaAltaApp, int idCategoria, int idUsuario, Blob img) {
        this.app_id = app_id;
        this.nombreApp = nombreApp;
        this.detalleApp = detalleApp;
        this.precioApp = precioApp;
        this.fechaAltaApp = fechaAltaApp;
        this.idCategoria = idCategoria;
        this.idUsuario = idUsuario;
        this.img = img;
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

    public Blob getImg() {
        return img;
    }

    public void setImg(Blob img) {
        this.img = img;
    }

    public String getImgApp() {
        return imgApp;
    }

    public void setImgApp(String imgApp) {
        this.imgApp = imgApp;
    }

    
        
    @Override
    public String toString() {
        return "Aplicaciones{" + "app_id=" + app_id + ", nombreApp=" + nombreApp + ", detalleApp=" + detalleApp + ", precioApp=" + precioApp + ", fechaAltaApp=" + fechaAltaApp + ", idUsuario=" + idUsuario + ", idCategoria=" + idCategoria + '}';
    }
    
    
}
