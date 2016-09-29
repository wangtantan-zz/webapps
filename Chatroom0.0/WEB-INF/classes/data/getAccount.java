package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class getAccount{
	public getAccount(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/chatroom?useUnicode=true&characterEncoding=utf8";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(url,username,password);
			if(conn != null){
				System.out.println("读取账户成功");

			}else{
				System.out.println("读取账户失败");
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public boolean isUser(String user, String code){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/chatroom?useUnicode=true&characterEncoding=utf8";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(url,username,password);
			if(conn != null){
				System.out.print("数据库连接成功>>>>>开始读取\n");
				
			}else{
				System.out.print("数据库连接失败>>>>>开始读取\n");
			}
			java.sql.Statement stmt = conn.createStatement();
			String sql = "select username,code from account;";
			ResultSet list = stmt.executeQuery(sql);
			while(list.next()){
				if(user.equals(list.getString("username"))&&code.equals(list.getString("code"))){
					return true;
				}
			}
			stmt.close();
			conn.close();
			
			return false;
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public String createAccount(String name, String code, String inviter){
		if(!inviter.equals("tantan")){
			return ("新增["+name+"]用户失败\t>>>未受邀请");
		}else if(this.likeUser(name)){
			return ("新增["+name+"]用户失败\t>>>用户已存在");
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/chatroom?useUnicode=true&characterEncoding=utf8";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(url,username,password);
			if(conn != null){
//				System.out.println("数据库连接成功>>>>>开始写入");

			}else{
				System.out.println("数据库连接失败>>>>>无法写入");
			}
			String sql = "insert into account values(?,?);";
			java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, code);
			
			stmt.executeUpdate();
			
			stmt.close();
			conn.close();
			return ("新增["+name+"]用户成功\t>>>欢迎加入");

		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return ("新增【"+name+"】用户失败\t>>>连接问题");
		
	}
	
	public boolean likeUser(String user){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/chatroom?useUnicode=true&characterEncoding=utf8";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(url,username,password);
			if(conn != null){
//				System.out.print("数据库连接成功>>>>>开始读取\n");
				
			}else{
				System.out.print("数据库连接失败>>>>>开始读取\n");
			}
			java.sql.Statement stmt = conn.createStatement();
			String sql = "select username from account;";
			ResultSet list = stmt.executeQuery(sql);
			while(list.next()){
				if(user.equals(list.getString("username"))){
					
					return true;
				}else{
//					System.out.println("现已经存在的用户有"+list.getString("username")+"----"+user);
				}
			}
			stmt.close();
			conn.close();
			
			return false;
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public int numOfUser(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/chatroom?useUnicode=true&characterEncoding=utf8";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(url,username,password);
			if(conn != null){
				System.out.print("数据库连接成功>>>>>开始读取\n");
				
			}else{
				System.out.print("数据库连接失败>>>>>开始读取\n");
			}
			java.sql.Statement stmt = conn.createStatement();
			String sql = "select username from account;";
			ResultSet list = stmt.executeQuery(sql);
			int num = 0;
			while(list.next()){
				num +=1;
			}
			stmt.close();
			conn.close();
			
			return num;
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args){
		getAccount gc = new getAccount();
		System.out.println("王潭潭:121212是否能登陆："+gc.isUser("王潭潭", "121212"));
		System.out.println("王潭潭:121112是否能登陆："+gc.isUser("王潭潭", "121112"));
		System.out.println("潭老师:121212是否能登陆："+gc.isUser("潭老师", "121212"));
		System.out.println("现有用户："+gc.numOfUser());
		System.out.println(gc.createAccount("潭老dd师", "121212","tntan"));
		System.out.println(gc.createAccount("潭老dd师", "121212","tantan"));
		System.out.println(gc.createAccount("潭老师", "121212","tantan"));
		System.out.println(gc.createAccount("潭老dddd师12", "121212","tantan"));

		
	}
}