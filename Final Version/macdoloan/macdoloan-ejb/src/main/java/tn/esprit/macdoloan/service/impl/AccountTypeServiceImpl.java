package tn.esprit.macdoloan.service.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.macdoloan.entity.Account;
import tn.esprit.macdoloan.entity.AccountType;
import tn.esprit.macdoloan.service.interf.IAccountTypeServiceLocal;
import tn.esprit.macdoloan.service.interf.IAccountTypeServiceRemote;

@Stateless
public class AccountTypeServiceImpl implements IAccountTypeServiceRemote , IAccountTypeServiceLocal {
	
	@PersistenceContext(unitName="macdoloan-ejb")
	EntityManager em;
	
	public static long getDiffrenceDays(Date d1, Date d2){
		long diff=d2.getTime()-d1.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	@Override
	public int addAccountType(AccountType accounttype) {
		System.out.println("In addAccountType : ");
		em.persist(accounttype);
		System.out.println("Out of addAccountType" + accounttype.getId());
		return accounttype.getId();
	}

	@Override
	public void removeAccountType(int id) {
		em.remove(em.find(AccountType.class, id));
		
	}

	@Override
	public void updateAccountType(AccountType accounttype) {
		AccountType newAccountType =em.find(AccountType.class, accounttype.getId());
		newAccountType.setName(accounttype.getName());
		newAccountType.setInterest(accounttype.getInterest());
		newAccountType.setPeriode(accounttype.getPeriode());
		
	}

	@Override
	public AccountType findAccountTypeById(int id) {
				System.out.println("In findAccountTypeById : ");
				AccountType accounttype = em.find(AccountType.class, id);
				return accounttype;
	}

	@Override
	public List<AccountType> findAllAccountsType() {
		List<AccountType> accountsType = em.createQuery("from AccountType", AccountType.class).getResultList();
		return accountsType;
	}

	@Override
	public AccountType findAccountTypeByName(String name) {
		TypedQuery<AccountType> typeAccount = em.createQuery("select t from AccountType t WHERE t.name=:name",AccountType.class);
		typeAccount.setParameter("name", name);
		System.out.println("Out of findAccountTypeByName : ");
		return typeAccount.getSingleResult();
	}
	
	@Override
	public void AffectTypeToAccount(int IdAccount, int IdType) {
		// TODO Auto-generated method stub
		AccountType TypeManagedEntity = em.find(AccountType.class, IdType);
		Account AccountManagedEntity = em.find(Account.class, IdAccount);
		System.out.println("out of AffectAccountToClient: Account: "+ IdAccount+" Type: "+IdType);
		AccountManagedEntity.setAccType(TypeManagedEntity);		
	}

	@Override
	public float BalanceAfterInterest(Account account,AccountType acctype) {
		float Balance=0;
		Date d=account.getOpeningDate();
        Date today=new Date();
        System.out.println(today);
        System.out.println(d);
		long diffdays = getDiffrenceDays(d,today);
		long nbrOfTimes=diffdays / acctype.getPeriode();
		if (acctype.getName().equals("Current Account"))
		{
		   Balance = account.getBalance()-(acctype.getInterest()*nbrOfTimes);
		}
		else if (acctype.getName().equals("Saving Account")) {
			Balance = account.getBalance()+(acctype.getInterest()*nbrOfTimes);
		}
		return Balance;
	}

}
