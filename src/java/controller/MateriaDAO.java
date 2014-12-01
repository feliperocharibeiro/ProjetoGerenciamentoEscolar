/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import Util.Classe;
import java.util.List;
import model.Materia;

/**
 *
 * @author Felipe Rocha Ribeiro
 */
public class MateriaDAO extends Classe{
    public void salvarMateria(Materia materia){
        em.getTransaction().begin();
        em.merge(materia);
        em.getTransaction().commit();
    }
    public void removerMateria(Materia materia){
        em.getTransaction().begin();
        em.remove(materia);
        em.getTransaction().commit();
    }
    public List<Materia> findAll(){
        em.getTransaction().begin();
        query = em.createQuery("SELECT m FROM Materia m");
        em.getTransaction().commit();
        return query.getResultList();
    }
    public List<Materia> findById(int cod){
        em.getTransaction().begin();
        query = em.createNamedQuery("Materia.findByCodmateria").setParameter("codmateria", cod);
        em.getTransaction().commit();
        return query.getResultList();
    }
}
