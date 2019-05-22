/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author pablo
 */
public class MainDB {

    static EntityManagerFactory emf;

    static EntityManager crearEntityManager() {
        if (emf == null || (emf != null && !emf.isOpen())) {
            emf = Persistence.createEntityManagerFactory("unidadPersistencia");
        }
        return emf.createEntityManager();

    }

    public static void insertarCompra(Compra cp) {
        //Insertar Shippers
        EntityManager em = crearEntityManager();

        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(cp);//para insertar en la base de datos
            et.commit();

        } catch (Exception e) {
        }

    }

    public static List<Compra> obtenerCompras() {
        //Coge los empleados y los introduce en una Lista

        List<Compra> resultado = null;

        EntityManager em = crearEntityManager();

        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            resultado = em.createNamedQuery("Compra.findAll", Compra.class)
                    .getResultList();//.setParameter("IDeMPLEADO", 5);

            et.commit();
        } catch (Exception e) {
            et.rollback();
        }

        return resultado;

    }

    public static void transaccionActiva() {
        EntityManager em = crearEntityManager();

        if (em.getTransaction().isActive()) {
            System.out.println("IS ACTIVE");
        } else {
            System.out.println("NO ACTIVE");
            em.getTransaction().begin();
              
               
        }
    }

    public static void modificarCompra(Compra cp) {
        EntityManager em = crearEntityManager();

        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(cp);//para modificar  la base de datos
            et.commit();

        } catch (Exception e) {

        }

    }
}
