/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.NewHibernateUtil;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Matias
 */
public class UsuarioDAO {

    public List<Usuario> Listar() {

        List<Usuario> listado = new ArrayList<Usuario>();
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        Query qr = sesion.createQuery("From Usuario");
        listado = qr.list();
        return listado;

    }
}
