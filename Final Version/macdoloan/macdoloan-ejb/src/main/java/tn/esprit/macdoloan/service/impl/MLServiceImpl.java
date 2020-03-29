package tn.esprit.macdoloan.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.macdoloan.entity.Client;
import tn.esprit.macdoloan.service.interf.IMLServiceLocal;
import tn.esprit.macdoloan.service.interf.IMLServiceRemote;

@Stateless
public class MLServiceImpl implements IMLServiceLocal, IMLServiceRemote {
	@PersistenceContext(unitName = "macdoloan-ejb")
	EntityManager em;
	@Override
	public List<Client> getClients() {
		List<Client> clients = em.createQuery("SELECT u FROM Client u", Client.class).getResultList();
		return clients;	
	}

}
