/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.AvaliacaoDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Avaliacao;

/**
 *
 * @author Felipe Rocha Ribeiro
 */
@ManagedBean
@ViewScoped
public class AvaliacaoMB {

    private AvaliacaoDAO avaliacaoDAO;
    
    private Avaliacao avaliacao;
    
    public AvaliacaoMB() {
        avaliacao = new Avaliacao();
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    public List<Avaliacao> findAll() {
        try {
            avaliacaoDAO = new AvaliacaoDAO();
            return avaliacaoDAO.findAll();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public void apagarAvaliacao(Avaliacao avaliacao) {
        try {
            avaliacaoDAO.removerAvaliacao(avaliacao);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editarAvaliacao(Avaliacao avaliacao) {
        try {
            avaliacaoDAO.salvarAvaliacao(avaliacao);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void salvarAvaliacao() {
        try {
            
            avaliacaoDAO = new AvaliacaoDAO();

            
            avaliacaoDAO.salvarAvaliacao(avaliacao);
            
            avaliacao = new Avaliacao();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
}
