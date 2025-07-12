package entity;

import entity.OficinasEntity;

import javax.persistence.*;

@Entity
@Table(name = "EMPLEADOS", schema = "UT4INT", catalog = "")
public class EmpleadosEntity {
    private String nifEmp;
    private String nombreEmp;
    private String direccionEmp;
    private String cargoEmp;
    private String codOfi;
    private OficinasEntity oficinasByCodOfi;

    @Id
    @Column(name = "NIF_EMP")
    public String getNifEmp() {
        return nifEmp;
    }

    public void setNifEmp(String nifEmp) {
        this.nifEmp = nifEmp;
    }

    @Basic
    @Column(name = "NOMBRE_EMP")
    public String getNombreEmp() {
        return nombreEmp;
    }

    public void setNombreEmp(String nombreEmp) {
        this.nombreEmp = nombreEmp;
    }

    @Basic
    @Column(name = "DIRECCION_EMP")
    public String getDireccionEmp() {
        return direccionEmp;
    }

    public void setDireccionEmp(String direccionEmp) {
        this.direccionEmp = direccionEmp;
    }

    @Basic
    @Column(name = "CARGO_EMP")
    public String getCargoEmp() {
        return cargoEmp;
    }

    public void setCargoEmp(String cargoEmp) {
        this.cargoEmp = cargoEmp;
    }

    @Basic
    @Column(name = "COD_OFI")
    public String getCodOfi() {
        return codOfi;
    }

    public void setCodOfi(String codOfi) {
        this.codOfi = codOfi;
    }

    @ManyToOne
    @JoinColumn(name = "COD_OFI", referencedColumnName = "COD_OFI", insertable = false, updatable = false)
    public OficinasEntity getOficinasByCodOfi() {
        return oficinasByCodOfi;
    }

    public void setOficinasByCodOfi(OficinasEntity oficinasByCodOfi) {
        this.oficinasByCodOfi = oficinasByCodOfi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpleadosEntity that = (EmpleadosEntity) o;

        if (nifEmp != null ? !nifEmp.equals(that.nifEmp) : that.nifEmp != null) return false;
        if (nombreEmp != null ? !nombreEmp.equals(that.nombreEmp) : that.nombreEmp != null) return false;
        if (direccionEmp != null ? !direccionEmp.equals(that.direccionEmp) : that.direccionEmp != null) return false;
        if (cargoEmp != null ? !cargoEmp.equals(that.cargoEmp) : that.cargoEmp != null) return false;
        if (codOfi != null ? !codOfi.equals(that.codOfi) : that.codOfi != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nifEmp != null ? nifEmp.hashCode() : 0;
        result = 31 * result + (nombreEmp != null ? nombreEmp.hashCode() : 0);
        result = 31 * result + (direccionEmp != null ? direccionEmp.hashCode() : 0);
        result = 31 * result + (cargoEmp != null ? cargoEmp.hashCode() : 0);
        result = 31 * result + (codOfi != null ? codOfi.hashCode() : 0);
        return result;
    }
}
