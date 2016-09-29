<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="data.getConnection" %>
<table width="350" border="" align="center" cellpadding="0"
	cellspacing="0" id="comment" bordercolor="#E5BB9" wrap="hard">
	<%
		//表单信息提交写入
		request.setCharacterEncoding("UTF-8");
		getConnection iodata = new getConnection();
		request.setCharacterEncoding("UTF-8");
		if ((!"".equals(request.getParameter("person")) && !"".equals(request.getParameter("content")))
				&& request.getParameter("person") != null) {
			iodata.addData(request.getParameter("person"), request.getParameter("reply"),
					request.getParameter("content"));
		}
		; //字符串中存入时间信息，便于聊天记录时间的显示

		String[][] tt = iodata.showData();
	%>
	<tr>
		<td colspan="2" align="center"  style="font-size:25px"><b>聊天记录</b>
		</td>
	</tr>
	<tr>
		<td width="25%" align="center" style="font-size:20px"><b>昵称</b></td>
		<td width="75%" align="center" style="font-size:20px"><b>回复</b></td>
	</tr>
	<tr>
		<td align="center" valign="middle"><label><%=" "+tt[6][1]%></label></td>
		<td><label><%=" "+tt[6][3]%></label></td>
	</tr>
	<tr>
		<td align="center" valign="middle"><label><%=" "+tt[5][1]%></label></td>
		<td><label><%=" "+tt[5][3]%></label></td>
	</tr>
	<tr>
		<td align="center" valign="middle"><label><%=" "+tt[4][1]%></label></td>
		<td><label><%=" "+tt[4][3]%></label></td>
	</tr>
	<tr>
		<td align="center" valign="middle"><label><%=" "+tt[3][1]%></label></td>
		<td><label><%=" "+tt[3][3]%></label></td>
	</tr>
	<tr>
		<td align="center" valign="middle"><label><%=" "+tt[2][1]%></label></td>
		<td><label><%=" "+tt[2][3]%></label></td>
	</tr>
	<tr>
		<td align="center" valign="middle"><label><%=" "+tt[1][1]%></label></td>
		<td><label><%=" "+tt[1][3]%></label></td>
	</tr>
	<tr>
		<td align="center" valign="middle"><label><%=" "+tt[0][1]%></label></td>
		<td><label><%=" "+tt[0][3]%></label></td>
	</tr>
	

</table>
