package com.ifly.travel.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifly.travel.dao.SignSpotDao;
import com.ifly.travel.dao.UserDao;

/**
 * Servlet Filter implementation class LoginSelfFilter
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD,
		DispatcherType.INCLUDE, DispatcherType.ERROR }, urlPatterns = { "/*" })
public class LoginSelfFilter implements Filter {
	SignSpotDao signDao = new SignSpotDao();
	/**
	 * Default constructor.
	 */
	public LoginSelfFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrRequest = (HttpServletRequest) request;
		HttpServletResponse hResponse=(HttpServletResponse)response;
		String path = hrRequest.getRequestURI();
		if (path.endsWith("login.jsp")) {
			String username = null;
			String password = null;
			Cookie[] cookies = hrRequest.getCookies();
			if (cookies != null&&cookies.length>0) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("username")) {
						username = cookie.getValue();
					} else if (cookie.getName().equals("password")) {
						password = cookie.getValue();
					}
				}
				UserDao userDao = new UserDao();
				if (userDao.isExists(username, password)) {
					hrRequest.getServletContext().setAttribute("username",username );
					hrRequest.getSession().setAttribute("username", username);
					List<String> allCitys = signDao.getAllCitys();
					hrRequest.getSession().setAttribute("allCitys", allCitys);
					hrRequest.getRequestDispatcher("GetCitySignspots.do").forward(request,
							response);
				} else {
					chain.doFilter(request, response);
				}
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
