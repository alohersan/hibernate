package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "oficinas", schema = "public", catalog = "intut4")
public class OficinasEntity {
    private String codOfi;
    private String nombreOfi;
    private String direccionOfi;
    private String localidad;
    private Collection<EmpleadosEntity> empleadosByCodOfi;

    @Id
    @Column(name = "cod_ofi")
    public String getCodOfi() {
        return codOfi;
    }

    public void setCodOfi(String codOfi) {
        this.codOfi = codOfi;
    }

    @Basic
    @Column(name = "nombre_ofi")
    public String getNombreOfi() {
        return nombreOfi;
    }

    public void setNombreOfi(String nombreOfi) {
        this.nombreOfi = nombreOfi;
    }

    @Basic
    @Column(name = "direccion_ofi")
    public String getDireccionOfi() {
        return direccionOfi;
    }

    public void setDireccionOfi(String direccionOfi) {
        this.direccionOfi = direccionOfi;
    }

    @Basic
    @Column(name = "localidad")
    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OficinasEntity that = (OficinasEntity) o;

        if (codOfi != null ? !codOfi.equals(that.codOfi) : that.codOfi != null) return false;
        if (nombreOfi != null ? !nombreOfi.equals(that.nombreOfi) : that.nombreOfi != null) return false;
        if (direccionOfi != null ? !direccionOfi.equals(that.direccionOfi) : that.direccionOfi != null) return false;
        if (localidad != null ? !localidad.equals(that.localidad) : that.localidad != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codOfi != null ? codOfi.hashCode() : 0;
        result = 31 * result + (nombreOfi != null ? nombreOfi.hashCode() : 0);
        result = 31 * result + (direccionOfi != null ? direccionOfi.hashCode() : 0);
        result = 31 * result + (localidad != null ? localidad.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "oficinasByCodOfi")
    public Collection<EmpleadosEntity> getEmpleadosByCodOfi() {
        return empleadosByCodOfi;
    }

    public void setEmpleadosByCodOfi(Collection<EmpleadosEntity> empleadosByCodOfi) {
        this.empleadosByCodOfi = empleadosByCodOfi;
    }
}
