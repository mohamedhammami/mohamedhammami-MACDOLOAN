package tn.esprit.macdoloan.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Penalty
 *
 */
@Entity
@Table(name = "Penalty")
public class Penalty implements Serializable {
	@ManyToOne
	Installment installment;

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	int id;
	@Column(name = "Amount")
	float amount;
	@Column(name = "RefundDate")
	Date refunddatenddate;

	public Penalty() {
		super();
	}

	public Installment getInstallment() {
		return installment;
	}

	public void setInstallment(Installment installment) {
		this.installment = installment;
	}

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

	@Override
	public String toString() {
		return "Penalty [installment=" + installment + ", id=" + id + ", refunddatenddate=" + refunddatenddate + "]";
	}

}
