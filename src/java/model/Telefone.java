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
@Table(name = "telefone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefone.findAll", query = "SELECT t FROM Telefone t"),
    @NamedQuery(name = "Telefone.findByCodtelefone", query = "SELECT t FROM Telefone t WHERE t.codtelefone = :codtelefone"),
    @NamedQuery(name = "Telefone.findByTelefone", query = "SELECT t FROM Telefone t WHERE t.telefone = :telefone")})
public class Telefone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODTELEFONE")
    private Integer codtelefone;
    @Basic(optional = false)
    @Column(name = "TELEFONE")
    private String telefone;
    @JoinColumn(name = "CODALUNO", referencedColumnName = "CODALUNO")
    @ManyToOne(optional = false)
    private Aluno codaluno;

    public Telefone() {
    }

    public Telefone(Integer codtelefone) {
        this.codtelefone = codtelefone;
    }

    public Telefone(Integer codtelefone, String telefone) {
        this.codtelefone = codtelefone;
        this.telefone = telefone;
    }

    public Integer getCodtelefone() {
        return codtelefone;
    }

    public void setCodtelefone(Integer codtelefone) {
        this.codtelefone = codtelefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
        hash += (codtelefone != null ? codtelefone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefone)) {
            return false;
        }
        Telefone other = (Telefone) object;
        if ((this.codtelefone == null && other.codtelefone != null) || (this.codtelefone != null && !this.codtelefone.equals(other.codtelefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Telefone[ codtelefone=" + codtelefone + " ]";
    }
    
}
