package com.star.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/randomCode")
public class RandomCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//���������
		String randomCode = UUID.randomUUID().toString().substring(0, 5);

		//��������Ž�Session��
		req.getSession().setAttribute("RANDOMCODE_IN_SESSION", randomCode);

		//����ͼƬ����
		int width = 80;
		int height = 40;
		int imageType = BufferedImage.TYPE_INT_RGB;
		BufferedImage image = new BufferedImage(width, height, imageType);

		//����
		Graphics g = image.getGraphics();
		g.setColor(Color.YELLOW);
		//����һ��ʵ�ĵľ���
		g.fillRect(1, 1, width - 2, height - 2);

		//�����������ͼƬ��
		g.setColor(Color.BLACK);//�������������ɫ
		Font font = new Font("����", Font.BOLD + Font.ITALIC, 20);
		g.setFont(font);//���������������ʹ�С
		g.drawString(randomCode, 10, 28);
		//������
		g.setColor(Color.GRAY);
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			g.fillRect(r.nextInt(width), r.nextInt(height), 2, 2);
		}

		//�ر�
		g.dispose();
		//��ͼƬ���������ķ�ʽ�����ȥ
		ImageIO.write(image, "jpg", resp.getOutputStream());
	}
}
