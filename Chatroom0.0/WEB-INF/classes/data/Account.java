package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class Account {
	
/*	private boolean in = false;*/
	private String[] text;
/*	
	//登录状态设置（in=1表示有登陆信息）
	public void setIn(boolean in){
		this.in = in;
	}
	//登录状态显示（in=1表示有登陆信息）
	public boolean getIn(){
		return in;
	}*/
		
	public void readAccount(){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("account.txt"), true));
			writer.close();
			BufferedReader reader = new BufferedReader(new FileReader(new File("account.txt")));
			StringBuilder sb = new StringBuilder();
			String s;
			while((s = reader.readLine()) != null){
				sb.append(s+"\n");
			}
			reader.close();
			text = sb.toString().split("#.#");
			System.out.println("账户读取成功");
		}catch(Exception e){
			System.out.println("账户读取失败");
		};
	}
	//创建新账户，判断user是否已存在，邀请码是否正确，然后完成新账户信息写入
	public String creatAccount(String username, String code, String inviter){
		try{
			if("wtt".equals(inviter)){
				if(likeUser(username)==false){
					BufferedWriter writer = new BufferedWriter(new FileWriter(new File("account.txt"), true));
					writer.write(username+"@.@"+code+"#.#");//简单判断账户，用户名可能会相同，文档可以看到密码，未做加密
					writer.close();
					System.out.println("创建成功：\t创建>"+username +"<");
					return "创建成功：\t已创建>"+username+"<";
				}else{System.out.println("创建失败:\t"+username+"已存在");return "创建失败:\t>"+username+"<已存在";}
			}else{System.out.println("创建失败:\t"+username+"未受邀请:" + inviter);return "创建失败:\t未受邀请";}
		}catch(Exception e){
			System.out.println("创建失败：\tIOException:"+username);
			return "创建失败：\tIOException:"+username;
		}
	}
	//判断username、密码是否正确，登录筛选
	public boolean isUser(String username, String code){
		int l = text.length;
		if(l<=0){return false;}else{
			String account = username+"@.@"+code;
			for(int i=0;i<l;i++){
				if(text[i].equals(account)){
					return true;
				}
			}
		}
		return false;
	}
	//判断username是否重复
	public boolean likeUser(String username){
		int l = text.length;
		if(l<=0){return false;}else{
			for(int i=0;i<l;i++){
				if(text[i].split("@.@")[0].equals(username)){
					return true;
				}
			}
		}
		return false;
	}
	//返回用户人数
	public int numOfUser(){
		return text.length-1;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account ac = new Account();
		ac.readAccount();
		ac.creatAccount("aaaa", "121212", "tantan");
		ac.creatAccount("bbbb", "121212", "tantn");
		ac.creatAccount("cccc", "121212", "tantan");
		ac.creatAccount("dddd", "121212", "tantan");
		ac.creatAccount("zzz", "121212", "tantan");
		System.out.println("aaaa:是否是注册用户"+ ac.isUser("aaaa", "121212"));
		System.out.println("bbbb:是否是注册用户"+ ac.isUser("bbbb", "121212"));
		System.out.println("cccc:是否是注册用户"+ ac.isUser("cccc", "121212"));
		System.out.println("cccc:是否是注册用户"+ ac.isUser("cccc", "1c1212"));
		System.out.println("aaa:是否是注册用户"+ ac.isUser("aaa", "121212"));
		System.out.println("zzz:是否是注册用户"+ ac.isUser("dddd", "121212"));
	}

}
