
package controller;

import Util.Classe;
import java.util.List;
import model.MateriaAluno;


public class MateriaAlunoDAO extends Classe{
    public void salvarMateriaAluno(MateriaAluno materiaAluno){
        em.getTransaction().begin();
        em.merge(materiaAluno);
        em.getTransaction().commit();
    }
    public void removerMateriaAluno(MateriaAluno materiaAluno){
        em.getTransaction().begin();
        em.remove(materiaAluno);
        em.getTransaction().commit();
    }
    public List<MateriaAluno> findAll(){
        em.getTransaction().begin();
        query = em.createQuery("SELECT m FROM MateriaAluno m");
        em.getTransaction().commit();
        return query.getResultList();
    }
}
