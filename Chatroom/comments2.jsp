<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="data.getConnection" %>
<%@ page import="java.util.*" %>

<table width="550" border="0" align="center" cellpadding="0" cellspacing="0" id="comment" 
		bordercolor="#E5BB9" bordercolorlight="#666666" bordercolordark="#FFFFFF" wrap="hard">


	<%
		request.setCharacterEncoding("UTF-8");
		getConnection iodata = new getConnection();
		String[][] tt = iodata.showData();
		String str = "";
		for (int i = 0; i < tt.length; i++) {
      if(tt[i][0]==null||"".equals(tt[i][0])){str += "";}else{
			str += tt[i][0] + "\n" + tt[i][1] + "\t" + tt[i][2] + "\n>> " + tt[i][3] + "\n\n";}
		}
	%>


	<tr>
		<td width="10" valign="middle" align="center"><label style="font-size:20px">历史聊天记录</label></td>
		<td><textarea rows="20" cols="70" readonly="readonly" style="background:#F5F5F5"><%=str %></textarea></td>
		<td width="10" valign="middle" align="center"><label style="font-size:20px">历史聊天记录</label></td>
	</tr>


</table>  
