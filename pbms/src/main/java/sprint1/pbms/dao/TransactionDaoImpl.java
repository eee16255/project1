package sprint1.pbms.dao;

//import java.util.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import sprint1.pbms.model.Transaction;
import sprint1.pbms.model.TransactionUsingSlip;

public class TransactionDaoImpl implements TransactionDao{
	Map<String,TransactionUsingSlip> transaction=new HashMap<String,TransactionUsingSlip>();
	public TransactionDaoImpl() {
		addSomeAccountDetails();
	}
	public void addSomeAccountDetails() {
		TransactionUsingSlip ta1=new TransactionUsingSlip("Rebeca","123456789012",2000,
				Arrays.asList(new Transaction("1000000001L",LocalDate.now())));
		TransactionUsingSlip ta2=new TransactionUsingSlip("Prameela","987654321012",3000,
				Arrays.asList(new Transaction("1000000002L",LocalDate.now())));
		transaction.put(ta1.getAccountNumber(), ta1);
		transaction.put(ta2.getAccountNumber(), ta2);
		
	}

	public boolean addAcountDetails(TransactionUsingSlip accountDetails) {
		if(transaction.containsKey(accountDetails)) {
			return false;
		}
		transaction.put(accountDetails.getAccountNumber(), accountDetails);
		return true;
		
	}
    
	public boolean creditUsingSlip(String userName, String accountNumber,double amount) {
		//int amount=1000;
	try {
			if(amount<=100||amount>=100000) {
				throw new Exception("Insufficient");
			}
		else if((accountNumber).length()!=12){
			throw new Exception("Invalid account number");
		}
	
			addAmount( accountNumber, amount) ;
	System.out.println("Deposited"+amount+".rs Successfully total amount"+getBalanceById( accountNumber));
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	return false;
	}

	public boolean debitUsingSlip(String userName, String accountNumber,double amount) {
		//int amount=10000;
		try {
			if(amount<=100||amount>=100000) {
				throw new Exception("Insufficient");
			}
		else if((accountNumber).length()!=12){
			throw new Exception("Invalid account number");
		}
	
			deductAmount(accountNumber, amount);
	System.out.println("withdrawn"+amount+".rs Successfully total amount"+  getBalanceById( accountNumber));
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	return false;
		
	}

	public int getBalanceById(String accountNumber) {
		if(!transaction.containsKey(accountNumber)) {
			System.out.println("No Account Found");
			return 0;
		}
		TransactionUsingSlip b=transaction.get(accountNumber);
		return (int) b.getBalance();
	}

	public boolean updateAccountBalance(TransactionUsingSlip accountDetails, double amount) {
		if(!transaction.containsKey(accountDetails.getAccountNumber())) {
		return false;
	}
		
//		TransactionUsngSlip transToUpdate=transaction.get(accountNumber.getBalanceById());
//		transToUpdate.setBalance(accountNumber.getBalance());
		
			
		return true;
	}
	
	public boolean deductAmount(String accountNumber,double amount) {
		if(!transaction.containsKey(accountNumber)) {
			return false;
		}
		TransactionUsingSlip acc=transaction.get(accountNumber);
		acc.setBalance(acc.getBalance()-amount);
		return true;
	}

public boolean addAmount(String accountNumber,double amount) {
	if(!transaction.containsKey(accountNumber)) {
		return false;
	}
	TransactionUsingSlip acc=transaction.get(accountNumber);
	acc.setBalance(acc.getBalance()+amount);
	return true;
}
}
class amountLessException extends Exception{
	amountLessException(String msg){
		super(msg);
	}
}
class AccountException extends Exception{
	AccountException(String msg){
		super(msg);
	}

}