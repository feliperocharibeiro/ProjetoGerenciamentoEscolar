/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Felipe Rocha Ribeiro
 */
@Entity
@Table(name = "aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a"),
    @NamedQuery(name = "Aluno.findByTurma", query = "SELECT a FROM Aluno a WHERE a.codturma = :codturma ORDER BY a.nome"),
    @NamedQuery(name = "Aluno.findByCodaluno", query = "SELECT a FROM Aluno a WHERE a.codaluno = :codaluno"),
    @NamedQuery(name = "Aluno.findByNome", query = "SELECT a FROM Aluno a WHERE a.nome = :nome"),
    @NamedQuery(name = "Aluno.findBySexo", query = "SELECT a FROM Aluno a WHERE a.sexo = :sexo"),
    @NamedQuery(name = "Aluno.findByDatanascimento", query = "SELECT a FROM Aluno a WHERE a.datanascimento = :datanascimento"),
    @NamedQuery(name = "Aluno.findByNomeresponsavel", query = "SELECT a FROM Aluno a WHERE a.nomeresponsavel = :nomeresponsavel"),
    @NamedQuery(name = "Aluno.findByCpfresponsavel", query = "SELECT a FROM Aluno a WHERE a.cpfresponsavel = :cpfresponsavel")})
public class Aluno implements Serializable {
    @Column(name = "nota")
    private String nota;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codaluno")
    private List<Telefone> telefoneList = new ArrayList<Telefone>();
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODALUNO")
    private Integer codaluno;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @Column(name = "SEXO")
    private String sexo;
    @Basic(optional = false)
    @Column(name = "DATANASCIMENTO")
    private String datanascimento;
    @Basic(optional = false)
    @Column(name = "NOMERESPONSAVEL")
    private String nomeresponsavel;
    @Basic(optional = false)
    @Column(name = "CPFRESPONSAVEL")
    private String cpfresponsavel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codaluno")
    private List<Frequencia> frequenciaList = new ArrayList<Frequencia>();
    @JoinColumn(name = "CODTURMA", referencedColumnName = "CODTURMA")
    @ManyToOne(optional = false)
    private Turma codturma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codaluno")
    private List<MateriaAluno> materiaAlunoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codaluno")
    private List<Endereco> enderecoList = new ArrayList<Endereco>();
    @Basic(optional = true)
    @Column(name = "DESCRICAO")
    private boolean descricao;

    public boolean isDescricao() {
        return descricao;
    }

    public void setDescricao(boolean descricao) {
        this.descricao = descricao;
    }

        
    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
        
    public Aluno() {
        this.enderecoList = new ArrayList<Endereco>();
    }

    public Aluno(Integer codaluno) {
        this.enderecoList = new ArrayList<Endereco>();
        this.codaluno = codaluno;
    }

    public Aluno(Integer codaluno, String nome, String sexo, String datanascimento, String nomeresponsavel, String cpfresponsavel) {
        this.enderecoList = new ArrayList<Endereco>();
        this.codaluno = codaluno;
        this.nome = nome;
        this.sexo = sexo;
        this.datanascimento = datanascimento;
        this.nomeresponsavel = nomeresponsavel;
        this.cpfresponsavel = cpfresponsavel;
    }

    public Integer getCodaluno() {
        return codaluno;
    }

    public void setCodaluno(Integer codaluno) {
        this.codaluno = codaluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getNomeresponsavel() {
        return nomeresponsavel;
    }

    public void setNomeresponsavel(String nomeresponsavel) {
        this.nomeresponsavel = nomeresponsavel;
    }

    public String getCpfresponsavel() {
        return cpfresponsavel;
    }

    public void setCpfresponsavel(String cpfresponsavel) {
        this.cpfresponsavel = cpfresponsavel;
    }

    @XmlTransient
    public List<Frequencia> getFrequenciaList() {
        return frequenciaList;
    }

    public void setFrequenciaList(List<Frequencia> frequenciaList) {
        this.frequenciaList = frequenciaList;
    }

    public Turma getCodturma() {
        return codturma;
    }

    public void setCodturma(Turma codturma) {
        this.codturma = codturma;
    }

    @XmlTransient
    public List<MateriaAluno> getMateriaAlunoList() {
        return materiaAlunoList;
    }

    public void setMateriaAlunoList(List<MateriaAluno> materiaAlunoList) {
        this.materiaAlunoList = materiaAlunoList;
    }

    @XmlTransient
    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codaluno != null ? codaluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.codaluno == null && other.codaluno != null) || (this.codaluno != null && !this.codaluno.equals(other.codaluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Aluno[ codaluno=" + codaluno + " ]";
    }

    @XmlTransient
    public List<Telefone> getTelefoneList() {
        return telefoneList;
    }

    public void setTelefoneList(List<Telefone> telefoneList) {
        this.telefoneList = telefoneList;
    }

        
}
