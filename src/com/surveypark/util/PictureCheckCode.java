package com.surveypark.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/pictureCheckCode")
public class PictureCheckCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/* 该方法主要作用是获得随机生成的颜色 */
	public Color getRandColor(int s, int e) {
		Random random = new Random();
		if (s > 255)
			s = 255;
		if (e > 255)
			e = 255;
		int r, g, b;
		r = s + random.nextInt(e - s); // 随机生成RGB颜色中的r值
		g = s + random.nextInt(e - s); // 随机生成RGB颜色中的g值
		b = s + random.nextInt(e - s); // 随机生成RGB颜色中的b值
		return new Color(r, g, b);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 //设置不缓存图片
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		//指定生成的响应图片,一定不能缺少这句话,否则错误
		response.setContentType("image/jpeg");
		 int width=86,height=22;     //指定生成验证码的宽度和高度

		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB); //创建BufferedImage对象,其作用相当于一图片  

		Graphics2D g = (Graphics2D) image.getGraphics(); //创建Grapchics2D对象,其作用相当于画笔
		//Graphics g = image.getGraphics(); //创建Graphics对象,其作用相当于画笔
		Random random = new Random();
		g.setColor(getRandColor(200, 250));
		g.fillRect(1, 1, width - 1, height - 1); //绘制背景
		g.setColor(new Color(102, 102, 102));
		g.drawRect(0, 0, width - 1, height - 1);
		Font mfont = new Font("opera", Font.BOLD, 16); // 定义字体样式
		g.setFont(mfont);  //设置字体  
		g.setColor(getRandColor(160, 200));
		//绘制150条颜色和位置全部为随机产生的线条  
		/*for (int i = 0; i < 100; i++){
			int x = random.nextInt(width - 1);
			int y = random.nextInt(height - 1);
			int xl = random.nextInt(6) + 1;
			int yl = random.nextInt(12) + 1;
			BasicStroke bs=new BasicStroke(2f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL); //定制线条样式  
			Line2D line=new Line2D.Double(x,y,x+xl,y+yl); 
            g.setStroke(bs);  
			g.draw(line); 
			//g.drawLine(x,y,x + xl,y + yl); 
		}*/
		//输出由英文，数字组成的验证文字，具体的组合方式根据生成随机数确定
		String sRand = "";
		//制定输出的验证码为四位  
		for (int i = 0; i < 5; i++){
			String tmp = getRandomChar();
			sRand += tmp;
			g.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(tmp, 15 * i + 10, 15);

		}
		HttpSession session = request.getSession(true);
		session.setAttribute("randStr",sRand);
		g.dispose();  //释放g所占用的系统资源 
		ImageIO.write(image, "JPEG", response.getOutputStream()); //输出图片
	}
	
	//产生一个随机的数字或字母
	private String getRandomChar()
	{
		Random random=new Random();
		int itmp=0;
        char ctmp=0;
		switch (random.nextInt(3))  
		{
		case 1:     //生成A-Z的字母  
            itmp=random.nextInt(26)+65;  
            ctmp=(char)itmp;  
			break;
		case 2:
			itmp = random.nextInt(26)+97;
			ctmp = (char) itmp;
			break;
		default:
			itmp=random.nextInt(10)+48;
			ctmp = (char) itmp;
			break;
		}
		return String.valueOf(ctmp);
	}
}
