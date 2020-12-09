/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dominio;

import java.sql.Blob;

/**
 *
 * @author Gonzalo
 */
public class Imagenes {
    private int imgApps_id;
    private int idApp;
    private Blob img;

    public Imagenes(int imgApps_id, int idApp, Blob img) {
        this.imgApps_id = imgApps_id;
        this.idApp = idApp;
        this.img = img;
    }

    public Imagenes(int idApp, Blob img) {
        this.idApp = idApp;
        this.img = img;
    }

    public int getImgApps_id() {
        return imgApps_id;
    }

    public void setImgApps_id(int imgApps_id) {
        this.imgApps_id = imgApps_id;
    }

    public int getIdApp() {
        return idApp;
    }

    public void setIdApp(int idApp) {
        this.idApp = idApp;
    }

    public Blob getImg() {
        return img;
    }

    public void setImg(Blob img) {
        this.img = img;
    }

    
    
    
    
}
