package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;			//暂时使用calendar类，日期显示方式有待修整
import java.text.DateFormat;
import java.util.Calendar;

public class IOdata{

	private String text;
	public int numOfInf =4;  		//（聊天记录4段保存）name + time + @reply + comments
	private String[] t = new String[50*numOfInf];
	public void setText(String text) throws IOException{
/*聊天记录储存路径，可以根据日期每天更新创建
**？？文本读写的相对路径有问题！相对路径会到C:\Download\02-编程相关\编程软件\eclipse\下！不解
**
*/
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("comment.txt"), true));
		writer.write(text);
		writer.close();
		this.text = text;
	}

	
	public String[] getText(){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("comment.txt"), true));
			BufferedReader reader = new BufferedReader(new FileReader(new File("comment.txt")));
			writer.close();
			StringBuilder sb = new StringBuilder();
			String s;
			while((s = reader.readLine()) != null){
				sb.append(s+"\n");
			}
			reader.close();
			text = sb.toString();
		}catch(Exception e){
			text = "read fails!";
		};
			arrays();	
		return t;
	}
	
	private void arrays(){
		String[] tt = text.split("#.#");
		int l = tt.length;			//读取数据字符串数组长度，奇数
		for(int j=50*numOfInf-1; j>=0; j--){
			if(l+j-50*numOfInf-1>=0){
				t[j] = tt[l+j-50*numOfInf-1];
			}else{
				t[j] = "";
			}
		}

	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		IOdata iodata = new IOdata(); 
		System.out.print(iodata.Time());
		
		
		
/*		iodata.setText("A#sadasdasdasd#");
		iodata.setText("B#dsadasdsad#");
		iodata.setText("C#dsdsadsaadh#");
		iodata.setText("D#djsah#");
		iodata.setText("E#sadasdasdasd#");
		iodata.setText("F#dsadasdsad#");
		iodata.setText("G#dsdsadsaadh#");
		iodata.setText("H#djsah#");
		
		String[] t = iodata.getText();
		String lasttext = "";
		for(int i=0; i<t.length-4; i=i+2){
			lasttext += t[i+0]+":\n  "+t[i+1]+"\n";
		}
		System.out.print(lasttext);*/
	}	
	
	public String Time(){
		Calendar cal = Calendar.getInstance();
		
		String hours, minutes,seconds,years,months,days;
		int hour=cal.get(Calendar.HOUR);//小时 
		int minute=cal.get(Calendar.MINUTE);//分        
		int second=cal.get(Calendar.SECOND);//秒 
		int year = cal.get(Calendar.YEAR);//获取年份
		int month=cal.get(Calendar.MONTH)+1;//获取月份 
		int day=cal.get(Calendar.DATE);//获取日 
		
		if(hour<10){hours = "0"+hour;}else{hours = ""+hour;};
		if(minute<10){minutes = "0"+minute;}else{minutes = ""+minute;};
		if(second<10){seconds = "0"+second;}else{seconds = ""+second;};
        if(month<10){months = "0"+month;}else{months = ""+month;};
        if(day<10){days = "0"+day;}else{days = ""+day;};
		
		return year+"/"+month+"/"+day+" "+hours+":"+minutes+":"+seconds;
	}
}

