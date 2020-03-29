
package tn.esprit.macdoloan.managedbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tn.esprit.macdoloan.entity.Installment;
import tn.esprit.macdoloan.entity.Penalty;
import tn.esprit.macdoloan.service.impl.LoanServiceImpl;
import tn.esprit.macdoloan.service.impl.UserService;

@ManagedBean
@SessionScoped
public class penalityBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private float amount;
	private Date refunddatenddate;
	private Installment installment;
	@EJB
	LoanServiceImpl loanservice;
	@EJB
	UserService userservice;
	private List<Penalty> penalitys;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getRefunddatenddate() {
		return refunddatenddate;
	}

	public void setRefunddatenddate(Date refunddatenddate) {
		this.refunddatenddate = refunddatenddate;
	}

	public Installment getInstallment() {
		return installment;
	}

	public void setInstallment(Installment installment) {
		this.installment = installment;
	}

	public LoanServiceImpl getLoanservice() {
		return loanservice;
	}

	public void setLoanservice(LoanServiceImpl loanservice) {
		this.loanservice = loanservice;
	}

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	public List<Penalty> getPenalitys() {
		return penalitys;
	}

	public void setPenalitys(List<Penalty> penalitys) {
		this.penalitys = penalitys;
	}

	public String putPenality(int i) {
		penalitys = loanservice.findAllPenalityByInstallmentId(i);
		String navigateTo = "penality.jsf?faces-redirect=true";
		return navigateTo;
	}

}
