<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="data.IOdata" %>
<%@ page import="java.util.*" %>


<table width="448" border="0" align="center" cellpadding="0" cellspacing="0" id="comment" 
		bordercolor="#E5BB9" bordercolorlight="#666666" bordercolordark="#FFFFFF" wrap="hard">


	<%
		IOdata iodata = new IOdata();
		request.setCharacterEncoding("UTF-8");
		int d = iodata.numOfInf;
		String[] tt = iodata.getText();
		String str = "";
		for (int i = 49*d; i >= 0; i = i - d) {
      if(tt[i]==null||"".equals(tt[i])){str += "";}else{
			str += tt[i] + ":\t" + tt[i + 1] + " "+ tt[i+2] +"\n>>" +tt[i + 3] +"\n\n";}
		}
	%>


	<tr>
		<td width="40" valign="middle" align="center"><label style="font-size:20px">历史聊天记录</label></td>
		<td><textarea rows="20" cols="65" readonly="readonly" style="background:#F5F5F5"><%=str %></textarea></td>
	</tr>


</table>  
