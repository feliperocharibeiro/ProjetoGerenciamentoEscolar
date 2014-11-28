
import Util.Classe;
import java.util.List;
import model.Aluno;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Felipe Rocha Ribeiro
 */
public class Teste extends Classe {

    public List<Aluno> lista() {
        em.getTransaction().begin();
        query = em.createNamedQuery("Aluno.findAll");
        em.getTransaction().commit();
        return query.getResultList();
    }

    public static void main(String[] args) {
        Teste teste= new Teste();
        System.out.println(teste.lista().get(0).getNome());
    }
}
