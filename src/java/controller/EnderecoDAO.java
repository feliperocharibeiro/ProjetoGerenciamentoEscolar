/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import Util.Classe;
import java.util.List;
import model.Endereco;

/**
 *
 * @author Felipe Rocha Ribeiro
 */
public class EnderecoDAO extends Classe {
    
    public void salvarEndereco(Endereco endereco){
        em.getTransaction().begin();
        em.merge(endereco);
        em.getTransaction().commit();
    }
    public void removerEndereco(Endereco endereco){
        em.getTransaction().begin();
        em.remove(endereco);
        em.getTransaction().commit();
    }
    public List<Endereco> findAll(){
        em.getTransaction().begin();
        query = em.createQuery("SELECT e FROM Endereco e");
        em.getTransaction().commit();
        return query.getResultList();
    }
    
}
