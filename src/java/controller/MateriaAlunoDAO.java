
package controller;

import Util.Classe;
import java.util.List;
import model.Materia;
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
    public List<Materia> findByMateria(Materia materia){
        em.getTransaction().begin();
        query = em.createNamedQuery("MateriaAluno.findByMateria").setParameter("codmateria", materia);
        em.getTransaction().commit();
        return query.getResultList();
    }
    public List<MateriaAluno> findByPeriodo(String periodo){
        em.getTransaction().begin();
        periodo = "%"+periodo+"%";
        System.out.println("Periodo no lado do DAO:"+periodo);
        query = em.createNamedQuery("MateriaAluno.findByPeriodo").setParameter("periodo", periodo);
        em.getTransaction().commit();
        return query.getResultList();
    }
}
