/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import Util.Classe;
import java.util.List;
import model.Avaliacao;

/**
 *
 * @author Felipe Rocha Ribeiro
 */
public class AvaliacaoDAO extends Classe{
    
    public void salvarAvaliacao(Avaliacao avaliacao){
        em.getTransaction().begin();
        em.merge(avaliacao);
        em.getTransaction().commit();
    }
    public void removerAvaliacao(Avaliacao avaliacao){
        em.getTransaction().begin();
        em.remove(avaliacao);
        em.getTransaction().commit();
    }
    public List<Avaliacao> findAll(){
        em.getTransaction().begin();
        query = em.createQuery("SELECT a FROM Avaliacao a");
        em.getTransaction().commit();
        return query.getResultList();
    }
}
