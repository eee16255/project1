package sprint1.pbms.service;

import sprint1.pbms.dao.TransactionDao;
import sprint1.pbms.dao.TransactionDaoImpl;

public class TransactionServiceImpl implements TransactionService {
	TransactionDao transactiondao=new TransactionDaoImpl();

	public boolean creditUsingSlip(String userName, String accountNumber,double amount) {
		// TODO Auto-generated method stub
		return transactiondao.creditUsingSlip(userName,accountNumber,amount);
	}

	public boolean debitUsingSlip(String userName, String accountNumber,double amount) {
		// TODO Auto-generated method stub
		return transactiondao.debitUsingSlip(userName, accountNumber,amount);
	}

}
