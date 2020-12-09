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
public class Categoria {
    private int categoria_id;
    private String n_categoria;
    private String descripcion;

    public Categoria(int categoria_id, String n_categoria, String descripcion) {
        this.categoria_id = categoria_id;
        this.n_categoria = n_categoria;
        this.descripcion = descripcion;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getN_categoria() {
        return n_categoria;
    }

    public void setN_categoria(String n_categoria) {
        this.n_categoria = n_categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Categoria{" + "categoria_id=" + categoria_id + ", n_categoria=" + n_categoria + ", descripcion=" + descripcion + '}';
    }
    
    
}
