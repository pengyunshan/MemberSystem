package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Card_Operate { 
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://127.0.0.1:3306/dirtyword";
	String user = "root";
	String password = "123456";
	Connection con;
	Statement sql;
	ResultSet rs;
	public String username;
	public String name;
	public String id;
	public String tel;
	public int balance;
	public String state;
	public String validity;
	//发卡
	public void issuecard(CardDetail carddetail){
		String str = "insert into card values ('"+ carddetail.getCardNumber()
		+ "','" + carddetail.getPassword() + "' , '" + carddetail.getUserName()+ "','"
		+ carddetail.getName() + "','" + carddetail.getID() + "','" + 
		carddetail.getTel() + "','" + carddetail.getBalance() + "','" + carddetail.getState() 
		+ "', '" + carddetail.getActivateDate()+ "', '" + carddetail.getValidity()+ "')";
		System.out.println(str);
		try{
			Class.forName(driver);
			System.out.println("加载驱动成功！");
			con = DriverManager.getConnection(url,user,password);
			sql = con.createStatement();
			sql.execute(str);
		}
		catch(ClassNotFoundException e)
		{	e.printStackTrace();
			System.out.println("加载驱动失败！");
		}
		catch(SQLException ee){
			ee.printStackTrace();
			System.out.println("数据库连接失败！");
		}
		try {
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	//状态控制
	public void stateControl(String cardnumber,String state){
		String str = "UPDATE card SET State = '" + state + "' WHERE CardNumber = '"+cardnumber+"';";
		try {
			Class.forName(driver);
			System.out.println("加载驱动成功！");
			con = DriverManager.getConnection(url,user,password);
			sql = con.createStatement();
			sql.executeUpdate(str);
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
	}
	//充值
	public void recharge(String cardnumber,int money){
		String getBalance = "SELECT Balance FROM card WHERE CardNumber = '"+cardnumber+"';";
		int oldBalance = 0;
		try {
			Class.forName(driver);
			System.out.println("加载驱动成功！");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dirtyword","root","123456");
			sql = con.createStatement();
			rs = sql.executeQuery(getBalance);
			while(rs.next()){
				 oldBalance = Integer.parseInt(rs.getString(1));
			}
			int newBalance = oldBalance + money;
			String update = "UPDATE card SET Balance = "+newBalance+" WHERE CardNumber = '"+cardnumber+"';";
			sql.executeUpdate(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//登陆时验证密码
	public boolean verfyPassword(String cardnumber,String inputpassword){
		Boolean verfy = false;
		String str = "SELECT * from card where CardNumber = "+ cardnumber+";";
		try {
			Class.forName(driver);
			System.out.println("加载驱动成功！");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dirtyword","root","123456");
			sql = con.createStatement();
			sql.execute(str);
			rs = sql.executeQuery(str);
			while(rs.next()){
				if( rs.getString("Password").equals(inputpassword))
					{verfy = true;}
				else
					{verfy =  false;
					}
			username = rs.getString("UserName");
			name = rs.getString("Name");
			id = rs.getString("ID");
			tel = rs.getString("Tel");
			balance = rs.getInt("Balance");
			state = rs.getString("State");
			validity = rs.getString("Validity");
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return verfy;
	}
	//显示余额
	public String getBalance(String cardnumber){
		String balance = "";
		try {
			Class.forName(driver);
			System.out.println("加载驱动成功！");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dirtyword","root","123456");
			sql=con.createStatement();
			String str = "SELECT Balance FROM card WHERE CardNumber = '" + cardnumber + "';"; 
			rs = sql.executeQuery(str);
			while(rs.next()){
				balance = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return balance;
	}
	//修改密码
	public boolean modifyPassword(String cardnumber,String newpassword){
		try {
			Class.forName(driver);
			System.out.println("加载驱动成功！");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dirtyword","root","123456");
			sql = con.createStatement();
			String str = "UPDATE  card SET Password = " +"'"+ newpassword +"'" + "WHERE CardNumber = "+ "'"+cardnumber +"'"+";";
			//UPDATE  card SET PASSWORD = '123456' WHERE CardNumber = '2016324122350';
			sql.executeUpdate(str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return true;
	}
	//获取状态信息
	public int getState(String cardnumber){
		int state = -1;
		String getState = "SELECT State FROM card WHERE CardNumber = '"+cardnumber+"';";
		try{
			Class.forName(driver);
			System.out.println("加载驱动成功！");
			con = DriverManager.getConnection(url,user,password);
			sql = con.createStatement();
			rs = sql.executeQuery(getState);
			while(rs.next()){
				state = Integer.parseInt(rs.getString(1));
			}
		}
		catch(ClassNotFoundException e)
		{	e.printStackTrace();
			System.out.println("加载驱动失败！");
		}
		catch(SQLException ee){
			ee.printStackTrace();
			System.out.println("数据库连接失败！");
		}
		try {
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return state;
	}
	//消费   
	public boolean consumption(String cardnumber,int money,int oldbalance){
		boolean flag = false;
		int newbalance = 0;
		try {
			Class.forName(driver);
			System.out.println("加载驱动成功！");
			con = DriverManager.getConnection(url,user,password);			
			sql=con.createStatement();
			
			newbalance = oldbalance - money;
			System.out.println(newbalance);
			String strr = "UPDATE card SET Balance = " + newbalance + " WHERE CardNumber = '"+cardnumber+"';";
			sql = con.createStatement();
			sql.execute(strr);
			flag = true;
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	   	try {
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	   	return flag;
	}
}