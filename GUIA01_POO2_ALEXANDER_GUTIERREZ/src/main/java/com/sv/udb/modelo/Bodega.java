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
public class Bodega {
    private int idBodega, bodeCanti, idPieza, idProveedor;
    private String fechComp, nombPiez, nombProve;

    public Bodega() {
    }

    public Bodega(int idBodega, int idPieza, int idProveedor, int bodeCanti) {
        this.idBodega = idBodega;
        this.bodeCanti = bodeCanti;
        this.idPieza = idPieza;
        this.idProveedor = idProveedor;
    }

    public Bodega(int idBodega, int idPieza, String nombPiez, int idProveedor, String nombProv, int bodeCanti, String fechComp) {
        this.idBodega = idBodega;
        this.bodeCanti = bodeCanti;
        this.idPieza = idPieza;
        this.idProveedor = idProveedor;
        this.fechComp = fechComp;
        this.nombProve = nombProv;
        this.nombPiez = nombPiez;
    }

    public int getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(int idBodega) {
        this.idBodega = idBodega;
    }

    public String getNombPiez() {
        return nombPiez;
    }

    public void setNombPiez(String nombPiez) {
        this.nombPiez = nombPiez;
    }

    public String getNombProve() {
        return nombProve;
    }

    public void setNombProve(String nombProve) {
        this.nombProve = nombProve;
    }

    public int getBodeCanti() {
        return bodeCanti;
    }

    public void setBodeCanti(int bodeCanti) {
        this.bodeCanti = bodeCanti;
    }

    public int getIdPieza() {
        return idPieza;
    }

    public void setIdPieza(int idPieza) {
        this.idPieza = idPieza;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getFechComp() {
        return fechComp;
    }

    public void setFechComp(String fechComp) {
        this.fechComp = fechComp;
    }
    
}
