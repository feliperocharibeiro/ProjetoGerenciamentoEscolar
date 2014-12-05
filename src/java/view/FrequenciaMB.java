/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.AlunoDAO;
import controller.FrequenciaDAO;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Aluno;
import model.Frequencia;

/**
 *
 * @author Felipe Rocha Ribeiro
 */
@ManagedBean
@ViewScoped
public class FrequenciaMB {
    
    private Frequencia frequencia;
    private Aluno aluno;
    
    private FrequenciaDAO frequenciaDAO;
    private AlunoDAO alunoDAO;
    
    private int codAluno;
    
    private Date dataAula;
    
    @ManagedProperty(value="#{alunoMB}")
    private AlunoMB alunoMB;

    public Date getDataAula() {
        return dataAula;
    }

    public void setDataAula(Date dataAula) {
        this.dataAula = dataAula;
    }
    
    
    public AlunoMB getAlunoMB() {
        return alunoMB;
    }

    public void setAlunoMB(AlunoMB alunoMB) {
        this.alunoMB = alunoMB;
    }
    
    
    private List<Frequencia> listaFrequencia;

    public List<Frequencia> getListaFrequencia() {
        return listaFrequencia;
    }

    public void setListaFrequencia(List<Frequencia> listaFrequencia) {
        this.listaFrequencia = listaFrequencia;
    }

    public int getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(int codAluno) {
        this.codAluno = codAluno;
    }

    public FrequenciaMB() {
        frequencia = new Frequencia();
    }

    public Frequencia getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Frequencia frequencia) {
        this.frequencia = frequencia;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public List<Frequencia> findAll() {
        try {
            frequenciaDAO = new FrequenciaDAO();
            return frequenciaDAO.findAll();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public List<Frequencia> findByCodAluno(){
        try {
            alunoDAO = new AlunoDAO();
            frequenciaDAO = new FrequenciaDAO();
            return frequenciaDAO.findBycodAluno(alunoDAO.findById(codAluno));
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        
    }
    
    public void apagarFrequencia(Frequencia frequencia) {
        try {
            frequenciaDAO.removerFrequencia(frequencia);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editarFrequencia(Frequencia frequencia) {
        try {
            frequenciaDAO.registrarFrequencia(frequencia);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public String registrarFrequencia() {
        try {
            
            frequenciaDAO = new FrequenciaDAO();
            alunoDAO = new AlunoDAO();
            
            List<Aluno> lista = alunoMB.getListaAluno();

            for(Aluno a:lista){

                frequencia.setCodaluno(a);
                frequencia.setDescricao(a.isDescricao());
                frequencia.setDataaula(dataAula);
                frequenciaDAO.registrarFrequencia(frequencia);
                frequencia = new Frequencia();
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return "/template.xhtml?faces-redirect=true";
    }
    public String removeSessão(){
             if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey("FrequenciaMB")){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("FrequenciaMB");
             }
             return "/template.xhtml?faces-redirect=true";
    }
}
