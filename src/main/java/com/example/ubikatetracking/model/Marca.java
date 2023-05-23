package com.example.ubikatetracking.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "FUBI_TA_UBICATE_MARCAS")
public class Marca {

    @Id
    @Column(name = "IN_SECUENCIAL")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codSecuencial;

    @Column(name = "VC_IDENTIFICADOR_EMPLEADO")
    private String idEmpleado;

    @Column(name = "VC_NOMBRE_EMPLEADO")
    private String nombreEmpleado;

    @Column(name = "CH_CODIGO_COMPANIA")
    private String codigoCompania;

    @Column(name = "VC_LATITUD")
    private String latitud;

    @Column(name = "VC_LONGITUD")
    private String longitud;

    @Column(name = "CH_TIPO_ORIGEN")
    private String tipoOrigen;

    @Column(name = "DT_FECHA_REGISTRO")
    private Timestamp fechaRegistro;

    @Column(name = "VC_IDENTIFICADOR_ENROLADOR")
    private String idEnrolador;

    @Column(name = "VC_DIRECCION")
    private String direccion;

    @Column(name = "CH_SITUACION_REGISTRO")
    private String situacionRegistro;

    @Column(name = "IN_CODIGO_USUARIO")
    private int codUsuario;

    public int getCodSecuencial() {
        return codSecuencial;
    }

    public void setCodSecuencial(int codSecuencial) {
        this.codSecuencial = codSecuencial;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCodigoCompania() {
        return codigoCompania;
    }

    public void setCodigoCompania(String codigoCompania) {
        this.codigoCompania = codigoCompania;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getTipoOrigen() {
        return tipoOrigen;
    }

    public void setTipoOrigen(String tipoOrigen) {
        this.tipoOrigen = tipoOrigen;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getIdEnrolador() {
        return idEnrolador;
    }

    public void setIdEnrolador(String idEnrolador) {
        this.idEnrolador = idEnrolador;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSituacionRegistro() {
        return situacionRegistro;
    }

    public void setSituacionRegistro(String situacionRegistro) {
        this.situacionRegistro = situacionRegistro;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }
}
