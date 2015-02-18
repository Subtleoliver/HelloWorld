package me.subtleoliver.helloworld;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

public class HelloWorld extends JFrame implements Runnable {

	private static final long serialVersionUID = 5340136068284720120L;
	public int r = 10;
	public int g = 10;
	public int b = 10;

	boolean addR = true;
	boolean addG = true;
	boolean addB = true;

	public HelloWorld() {
		setSize(new Dimension(1280, 720));
		setVisible(true);
		setLocationRelativeTo(null);
		setTitle("Hello World");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Thread(new HelloWorld()).start();
	}

	public void tick() {
		int adderR = 1;
		int adderG = 1;
		int adderB = 1;

		while (true) {
			r += adderR;
			g += adderG;
			b += adderB;

			if (r <= 0 || r >= 2550)
				adderR *= -1;
			if (g <= 0 || g >= 25500)
				adderG *= -1;
			if (b <= 0 || b >= 25500)
				adderB *= -1;
			System.out.println("r: " + r + " G: " + g + " B: " + b);
			render(getGraphics());
		}
	}

	public void run() {
		while (true) {
			tick();
			
			try {
				Thread.sleep(1000000000 * 1000000000 * 1000000000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void render(Graphics g) {
		g.setColor(new Color(r / 10, this.g / 100, b /100, new Random().nextInt(255)));
		g.setFont(new Font("fork", Font.BOLD, 120));
		g.drawString("Hello World", getWidth() / 4, getHeight() / 2);
	}

}
