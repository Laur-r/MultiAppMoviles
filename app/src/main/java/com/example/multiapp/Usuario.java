package com.example.multiapp;

import java.io.Serializable;

public class Usuario implements Serializable {

    // Datos personales
    private String nombre;
    private String apellido;
    private String cedula;
    private String sexo;
    private String direccion;
    private String telefono;
    private String correo;
    private String fechaNacimiento;

    // Intereses
    private boolean intDeporte;
    private boolean intMusica;
    private boolean intCine;
    private boolean intArte;
    private boolean intLectura;
    private boolean intViajes;
    private boolean intCocina;
    private boolean intTecnologia;
    private boolean intModa;
    private boolean intFotografia;

    // Preferencias
    private boolean prefCine;
    private boolean prefConciertos;
    private boolean prefRestaurantes;
    private boolean prefTeatro;
    private boolean prefNaturaleza;
    private boolean prefVideojuegos;
    private boolean prefCompras;
    private boolean prefFestivales;
    private boolean prefMuseos;
    private boolean prefDeportes;

    // Constructor vacío
    public Usuario() {}

    // Constructor con datos personales
    public Usuario(String nombre, String apellido, String cedula,String telefono,
                   String correo, String direccion, String fechaNacimiento, String sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
    }

    // ─── Getters y Setters: Datos personales ────────────────────────────────

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    // ─── Getters y Setters: Intereses ───────────────────────────────────────

    public boolean isIntDeporte() { return intDeporte; }
    public void setIntDeporte(boolean intDeporte) { this.intDeporte = intDeporte; }

    public boolean isIntMusica() { return intMusica; }
    public void setIntMusica(boolean intMusica) { this.intMusica = intMusica; }

    public boolean isIntCine() { return intCine; }
    public void setIntCine(boolean intCine) { this.intCine = intCine; }

    public boolean isIntArte() { return intArte; }
    public void setIntArte(boolean intArte) { this.intArte = intArte; }

    public boolean isIntLectura() { return intLectura; }
    public void setIntLectura(boolean intLectura) { this.intLectura = intLectura; }

    public boolean isIntViajes() { return intViajes; }
    public void setIntViajes(boolean intViajes) { this.intViajes = intViajes; }

    public boolean isIntCocina() { return intCocina; }
    public void setIntCocina(boolean intCocina) { this.intCocina = intCocina; }

    public boolean isIntTecnologia() { return intTecnologia; }
    public void setIntTecnologia(boolean intTecnologia) { this.intTecnologia = intTecnologia; }

    public boolean isIntModa() { return intModa; }
    public void setIntModa(boolean intModa) { this.intModa = intModa; }

    public boolean isIntFotografia() { return intFotografia; }
    public void setIntFotografia(boolean intFotografia) { this.intFotografia = intFotografia; }

    // ─── Getters y Setters: Preferencias────────────────────────────

    public boolean isPrefCine() { return prefCine; }
    public void setPrefCine(boolean prefCine) { this.prefCine = prefCine; }

    public boolean isPrefConciertos() { return prefConciertos; }
    public void setPrefConciertos(boolean prefConciertos) { this.prefConciertos = prefConciertos; }

    public boolean isPrefRestaurantes() { return prefRestaurantes; }
    public void setPrefRestaurantes(boolean prefRestaurantes) { this.prefRestaurantes = prefRestaurantes; }

    public boolean isPrefTeatro() { return prefTeatro; }
    public void setPrefTeatro(boolean prefTeatro) { this.prefTeatro = prefTeatro; }

    public boolean isPrefNaturaleza() { return prefNaturaleza; }
    public void setPrefNaturaleza(boolean prefNaturaleza) { this.prefNaturaleza = prefNaturaleza; }

    public boolean isPrefVideojuegos() { return prefVideojuegos; }
    public void setPrefVideojuegos(boolean prefVideojuegos) { this.prefVideojuegos = prefVideojuegos; }

    public boolean isPrefCompras() { return prefCompras; }
    public void setPrefCompras(boolean prefCompras) { this.prefCompras = prefCompras; }

    public boolean isPrefFestivales() { return prefFestivales; }
    public void setPrefFestivales(boolean prefFestivales) { this.prefFestivales = prefFestivales; }

    public boolean isPrefMuseos() { return prefMuseos; }
    public void setPrefMuseos(boolean prefMuseos) { this.prefMuseos = prefMuseos; }

    public boolean isPrefDeportes() { return prefDeportes; }
    public void setPrefDeportes(boolean prefDeportes) { this.prefDeportes = prefDeportes; }

    // ─── Helpers para mostrar en pantalla ───────────────────────────────────

    public String getInteresesTexto() {
        StringBuilder sb = new StringBuilder();
        if (intDeporte)    sb.append("Deporte, ");
        if (intMusica)     sb.append("Música, ");
        if (intCine)       sb.append("Cine, ");
        if (intArte)       sb.append("Arte, ");
        if (intLectura)    sb.append("Lectura, ");
        if (intViajes)     sb.append("Viajes, ");
        if (intCocina)     sb.append("Cocina, ");
        if (intTecnologia) sb.append("Tecnología, ");
        if (intModa)       sb.append("Moda, ");
        if (intFotografia) sb.append("Fotografía, ");
        if (sb.length() > 2) sb.setLength(sb.length() - 2);
        return sb.length() > 0 ? sb.toString() : "Ninguno";
    }

    public String getPreferenciasTexto() {
        StringBuilder sb = new StringBuilder();
        if (prefCine)         sb.append("Cine, ");
        if (prefConciertos)   sb.append("Conciertos, ");
        if (prefRestaurantes) sb.append("Restaurantes, ");
        if (prefTeatro)       sb.append("Teatro, ");
        if (prefNaturaleza)   sb.append("Naturaleza, ");
        if (prefVideojuegos)  sb.append("Videojuegos, ");
        if (prefCompras)      sb.append("Compras, ");
        if (prefFestivales)   sb.append("Festivales, ");
        if (prefMuseos)       sb.append("Museos, ");
        if (prefDeportes)     sb.append("Gym/Sport, ");
        if (sb.length() > 2) sb.setLength(sb.length() - 2);
        return sb.length() > 0 ? sb.toString() : "Ninguna";
    }
}