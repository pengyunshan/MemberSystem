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
	
	//增加一条消费记录
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
			System.out.println("加载驱动成功！");
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
	//此方法用于查询单个信息(给出参数卡号，查询到消费记录)
	
	public StringBuffer queryMessagebynumber(String cardnumber) {
		StringBuffer returnmessage = new StringBuffer("消费记录");
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/dirtyword";
		String user = "root";
		String password = "123456";
		Connection con = null;
		Statement sql;
		ResultSet rs;
		try {
			Class.forName(driver);
			System.out.println("加载驱动成功！");
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