package com.example.multiapp;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombre, apellido, cedula, sexo, telefono, correo, direccion, fechaNacimiento;

    private boolean intDeporte, intMusica, intCine, intArte, intLectura, intViajes, intCocina, intTecnologia, intModa, intFotografia;

    private boolean prefPlaya, prefMontana, prefCiudad, prefCampo, prefNoche, prefDia, prefSolo, prefGrupo, prefInterior, prefExterior;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isIntDeporte() {
        return intDeporte;
    }
    public void setIntDeporte(boolean v) {
        this.intDeporte = v;
    }

    public boolean isIntMusica() {
        return intMusica;
    }
    public void setIntMusica(boolean v) {
        this.intMusica = v;
    }
    public boolean isIntCine() {
        return intCine;
    }
    public void setIntCine(boolean v) {
        this.intCine = v;
    }

    public boolean isIntArte() {
        return intArte;
    }
    public void setIntArte(boolean v) {
        this.intArte = v;
    }
    public boolean isIntLectura() {
        return intLectura;
    }
    public void setIntLectura(boolean v) {
        this.intLectura = v;
    }

    public boolean isIntViajes() {
        return intViajes;
    }
    public void setIntViajes(boolean v) {
        this.intViajes = v;
    }

    public boolean isIntCocina() {
        return intCocina;
    }
    public void setIntCocina(boolean v) {
        this.intCocina = v;
    }

    public boolean isIntTecnologia() {
        return intTecnologia;
    }
    public void setIntTecnologia(boolean v) {
        this.intTecnologia = v;
    }

    public boolean isIntModa() {
        return intModa;
    }
    public void setIntModa(boolean v) {
        this.intModa = v;
    }

    public boolean isIntFotografia() {
        return intFotografia;
    }
    public void setIntFotografia(boolean v) {
        this.intFotografia = v;
    }
    public boolean isPrefPlaya() {
        return prefPlaya;
    }
    public void setPrefPlaya(boolean v) {
        this.prefPlaya = v;
    }

    public boolean isPrefMontana() {
        return prefMontana;
    }
    public void setPrefMontana(boolean v) {
        this.prefMontana = v;
    }

    public boolean isPrefCiudad() {
        return prefCiudad;
    }
    public void setPrefCiudad(boolean v) {
        this.prefCiudad = v;
    }

    public boolean isPrefCampo() {
        return prefCampo;
    }
    public void setPrefCampo(boolean v) {
        this.prefCampo = v;
    }

    public boolean isPrefNoche() {
        return prefNoche;
    }
    public void setPrefNoche(boolean v) {
        this.prefNoche = v;
    }

    public boolean isPrefDia() {
        return prefDia;
    }
    public void setPrefDia(boolean v) {
        this.prefDia = v;
    }

    public boolean isPrefSolo() {
        return prefSolo;
    }
    public void setPrefSolo(boolean v) {
        this.prefSolo = v;
    }

    public boolean isPrefGrupo() {
        return prefGrupo;
    }
    public void setPrefGrupo(boolean v) {
        this.prefGrupo = v;
    }

    public boolean isPrefInterior() {
        return prefInterior;
    }
    public void setPrefInterior(boolean v) {
        this.prefInterior = v;
    }

    public boolean isPrefExterior() {
        return prefExterior;
    }
    public void setPrefExterior(boolean v) {
        this.prefExterior = v;
    }
}