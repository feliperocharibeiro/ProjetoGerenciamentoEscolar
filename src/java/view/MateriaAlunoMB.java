/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.MateriaAlunoDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.MateriaAluno;

/**
 *
 * @author Felipe Rocha Ribeiro
 */
@ManagedBean
@ViewScoped
public class MateriaAlunoMB {
    
    private MateriaAlunoDAO materiaAlunoDAO;
    
    private MateriaAluno materiaAluno;
    
    public MateriaAlunoMB() {
        materiaAluno = new MateriaAluno();
    }

    public MateriaAluno getMateriaAluno() {
        return materiaAluno;
    }

    public void setMateriaAluno(MateriaAluno materiaAluno) {
        this.materiaAluno = materiaAluno;
    }
    
    public List<MateriaAluno> findAll() {
        try {
            materiaAlunoDAO = new MateriaAlunoDAO();
            return materiaAlunoDAO.findAll();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public void apagarMateriaAluno(MateriaAluno materiaAluno) {
        try {
            materiaAlunoDAO.removerMateriaAluno(materiaAluno);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editarMateriaAluno(MateriaAluno materiaAluno) {
        try {
            materiaAlunoDAO.salvarMateriaAluno(materiaAluno);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void salvarMateriaAluno() {
        try {
            
            materiaAlunoDAO = new MateriaAlunoDAO();

            
            materiaAlunoDAO.salvarMateriaAluno(materiaAluno);
            
            materiaAluno = new MateriaAluno();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
