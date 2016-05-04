package database;

public class CardDetail {
	private String CardNumber;
	private String Password;
	private String UserName;
	private String Name;
	private String ID;
	private String Tel;
	private String State;
	private int Balance;	
	private String ActivateDate;	
	private String Validity;

	public CardDetail(String cardnumber,  String password, String username,  
			String name,String id,  String tel,	String state,  
			int balance, String activatedate, String validity) 
	{
		this.CardNumber = cardnumber;
		this.Password = password;
		this.Name = name;
		this.UserName = username;
		this.ID = id;
		this.Tel = tel;
		this.State = state;
		this.Balance = balance;
		this.ActivateDate = activatedate;
		this.Validity = validity;
	}
	public String getCardNumber(){
		return CardNumber;
	}
	public String getPassword(){
		return Password;
	}
	public String getUserName(){
		return UserName;
	}
	public String getName(){
		return Name;
	}
	public String getID(){
		return ID;
	}
	public String getTel(){
		return Tel;
	}
	public int getBalance(){
		return Balance;
	}
	public String getState(){
		return State;
	}
	public String getActivateDate(){
		return ActivateDate;
	}
	public String getValidity(){
		return Validity;
	}
	public void setPassword(String password){
		this.Password = password;
	}
	public void setUserName(String username){
		this.UserName = username;
	}
	public void setName(String name){
		this.Name = name;
	}
	public void setID(String id){
		this.ID = id;
	}
	public void setTel(String tel){
		this.Tel = tel;
	}
	public void setBalance(int balance){
		this.Balance = balance;
	}
	public void setState(String state){
		this.State = state;
	}
	public void setActivateDate(String activitedate){
		this.ActivateDate = activitedate;
	}
	public void setValidity(String validity){
		this.Validity = validity;
	}
}