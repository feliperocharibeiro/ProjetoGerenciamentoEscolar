/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import Util.Classe;
import java.util.List;
import model.Telefone;


public class TelefoneDAO extends Classe{
    
    public void salvarTelefone(Telefone telefone){
        em.getTransaction().begin();
        em.merge(telefone);
        em.getTransaction().commit();
    }
    public void removerTelefone(Telefone telefone){
        em.getTransaction().begin();
        em.remove(telefone);
        em.getTransaction().commit();
    }
    public List<Telefone> findAll(){
        em.getTransaction().begin();
        query = em.createQuery("SELECT t FROM Telefone t");
        em.getTransaction().commit();
        return query.getResultList();
    }
}
