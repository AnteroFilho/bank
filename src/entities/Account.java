package entities;

public class Account {
	
	public String name;
	public Integer accNumber;
	public String password;
	public Double balance;
	
	public Account() {
	}	
	
	public Account(String name, Integer accNumber, String password, Double balance) {
		this.name = name;
		this.accNumber = accNumber;
		this.password = password;
		this.balance = balance;
	}
	
	public Account(Integer accNumber,String password) {
		this.accNumber = accNumber;
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(Integer accNumber) {
		this.accNumber = accNumber;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}	
	
	public String getPassword() {
		return this.password;
	}
	
	public Double getBalance() {
		return balance;
	}	
	
	public void deposit(Double value) {
		balance += value;
	}
	
	public void withDraw(double value) {
		balance-= value;
	}
	
	public boolean checkAcc(int acc) {
		if(this.accNumber == acc) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean checkPss(String pss) {
		if(this.password == pss) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", accNumber=" + accNumber + ", balance=" + balance + "]";
	}
	
	
	

}
