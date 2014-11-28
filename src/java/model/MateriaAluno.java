/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe Rocha Ribeiro
 */
@Entity
@Table(name = "materia_aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MateriaAluno.findAll", query = "SELECT m FROM MateriaAluno m"),
    @NamedQuery(name = "MateriaAluno.findByIdmateriaaluno", query = "SELECT m FROM MateriaAluno m WHERE m.idmateriaaluno = :idmateriaaluno")})
public class MateriaAluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMATERIAALUNO")
    private Integer idmateriaaluno;
    @JoinColumn(name = "CODMATERIA", referencedColumnName = "CODMATERIA")
    @ManyToOne(optional = false)
    private Materia codmateria;
    @JoinColumn(name = "CODALUNO", referencedColumnName = "CODALUNO")
    @ManyToOne(optional = false)
    private Aluno codaluno;

    public MateriaAluno() {
    }

    public MateriaAluno(Integer idmateriaaluno) {
        this.idmateriaaluno = idmateriaaluno;
    }

    public Integer getIdmateriaaluno() {
        return idmateriaaluno;
    }

    public void setIdmateriaaluno(Integer idmateriaaluno) {
        this.idmateriaaluno = idmateriaaluno;
    }

    public Materia getCodmateria() {
        return codmateria;
    }

    public void setCodmateria(Materia codmateria) {
        this.codmateria = codmateria;
    }

    public Aluno getCodaluno() {
        return codaluno;
    }

    public void setCodaluno(Aluno codaluno) {
        this.codaluno = codaluno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmateriaaluno != null ? idmateriaaluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaAluno)) {
            return false;
        }
        MateriaAluno other = (MateriaAluno) object;
        if ((this.idmateriaaluno == null && other.idmateriaaluno != null) || (this.idmateriaaluno != null && !this.idmateriaaluno.equals(other.idmateriaaluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.MateriaAluno[ idmateriaaluno=" + idmateriaaluno + " ]";
    }
    
}
