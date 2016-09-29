<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="data.IOdata" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<table width="350" border="" align="center" cellpadding="0"
	cellspacing="0" id="comment" bordercolor="#E5BB9" wrap="hard">
	<%
		//表单信息提交写入
			IOdata iodata = new IOdata();
			request.setCharacterEncoding("UTF-8");
		if ((!"".equals(request.getParameter("person")) && !"".equals(request.getParameter("content")))
				&& request.getParameter("person") != null) {
			iodata.setText(request.getParameter("person") + "#.#" 
						+ iodata.Time() + "#.#" + " @"
						+ request.getParameter("reply")	+ "#.#" 
						+ request.getParameter("content") + "#.#");
		}
		; //字符串中存入时间信息，便于聊天记录时间的显示

		String[] tt = iodata.getText();
		int d = iodata.numOfInf;
		String[] t = new String[8 * d];
		for (int i = 0; i <= 8 * d - 1; i++) {
			t[i] = tt[42 * d + i];
		}
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
		<td align="center"><label><%=t[0]%></label></td>
		<td><label><%=t[d-1]%></label></td>
	</tr>
	<tr>
		<td align="center"><label><%=t[d]%></label></td>
		<td><label><%=t[2*d-1]%></label></td>
	</tr>
	<tr>
		<td align="center"><label><%=t[2*d]%></label></td>
		<td><label><%=t[3*d-1]%></label></td>
	</tr>
	<tr>
		<td align="center"><label><%=t[3*d]%></label></td>
		<td><label><%=t[4*d-1]%></label></td>
	</tr>
	<tr>
		<td align="center"><label><%=t[4*d]%></label></td>
		<td><label><%=t[5*d-1]%></label></td>
	</tr>
	<tr>
		<td align="center"><label><%=t[5*d]%></label></td>
		<td><label><%=t[6*d-1]%></label></td>
	</tr>
	<tr>
		<td align="center"><label><%=t[6*d]%></label></td>
		<td><label><%=t[7*d-1]%></label></td>
	</tr>
	<tr>
		<td align="center"><label><%=t[7*d]%></label></td>
		<td><label><%=t[8*d-1]%></label></td>
	</tr>

</table>
