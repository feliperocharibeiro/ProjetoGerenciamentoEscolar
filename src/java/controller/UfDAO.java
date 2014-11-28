/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import Util.Classe;
import java.util.List;
import model.Uf;


public class UfDAO extends Classe{
    
    public void salvarUf(Uf uf){
        em.getTransaction().begin();
        em.merge(uf);
        em.getTransaction().commit();
    }
    public void removerUf(Uf uf){
        em.getTransaction().begin();
        em.remove(uf);
        em.getTransaction().commit();
    }
    public List<Uf> findAll(){
        em.getTransaction().begin();
        query = em.createQuery("SELECT a FROM Uf a");
        em.getTransaction().commit();
        return query.getResultList();
    }
    public Uf findById(String cod){
        em.getTransaction().begin();
        query = em.createNamedQuery("Uf.findByUf").setParameter("uf", cod);
        em.getTransaction().commit();
        return (Uf) query.getSingleResult();
    }
    
}
