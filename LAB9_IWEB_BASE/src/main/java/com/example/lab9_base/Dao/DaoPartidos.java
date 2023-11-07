package com.example.lab9_base.Dao;

import com.example.lab9_base.Bean.Arbitro;
import com.example.lab9_base.Bean.Partido;
import com.example.lab9_base.Bean.SeleccionNacional;

import java.sql.*;
import java.util.ArrayList;

public class DaoPartidos extends DaoBase {
    public ArrayList<Partido> listaDePartidos() {

        ArrayList<Partido> partidos = new ArrayList<>();
        String sql = "select * from partidos";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()){
                Partido partido = new Partido();
                partido.setIdPartido(rs.getInt(1));
                partido.setSeleccionLocal((SeleccionNacional) rs.getObject(2));
                partido.setSeleccionVisitante((SeleccionNacional) rs.getObject(3));
                partido.setArbitro((Arbitro) rs.getObject(4));
                partido.setFecha(rs.getString(5));
                partido.setNumeroJornada(rs.getInt(6));
                partidos.add(partido);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return partidos;
    }

    public void crearPartido(Partido partido) {

        String sql = "INSERT INTO partido (numeroJornada, fecha, seleccionLocal, seleccionVisitante, arbitro) VALUES (?,?,?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,numeroJornada);
            pstmt.setDate(2,fecha);
            pstmt.setInt(3,seleccionLocal);
            pstmt.setInt(4,seleccionVisitante);
            pstmt.setInt(5,arbitro);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
