/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Felipe Rocha Ribeiro
 */
public class Classe {
    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoGerenciamentoEscolarPU");
    protected EntityManager em = emf.createEntityManager();
    protected Query query;
}
