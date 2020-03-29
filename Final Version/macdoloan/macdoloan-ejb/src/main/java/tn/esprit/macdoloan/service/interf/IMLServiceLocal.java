package tn.esprit.macdoloan.service.interf;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.macdoloan.entity.Client;

@Local
public interface IMLServiceLocal {
	List<Client> getClients();
}
