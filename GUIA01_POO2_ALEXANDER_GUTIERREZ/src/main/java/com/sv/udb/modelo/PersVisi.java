/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author Alexander José
 */
public class PersVisi {
    int idPers;
    String nombPers, apelPers, duiPers, genePers;

    public PersVisi() {
    }

    public PersVisi(int idPers, String nombPers, String apelPers, String duiPers, String genePers) {
        this.idPers = idPers;
        this.nombPers = nombPers;
        this.apelPers = apelPers;
        this.duiPers = duiPers;
        this.genePers = genePers;
    }

    public int getIdPers() {
        return idPers;
    }

    public void setIdPers(int idPers) {
        this.idPers = idPers;
    }

    public String getNombPers() {
        return nombPers;
    }

    public void setNombPers(String nombPers) {
        this.nombPers = nombPers;
    }

    public String getApelPers() {
        return apelPers;
    }

    public void setApelPers(String apelPers) {
        this.apelPers = apelPers;
    }

    public String getDuiPers() {
        return duiPers;
    }

    public void setDuiPers(String duiPers) {
        this.duiPers = duiPers;
    }

    public String getGenePers() {
        return genePers;
    }

    public void setGenePers(String genePers) {
        this.genePers = genePers;
    }
    
    
}
