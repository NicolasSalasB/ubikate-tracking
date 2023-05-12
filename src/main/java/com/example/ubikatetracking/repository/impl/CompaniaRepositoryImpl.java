package com.example.ubikatetracking.repository.impl;

import com.example.ubikatetracking.model.Compania;
import com.example.ubikatetracking.repository.CompaniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CompaniaRepositoryImpl implements CompaniaRepository {

    @Autowired
    private Environment environment;
    private String dataSource;
    private String user;
    private String password;

    @PostConstruct
    public void init() {
        dataSource = environment.getProperty("spring.datasource.url");
        user = environment.getProperty("spring.datasource.username");
        password = environment.getProperty("spring.datasource.password");
    }

    @Override
    public String save(Compania compania) {

        String query = "INSERT INTO FUBI_TA_COMPANIA (CH_CODIGO_COMPANIA, VC_NOMBRE_COMPANIA, VC_NOMBRE_CORTO_COMPANIA, CH_SITUACION_REGISTRO, DT_FECHA_REGISTRO, VC_DOMICILIO_EMPRESA) VALUES (?, ?, ?, ?, ?, ?)";
        String msg = "";

        Date fechaHoraActual = new Date();
        SimpleDateFormat formatoFechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaHora = formatoFechaHora.format(fechaHoraActual);

        try (Connection con = DriverManager.getConnection(dataSource, user, password);
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setLong(1, compania.getCodigoCompania());
            stmt.setString(2, compania.getNombreCompania());
            stmt.setString(3, compania.getNombreCortoCompania());
            stmt.setString(4, compania.getSituacionRegistro());
            stmt.setString(5, fechaHora);
            stmt.setString(6, compania.getDomicilioEmpresa());

            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                msg = "Registro creado correctamente.";
            } else {
                msg = "No se pudo crear el registro.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return msg;
    }

    @Override
    public String delete(String id) {

        String query = "UPDATE FUBI_TA_COMPANIA SET CH_SITUACION_REGISTRO = ? WHERE CH_CODIGO_COMPANIA = ?";
        String msg = "";

        try (Connection conn = DriverManager.getConnection(dataSource, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, "I");
            stmt.setString(2, id);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                msg = "Registro "+ id +" eliminado correctamente.";
            } else {
                msg = "No se encontró el id " + id +" para eliminado.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return msg;
    }
}
