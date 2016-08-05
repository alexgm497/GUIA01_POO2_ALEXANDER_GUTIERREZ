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
public class UniOrg {
    private int idUni;
    private String NombUni, DirUni, TelUni, FaxUni, EmaUni;

    public UniOrg() {
    }

    public UniOrg(int idUni, String NombUni, String DirUni, String TelUni, String FaxUni, String EmaUni) {
        this.idUni = idUni;
        this.NombUni = NombUni;
        this.DirUni = DirUni;
        this.TelUni = TelUni;
        this.FaxUni = FaxUni;
        this.EmaUni = EmaUni;
    }

    public int getIdUni() {
        return idUni;
    }

    public void setIdUni(int idUni) {
        this.idUni = idUni;
    }

    public String getNombUni() {
        return NombUni;
    }

    public void setNombUni(String NombUni) {
        this.NombUni = NombUni;
    }

    public String getDirUni() {
        return DirUni;
    }

    public void setDirUni(String DirUni) {
        this.DirUni = DirUni;
    }

    public String getTelUni() {
        return TelUni;
    }

    public void setTelUni(String TelUni) {
        this.TelUni = TelUni;
    }

    public String getFaxUni() {
        return FaxUni;
    }

    public void setFaxUni(String FaxUni) {
        this.FaxUni = FaxUni;
    }

    public String getEmaUni() {
        return EmaUni;
    }

    public void setEmaUni(String EmaUni) {
        this.EmaUni = EmaUni;
    }
    
}
