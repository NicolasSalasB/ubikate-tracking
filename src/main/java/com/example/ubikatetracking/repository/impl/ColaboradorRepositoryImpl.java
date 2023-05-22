package com.example.ubikatetracking.repository.impl;

import com.example.ubikatetracking.model.Colaborador;
import com.example.ubikatetracking.model.Results;
import com.example.ubikatetracking.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class ColaboradorRepositoryImpl implements ColaboradorRepository {

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
    public String save(Colaborador colaborador) {
        String query = "INSERT INTO FUBI_TA_USUARIO (" +
                "IN_CODIGO_USUARIO, VC_USUARIO, VC_CLAVE, VC_NOMBRES, " +
                "CH_SITUACION_REGISTRO, DT_FECHA_CREACION, VC_APELLIDO_PATERNO, VC_APELLIDO_MATERNO, VC_CORREO, " +
                "VC_NUMERO_DOCUMENTO_IDENTIDAD, VC_TIPO_DOCUMENTO, VC_NUMERO_TELEFONO, CH_CODIGO_COMPANIA, VC_FACE_ID," +
                "VC_RUTA_IMAGEN_PERFIL, VC_IP, VC_UBICACION_LATITUD, VC_UBICACION_LONGITUD, CH_INDICADOR_ORIGEN_ENROLADO," +
                "DT_FECHA_HORA_ENROLADO, VC_GENERATERANDOM, CH_INDICADOR_UBICACION) " +
                "VALUES (?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?,?,?,?,?)";

        String msg = "";

        Date fechaHoraActual = new Date();
        SimpleDateFormat formatoFechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaHora = formatoFechaHora.format(fechaHoraActual);

        try (Connection con = DriverManager.getConnection(dataSource, user, password);
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setLong(1, colaborador.getCodigoUsuario());
            stmt.setString(2, colaborador.getUsuario());
            stmt.setString(3, colaborador.getClave());
            stmt.setString(4, colaborador.getNombres());
            stmt.setString(5, colaborador.getSituacionRegistro());
            stmt.setString(6, fechaHora);
            stmt.setString(7, colaborador.getApellidoPaterno());
            stmt.setString(8, colaborador.getApellidoMaterno());
            stmt.setString(9, colaborador.getCorreo());
            stmt.setString(10, colaborador.getNumeroDocumentoIdentidad());
            stmt.setString(11, colaborador.getTipoDocumento());
            stmt.setString(12, colaborador.getNumeroTelefono());
            stmt.setInt(13, colaborador.getCodigoCompania());
            stmt.setString(14, colaborador.getFaceId());
            stmt.setString(15, colaborador.getRutaImagenPerfil());
            stmt.setString(16, colaborador.getIp());
            stmt.setString(17, colaborador.getUbicacionLatitud());
            stmt.setString(18, colaborador.getUbicacionLongitud());
            stmt.setInt(19, colaborador.getIndicadoresOrigEnrolado());
            stmt.setString(20, fechaHora);
            stmt.setString(21, colaborador.getGenerateRandom());
            stmt.setInt(22, colaborador.getIndicadorUbicacion());

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
    public String update(Colaborador colaborador) {
        String query = "UPDATE FUBI_TA_USUARIO SET " +
                "VC_USUARIO=?, VC_CLAVE=?, VC_NOMBRES=?, " +
                "CH_SITUACION_REGISTRO=?, DT_FECHA_CREACION=?, VC_APELLIDO_PATERNO=?, VC_APELLIDO_MATERNO=?, VC_CORREO=?, " +
                "VC_NUMERO_DOCUMENTO_IDENTIDAD=?, VC_TIPO_DOCUMENTO=?, VC_NUMERO_TELEFONO=?, CH_CODIGO_COMPANIA=?, VC_FACE_ID=?," +
                "VC_RUTA_IMAGEN_PERFIL=?, VC_IP=?, VC_UBICACION_LATITUD=?, VC_UBICACION_LONGITUD=?, CH_INDICADOR_ORIGEN_ENROLADO=?," +
                "DT_FECHA_HORA_ENROLADO=?, VC_GENERATERANDOM=?, CH_INDICADOR_UBICACION=?" +" WHERE IN_CODIGO_USUARIO = ?";

        String msg = "";

        Date fechaHoraActual = new Date();
        SimpleDateFormat formatoFechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaHora = formatoFechaHora.format(fechaHoraActual);

        try (Connection con = DriverManager.getConnection(dataSource, user, password);
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, colaborador.getUsuario());
            stmt.setString(2, colaborador.getClave());
            stmt.setString(3, colaborador.getNombres());
            stmt.setString(4, colaborador.getSituacionRegistro());
            stmt.setString(5, fechaHora);
            stmt.setString(6, colaborador.getApellidoPaterno());
            stmt.setString(7, colaborador.getApellidoMaterno());
            stmt.setString(8, colaborador.getCorreo());
            stmt.setString(9, colaborador.getNumeroDocumentoIdentidad());
            stmt.setString(10, colaborador.getTipoDocumento());
            stmt.setString(11, colaborador.getNumeroTelefono());
            stmt.setInt(12, colaborador.getCodigoCompania());
            stmt.setString(13, colaborador.getFaceId());
            stmt.setString(14, colaborador.getRutaImagenPerfil());
            stmt.setString(15, colaborador.getIp());
            stmt.setString(16, colaborador.getUbicacionLatitud());
            stmt.setString(17, colaborador.getUbicacionLongitud());
            stmt.setInt(18, colaborador.getIndicadoresOrigEnrolado());
            stmt.setString(19, fechaHora);
            stmt.setString(20, colaborador.getGenerateRandom());
            stmt.setInt(21, colaborador.getIndicadorUbicacion());
            stmt.setLong(22, colaborador.getCodigoUsuario());

            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                msg = "Registro actualizado correctamente.";
            } else {
                msg = "No se pudo actualizar el registro.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return msg;
    }

    @Override
    public Colaborador getById(String id) {
        String query = "SELECT * FROM FUBI_TA_USUARIO WHERE IN_CODIGO_USUARIO = ?";
        Colaborador colaborador = null;

        try (Connection con = DriverManager.getConnection(dataSource, user, password);
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Obtener los datos del resultado y crear un objeto Compania
                colaborador = new Colaborador();
                colaborador.setCodigoUsuario(rs.getLong("IN_CODIGO_USUARIO"));
                colaborador.setUsuario(rs.getString("VC_USUARIO"));
                colaborador.setClave(rs.getString("VC_CLAVE"));
                colaborador.setNombres(rs.getString("VC_NOMBRES"));
                colaborador.setSituacionRegistro(rs.getString("CH_SITUACION_REGISTRO"));
                colaborador.setFechaCreacion(rs.getDate("DT_FECHA_CREACION"));
                colaborador.setApellidoPaterno(rs.getString("VC_APELLIDO_PATERNO"));
                colaborador.setApellidoMaterno(rs.getString("VC_APELLIDO_MATERNO"));
                colaborador.setCorreo(rs.getString("VC_CORREO"));
                colaborador.setTipoDocumento(rs.getString("VC_TIPO_DOCUMENTO"));
                colaborador.setNumeroDocumentoIdentidad(rs.getString("VC_NUMERO_DOCUMENTO_IDENTIDAD"));
                colaborador.setNumeroTelefono(rs.getString("VC_NUMERO_TELEFONO"));
                colaborador.setCodigoCompania(rs.getInt("CH_CODIGO_COMPANIA"));
                colaborador.setFaceId(rs.getString("VC_FACE_ID"));
                colaborador.setRutaImagenPerfil(rs.getString("VC_RUTA_IMAGEN_PERFIL"));
                colaborador.setIp(rs.getString("VC_IP"));
                colaborador.setUbicacionLatitud(rs.getString("VC_UBICACION_LATITUD"));
                colaborador.setUbicacionLongitud(rs.getString("VC_UBICACION_LONGITUD"));
                colaborador.setIndicadoresOrigEnrolado(rs.getInt("CH_INDICADOR_ORIGEN_ENROLADO"));
                colaborador.setFechaHoraEnrolado(rs.getDate("DT_FECHA_HORA_ENROLADO"));
                colaborador.setGenerateRandom(rs.getString("VC_GENERATERANDOM"));
                colaborador.setIndicadorUbicacion(rs.getInt("CH_INDICADOR_UBICACION"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return colaborador;
    }

    @Override
    public Colaborador getByUser(String userColaborador) {
        String query = "SELECT * FROM FUBI_TA_USUARIO WHERE VC_USUARIO = ?";
        Colaborador colaborador = null;

        try (Connection con = DriverManager.getConnection(dataSource, user, password);
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, userColaborador);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Obtener los datos del resultado y crear un objeto Colaborador
                colaborador = new Colaborador();
                colaborador.setCodigoUsuario(rs.getLong("IN_CODIGO_USUARIO"));
                colaborador.setUsuario(rs.getString("VC_USUARIO"));
                colaborador.setClave(rs.getString("VC_CLAVE"));
                colaborador.setNombres(rs.getString("VC_NOMBRES"));
                colaborador.setSituacionRegistro(rs.getString("CH_SITUACION_REGISTRO"));
                colaborador.setFechaCreacion(rs.getDate("DT_FECHA_CREACION"));
                colaborador.setApellidoPaterno(rs.getString("VC_APELLIDO_PATERNO"));
                colaborador.setApellidoMaterno(rs.getString("VC_APELLIDO_MATERNO"));
                colaborador.setCorreo(rs.getString("VC_CORREO"));
                colaborador.setTipoDocumento(rs.getString("VC_TIPO_DOCUMENTO"));
                colaborador.setNumeroDocumentoIdentidad(rs.getString("VC_NUMERO_DOCUMENTO_IDENTIDAD"));
                colaborador.setNumeroTelefono(rs.getString("VC_NUMERO_TELEFONO"));
                colaborador.setCodigoCompania(rs.getInt("CH_CODIGO_COMPANIA"));
                colaborador.setFaceId(rs.getString("VC_FACE_ID"));
                colaborador.setRutaImagenPerfil(rs.getString("VC_RUTA_IMAGEN_PERFIL"));
                colaborador.setIp(rs.getString("VC_IP"));
                colaborador.setUbicacionLatitud(rs.getString("VC_UBICACION_LATITUD"));
                colaborador.setUbicacionLongitud(rs.getString("VC_UBICACION_LONGITUD"));
                colaborador.setIndicadoresOrigEnrolado(rs.getInt("CH_INDICADOR_ORIGEN_ENROLADO"));
                colaborador.setFechaHoraEnrolado(rs.getDate("DT_FECHA_HORA_ENROLADO"));
                colaborador.setGenerateRandom(rs.getString("VC_GENERATERANDOM"));
                colaborador.setIndicadorUbicacion(rs.getInt("CH_INDICADOR_UBICACION"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return colaborador;
    }

    @Override
    public String delete(String id) {
        String query = "UPDATE FROM FUBI_TA_USUARIO SET CH_SITUACION_REGISTRO = ? WHERE IN_CODIGO_USUARIO = ?";
        String msg = "";

        try (Connection conn = DriverManager.getConnection(dataSource, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, "E");
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

    @Override
    public Results getAll() {

        String query = "SELECT * FROM FUBI_TA_USUARIO";

        Results results = new Results();
        List<Colaborador> resultados = new ArrayList<>();
        int totalRegistros = 0;

        try (Connection connection = DriverManager.getConnection(dataSource, user, password);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {

                Colaborador colaborador = new Colaborador();
                colaborador.setCodigoUsuario(rs.getLong("IN_CODIGO_USUARIO"));
                colaborador.setUsuario(rs.getString("VC_USUARIO"));
                colaborador.setClave(rs.getString("VC_CLAVE"));
                colaborador.setNombres(rs.getString("VC_NOMBRES"));
                colaborador.setSituacionRegistro(rs.getString("CH_SITUACION_REGISTRO"));
                colaborador.setFechaCreacion(rs.getDate("DT_FECHA_CREACION"));
                colaborador.setApellidoPaterno(rs.getString("VC_APELLIDO_PATERNO"));
                colaborador.setApellidoMaterno(rs.getString("VC_APELLIDO_MATERNO"));
                colaborador.setCorreo(rs.getString("VC_CORREO"));
                colaborador.setTipoDocumento(rs.getString("VC_TIPO_DOCUMENTO"));
                colaborador.setNumeroDocumentoIdentidad(rs.getString("VC_NUMERO_DOCUMENTO_IDENTIDAD"));
                colaborador.setNumeroTelefono(rs.getString("VC_NUMERO_TELEFONO"));
                colaborador.setCodigoCompania(rs.getInt("CH_CODIGO_COMPANIA"));
                colaborador.setFaceId(rs.getString("VC_FACE_ID"));
                colaborador.setRutaImagenPerfil(rs.getString("VC_RUTA_IMAGEN_PERFIL"));
                colaborador.setIp(rs.getString("VC_IP"));
                colaborador.setUbicacionLatitud(rs.getString("VC_UBICACION_LATITUD"));
                colaborador.setUbicacionLongitud(rs.getString("VC_UBICACION_LONGITUD"));
                colaborador.setIndicadoresOrigEnrolado(rs.getInt("CH_INDICADOR_ORIGEN_ENROLADO"));
                colaborador.setFechaHoraEnrolado(rs.getDate("DT_FECHA_HORA_ENROLADO"));
                colaborador.setGenerateRandom(rs.getString("VC_GENERATERANDOM"));
                colaborador.setIndicadorUbicacion(rs.getInt("CH_INDICADOR_UBICACION"));

                resultados.add(colaborador);
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
