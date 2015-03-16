package demo1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.io.*;

import javax.imageio.ImageIO;

import org.junit.Test;

public class Demo1 {

	@Test
	public void fun1() throws Exception
	{
		int width = 60;
		int height = 32;
		//create the image
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		// set the background color
		g.setColor(new Color(0xDCDCDC));
		g.fillRect(0, 0, width, height);
		// draw the border
		g.setColor(Color.RED);
		g.drawRect(0, 0, width - 1, height - 1);
		// create a random instance to generate the codes
		Random rdm = new Random();
		String hash1 = Integer.toHexString(rdm.nextInt());
		System.out.print(hash1);
		// make some confusion
		for (int i = 0; i < 50; i++) {
			int x = rdm.nextInt(width);
			int y = rdm.nextInt(height);
			g.drawOval(x, y, 0, 0);
		}
		// generate a random code
		String capstr = hash1.substring(0, 4);
		
		g.setColor(new Color(0, 100, 0));
		g.setFont(new Font("Candara", Font.BOLD, 24));
		g.drawString(capstr, 8, 24);
		g.dispose();
		
		//保存图片:
		FileOutputStream fos=new FileOutputStream("H:/hyy.jpeg");
		
		ImageIO.write(image, "jpeg", fos);
		fos.close();
		
		
		
	}
	
	
}
