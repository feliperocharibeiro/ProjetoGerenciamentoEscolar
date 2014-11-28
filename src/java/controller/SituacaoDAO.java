
package controller;

import Util.Classe;
import java.util.List;
import model.Situacao;


public class SituacaoDAO extends Classe {
    public void salvarSituacao(Situacao situacao){
        em.getTransaction().begin();
        em.merge(situacao);
        em.getTransaction().commit();
    }
    public void removerSituacao(Situacao situacao){
        em.getTransaction().begin();
        em.remove(situacao);
        em.getTransaction().commit();
    }
    public List<Situacao> findAll(){
        em.getTransaction().begin();
        query = em.createQuery("SELECT s FROM Situacao s");
        em.getTransaction().commit();
        return query.getResultList();
    }
}
