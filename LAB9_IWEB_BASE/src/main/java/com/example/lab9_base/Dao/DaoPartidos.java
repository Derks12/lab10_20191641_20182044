package com.example.lab9_base.Dao;

import com.example.lab9_base.Bean.Arbitro;
import com.example.lab9_base.Bean.Partido;
import com.example.lab9_base.Bean.Seleccion;
import com.example.lab9_base.Bean.SeleccionNacional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoPartidos extends DaoBase {
    public ArrayList<Partido> listaDePartidos() {

        ArrayList<Partido> partidos = new ArrayList<>();
        String sql = "select * from partido";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()){
                Partido partido = new Partido();
                partido.setIdPartido(rs.getInt(1));
                partido.setSeleccionLocal(rs.getInt(2));
                partido.setSeleccionVisitante(rs.getInt(3));
                partido.setArbitro(rs.getInt(4));
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

        /*
        Inserte su código aquí
        */
    }
}
