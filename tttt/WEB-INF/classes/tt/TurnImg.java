package tt;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TurnImg {
	private int charstart = 32;
	private int charnum = 65;
	private int[][] charGray = new int[charnum][2];
	private int zoom = 8;
	int tt = 13;
	private int[][] show=new int[tt][tt];
	int MAX,MIN,min,max;
	//初始化后，生成字符对应灰度列表charGray，并排序
	public void init(){
		
		for(int ch=0; ch<charnum; ch++){
			charGray[ch][0]=ch+charstart;
			charGray[ch][1]=whatGray(ch+charstart);//计算相应回复
					}
		charGray = sort(charGray);
		max = charGray[0][1];
		min = charGray[charnum-1][1];
	}
	//生成单个字符图片，并计算灰度
	public int whatGray(int num){
		String[][]	cha = new String[1][1];
		cha[0][0] = (char)num + "";
		BufferedImage image = createImage(cha,13);
		int width = image.getWidth();  
	    int height = image.getHeight();  
	    int gray = 0;  
	    
	    BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY); 
	    for(int i= 0 ; i < width ; i++){  
	        for(int j = 0 ; j < height; j++){  
	        int rgb = image.getRGB(i, j);  
	        grayImage.setRGB(i, j, rgb);
	        gray += rgb;
	        }  
	    }
	    gray=gray/169;		
		return gray;
	}
	//读取原图片，计算返回每个像素灰度的数组
	public int[][] grayImage(String str) throws IOException{
	   try{
		  
		File file = new File(str);
	    BufferedImage image = ImageIO.read(file);
	    
	    int width = image.getWidth();  
	    int height = image.getHeight();  
	    int[][] gray = new int[height][width];  
	    
	    BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY); 
	    for(int i= 0 ; i < width ; i++){  
	        for(int j = 0 ; j < height; j++){  
	        int rgb = image.getRGB(i, j);  
	        grayImage.setRGB(i, j, rgb);
	        gray[j][i] = rgb;
	        	
	        }  
	    }  
	    return gray;
	}catch(IOException e){
		int[][] error = new int[1][1];
		error[0][0]=0;
		return error;
	}
	}
	
	public void draw(String url, int[][] str){
		try{
			grayImage(url);
 
			File newFile = new File(url); 
			int h=str.length/zoom ,w=str[0].length/zoom;
			String[][] strr=new  String[h][w];
			strr = getChar(str);
			
			ImageIO.write(createImage(strr,13), "jpg", newFile);				//绘制最终成品图
		}catch(IOException e){
			
		}
	}
	
	//字符绘图，考虑字符排列，选取delta=13最合适
	public static BufferedImage createImage(String[][] s, int delta) {
		int d = delta;
		int height = s.length*d;
		int width = s[0].length*d;
		
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);    
        Graphics2D g2 = (Graphics2D)bi.getGraphics();    
        g2.setBackground(Color.WHITE);    
        g2.clearRect(0, 0, width, height);    
        g2.setPaint(Color.BLACK);
        for(int i=0; i<s.length;i++){
        	for(int j=0; j<s[i].length;j++){
        		g2.drawString(s[i][j] , 0+d*j+1,  11+i*d);
        	}
        }
        return bi;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str0 = "C:\\Users\\Wtt\\Desktop\\test.jpg";
		String str = "C:\\Users\\Wtt\\Desktop\\testnew.jpg";
		TurnImg test = new TurnImg();
		test.init();
		
		
		try {
			test.draw(str, test.grayImage(str0));
						
			/*for(int i=0;i<test.charGray.length;i++){
				System.out.print(i+":"+(char)test.charGray[i][0]+"\t");
				for(int j=0;j<test.charGray[0].length;j++){
				System.out.print(test.charGray[i][j]+"\t");
				}System.out.print("\n");
			}
			
			for(int i=0;i<test.show.length;i++){
				for(int j=0;j<test.show[0].length;j++){
					System.out.print(test.show[i][j]+"\t");
				}System.out.print("\n");
			}*/
			System.out.println("MIN:"+test.MIN+"\tMAX:"+test.MAX+"\tcharGray[0][1]"+test.charGray[0][1]+"\t\tcharGray[last][1]"+test.charGray[test.charnum-1][1]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		request.setAttribute("path", request.getContextPath()+"/images/defaul1.jpg");
		
		
		
		
	}
	//对字符灰度序列表进行排序，输入92x2表，输出92x2表：arr{编号，灰度}
	private int[][] sort(int[][] arr){
		int[][] temp = new int[1][2];
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i][1]<arr[j][1]){
					temp[0] = arr[i];
					arr[i] = arr[j];
					arr[j] = temp[0];
 				}
			}
				
		}
		for(int i=0;i<arr.length;i++){
			arr[i][1] = arr[i][1]/1000;
		}
		return arr;
	}
	//将原图片灰度数组，进行缩放,然后转换字符+调用copyright添加“Wangtantan@Copyright”
	private String[][] getChar(int[][] mit){
			int h = mit.length;
			int w = mit[0].length;
			int d = zoom;//图片均分小区域求灰度均值
			
			
			int[][] mit2= new int[h/d][w/d];
			for(int i=0;i<h/d;i++){
				for(int j=0;j<w/d;j++){
					long tem = 0;
					for(int m=d*i;m<d*(i+1);m++){
						for(int n=d*j;n<d*(j+1);n++){
							tem += mit[m][n];
						}
					}
					mit2[i][j] = (int) (tem/(zoom*zoom)/1000);

				}
			}
			MAX = mit2[0][0];
			MIN = mit2[0][0];
			for(int i=0;i<h/d;i++){
				for(int j=0;j<w/d;j++){
					if(mit2[i][j]>MAX){MAX=mit2[i][j];}
					if(mit2[i][j]<MIN){MIN=mit2[i][j];}
					
					
				}
			}
			int temp;
			for(int i=0;i<h/d;i++){
				for(int j=0;j<w/d;j++){
					temp =(charGray[0][1]-charGray[charnum-1][1])*(mit2[i][j]-MIN)+min*(MAX-MIN);// (mit2[i][j]-MIN)*(charGray[0][1]-charGray[charnum-1][1])/(MAX-MIN)+min;
					temp = temp/(MAX-MIN);
					mit2[i][j] = findchar(temp);
				}
			}
			for(int i=0;i<show.length;i++){			//show临时查看输出；
				for(int j=0;j<show[0].length;j++){
					show[i][j] = mit2[i][j];
				}
			}
			String[][] mit0= new String[h/d][w/d];
			for(int x=0;x<h/d;x++){
				for(int y=0;y<w/d;y++){
					mit0[x][y] = (char)mit2[x][y] + "";
				}
			}
			mit0 = copyright(mit0);//添加“Wangtantan@Copyright”
			
		return mit0;
	}
	
	private int findchar(int i){
		if(i>=charGray[0][1]){return charGray[0][0];}
		for(int m=0;m<charnum;m++){
			if(i>charGray[m][1]){return charGray[m-1][0];}
		}
		return charGray[charnum-1][0];
	}
	
	//添加“Wangtantan@Copyright”
	private String[][] copyright(String[][] right){
		
		String[] copy1 = "%            % ".split("");
		String[] copy = "%  不靠谱的猕猴 潭  % ".split("");//一个芷再加一个萱
		String[] copy2 = "%            % ".split("");
		int w = right[0].length;
		int l = copy.length;
		for(int i=1;i<l-1;i++){
			if(i<w){right[1][i] = "%";right[2][i] = copy1[i];right[3][i] = copy[i];right[4][i] = copy2[i];right[5][i] = "%";}
		}
		return right;
	}

}
