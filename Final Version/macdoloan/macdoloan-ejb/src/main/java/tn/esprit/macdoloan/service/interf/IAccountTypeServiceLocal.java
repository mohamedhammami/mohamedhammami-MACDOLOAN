package tn.esprit.macdoloan.service.interf;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.macdoloan.entity.Account;
import tn.esprit.macdoloan.entity.AccountType;

@Local
public interface IAccountTypeServiceLocal {

	public int addAccountType(AccountType accounttype);

	public void removeAccountType(int id);

	public void updateAccountType(AccountType accounttype);

	public AccountType findAccountTypeById(int id);

	public List<AccountType> findAllAccountsType();
	
	public AccountType findAccountTypeByName(String name);
	
	public void AffectTypeToAccount(int IdAccount, int IdType);
	
	public float BalanceAfterInterest(Account account,AccountType acctype);
}
