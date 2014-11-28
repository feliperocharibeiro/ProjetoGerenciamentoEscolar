/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import Util.Classe;
import java.util.List;
import model.Aluno;
import model.Turma;

/**
 *
 * @author Felipe Rocha Ribeiro
 */
public class TurmaDAO extends Classe {
    
    public void salvarTurma(Turma turma){
        em.getTransaction().begin();
        em.merge(turma);
        em.getTransaction().commit();
    }
    public void removerTurma(Turma turma){
        em.getTransaction().begin();
        em.remove(turma);
        em.getTransaction().commit();
    }
    public List<Turma> findAll(){
        em.getTransaction().begin();
        query = em.createQuery("SELECT t FROM Turma t");
        em.getTransaction().commit();
        return query.getResultList();
    }
    public Turma findById(int cod){
        em.getTransaction().begin();
        query = em.createNamedQuery("Turma.findByCodturma").setParameter("codturma", cod);
        em.getTransaction().commit();
        return (Turma) query.getSingleResult();
    }
    
    public List<Turma> listaAlunoPorTurma(int cod){
        em.getTransaction().begin();
        query = em.createNamedQuery("Turma.listaAlunoPorTurma").setParameter("codturma", cod);
        em.getTransaction().commit();
        return query.getResultList();
    }
    
    
}
