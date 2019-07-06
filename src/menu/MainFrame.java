package menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.CharBuffer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.openqa.selenium.WebDriver;

import test.Testovi;
import utility.Logger;
import utility.LoggerListener;

public class MainFrame extends JFrame implements LoggerListener {

	public class JTextFieldInputStream extends InputStream {
	    byte[] contents;
	    int pointer = 0;

	    public boolean x=false;
	    
	    public JTextFieldInputStream(final JTextField text) {

	    	contents = new byte[0];
	    	
	        text.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyReleased(KeyEvent e) {
	                if(e.getKeyChar()=='\n'){
	                    contents = text.getText().getBytes();
	                    pointer = 0;
	                    text.setText("");
	                    x=true;
	                }
	                super.keyReleased(e);
	            }
	        });
	    }

	    @Override
	    public int read() throws IOException {
	    	while(!x) {
	    		try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	    	}
	    	
	    	if(pointer==contents.length) {
	    		//System.out.println("jednako");
	    		pointer++;
	    		return 10;
	    		}
	        if(pointer > contents.length) {
	        //	System.out.println("vece");
	        	x=false;
	        	return -1;
	        	}
	       // System.out.println("manje");
	        return this.contents[pointer++];
	    }

	}
	
	
	//
	
	//JMenuBar menuBar = new JMenuBar();
	//JMenu fileMenu = new JMenu("File");
	//JMenu editMenu = new JMenu("Edit");
	//JMenuItem exitMenuItem = new JMenuItem("EXIT");

	JButton button = new JButton(new ImageIcon("C:\\Users\\Milan\\Desktop\\PROJEKAT eclipse workspace\\ZavrsniProjekat\\images\\registarN2.png"));
	JButton button2 = new JButton(new ImageIcon("C:\\Users\\Milan\\Desktop\\PROJEKAT eclipse workspace\\ZavrsniProjekat\\images\\loginN2.png"));
	JButton button3= new JButton(new ImageIcon("C:\\Users\\Milan\\Desktop\\PROJEKAT eclipse workspace\\ZavrsniProjekat\\images\\postN2.png"));
	JButton button4 = new JButton(new ImageIcon("C:\\Users\\Milan\\Desktop\\PROJEKAT eclipse workspace\\ZavrsniProjekat\\images\\editN2.png"));
	JButton button5 = new JButton(new ImageIcon("C:\\Users\\Milan\\Desktop\\PROJEKAT eclipse workspace\\ZavrsniProjekat\\images\\backN2.png"));
	JButton button6 = new JButton(new ImageIcon("C:\\Users\\Milan\\Desktop\\PROJEKAT eclipse workspace\\ZavrsniProjekat\\images\\logoutN2.png"));
	JTextArea area = new JTextArea();
	JScrollPane scroll = new JScrollPane();
	JTextField input = new JTextField();
	
	
	 WebDriver driver;
	
	// private String buff="";
	/* InputStream is = new InputStream() {
		
		@Override
		public int read() throws IOException {
			try{
				char c= buff.charAt(0);
			
			buff=buff.substring(1);
			return c;
			}catch(Exception e) {return 0;}
		}
	};*/
	
	 
	 InputStream is = new JTextFieldInputStream(input);

	public MainFrame(String title, WebDriver driver) {
			super(title);
	this.driver=driver;
		
		
		//exitMenuItem.setSize(100, 50);
			//	fileMenu.add(exitMenuItem);
			//	menuBar.add(fileMenu);
			//	menuBar.add(editMenu);
				
				
				button.setBounds(25, 120, 200, 60);				
				button2.setBounds(260, 120, 200, 60);
				button3.setBounds(25, 250, 200, 60);
				button4.setBounds(260, 250, 200, 60);
				button5.setBounds(80, 200, 100, 30);
				button6.setBounds(300, 200, 100, 30);
				
			
				
				
				button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						new Thread(new Runnable() {

							@Override
							public void run() {
								try {
									Logger.println("");
									Testovi.testReg(driver, is);
								} catch (Exception e1) {
		
									e1.printStackTrace();
								}
								
							}}).start();
						
						
					}
				});
				
				button2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						new Thread(new Runnable() {

							@Override
							public void run() {
								try {
									Logger.println("");
									Testovi.testLogovanje(driver, is);
								} catch (Exception e1) {
									
									e1.printStackTrace();
								}
								
							}}).start();
						
					}
				});
				
				button3.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						new Thread(new Runnable() {

							@Override
							public void run() {
								try {
									Logger.println("");
									Testovi.testSveObjave(driver, is);
								} catch (Exception e1) {
									
									e1.printStackTrace();
								}
								
							}}).start();
						
					}
				});
				
				button4.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						new Thread(new Runnable() {

							@Override
							public void run() {
								try {
									Logger.println("");
									Testovi.izmenaObjave(driver, is);
								} catch (Exception e1) {
									
									e1.printStackTrace();
								}
								
							}}).start();
						
					}
				});
				
				button5.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						new Thread(new Runnable() {

							@Override
							public void run() {
								try {
									Testovi.back(driver);
								} catch (Exception e1) {
									
									e1.printStackTrace();
								}
								
							}}).start();
						
					}
				});
				
				button6.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						new Thread(new Runnable() {

							@Override
							public void run() {
								try {
									Testovi.logOut(driver);
								} catch (Exception e1) {
									
									e1.printStackTrace();
								}
								
							}}).start();
						
					}
				});
				

				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				area.setBounds(25,20,450,75);
				area.setEditable(false);
				scroll.setBounds(25,20,450,75);
				scroll.getViewport().setBackground(Color.WHITE);
				scroll.getViewport().add(area);
				input.setBounds(25,350,450,50);
				
			//	setJMenuBar(menuBar);
				add(button);
				add(button2);
				add(button3);
				add(button4);
				add(button5);
				add(button6);
				add(scroll);
				add(input);
				setSize(500, 500);
				
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setLayout(null);
				setLocationRelativeTo(null);
		
				Logger.listen(this);
	}


	@Override
	public void onMessageRecieve(String message) {
		
		 SwingUtilities.invokeLater(new Runnable() 
		    {
		      public void run()
		      {
		    		area.append(message+"\n");
		      }
		    });
		
	
		
	}


	/*@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
		File f=new File("images\\izletbg1.jpeg");
		BufferedImage image;
		try {
			image = ImageIO.read(f);
			g.drawImage(image, 0, 0,null );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/


	
	
}
