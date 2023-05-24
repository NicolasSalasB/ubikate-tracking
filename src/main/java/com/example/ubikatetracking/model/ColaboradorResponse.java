package com.example.ubikatetracking.model;

public class ColaboradorResponse {

    private String id;
    private String nombres;
    private String situacionRegistro;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String numeroTelefono;
    private int indicadorUbicacion;
    private String numeroDocumentoIdentidad;
    private String rol;
    private String agrupador;
    private String correo;

    private String tipoDocumento;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public int getIndicadorUbicacion() {
        return indicadorUbicacion;
    }

    public void setIndicadorUbicacion(int indicadorUbicacion) {
        this.indicadorUbicacion = indicadorUbicacion;
    }

    public String getNumeroDocumentoIdentidad() {
        return numeroDocumentoIdentidad;
    }

    public void setNumeroDocumentoIdentidad(String numeroDocumentoIdentidad) {
        this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getAgrupador() {
        return agrupador;
    }

    public void setAgrupador(String agrupador) {
        this.agrupador = agrupador;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
}
