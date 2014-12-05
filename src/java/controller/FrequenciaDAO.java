/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import Util.Classe;
import java.util.List;
import model.Aluno;
import model.Frequencia;

/**
 *
 * @author Felipe Rocha Ribeiro
 */
public class FrequenciaDAO extends Classe{
    public void registrarFrequencia(Frequencia frequencia){
        em.getTransaction().begin();
        em.merge(frequencia);
        em.getTransaction().commit();
    }
    public void removerFrequencia(Frequencia frequencia){
        em.getTransaction().begin();
        em.remove(frequencia);
        em.getTransaction().commit();
    }
    public List<Frequencia> findAll(){
        em.getTransaction().begin();
        query = em.createQuery("SELECT f FROM Frequencia f");
        em.getTransaction().commit();
        return query.getResultList();
    }
    public List<Frequencia> findBycodAluno(Aluno aluno){
        em.getTransaction().begin();
        query = em.createNamedQuery("Frequencia.findByCodAluno").setParameter("codaluno", aluno);
        em.getTransaction().commit();
        return query.getResultList();
    }
}
