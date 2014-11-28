
package view;

import controller.SituacaoDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Situacao;


@ManagedBean
@ViewScoped
public class SituacaoMB {

    private SituacaoDAO situacaoDAO;
    
    private Situacao situacao;
    
    public SituacaoMB() {
        situacao = new Situacao();
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
    
    public List<Situacao> findAll() {
        try {
            situacaoDAO = new SituacaoDAO();
            return situacaoDAO.findAll();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public void apagarSituacao(Situacao situacao) {
        try {
            situacaoDAO.removerSituacao(situacao);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editarSituacao(Situacao situacao) {
        try {
            situacaoDAO.salvarSituacao(situacao);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void salvarSituacao() {
        try {
            
            situacaoDAO = new SituacaoDAO();

            
            situacaoDAO.salvarSituacao(situacao);
            
            situacao = new Situacao();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
}
