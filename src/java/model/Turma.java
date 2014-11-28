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
@Table(name = "turma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turma.findAll", query = "SELECT t FROM Turma t"),
    @NamedQuery(name = "Turma.listaAlunoPorTurma", query = "SELECT t FROM Turma t WHERE t.codturma = :codturma"),
    @NamedQuery(name = "Turma.findByCodturma", query = "SELECT t FROM Turma t WHERE t.codturma = :codturma"),
    @NamedQuery(name = "Turma.findByDescricao", query = "SELECT t FROM Turma t WHERE t.descricao = :descricao")})
public class Turma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODTURMA")
    private Integer codturma;
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codturma")
    private List<Aluno> alunoList = new ArrayList<Aluno>();

    public Turma() {
    }

    public Turma(Integer codturma) {
        this.codturma = codturma;
    }

    public Turma(Integer codturma, String descricao) {
        this.codturma = codturma;
        this.descricao = descricao;
    }

    public Integer getCodturma() {
        return codturma;
    }

    public void setCodturma(Integer codturma) {
        this.codturma = codturma;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Aluno> getAlunoList() {
        return alunoList;
    }

    public void setAlunoList(List<Aluno> alunoList) {
        this.alunoList = alunoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codturma != null ? codturma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turma)) {
            return false;
        }
        Turma other = (Turma) object;
        if ((this.codturma == null && other.codturma != null) || (this.codturma != null && !this.codturma.equals(other.codturma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Turma[ codturma=" + codturma + " ]";
    }
    
}
