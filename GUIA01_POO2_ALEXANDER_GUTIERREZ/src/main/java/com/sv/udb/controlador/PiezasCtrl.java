/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Piezas;
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
public class PiezasCtrl {
    public boolean guar(Piezas obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "INSERT INTO Piezas VALUES(null, ?, ?, ?)";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setString(1, obje.getNombPiez());
            cmd.setString(2, obje.getTipoPiez());
            cmd.setInt(3, obje.getCantPiez());
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
    public boolean actu(Piezas obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "UPDATE Piezas SET nomb_piez = ?, tipo_piez = ?, cant_piez = ? WHERE codi_piez = ?";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setString(1, obje.getNombPiez());
            cmd.setString(2, obje.getTipoPiez());
            cmd.setInt(3, obje.getCantPiez());
            cmd.setInt(4, obje.getIdPiez());
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
    public boolean elim(Piezas obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "DELETE FROM Piezas WHERE codi_piez = ?";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setInt(1, obje.getIdPiez());
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
    public List<Piezas> consTodo(){
        List<Piezas> resp = new ArrayList<>();
        Connection cn = new Conexion().getConn();
        try{
            String consulta = "SELECT * FROM Piezas ORDER BY codi_piez ASC";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                resp.add(new Piezas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
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
    public Piezas cons(int codiEqui){
        Piezas resp = null;
        Connection cn = new Conexion().getConn();
        try{
            String consulta = "SELECT * FROM PIEZAS WHERE codi_piez = ?";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            cmd.setInt(1, codiEqui);
            ResultSet rs = cmd.executeQuery();
            if(rs.next()){
                resp = new Piezas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
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
