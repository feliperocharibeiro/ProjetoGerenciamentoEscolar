/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.TelefoneDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import model.Telefone;


@ManagedBean
@ViewScoped
public class TelefoneMB {

    private Telefone telefone;
    private TelefoneDAO telefoneDAO;
    
    public TelefoneMB() {
        telefone = new Telefone();
    }
    
    public List<Telefone> findAll() {
          try {
            telefone = new Telefone();
            return telefoneDAO.findAll();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
    
    public void apagarTelefone(Telefone telefone) {
        try {
            telefoneDAO.removerTelefone(telefone);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editarTelefone(Telefone telefone) {
        try {
            telefoneDAO.salvarTelefone(telefone);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void salvarTelefone() {
        try {
            telefoneDAO.salvarTelefone(telefone);
            telefone = new Telefone();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
}
