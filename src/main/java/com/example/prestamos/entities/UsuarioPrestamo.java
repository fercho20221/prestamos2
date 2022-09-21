package com.example.prestamos.entities;

import javax.persistence.*;

@Entity
@Table(name="usuarioprestamo")
public class UsuarioPrestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="tipoprestamoid")
    private TipoPrestamo prestamo;

    @ManyToOne
    @JoinColumn(name="usuarioid")
    private User usuario;

    @Column(name="montosolicitado")
    private int montoSolicitado;

    @Column(name="cantidadcuotas")
    private int cantidadcuotas;

    @Column(name="codeudor")
    private String codeudor;

    @Column(name="celularcodeudor")
    private String celularCodeudor;

    public TipoPrestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(TipoPrestamo prestamo) {
        this.prestamo = prestamo;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public int getMontoSolicitado() {
        return montoSolicitado;
    }

    public void setMontoSolicitado(int montoSolicitado) {
        this.montoSolicitado = montoSolicitado;
    }

    public int getCantidadcuotas() {
        return cantidadcuotas;
    }

    public void setCantidadcuotas(int cantidadcuotas) {
        this.cantidadcuotas = cantidadcuotas;
    }

    public String getCodeudor() {
        return codeudor;
    }

    public void setCodeudor(String codeudor) {
        this.codeudor = codeudor;
    }

    public String getCelularCodeudor() {
        return celularCodeudor;
    }

    public void setCelularCodeudor(String celularCodeudor) {
        this.celularCodeudor = celularCodeudor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
