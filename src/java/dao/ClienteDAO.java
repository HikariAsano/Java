/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.NewHibernateUtil;
import entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Matias
 */
public class ClienteDAO {

    public boolean Grabar(Cliente cli) {
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        Transaction trans = sesion.beginTransaction();

        try {
            sesion.save(cli);
            trans.commit();
            return true;

        } catch (Exception e) {
            System.out.println("Error Grabar:" + e.getMessage());
            trans.rollback();
            return false;

        } finally {

            sesion.close();
        }
    }

    public List<Cliente> Listar() {

        List<Cliente> listado = new ArrayList<Cliente>();
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        Query qr = sesion.createQuery("From cliente");

        listado = qr.list();
        return listado;

    }

    public boolean Eliminar(Cliente cli) {
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        Transaction trans = sesion.beginTransaction();
        boolean r = false;
        try {
            sesion.delete(cli);
            trans.commit();
            r = true;
        } catch (Exception e) {
            System.out.println("Error Eliminar:" + e.getMessage());
            trans.rollback();
        } finally {
            sesion.close();
        }
        return r;
    }

    public boolean Modificar(Cliente cli) {
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        Transaction trans = sesion.beginTransaction();
        boolean r = false;
        try {
            sesion.update(cli);
            trans.commit();
            r = true;
        } catch (Exception e) {
            System.out.println("Error al Modificar:" + e.getMessage());
            trans.rollback();
        } finally {
            sesion.close();
        }
        return r;
    }
}
