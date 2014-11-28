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
@Table(name = "avaliacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avaliacao.findAll", query = "SELECT a FROM Avaliacao a"),
    @NamedQuery(name = "Avaliacao.findByCodavaliacao", query = "SELECT a FROM Avaliacao a WHERE a.codavaliacao = :codavaliacao"),
    @NamedQuery(name = "Avaliacao.findByNota", query = "SELECT a FROM Avaliacao a WHERE a.nota = :nota")})
public class Avaliacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODAVALIACAO")
    private Integer codavaliacao;
    @Basic(optional = false)
    @Column(name = "NOTA")
    private String nota;
    @JoinColumn(name = "CODMATERIA", referencedColumnName = "CODMATERIA")
    @ManyToOne(optional = false)
    private Materia codmateria;

    public Avaliacao() {
    }

    public Avaliacao(Integer codavaliacao) {
        this.codavaliacao = codavaliacao;
    }

    public Avaliacao(Integer codavaliacao, String nota) {
        this.codavaliacao = codavaliacao;
        this.nota = nota;
    }

    public Integer getCodavaliacao() {
        return codavaliacao;
    }

    public void setCodavaliacao(Integer codavaliacao) {
        this.codavaliacao = codavaliacao;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Materia getCodmateria() {
        return codmateria;
    }

    public void setCodmateria(Materia codmateria) {
        this.codmateria = codmateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codavaliacao != null ? codavaliacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avaliacao)) {
            return false;
        }
        Avaliacao other = (Avaliacao) object;
        if ((this.codavaliacao == null && other.codavaliacao != null) || (this.codavaliacao != null && !this.codavaliacao.equals(other.codavaliacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Avaliacao[ codavaliacao=" + codavaliacao + " ]";
    }
    
}
