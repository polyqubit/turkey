import pkg.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class starter {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		char[][] turkey = new char[70][70];
		int c,r,g,b;
		Color col;
		try {
			BufferedImage img = ImageIO.read(new File("C:/Users/MREI6641/Desktop/turkey/err.jpg"));
			for(int i=0;i<turkey.length;i++) {
				for(int j=0;j<turkey[i].length;j++) {
					c = img.getRGB(i,j);
					col = new Color(c);
					b = c & 0xff;
					g = (c & 0xff00) >> 8;
					r = (c & 0xff0000) >> 16;  //bit shift stuff
					// System.out.println("Pixel: "+r+","+g+","+b);
					if((r+g+b)<50) {
						turkey[i][j] = '0';
					}
					else if((r+g+b)<150) {
						turkey[i][j] = 'o';
					}
					else {turkey[i][j] = ' ';}
				}
			}
		}
		catch (IOException e) {System.out.println("oops error lol");}
		for(int j=0;j<turkey.length;j+=2) {
			for(int i=0;i<turkey[j].length;i++) {
				System.out.print(turkey[i][j]);
			}
			System.out.println("");
		}
	}

}
