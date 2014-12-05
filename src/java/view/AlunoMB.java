/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AlunoDAO;
import controller.EnderecoDAO;
import controller.FrequenciaDAO;
import controller.TelefoneDAO;
import controller.TurmaDAO;
import controller.UfDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Aluno;
import model.Endereco;
import model.Frequencia;
import model.Telefone;
import model.Turma;
import model.Uf;

/**
 *
 * @author Felipe Rocha Ribeiro
 */
@ManagedBean(name = "alunoMB")
@SessionScoped
public class AlunoMB {

    private Aluno aluno;
    private Endereco endereco;
    private Uf uf;
    private Telefone telefone;
    private Turma turma;
    private Frequencia frequencia;
    
    private AlunoDAO alunoDAO;
    private TurmaDAO turmaDAO;
    private EnderecoDAO enderecoDAO;
    private UfDAO ufDAO;
    private TelefoneDAO telefoneDAO;
    private FrequenciaDAO frequenciaDAO;
    
    private int codTurma;
    private String codUf;
    private int codAluno;
    
    
    private List<Aluno> filtroAlunos;
    private List<Aluno> alunosSelecionados;
    

    public List<Aluno> getAlunosSelecionados() {
        return alunosSelecionados;
    }

    public void setAlunosSelecionados(List<Aluno> alunosSelecionados) {
        this.alunosSelecionados = alunosSelecionados;
    }

    public List<Aluno> getFiltroAlunos() {
        return filtroAlunos;
    }

    public void setFiltroAlunos(List<Aluno> filtroAlunos) {
        this.filtroAlunos = filtroAlunos;
    }

    public int getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(int codAluno) {
        this.codAluno = codAluno;
    }
    
    private List<Aluno> listaAluno;

    public List<Aluno> getListaAluno() {
        return listaAluno;
    }

    public void setListaAluno(List<Aluno> listaAluno) {
        this.listaAluno = listaAluno;
    }

    public Frequencia getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Frequencia frequencia) {
        this.frequencia = frequencia;
    }

        
    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public void mostrarAluno(Aluno aluno){
        this.aluno = aluno;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public String getCodUf() {
        return codUf;
    }

    public void setCodUf(String codUf) {
        this.codUf = codUf;
    }

    public int getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(int codTurma) {
        this.codTurma = codTurma;
    }
    
    

    public AlunoMB() {
        aluno = new Aluno();
        endereco = new Endereco();
        telefone = new Telefone();
        listaAluno = new ArrayList<Aluno>();
    }

    public List<Aluno> findAll() {
        try {
            alunoDAO = new AlunoDAO();
            return alunoDAO.findAll();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public List<Aluno> findByTurma(){
        try {
            turmaDAO = new TurmaDAO();
            alunoDAO = new AlunoDAO();
            listaAluno = alunoDAO.findByTurma(turmaDAO.findById(codTurma));
            
            return listaAluno;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void apagarAluno(Aluno aluno) {
        try {
            alunoDAO.removerAluno(aluno);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String editarAluno() {
        try {
            turmaDAO = new TurmaDAO();
            alunoDAO = new AlunoDAO();
            aluno.setCodturma(turmaDAO.findById(codTurma));
            alunoDAO.salvarAluno(aluno);
        } catch (Exception e) {
            System.out.println(e);
        }
        if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey("alunoMB")){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("alunoMB");
             }
        return "/template.xhtml?faces-redirect=true";
    }
    
    public void registrarFrequencia(){
        try {
            alunoDAO = new AlunoDAO();
            frequenciaDAO = new FrequenciaDAO();
            
            frequencia.setCodaluno(alunoDAO.findById(codAluno));
            
            frequenciaDAO.registrarFrequencia(frequencia);
            
            frequencia = new Frequencia();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String salvarAluno() {
        try {
            turmaDAO = new TurmaDAO();
            alunoDAO = new AlunoDAO();
            enderecoDAO = new EnderecoDAO();
            telefoneDAO = new TelefoneDAO();
            ufDAO = new UfDAO();
            
            endereco.setUf(ufDAO.findById(codUf));
            endereco.setCodaluno(aluno);
            aluno.getEnderecoList().add(endereco);
            telefone.setCodaluno(aluno);
            aluno.getTelefoneList().add(telefone);
            aluno.setCodturma(turmaDAO.findById(codTurma));          

                     
            alunoDAO.salvarAluno(aluno);
            
            aluno = new Aluno();
            endereco = new Endereco();
            telefone = new Telefone();
        } catch (Exception e) {
            System.out.println(e);
        }
           return "/template.xhtml?faces-redirect=true";
    }

    public String removeSessão(){
             if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey("alunoMB")){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("alunoMB");
             }
             return "/template.xhtml?faces-redirect=true";
    }
    
    public String prepararAlterarAluno(Aluno aluno) {
        this.setAluno(aluno);
        this.aluno.setCodaluno(this.getAluno().getCodaluno());

        return "editarAluno.xhtml";
    }

}
