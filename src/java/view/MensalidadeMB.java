
package view;

import controller.MensalidadeDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Mensalidade;

@ManagedBean
@ViewScoped
public class MensalidadeMB {

    private MensalidadeDAO mensalidadeDAO;
    
    private Mensalidade mensalidade;
    
    public MensalidadeMB() {
        mensalidade = new Mensalidade();
    }

    public Mensalidade getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(Mensalidade mensalidade) {
        this.mensalidade = mensalidade;
    }
    
    public List<Mensalidade> findAll() {
        try {
            mensalidadeDAO = new MensalidadeDAO();
            return mensalidadeDAO.findAll();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public void apagarMensalidade(Mensalidade mensalidade) {
        try {
            mensalidadeDAO.removerMensalidade(mensalidade);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editarMensalidade(Mensalidade mensalidade) {
        try {
            mensalidadeDAO.salvarMensalidade(mensalidade);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void salvarMensalidade() {
        try {
            
            mensalidadeDAO = new MensalidadeDAO();

            
            mensalidadeDAO.salvarMensalidade(mensalidade);
            
            mensalidade = new Mensalidade();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
