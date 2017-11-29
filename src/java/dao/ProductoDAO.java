/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.NewHibernateUtil;
import entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Matias
 */
public class ProductoDAO {
     public boolean Grabar(Producto pro) {
         Session sesion = NewHibernateUtil.getSessionFactory().openSession();
         Transaction trans = sesion.beginTransaction();

        try {
            sesion.save(pro);
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

    public List<Producto> Listar() {

        List<Producto> listado = new ArrayList<Producto>();
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        Query qr = sesion.createQuery("From Producto");

        listado = qr.list();
        return listado;

    }

    public boolean Eliminar(Producto pro) {
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        Transaction trans = sesion.beginTransaction();
        boolean r = false;
        try {
            sesion.delete(pro);
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

    public boolean Modificar(Producto pro) {
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        Transaction trans = sesion.beginTransaction();
        boolean r = false;
        try {
            sesion.update(pro);
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
