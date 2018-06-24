package com.ifly.travel.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifly.travel.dao.UserDao;
import com.ifly.travel.entity.User;

/**
 * Servlet implementation class MyTravel
 */
@WebServlet("/MyTravel.do")
public class MyTravel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao=new UserDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyTravel() {
    	
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=getServletContext().getAttribute("username").toString();
		User user=dao.getUser(username);
		request.setAttribute("user", user);
		request.getRequestDispatcher("myTravel.jsp").forward(request, response);
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String username=getServletContext().getAttribute("username").toString();
		User user=dao.getUser(username);
		
    	String userN=request.getParameter("username");
		String realname=request.getParameter("realname");
		String userpassword=request.getParameter("userpassword");
		String telephone=request.getParameter("telephone");
		String code=request.getParameter("code");
		
		Object codeInSession = request.getSession().getAttribute("code");
		if (codeInSession ==  null|| !codeInSession.toString().equals(code)) {
			response.getWriter().write("<script type='text/javascript'>$.messager.alert('我的消息','验证码输入错误！','info');</script>");
		}else if(!userN.equals(username)){
			List<User> users=new ArrayList<User>();
			users=dao.getAllUser();
			for(User u:users){
				if(u.getUserName().equals(username)){
				
					response.getWriter().write( "<script type='text/javascript'>$.messager.alert('我的消息','用户名已存在！','info');</script>");
				}
			}
		}
	    else{
	    	User newUser=new User(user.getUserId(), userN, userpassword, realname, telephone);
			dao.updateUser(newUser);
			getServletContext().setAttribute("user", newUser);
			response.getWriter().write("<script type='text/javascript'>$.messager.alert('我的消息','修改成功！','info');</script>");
			}
		}
	
}
