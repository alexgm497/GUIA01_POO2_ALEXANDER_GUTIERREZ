/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author user
 */
public class Piezas {
    private int idPiez, cantPiez;
    private String nombPiez, tipoPiez;

    public Piezas() {
    }

    public Piezas(int idPiez, String nombPiez, String tipoPiez, int cantPiez) {
        this.idPiez = idPiez;
        this.cantPiez = cantPiez;
        this.nombPiez = nombPiez;
        this.tipoPiez = tipoPiez;
    }

    public int getIdPiez() {
        return idPiez;
    }

    public void setIdPiez(int idPiez) {
        this.idPiez = idPiez;
    }

    public int getCantPiez() {
        return cantPiez;
    }

    public void setCantPiez(int cantPiez) {
        this.cantPiez = cantPiez;
    }

    public String getNombPiez() {
        return nombPiez;
    }

    public void setNombPiez(String nombPiez) {
        this.nombPiez = nombPiez;
    }

    public String getTipoPiez() {
        return tipoPiez;
    }

    public void setTipoPiez(String tipoPiez) {
        this.tipoPiez = tipoPiez;
    }

    @Override
    public String toString() {
        return this.nombPiez;
    }   
}
