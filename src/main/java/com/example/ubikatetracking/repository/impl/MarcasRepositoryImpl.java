package com.example.ubikatetracking.repository.impl;

import com.example.ubikatetracking.model.Marca;
import com.example.ubikatetracking.model.Results;
import com.example.ubikatetracking.repository.MarcasRepository;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MarcasRepositoryImpl implements MarcasRepository {

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
    public Results getMarcasByFilters(String fechaInicio, String fechaFin, String nombre) {

        String query = "";
        if (StringUtils.isNullOrEmpty(nombre)) {
            query = "SELECT * FROM FUBI_TA_UBICATE_MARCAS WHERE DT_FECHA_REGISTRO >= ? AND DT_FECHA_REGISTRO <= ?";
        } else {
            query = "SELECT * FROM FUBI_TA_UBICATE_MARCAS WHERE DT_FECHA_REGISTRO >= ? AND DT_FECHA_REGISTRO <= ? AND VC_NOMBRE_EMPLEADO LIKE CONCAT('%', UPPER(?) ,'%')";
        }

        Results results = new Results();
        List<Marca> resultados = new ArrayList<>();
        int totalRegistros = 0;

        try (Connection connection = DriverManager.getConnection(dataSource, user, password);
            PreparedStatement statement = connection.prepareStatement(query)) {

            fechaInicio = fechaInicio.substring(0, 11) + "00:00:00" + fechaInicio.substring(11 + 1);
            fechaFin = fechaFin.substring(0, 11) + "23:59:59" + fechaFin.substring(11 + 1);

            statement.setString(1, fechaInicio);
            statement.setString(2, fechaFin);
            if (!StringUtils.isNullOrEmpty(nombre)) {
                statement.setString(3, nombre);
            }

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                Marca marca = new Marca();
                marca.setCodSecuencial(rs.getInt("IN_SECUENCIAL"));
                marca.setIdEmpleado(rs.getString("VC_IDENTIFICADOR_EMPLEADO"));
                marca.setNombreEmpleado(rs.getString("VC_NOMBRE_EMPLEADO"));
                marca.setCodigoCompania(rs.getString("CH_CODIGO_COMPANIA"));
                marca.setLatitud(rs.getString("VC_LATITUD"));
                marca.setLongitud(rs.getString("VC_LONGITUD"));
                //marca.setTipoOrigen(rs.getString("CH_TIPO_ORIGEN"));
                marca.setFechaRegistro(rs.getTimestamp("DT_FECHA_REGISTRO"));
                //marca.setIdEnrolador(rs.getString("VC_IDENTIFICADOR_ENROLADOR"));
                //marca.setDireccion(rs.getString("VC_DIRECCION"));
                marca.setSituacionRegistro(rs.getString("CH_SITUACION_REGISTRO"));
                marca.setCodUsuario(rs.getInt("IN_CODIGO_USUARIO"));

                resultados.add(marca);
                totalRegistros++;
            }

            results.setResultados(resultados);
            results.setTotalRegistros(totalRegistros);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
}
