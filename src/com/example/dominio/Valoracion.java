/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dominio;

/**
 *
 * @author Gonzalo
 */
public class Valoracion {
    private int valoracion_id;
    private int puntaje;
    private String opinion;
    private int appId;
    private int userId;

    public Valoracion(int valoracion_id, int puntaje, String opinion, int appId, int userId) {
        this.valoracion_id = valoracion_id;
        this.puntaje = puntaje;
        this.opinion = opinion;
        this.appId = appId;
        this.userId = userId;
    }

    public Valoracion(int puntaje, String opinion, int appId, int userId) {
        this.puntaje = puntaje;
        this.opinion = opinion;
        this.appId = appId;
        this.userId = userId;
    }
    
    

    public int getValoracion_id() {
        return valoracion_id;
    }

    public void setValoracion_id(int valoracion_id) {
        this.valoracion_id = valoracion_id;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
    
}
