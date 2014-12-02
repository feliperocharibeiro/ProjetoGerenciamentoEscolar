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
@Table(name = "materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m"),
    @NamedQuery(name = "Materia.findByCodmateria", query = "SELECT m FROM Materia m WHERE m.codmateria = :codmateria"),
    @NamedQuery(name = "Materia.findByDescricao", query = "SELECT m FROM Materia m WHERE m.descricao = :descricao")})
public class Materia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODMATERIA")
    private Integer codmateria;
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmateria")
    private List<MateriaAluno> materiaAlunoList;

    public Materia() {
    }

    public Materia(Integer codmateria) {
        this.codmateria = codmateria;
    }

    public Materia(Integer codmateria, String descricao) {
        this.codmateria = codmateria;
        this.descricao = descricao;
    }

    public Integer getCodmateria() {
        return codmateria;
    }

    public void setCodmateria(Integer codmateria) {
        this.codmateria = codmateria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<MateriaAluno> getMateriaAlunoList() {
        return materiaAlunoList;
    }

    public void setMateriaAlunoList(List<MateriaAluno> materiaAlunoList) {
        this.materiaAlunoList = materiaAlunoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmateria != null ? codmateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.codmateria == null && other.codmateria != null) || (this.codmateria != null && !this.codmateria.equals(other.codmateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Materia[ codmateria=" + codmateria + " ]";
    }

    
}
