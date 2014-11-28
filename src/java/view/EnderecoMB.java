/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.AlunoDAO;
import controller.EnderecoDAO;
import controller.UfDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import model.Aluno;
import model.Endereco;
import model.Telefone;
import model.Uf;

/**
 *
 * @author Felipe Rocha Ribeiro
 */
@ManagedBean
@ViewScoped
public class EnderecoMB {
    
    private Endereco endereco;
    private EnderecoDAO enderecoDAO;
    private Aluno aluno;
    private AlunoDAO alunoDAO;
    private Uf uf;
    private UfDAO ufDAO;
    private AlunoMB alunoMB;
    private Telefone telefone;


    public void mostrarEndereco(Endereco endereco){
        this.endereco = endereco;
    }
    
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    private String codUf;

    public String getCodUf() {
        return codUf;
    }

    public void setCodUf(String codUf) {
        this.codUf = codUf;
    }

    
    
    public EnderecoMB() {
        endereco = new Endereco();
        aluno = new Aluno();
    }
    
    public List<Endereco> findAll() {
          try {
            endereco = new Endereco();
            return enderecoDAO.findAll();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public void apagarEndereco(Endereco endereco) {
        try {
            enderecoDAO.removerEndereco(endereco);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editarEndereco(Endereco endereco) {
        try {
            enderecoDAO.salvarEndereco(endereco);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void salvarEndereco() {
        try {
            enderecoDAO = new EnderecoDAO();
            ufDAO = new UfDAO();
                      
            alunoMB.salvarAluno();
            enderecoDAO.salvarEndereco(endereco);
            endereco = new Endereco();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public String prepararAlterarEndereco(Endereco endereco) {
        this.setEndereco(endereco);
        this.endereco.setCodendereco(this.getEndereco().getCodendereco());

        return "editarEndereco.xhtml";
    }
}
