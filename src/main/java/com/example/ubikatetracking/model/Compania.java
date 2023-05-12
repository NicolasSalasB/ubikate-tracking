package com.example.ubikatetracking.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FUBI_TA_COMPANIA")
public class Compania {

    @Id
    @Column(name = "CH_CODIGO_COMPANIA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoCompania;

    @Column(name = "VC_NOMBRE_COMPANIA")
    private String nombreCompania;

    @Column(name = "VC_NOMBRE_CORTO_COMPANIA")
    private String nombreCortoCompania;

    @Column(name = "CH_SITUACION_REGISTRO")
    private String situacionRegistro;

    @Column(name = "DT_FECHA_REGISTRO")
    private Date fechaRegistro;

    @Column(name = "VC_DOMICILIO_EMPRESA")
    private String domicilioEmpresa;


    public Long getCodigoCompania() {
        return codigoCompania;
    }

    public void setCodigoCompania(Long codigoCompania) {
        this.codigoCompania = codigoCompania;
    }

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public String getNombreCortoCompania() {
        return nombreCortoCompania;
    }

    public void setNombreCortoCompania(String nombreCortoCompania) {
        this.nombreCortoCompania = nombreCortoCompania;
    }

    public String getSituacionRegistro() {
        return situacionRegistro;
    }

    public void setSituacionRegistro(String situacionRegistro) {
        this.situacionRegistro = situacionRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getDomicilioEmpresa() {
        return domicilioEmpresa;
    }

    public void setDomicilioEmpresa(String domicilioEmpresa) {
        this.domicilioEmpresa = domicilioEmpresa;
    }
}
