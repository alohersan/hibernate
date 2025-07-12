package entity;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

public class Querys {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);

        //Obtener todos los datos de los empleados
        EmpleadosEntity emp = new EmpleadosEntity();
        Query q1 = session.createQuery("from EmpleadosEntity ");
        List<EmpleadosEntity> listaemp = q1.getResultList();
        Iterator<EmpleadosEntity> itemp = listaemp.iterator();
        while (itemp.hasNext()) {
            emp = (EmpleadosEntity) itemp.next();
            System.out.println("------------------------------------");
            System.out.println("NIF: " + emp.getNifEmp());
            System.out.println("Nombre: " + emp.getNombreEmp());
            System.out.println("Direccion: " + emp.getDireccionEmp());
            System.out.println("Cargo: " + emp.getCargoEmp());
            System.out.println("Codigo Oficina: " + emp.getCodOfi());
        }

       //Modificar el cargo de los empleados de la oficina 50 a comerciales
        Transaction tx = session.beginTransaction();
        Query q2 = session.createQuery("update EmpleadosEntity set cargoEmp=:nuevocargo where codOfi='50'");
        q2.setParameter("nuevocargo","Comercial");
        int updatedrows=q2.executeUpdate();
        System.out.println("Se ha modificado el cargo de "+updatedrows+" empleados");
        tx.commit();



        //Mostrar cuántos empleados hay por cada oficina
        System.out.println("--------------------------------------------");
        Query q3 = session.createQuery("select codOfi, count(codOfi) from EmpleadosEntity group by codOfi");
        List<Object[]> result = q3.getResultList();
        for (Object[] row : result) {
            System.out.println("Oficina: " + row[0] + " - Empleados: " + row[1]);
        }

        //Obtener el nombre de las oficinas de Telde (por parámetro)
        System.out.println("--------------------------------------------");
        Query q4 = session.createQuery("from OficinasEntity ofi where ofi.localidad LIKE:localidad");
        q4.setParameter("localidad", "Telde%");//el % es para rellenar los espacios que quedan porque si no no encuentra la consulta
        List<OficinasEntity> listaoficina = q4.getResultList();
        Iterator<OficinasEntity> itoficina = listaoficina.iterator();
        OficinasEntity ofi = new OficinasEntity();
        System.out.println("Oficinas con localidad Telde: ");
        while (itoficina.hasNext()) {
            ofi = itoficina.next();
            System.out.println("Nombre: " + ofi.getNombreOfi());
        }


        //Eliminar las oficinas de Telde
        session.beginTransaction();
        Query q5 = session.createQuery("delete OficinasEntity where localidad='Telde'");
        int deletedrows=q5.executeUpdate();
        System.out.println("Se ha borrado el registro de "+deletedrows+" oficina");
        tx.commit();

        session.close();
        entityManager.close();
        entityManagerFactory.close();


    }
}
