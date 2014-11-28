/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
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
@Table(name = "situacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Situacao.findAll", query = "SELECT s FROM Situacao s"),
    @NamedQuery(name = "Situacao.findByCodsituacao", query = "SELECT s FROM Situacao s WHERE s.codsituacao = :codsituacao"),
    @NamedQuery(name = "Situacao.findByDescricao", query = "SELECT s FROM Situacao s WHERE s.descricao = :descricao")})
public class Situacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODSITUACAO")
    private Integer codsituacao;
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codsituacao")
    private List<Mensalidade> mensalidadeList;

    public Situacao() {
    }

    public Situacao(Integer codsituacao) {
        this.codsituacao = codsituacao;
    }

    public Situacao(Integer codsituacao, String descricao) {
        this.codsituacao = codsituacao;
        this.descricao = descricao;
    }

    public Integer getCodsituacao() {
        return codsituacao;
    }

    public void setCodsituacao(Integer codsituacao) {
        this.codsituacao = codsituacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Mensalidade> getMensalidadeList() {
        return mensalidadeList;
    }

    public void setMensalidadeList(List<Mensalidade> mensalidadeList) {
        this.mensalidadeList = mensalidadeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codsituacao != null ? codsituacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Situacao)) {
            return false;
        }
        Situacao other = (Situacao) object;
        if ((this.codsituacao == null && other.codsituacao != null) || (this.codsituacao != null && !this.codsituacao.equals(other.codsituacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Situacao[ codsituacao=" + codsituacao + " ]";
    }
    
}
