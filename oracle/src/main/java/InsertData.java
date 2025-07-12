
import entity.EmpleadosEntity;
import entity.OficinasEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

public class InsertData {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        Transaction tx = session.beginTransaction();

        // Insertar datos en las tablas oficinas
        OficinasEntity of1 = new OficinasEntity();
        of1.setCodOfi("20");
        of1.setNombreOfi("Orange");
        of1.setDireccionOfi("Av.Canarias");
        of1.setLocalidad("Santa Lucia");
        session.save(of1);
        tx.commit();

        session.beginTransaction();
        OficinasEntity of2 = new OficinasEntity();
        of2.setCodOfi("50");
        of2.setNombreOfi("VodafoneSur");
        of2.setDireccionOfi("Alcorac 50");
        of2.setLocalidad("Aguimes");
        session.save(of2);
        tx.commit();

        session.beginTransaction();
        OficinasEntity of3 = new OficinasEntity();
        of3.setCodOfi("10");
        of3.setNombreOfi("Movistar");
        of3.setDireccionOfi("La Mareta");
        of3.setLocalidad("Telde");
        session.save(of3);
        tx.commit();

      //Insertar empleados
        session.beginTransaction();
        EmpleadosEntity emp1=new EmpleadosEntity();
        emp1.setNifEmp("01234567A");
        emp1.setNombreEmp("Juan");
        emp1.setDireccionEmp("Calle 2");
        emp1.setCargoEmp("Director");
        emp1.setCodOfi("20");
        session.save(emp1);
        tx.commit();

        session.beginTransaction();
        EmpleadosEntity emp2=new EmpleadosEntity();
        emp2.setNifEmp("12123556M");
        emp2.setNombreEmp("Pepe");
        emp2.setDireccionEmp("Calle 5");
        emp2.setCargoEmp("Becario");
        emp2.setCodOfi("50");
        session.save(emp2);
        tx.commit();

        session.beginTransaction();
        EmpleadosEntity emp3=new EmpleadosEntity();
        emp3.setNifEmp("91705732V");
        emp3.setNombreEmp("Maria");
        emp3.setDireccionEmp("Calle 24");
        emp3.setCargoEmp("Manager");
        emp3.setCodOfi("50");
        session.save(emp3);
        tx.commit();

        session.beginTransaction();
        EmpleadosEntity emp4=new EmpleadosEntity();
        emp4.setNifEmp("70010556M");
        emp4.setNombreEmp("Luis");
        emp4.setDireccionEmp("Avenida 253");
        emp4.setCargoEmp("Tecnico");
        emp4.setCodOfi("10");
        session.save(emp4);
        tx.commit();



        session.close();
        entityManager.close();
        entityManagerFactory.close();


    }
}
