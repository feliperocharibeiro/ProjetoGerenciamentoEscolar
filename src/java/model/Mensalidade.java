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
@Table(name = "mensalidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensalidade.findAll", query = "SELECT m FROM Mensalidade m"),
    @NamedQuery(name = "Mensalidade.findByCodmensalidade", query = "SELECT m FROM Mensalidade m WHERE m.codmensalidade = :codmensalidade"),
    @NamedQuery(name = "Mensalidade.findByValormensalidade", query = "SELECT m FROM Mensalidade m WHERE m.valormensalidade = :valormensalidade"),
    @NamedQuery(name = "Mensalidade.findByValorlanche", query = "SELECT m FROM Mensalidade m WHERE m.valorlanche = :valorlanche")})
public class Mensalidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODMENSALIDADE")
    private Integer codmensalidade;
    @Basic(optional = false)
    @Column(name = "VALORMENSALIDADE")
    private double valormensalidade;
    @Basic(optional = false)
    @Column(name = "VALORLANCHE")
    private double valorlanche;
    @JoinColumn(name = "CODSITUACAO", referencedColumnName = "CODSITUACAO")
    @ManyToOne(optional = false)
    private Situacao codsituacao;
    @JoinColumn(name = "CODALUNO", referencedColumnName = "CODALUNO")
    @ManyToOne(optional = false)
    private Aluno codaluno;

    public Mensalidade() {
    }

    public Mensalidade(Integer codmensalidade) {
        this.codmensalidade = codmensalidade;
    }

    public Mensalidade(Integer codmensalidade, double valormensalidade, double valorlanche) {
        this.codmensalidade = codmensalidade;
        this.valormensalidade = valormensalidade;
        this.valorlanche = valorlanche;
    }

    public Integer getCodmensalidade() {
        return codmensalidade;
    }

    public void setCodmensalidade(Integer codmensalidade) {
        this.codmensalidade = codmensalidade;
    }

    public double getValormensalidade() {
        return valormensalidade;
    }

    public void setValormensalidade(double valormensalidade) {
        this.valormensalidade = valormensalidade;
    }

    public double getValorlanche() {
        return valorlanche;
    }

    public void setValorlanche(double valorlanche) {
        this.valorlanche = valorlanche;
    }

    public Situacao getCodsituacao() {
        return codsituacao;
    }

    public void setCodsituacao(Situacao codsituacao) {
        this.codsituacao = codsituacao;
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
        hash += (codmensalidade != null ? codmensalidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensalidade)) {
            return false;
        }
        Mensalidade other = (Mensalidade) object;
        if ((this.codmensalidade == null && other.codmensalidade != null) || (this.codmensalidade != null && !this.codmensalidade.equals(other.codmensalidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Mensalidade[ codmensalidade=" + codmensalidade + " ]";
    }
    
}
