package com.exemplo.dao;

import com.exemplo.dto.DtoGenerico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DtoDao {

    private final Connection connection;

    public DtoDao(Connection connection) {
        this.connection = connection;
    }

    public List<DtoGenerico> especieAnimais() throws SQLException {
        List<DtoGenerico> resultados = new ArrayList<>();
        String sql = "SELECT especie, COUNT(*) AS quantidade FROM Animal GROUP BY especie ORDER BY quantidade DESC";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                resultados.add(
                        DtoGenerico.builder()
                        .quantidade(rs.getInt("quantidade"))
                        .tipo(rs.getString("especie"))
                        .build()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultados;
    }

    public List<DtoGenerico> quantidadeRaca(String especie) throws SQLException {
        List<DtoGenerico> resultados = new ArrayList<>();
        String sql = "SELECT raca, COUNT(*) AS quantidade FROM Animal WHERE especie = ? GROUP BY raca ORDER BY quantidade DESC";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, especie);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    resultados.add(
                            DtoGenerico.builder()
                                    .quantidade(rs.getInt("quantidade"))
                                    .tipo(rs.getString("raca"))
                                    .build()
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultados;
    }


    public List<DtoGenerico> tiposUsuarios() throws SQLException {
        List<DtoGenerico> resultados = new ArrayList<>();
        String sql = "SELECT 'Administrador' AS tipo, COUNT(*) AS quantidade FROM Pessoa WHERE adm = TRUE " +
                "UNION ALL " +
                "SELECT 'Tutor', COUNT(*) FROM Pessoa WHERE tutor = TRUE " +
                "UNION ALL " +
                "SELECT 'Adotante', COUNT(*) FROM Pessoa WHERE adotante = TRUE " +
                "UNION ALL " +
                "SELECT 'Funcionário', COUNT(*) FROM Pessoa WHERE funcionario = TRUE";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                resultados.add(
                        DtoGenerico.builder()
                                .tipo(rs.getString("tipo"))
                                .quantidade(rs.getInt("quantidade"))
                                .build()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultados;
    }


}
