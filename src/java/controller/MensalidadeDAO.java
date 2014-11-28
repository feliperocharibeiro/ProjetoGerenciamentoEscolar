

package controller;

import Util.Classe;
import java.util.List;
import model.Mensalidade;

public class MensalidadeDAO extends Classe {
    public void salvarMensalidade(Mensalidade mensalidade){
        em.getTransaction().begin();
        em.merge(mensalidade);
        em.getTransaction().commit();
    }
    public void removerMensalidade(Mensalidade mensalidade){
        em.getTransaction().begin();
        em.remove(mensalidade);
        em.getTransaction().commit();
    }
    public List<Mensalidade> findAll(){
        em.getTransaction().begin();
        query = em.createQuery("SELECT m FROM Mensalidade m");
        em.getTransaction().commit();
        return query.getResultList();
    }
}
