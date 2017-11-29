/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.NewHibernateUtil;
import entidades.Detallepedido;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Matias
 */
public class DetallePedidoDAO {

    public boolean Grabar(Detallepedido dp) {
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        Transaction trans = sesion.beginTransaction();

        try {
            sesion.save(dp);
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

    public List<Detallepedido> Listar() {

        List<Detallepedido> listado = new ArrayList<Detallepedido>();
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        Query qr = sesion.createQuery("From Detallepedido");

        listado = qr.list();
        return listado;

    }

    public boolean Eliminar(Detallepedido dp) {
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        Transaction trans = sesion.beginTransaction();
        boolean r = false;
        try {
            sesion.delete(dp);
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

    public boolean Modificar(Detallepedido dp) {
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        Transaction trans = sesion.beginTransaction();
        boolean r = false;
        try {
            sesion.update(dp);
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
