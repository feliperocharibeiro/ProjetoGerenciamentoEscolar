/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.AlunoDAO;
import controller.MateriaAlunoDAO;
import controller.MateriaDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import model.Aluno;
import model.Materia;
import model.MateriaAluno;

/**
 *
 * @author Felipe Rocha Ribeiro
 */
@ManagedBean
@ViewScoped
public class MateriaAlunoMB {
    
    private MateriaAlunoDAO materiaAlunoDAO;
    private AlunoDAO alunoDAO;
    private MateriaDAO materiaDAO;
    
    private MateriaAluno materiaAluno;
    private Aluno aluno;
    private Materia materia;
    
    private String nota;
    private String codMateria;
    private String periodo;
    
    @ManagedProperty(value="#{alunoMB}")
    private AlunoMB alunoMB;
    
    @ManagedProperty(value="#{materiaMB}")
    private MateriaMB materiaMB;
    
    public MateriaAlunoMB() {
        materiaAluno = new MateriaAluno();
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

        
    public String getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(String codMateria) {
        this.codMateria = codMateria;
    }
    

    public MateriaMB getMateriaMB() {
        return materiaMB;
    }

    public void setMateriaMB(MateriaMB materiaMB) {
        this.materiaMB = materiaMB;
    }
    

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }


    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

          
    public AlunoMB getAlunoMB() {
        return alunoMB;
    }

    public void setAlunoMB(AlunoMB alunoMB) {
        this.alunoMB = alunoMB;
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
    
    public String salvarNota(){
        try {
            alunoDAO = new AlunoDAO();
            materiaDAO = new MateriaDAO();
            materiaAlunoDAO = new MateriaAlunoDAO();
            
            
            List<Aluno> lista = alunoMB.getListaAluno();
            List<Materia> listaMateria = materiaMB.getListaMateria();
            
            System.out.println("Tamanho lista em Materia:"+lista.size());
            System.out.println("Tamanho da Lista de Materia:" + listaMateria.size());
            for(Materia m:listaMateria){
            for(Aluno a:lista){
                System.out.println("Lista da Materia:"+a.getNome());
                System.out.println("Nome da Materia:"+m.getDescricao());
                materiaAluno.setCodaluno(a);
                materiaAluno.setCodmateria(m);
                System.out.println("NOTA"+a.getNota());
                materiaAluno.setNota(a.getNota());
                materiaAluno.setPeriodo(periodo);
                
                materiaAlunoDAO.salvarMateriaAluno(materiaAluno);
                materiaAluno = new MateriaAluno();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "cadastroNota.xhtml";
    }
    
    public List<MateriaAluno> findByPeriodo(){
        try {
            materiaDAO = new MateriaDAO();
            materiaAlunoDAO = new MateriaAlunoDAO();
            System.out.println(periodo);
            return materiaAlunoDAO.findByPeriodo(periodo);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        
    }
}
