package tn.esprit.macdoloan.service.interf;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.macdoloan.entity.Client;

@Remote
public interface IMLServiceRemote {
	List<Client> getClients();
}
