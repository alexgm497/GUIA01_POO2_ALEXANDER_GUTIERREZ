/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Bodega;
import com.sv.udb.modelo.Piezas;
import com.sv.udb.modelo.Proveedores;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander José
 */
public class BodegaCtrl {
    public boolean guar(Bodega obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "INSERT INTO bodega VALUES(null, ?, ?, ?, STR_TO_DATE(?, '%d-%m-%Y'))";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setInt(1, obje.getIdPieza());
            cmd.setInt(2, obje.getIdProveedor());
            cmd.setInt(3, obje.getBodeCanti());
            cmd.setString(4, obje.getFechComp());
            cmd.executeUpdate();
            resp = true;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(cn!= null){
                try{
                    if(!cn.isClosed()){
                        cn.close();
                    }
                }catch(SQLException ex){
                     ex.printStackTrace();
                }
            }
        }
        return resp;
    }
    public boolean actu(Bodega obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "UPDATE Bodega SET codi_piez = ?, codi_prov = ?, cantidad = ? WHERE codi_bode = ?";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setInt(1, obje.getIdPieza());
            cmd.setInt(2, obje.getIdProveedor());
            cmd.setInt(3, obje.getBodeCanti());
            cmd.setInt(4, obje.getIdBodega());
            cmd.executeUpdate();
            resp = true;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(cn!= null){
                try{
                    if(!cn.isClosed()){
                        cn.close();
                    }
                }catch(SQLException ex){
                     ex.printStackTrace();
                }
            }
        }
        return resp;
    }
    public boolean elim(Bodega obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "DELETE FROM Bodega WHERE codi_bode = ?";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setInt(1, obje.getIdBodega());
            cmd.executeUpdate();
            resp = true;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(cn!= null){
                try{
                    if(!cn.isClosed()){
                        cn.close();
                    }
                }catch(SQLException ex){
                     ex.printStackTrace();
                }
            }
        }
        return resp;
    }
    public List<Bodega> consTodo(){
        List<Bodega> resp = new ArrayList<>();
        Connection cn = new Conexion().getConn();
        try{
            String consulta = "SELECT b.codi_bode, pi.codi_piez, pi.nomb_piez, p.codi_prov, p.nomb_prov, b.cantidad, DATE_FORMAT(b.fecha_comp,'%d-%m-%Y') AS FCompra FROM bodega b, proveedores p, piezas pi WHERE b.codi_piez = pi.codi_piez AND b.codi_prov = p.codi_prov ORDER BY b.codi_bode ASC";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                resp.add(new Bodega(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7)));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(cn!= null){
                try{
                    if(!cn.isClosed()){
                        cn.close();
                    }
                }catch(SQLException ex){
                     ex.printStackTrace();
                }
            }
        }
        return resp;
    }
    public Bodega cons(int codiBode){
        Bodega resp = null;
        Connection cn = new Conexion().getConn();
        try{
            String consulta = "SELECT codi_bode, codi_piez, codi_prov, cantidad FROM BODEGA WHERE codi_bode = ?";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            cmd.setInt(1, codiBode);
            ResultSet rs = cmd.executeQuery();
            if(rs.next()){
                resp = new Bodega(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(cn!= null){
                try{
                    if(!cn.isClosed()){
                        cn.close();
                    }
                }catch(SQLException ex){
                     ex.printStackTrace();
                }
            }
        }
        return resp;
    }
}
