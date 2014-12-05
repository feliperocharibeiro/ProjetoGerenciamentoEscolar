/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.TurmaDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Aluno;
import model.Turma;

/**
 *
 * @author Felipe Rocha Ribeiro
 */
@ManagedBean
@ViewScoped
public class TurmaMB {

    private Turma turma;
    private TurmaDAO turmaDAO;
    
    private Aluno aluno;
    
    public void mostrarTurma(Turma turma){
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public TurmaMB() {
        turma = new Turma();
        aluno = new Aluno();
    }
    
    public List<Turma> findAll() {
          try {
            turmaDAO = new TurmaDAO();
            return turmaDAO.findAll();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public Turma findById(int cod){
        try {
            System.out.println(cod);
            turmaDAO = new TurmaDAO();
            return turmaDAO.findById(cod);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public List<Turma> listaAlunoPorTurma(int cod){
        try {
            System.out.println(cod);
            turmaDAO = new TurmaDAO();
            return turmaDAO.listaAlunoPorTurma(cod);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    
    public void apagarTurma(Turma turma) {
        try {
            turmaDAO.removerTurma(turma);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editarTurma(Turma turma) {
        try {
            turmaDAO.salvarTurma(turma);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String salvarTurma() {
        try {
            turmaDAO = new TurmaDAO();
            turmaDAO.salvarTurma(turma);
            turma = new Turma();
        } catch (Exception e) {
            System.out.println(e);
        }
        return "/template.xhtml?faces-redirect=true";
    }
    public String removeSessão(){
             if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey("TurmaMB")){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TurmaMB");
             }
             return "/template.xhtml?faces-redirect=true";
    }
}
