package sprint1.pbms.service;

public interface TransactionService {
	public boolean creditUsingSlip(String userName,String accountNumber,double balance);
	public boolean debitUsingSlip(String userName,String accountNumber,double balance);

}
