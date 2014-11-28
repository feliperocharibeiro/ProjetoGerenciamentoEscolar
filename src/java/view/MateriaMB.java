/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.MateriaDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Materia;

/**
 *
 * @author Felipe Rocha Ribeiro
 */
@ManagedBean
@ViewScoped
public class MateriaMB {

    private MateriaDAO materiaDAO;
    
    private Materia materia;
    
    public MateriaMB() {
        materia = new Materia();
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
    public List<Materia> findAll() {
        try {
            materiaDAO = new MateriaDAO();
            return materiaDAO.findAll();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public void apagarMateria(Materia materia) {
        try {
            materiaDAO.removerMateria(materia);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editarMateria(Materia materia) {
        try {
            materiaDAO.salvarMateria(materia);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void salvarMateria() {
        try {
            
            materiaDAO = new MateriaDAO();
            
            materiaDAO.salvarMateria(materia);
            
            materia = new Materia();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
}
