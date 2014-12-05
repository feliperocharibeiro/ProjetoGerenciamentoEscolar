/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe Rocha Ribeiro
 */
@Entity
@Table(name = "frequencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Frequencia.findAll", query = "SELECT f FROM Frequencia f"),
    @NamedQuery(name = "Frequencia.findByCodAluno", query = "SELECT f FROM Frequencia f WHERE f.codaluno = :codaluno"),
    @NamedQuery(name = "Frequencia.findByCodfrequencia", query = "SELECT f FROM Frequencia f WHERE f.codfrequencia = :codfrequencia"),
    @NamedQuery(name = "Frequencia.findByDescricao", query = "SELECT f FROM Frequencia f WHERE f.descricao = :descricao"),
    @NamedQuery(name = "Frequencia.findByDataaula", query = "SELECT f FROM Frequencia f WHERE f.dataaula = :dataaula")})
public class Frequencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODFREQUENCIA")
    private Integer codfrequencia;
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private boolean descricao;
    @Basic(optional = false)
    @Column(name = "DATAAULA")
    @Temporal(TemporalType.DATE)
    private Date dataaula;
    @JoinColumn(name = "CODALUNO", referencedColumnName = "CODALUNO")
    @ManyToOne(optional = false)
    private Aluno codaluno;

    public Frequencia() {
    }

    public Frequencia(Integer codfrequencia) {
        this.codfrequencia = codfrequencia;
    }

    public Frequencia(Integer codfrequencia, boolean descricao, Date dataaula) {
        this.codfrequencia = codfrequencia;
        this.descricao = descricao;
        this.dataaula = dataaula;
    }

    public Integer getCodfrequencia() {
        return codfrequencia;
    }

    public void setCodfrequencia(Integer codfrequencia) {
        this.codfrequencia = codfrequencia;
    }

    public boolean getDescricao() {
        return descricao;
    }

    public void setDescricao(boolean descricao) {
        this.descricao = descricao;
    }

    public Date getDataaula() {
        return dataaula;
    }

    public void setDataaula(Date dataaula) {
        this.dataaula = dataaula;
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
        hash += (codfrequencia != null ? codfrequencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Frequencia)) {
            return false;
        }
        Frequencia other = (Frequencia) object;
        if ((this.codfrequencia == null && other.codfrequencia != null) || (this.codfrequencia != null && !this.codfrequencia.equals(other.codfrequencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Frequencia[ codfrequencia=" + codfrequencia + " ]";
    }
    
}
