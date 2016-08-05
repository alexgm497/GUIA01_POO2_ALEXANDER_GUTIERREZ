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
    private String nombUni, dirUni, telUni, faxUni, emaUni;

    public UniOrg() {
    }

    public UniOrg(int idUni, String nombUni, String dirUni, String telUni, String faxUni, String emaUni) {
        this.idUni = idUni;
        this.nombUni = nombUni;
        this.dirUni = dirUni;
        this.telUni = telUni;
        this.faxUni = faxUni;
        this.emaUni = emaUni;
    }

    public int getIdUni() {
        return idUni;
    }

    public void setIdUni(int idUni) {
        this.idUni = idUni;
    }

    public String getNombUni() {
        return nombUni;
    }

    public void setNombUni(String nombUni) {
        this.nombUni = nombUni;
    }

    public String getDirUni() {
        return dirUni;
    }

    public void setDirUni(String dirUni) {
        this.dirUni = dirUni;
    }

    public String getTelUni() {
        return telUni;
    }

    public void setTelUni(String telUni) {
        this.telUni = telUni;
    }

    public String getFaxUni() {
        return faxUni;
    }

    public void setFaxUni(String faxUni) {
        this.faxUni = faxUni;
    }

    public String getEmaUni() {
        return emaUni;
    }

    public void setEmaUni(String emaUni) {
        this.emaUni = emaUni;
    }
    
}
