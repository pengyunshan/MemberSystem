package database;

public class ConsumptionDetail {
	private String CardNumber;
	private int Cost;
	private String ConsumptionDate;
	public ConsumptionDetail(String cardnumber,int cost,String consumptiondate)
	{
		this.CardNumber = cardnumber;
		this.Cost = cost;
		this.ConsumptionDate = consumptiondate;
	}
	
	public String getCardNumber(){
		return CardNumber;
	}
	public void setCardNumber(String cardnumber){
		this.CardNumber = cardnumber;
	}
	public int getCost(){
		return Cost;
	}
	public void setCost(int cost){
		this.Cost = cost;
	}
	public String getConsumptionDate(){
		return ConsumptionDate;
	}
	public void setConsumptionDate(String consumptiondate){
		this.ConsumptionDate = consumptiondate;
	}
}