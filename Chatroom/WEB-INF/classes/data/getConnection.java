package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class getConnection {
	public getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/chatroom?useUnicode=true&characterEncoding=utf8";
			String username = "wtt";
			String password = "1";
			Connection conn = DriverManager.getConnection(url,username,password);
			if(conn != null){
				System.out.println("数据库连接成功");

			}else{
				System.out.println("数据库连接失败");
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public String[][] showData(){
		String[][] rs= new String[20][4];
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/chatroom?useUnicode=true&characterEncoding=utf8";
			String username = "wtt";
			String password = "1";
			Connection conn = DriverManager.getConnection(url,username,password);
			if(conn != null){
				System.out.print("数据库连接成功>>>>>开始读取\n");
				
			}else{
				System.out.print("数据库连接失败>>>>>开始读取\n");
			}
			java.sql.Statement stmt = conn.createStatement();
			String sql = "select * from comment order by time desc;";
			ResultSet list = stmt.executeQuery(sql);
			int n = 0;
			
			while(list.next()&&n<20){
				
				rs[n][0] = list.getString("time");
				rs[n][1] = list.getString("name");
				rs[n][2] = "@ "+list.getString("reply");
                if("@ ".equals(rs[n][2])){rs[n][2]="";}
				rs[n][3] = list.getString("content");
				n += 1;
			}
			if(n<20){
				for(int m=n;m<20;m++){
					rs[m][0] = "";
					rs[m][1] = "";
					rs[m][2] = "";
					rs[m][3] = "";
				}
			}
			n=0;
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	
	public void addData(String name, String reply, String content){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/chatroom?useUnicode=true&characterEncoding=utf8";
			String username = "wtt";
			String password = "1";
			Connection conn = DriverManager.getConnection(url,username,password);
			if(conn != null){
				System.out.println("数据库连接成功>>>>>开始写入");

			}else{
				System.out.println("数据库连接失败>>>>>无法写入");
			}
			String sql = "insert into comment values(now(),?,?,?);";
			java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, reply);
			stmt.setString(3, content);
			int rows = stmt.executeUpdate();
			System.out.println("成功写入\t"+rows+"\t组数据");
			stmt.close();
			conn.close();

		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		getConnection gc = new getConnection();
		String[][] c = gc.showData();
		for(int i=0;i<2;i++){
            for (int j=0;j<4;j++)
                System.out.print(c[i][j]+" ");
            System.out.println();
        }
		gc.addData("管理员","All","写入数据尝试1");
		gc.addData("管理员","All","写入数据尝试2");
		gc.addData("管理员","All","写入数据尝试3");
		gc.showData();
		for(int i=0;i<20;i++){
            for (int j=0;j<4;j++)
                System.out.print(c[i][j]+" ");
            System.out.println();
        }
	}
}
