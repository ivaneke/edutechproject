package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cupon {
    @Id
    private String codigo;
    private String descripcion;
    private int descuento;
    private String fechaExpiracion;
    private String activo = "true"; // Por defecto, el cupón está activo
    private int cantidadUsos; // Número de veces que se puede usar el cupón
    
/*

    //Cupon se aplica en un registro
    // Relación uno a muchos entre Cupon y Registro_alumno
    // Cada cupón puede ser aplicado en múltiples registros, pero un registro solo puede tener un cupón aplicado
    @OneToMany(mappedBy = "cupon")
    @JsonBackReference
    private List<Registro_alumno> registros;
*/
    // Constructor por defecto
    public Cupon() {
        this.codigo = "";
        this.descripcion = "";
        this.descuento = 0;
        this.fechaExpiracion = "";
        this.cantidadUsos = 1; // Por defecto, el cupón se puede usar una vez
    }


    // Getters y Setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public int getCantidadUsos() {
        return cantidadUsos;
    }

    public void setCantidadUsos(int cantidadUsos) {
        this.cantidadUsos = cantidadUsos;
    }


}
