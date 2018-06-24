package com.ifly.travel.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifly.travel.dao.IndentDao;
import com.ifly.travel.dao.MyCollectDao;
import com.ifly.travel.dao.NpassangerDao;
import com.ifly.travel.dao.ShareDao;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete.do")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IndentDao indentDao = new IndentDao();
	private ShareDao shareDao = new ShareDao();
	private NpassangerDao passangerDao = new NpassangerDao();
	private MyCollectDao collectdao=new MyCollectDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opt = request.getParameter("opt");
		String optId = request.getParameter("optId");
		if ("MyShare".equals(opt)) {
			shareDao.delMyShareById(Integer.parseInt(optId));
			request.getRequestDispatcher("MyShare.do").forward(request, response);
		} 
		if ("AllIndent".equals(opt)) {
			//String optId = request.getParameter("optId");
			indentDao.delIndent(Integer.parseInt(optId));
			response.sendRedirect("GetAllIndents.do");
		}
		if ("Passenger".equals(opt)) {
			String[] delId = optId.split(",");
			for (String id : delId) {
				passangerDao.delNpassanger(Integer.parseInt(id));
			}
			request.getRequestDispatcher("GetNpassangers.do").forward(request,response);
		}
		if ("MyCollect".equals(opt)) {
			String[] delId = optId.split(",");
			for (String id : delId) {
				collectdao.delMyCollect(Integer.parseInt(id));
			}
			request.getRequestDispatcher("GetMyCollects.do").forward(request,response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
