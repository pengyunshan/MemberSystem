package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consumption_Operate { 
	
	Connection con;
	Statement sql;
	ResultSet rs;
	
	//����һ�����Ѽ�¼
	public boolean addMessage(ConsumptionDetail consumptiondetail) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/dirtyword";
		String user = "root";
		String password = "123456";
		Connection con = null;
		Statement sql;
		boolean flag = false;
		try {
			Class.forName(driver);
			System.out.println("���������ɹ���");
			con = DriverManager.getConnection(url,user,password);
			sql = con.createStatement();
			String string = "insert into cost(Cost,ConsumptionDate,CardNumber) values ('" + consumptiondetail.getCost() + "','"
					+ consumptiondetail.getConsumptionDate() + "',"+ consumptiondetail.getCardNumber()+")";
			sql.executeUpdate(string);
			flag = true;
		} 
		catch (Exception e) {
			System.out.println(e);
			flag = false;
		}
		try {
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}
	//�˷������ڲ�ѯ������Ϣ(�����������ţ���ѯ�����Ѽ�¼)
	
	public StringBuffer queryMessagebynumber(String cardnumber) {
		StringBuffer returnmessage = new StringBuffer("���Ѽ�¼");
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/dirtyword";
		String user = "root";
		String password = "123456";
		Connection con = null;
		Statement sql;
		ResultSet rs;
		try {
			Class.forName(driver);
			System.out.println("���������ɹ���");
			con = DriverManager.getConnection(url,user,password);
			sql = con.createStatement();
			//String str = "SELECT * FROM cost WHERE CardNumber = '"+cardnumber+"';";
			String str = "SELECT * FROM cost WHERE CardNumber = '"+cardnumber+"';";
			rs  = sql.executeQuery(str);
			while(rs.next()){			
				returnmessage.append(rs.getString(1)+"-");
				returnmessage.append(rs.getInt(2)+"-");
				returnmessage.append(rs.getString(3)+"-");
				returnmessage.append(rs.getString(4)+"||");
			}  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return returnmessage;
	}
}