/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.UfDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import model.Uf;

/**
 *
 * @author Felipe Rocha Ribeiro
 */
@ManagedBean
@ViewScoped
public class UfMB {

    private Uf uf;
    private UfDAO ufDAO;
    
    public void mostrarUf(Uf uf){
        this.uf = uf;
    }
    
    public UfMB() {
        uf = new Uf();
    }
    
    public List<Uf> findAll() {
          try {
            uf = new Uf();
            return ufDAO.findAll();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }
    
    public void apagarUf(Uf uf) {
        try {
            ufDAO.removerUf(uf);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editarUf(Uf uf) {
        try {
            ufDAO.salvarUf(uf);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void salvarUf() {
        try {
            ufDAO.salvarUf(uf);
            uf = new Uf();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
}
