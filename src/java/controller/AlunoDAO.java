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
public class AlunoDAO extends Classe{
    
    public void salvarAluno(Aluno aluno){
        em.getTransaction().begin();
        em.merge(aluno);
        em.getTransaction().commit();
    }
    public void removerAluno(Aluno aluno){
        em.getTransaction().begin();
        em.remove(aluno);
        em.getTransaction().commit();
    }
    public List<Aluno> findAll(){
        em.getTransaction().begin();
        query = em.createQuery("SELECT a FROM Aluno a");
        em.getTransaction().commit();
        return query.getResultList();
    }
    public Aluno findById(int cod){
        em.getTransaction().begin();
        query = em.createNamedQuery("Aluno.findByCodaluno").setParameter("codaluno", cod);
        em.getTransaction().commit();
        return (Aluno) query.getSingleResult();
    }
    
    public List<Aluno> findByTurma(Turma turma){
        em.getTransaction().begin();
        query = em.createNamedQuery("Aluno.findByTurma").setParameter("codturma", turma);
        em.getTransaction().commit();
        return query.getResultList();
    }
}
