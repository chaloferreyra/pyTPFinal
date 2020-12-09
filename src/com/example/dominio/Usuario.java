/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dominio;

import com.example.excepciones.CorreoInvalidoException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Gonzalo
 */
public class Usuario {
    private int usuario_id;
    private String nick_usuario;
    private String pass_usuario;
    private String n_usuario;
    private String a_usuario;
    private int dni_usuario;
    private String correo_usuario;
    private String img_usuario;
    private int idTipo;

    
    
    
    public Usuario(String nick_usuario, String pass_usuario, String n_usuario, String a_usuario, int dni_usuario, String correo_usuario, String img_usuario, int idTipo) throws CorreoInvalidoException{
        this.nick_usuario = nick_usuario;
        this.pass_usuario = pass_usuario;
        this.n_usuario = n_usuario;
        this.a_usuario = a_usuario;
        this.dni_usuario = dni_usuario;
        setCorreo_usuario(correo_usuario);
        this.img_usuario = img_usuario;
        this.idTipo = idTipo;
    }

    public Usuario(int usuario_id, String nick_usuario, String pass_usuario, String n_usuario, String a_usuario, int dni_usuario, String correo_usuario, String img_usuario, int idTipo) throws CorreoInvalidoException{
        this.usuario_id = usuario_id;
        this.nick_usuario = nick_usuario;
        this.pass_usuario = pass_usuario;
        this.n_usuario = n_usuario;
        this.a_usuario = a_usuario;
        this.dni_usuario = dni_usuario;
        this.setCorreo_usuario(correo_usuario);
        this.img_usuario = img_usuario;
        
        this.idTipo = idTipo;
    }

    public String getCorreo_usuario() {
        return correo_usuario;
    }

    public void setNick_usuario(String nick_usuario) {
        this.nick_usuario = nick_usuario;
    }
    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNick_usuario() {
        return nick_usuario;
    }

    public void setCorreo_usuario(String correo_usuario) throws CorreoInvalidoException{
        if(correo_usuario != null && formatoCorreoValido(correo_usuario))
            this.correo_usuario = correo_usuario;
        else
           throw new CorreoInvalidoException(nick_usuario);
    }

    public String getPass_usuario() {
        return pass_usuario;
    }

    public void setPass_usuario(String pass_usuario) {
        this.pass_usuario = pass_usuario;
    }

    public String getN_usuario() {
        return n_usuario;
    }

    public void setN_usuario(String n_usuario) {
        this.n_usuario = n_usuario;
    }

    public String getA_usuario() {
        return a_usuario;
    }

    public void setA_usuario(String a_usuario) {
        this.a_usuario = a_usuario;
    }

    public int getDni_usuario() {
        return dni_usuario;
    }

    public void setDni_usuario(int dni_usuario) {
        this.dni_usuario = dni_usuario;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
    
    public String getImg_usuario() {
        return img_usuario;
    }

    public void setImg_usuario(String img_usuario) {
        this.img_usuario = img_usuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario_id=" + usuario_id + ", nick_usuario=" + nick_usuario + ", pass_usuario=" + pass_usuario + ", n_usuario=" + n_usuario + ", a_usuario=" + a_usuario + ", dni_usuario=" + dni_usuario + ", idTipo=" + idTipo + '}';
    }
    
    private boolean formatoCorreoValido(String n_usuario) {
        Pattern pattern = Pattern.compile("(\\S+?)\\@(\\S+?)\\.com");
        Matcher matcher = pattern.matcher(n_usuario);
        return matcher.find();
    }
}
