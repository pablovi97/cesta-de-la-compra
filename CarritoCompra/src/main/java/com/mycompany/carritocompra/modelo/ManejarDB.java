/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carritocompra.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Adrian
 */
public class ManejarDB {

    static EntityManagerFactory emf;

    static EntityManager crearEntityManager() {
        if (emf == null || (emf != null && !emf.isOpen())) {
            emf = Persistence.createEntityManagerFactory("unidadPersistencia");
        }
        return emf.createEntityManager();
    }

    public static void insertarArticulo(Articulo a) {
        EntityManager em = crearEntityManager();

        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(a);//para insertar en la base de datos
            et.commit();

        } catch (Exception e) {
        }
    }

  public  static void crearCliente(Cliente c) {
        EntityManager em = crearEntityManager();

        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(c);//para insertar en la base de datos
            et.commit();

        } catch (Exception e) {
        }

    }

    static void insertarPedido(Pedido p) {

    }

    public static List<Articulo> obtenerArticulos() {
        EntityManager em = crearEntityManager();
        List<Articulo> result = em.createNamedQuery("Articulo.findAll", Articulo.class)
                .getResultList();
        return result;
    }

    public static List<Cliente> obtenerClientes() {
        EntityManager em = crearEntityManager();
        List<Cliente> result = em.createNamedQuery("Cliente.findAll", Cliente.class)
                .getResultList();
        return result;
    }

    public static List<Pedido> obtenerPedidos() {
        EntityManager em = crearEntityManager();
        List<Pedido> result = em.createNamedQuery("Pedido.findAll", Pedido.class)
                .getResultList();
        return result;
    }
}
