package com.ifly.travel.control;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateCodeServlet
 */
@WebServlet("/ValidateCodeServlet.do")

public class ValidateCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Random random=new Random();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int width = 85;
		int height = 30;
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setColor(getRandColor(200, 255));
		g.fillRect(0, 0, width, height);

		g.setFont(new Font("serif", Font.PLAIN, 26));
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 100; i++) {
			int x1 = random.nextInt(width);
			int y1 = random.nextInt(height);
			int x2 = random.nextInt(12);
			int y2 = random.nextInt(12);
			g.drawLine(x1, y1, x1+x2, y1+y2);
		}

		String rand = getValidateCode();
		for (int i = 0; i < 4; i++) {
			String s = rand.substring(i,i+1);
			g.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(s, 18* i + 6, 22);
		}
		g.dispose();
		
		OutputStream os=response.getOutputStream();
		request.getSession().setAttribute("code", rand);  
	    ImageIO.write(image, "JPEG", os);  
		
	}
	
	private Color getRandColor(int fc, int bc) {
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	private String getValidateCode() {
		String code="";
		for(int i=0;i<4;i++){
			code+=String.valueOf(random.nextInt(10));
		}
		return code;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object object=request.getSession().getAttribute("code");
		String inCode=request.getParameter("inCode");
		if(inCode.equals(object.toString())){
			response.getWriter().print("验证码正确");
		}else {
			response.getWriter().print("验证码错误");
		}
	}

}
