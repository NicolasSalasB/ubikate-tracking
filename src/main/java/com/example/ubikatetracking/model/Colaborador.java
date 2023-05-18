package com.example.ubikatetracking.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FUBI_TA_USUARIO")
public class Colaborador {

    @Id
    @Column(name = "IN_CODIGO_USUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoUsuario;

    @Column(name = "VC_USUARIO")
    private String usuario;

    @Column(name = "VC_CLAVE")
    private String clave;

    @Column(name = "VC_NOMBRES")
    private String nombres;

    @Column(name = "CH_SITUACION_REGISTRO")
    private String situacionRegistro;

    @Column(name = "DT_FECHA_CREACION")
    private Date fechaCreacion;

    @Column(name = "VC_APELLIDO_PATERNO")
    private String apellidoPaterno;

    @Column(name = "VC_APELLIDO_MATERNO")
    private String apellidoMaterno;

    @Column(name = "VC_CORREO")
    private String correo;

    @Column(name = "VC_NUMERO_DOCUMENTO_IDENTIDAD")
    private String numeroDocumentoIdentidad;

    @Column(name = "VC_TIPO_DOCUMENTO")
    private String tipoDocumento;

    @Column(name = "VC_NUMERO_TELEFONO")
    private String numeroTelefono;

    @Column(name = "CH_CODIGO_COMPANIA")
    private int codigoCompania;

    @Column(name = "VC_FACE_ID")
    private String faceId;

    @Column(name = "VC_RUTA_IMAGEN_PERFIL")
    private String rutaImagenPerfil;

    @Column(name = "VC_IP")
    private String ip;

    @Column(name = "VC_UBICACION_LATITUD")
    private String ubicacionLatitud;

    @Column(name = "VC_UBICACION_LONGITUD")
    private String ubicacionLongitud;

    @Column(name = "CH_INDICADOR_ORIGEN_ENROLADO")
    private int indicadoresOrigEnrolado;

    @Column(name = "DT_FECHA_HORA_ENROLADO")
    private Date fechaHoraEnrolado;

    @Column(name = "VC_GENERATERANDOM")
    private String generateRandom;

    @Column(name = "CH_INDICADOR_UBICACION")
    private int indicadorUbicacion;

    public Long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getSituacionRegistro() {
        return situacionRegistro;
    }

    public void setSituacionRegistro(String situacionRegistro) {
        this.situacionRegistro = situacionRegistro;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumeroDocumentoIdentidad() {
        return numeroDocumentoIdentidad;
    }

    public void setNumeroDocumentoIdentidad(String numeroDocumentoIdentidad) {
        this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public int getCodigoCompania() {
        return codigoCompania;
    }

    public void setCodigoCompania(int codigoCompañia) {
        this.codigoCompania = codigoCompañia;
    }

    public String getFaceId() {
        return faceId;
    }

    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    public String getRutaImagenPerfil() {
        return rutaImagenPerfil;
    }

    public void setRutaImagenPerfil(String rutaImagenPerfil) {
        this.rutaImagenPerfil = rutaImagenPerfil;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUbicacionLatitud() {
        return ubicacionLatitud;
    }

    public void setUbicacionLatitud(String ubicacionLatitud) {
        this.ubicacionLatitud = ubicacionLatitud;
    }

    public String getUbicacionLongitud() {
        return ubicacionLongitud;
    }

    public void setUbicacionLongitud(String ubicacionLongitud) {
        this.ubicacionLongitud = ubicacionLongitud;
    }

    public int getIndicadoresOrigEnrolado() {
        return indicadoresOrigEnrolado;
    }

    public void setIndicadoresOrigEnrolado(int indicadoresOrigEnrolado) {
        this.indicadoresOrigEnrolado = indicadoresOrigEnrolado;
    }

    public Date getFechaHoraEnrolado() {
        return fechaHoraEnrolado;
    }

    public void setFechaHoraEnrolado(Date fechaHoraEnrolado) {
        this.fechaHoraEnrolado = fechaHoraEnrolado;
    }

    public String getGenerateRandom() {
        return generateRandom;
    }

    public void setGenerateRandom(String generateRandom) {
        this.generateRandom = generateRandom;
    }

    public int getIndicadorUbicacion() {
        return indicadorUbicacion;
    }

    public void setIndicadorUbicacion(int indicadorUbicacion) {
        this.indicadorUbicacion = indicadorUbicacion;
    }
}
