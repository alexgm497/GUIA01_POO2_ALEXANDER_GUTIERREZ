/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

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
 * @author user
 */
public class ProveedoresCtrl {
    public boolean guar(Proveedores obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "INSERT INTO Proveedores VALUES(null, ?, ?, ?)";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setString(1, obje.getNombProv());
            cmd.setString(2, obje.getDireProv());
            cmd.setString(3, obje.getTeleProv());
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
    public boolean actu(Proveedores obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "UPDATE Proveedores SET nomb_prov = ?, dire_prov = ?, tele_prov = ? WHERE codi_prov = ?";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setString(1, obje.getNombProv());
            cmd.setString(2, obje.getDireProv());
            cmd.setString(3, obje.getTeleProv());
            cmd.setInt(4, obje.getIdProv());
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
    public boolean elim(Proveedores obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "DELETE FROM Proveedores WHERE codi_prov = ?";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setInt(1, obje.getIdProv());
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
    public List<Proveedores> consTodo(){
        List<Proveedores> resp = new ArrayList<>();
        Connection cn = new Conexion().getConn();
        try{
            String consulta = "SELECT * FROM Proveedores ORDER BY codi_prov ASC";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                resp.add(new Proveedores(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
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
    public Proveedores cons(int codiEqui){
        Proveedores resp = null;
        Connection cn = new Conexion().getConn();
        try{
            String consulta = "SELECT * FROM PROVEEDORES WHERE codi_prov = ?";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            cmd.setInt(1, codiEqui);
            ResultSet rs = cmd.executeQuery();
            if(rs.next()){
                resp = new Proveedores(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
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
