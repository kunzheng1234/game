package mygame2;
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
//by using java.awt etc, must be javaSE-1.7
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Robot;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.util.Timer;
	/*
	 * To change this template, choose Tools | Templates
	 * and open the template in the editor.
	 */

	public class display implements KeyListener, MouseListener{
		 JLabel[] lb1=new JLabel[8];
		 ImageIcon [] ic=new ImageIcon[8];
		  JPanel mainPanel = new JPanel();
		  
		 JFrame frame=new JFrame();
		 
		JButton[] button = new JButton[8];
		JButton tempbutton = new JButton();
		JButton checkButton = new JButton("check");
		JButton restartButton = new JButton("restart");
		 Timer timer = new Timer();
		 
		 int[] check=new int[8];
		 int[] block=new int[8];
		 //Timer timer2 = new Timer();
		 int first,second;
		 public display()
	    	{
			 first=-1;second=-1;
	    		tempbutton=null;
	    	}
	    public void display()  throws IOException, InterruptedException 
	    {
	    	
	    	synchronized (timer){
	    	       try{
	    	          timer.wait(100);
	    	       } catch (InterruptedException g) {
	    	          g.printStackTrace();
	    	       }
	    	    }
	    	//BufferedImage[] img=new BufferedImage[2];
	    	Image[] img1=new Image[8];
	    	for(int i=0;i<8;i++)
	    	{
	    		String s=Integer.toString(i+1);  
		    	File path = new File("pict\\image"+s+".png");
		    	System.out.println(path);
		    	try {
		 	    	   // img = ImageIO.read(new File("pict\\image2.png"));
		 	    	   // img[i] = ImageIO.read(path);
		 	    	    img1[i] = ImageIO.read(path);
		 	    	  // img1[i]=img1[i].getScaledInstance(50, 100, i);
		 	    	    img1[i] = img1[i].getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		 	    	} catch (IOException e) {
		 	    	}
	    	}
	    	Border border = BorderFactory.createLineBorder(Color.RED);
	    	
	       // BufferedImage img=ImageIO.read(new File("C:\\Users\\123\\Desktop\\image.png"));
	    	//BufferedImage img=ImageIO.read(new File("pict\\image2.png"));
	    	
	    	//img[0]=img[1];
	    	
	    	//ImageIcon icon=new ImageIcon(img1[0]);
	    	
	    	for(int i=0;i<8;i++)
	    	{
	    		ic[i]=new ImageIcon(img1[i]);
	    	}
	    	
	        
	       
	        //Timer timer = new Timer();
	        //timer.wait(10000);
	       // mainPanel.add(img1[0]);
	      
	        /*
	        for(int i=0;i<8;i++)
	    	{
	        	String s=Integer.toString(i+1);  
	        	lb1[i]=new JLabel(s);
	        	lb1[i].setIcon(ic[i]);
	        	lb1[i].setSize(100,100);
	   	     
		        //lb1[0].setLocation(100,30);
		        lb1[i].setBorder(border);
	    	}
	    	*/
	        //lb1[0].setName("lb1");
	        
	        
	        //lb1[0].setSize(200, 50);
	        
	       
	        //lb1.setBorder(border);
	        
	        //lb1.setForeground(Color.BLACK); 
	       // lb1.setBackground(Color.BLUE);
	        //lb1.setVisible(true);
	        //lb1.setBounds(10, 40, 50, 100);
	        
	        
	        //lb1[1].setSize(50,100);
	        //lb1[1].setLocation(40,30);
	        /*
	        JLabel lb2=new JLabel();
	        lb2.setIcon(ic[1]);
	        lb2.setBounds(10, 40, 50, 100);
	        
	        */
	      
	        
	        for(int i=0;i<8;i++)
	    	{
	        	 //mainPanel.add(lb1[i]);
	    	}
	        //mainPanel.add(lb1[0]);
	        //mainPanel.add(lb1[1]);
	        //must have this null define
	        mainPanel.setLayout(null);
	        //mainPanel.setSize(200,200);
	        mainPanel.setBounds(50, 10, 200, 200);
	        mainPanel.setBorder(border);
	        mainPanel.setLocation(100, 100);
	        //mainPanel.addKeyListener(this);
	        
	        for(int i=0;i<8;i++)
	    	{
	    	//button[i]= new JButton(String.valueOf(i));
	    	button[i]= new JButton();
	    	button[i].addMouseListener(this);
	    	mainPanel.add(button[i]);
	    	//
	    	button[i].setSize(100, 100);
	    	String s=Integer.toString(i); 
	    	button[i].setName(s);
	    	}
	        checkButton.setSize(100, 50);
	        checkButton.setLocation(100, 250);
	        checkButton.addMouseListener(this);
	        mainPanel.add(checkButton);
	        String s=Integer.toString(9); 
	        checkButton.setName(s);
	        
	        
	        restartButton.setSize(100, 50);
	        restartButton.setLocation(200, 250);
	        restartButton.addMouseListener(this);
	        mainPanel.add(restartButton);
	        String ss=Integer.toString(10); 
	        restartButton.setName(ss);
	        //frame.setLayout(new FlowLayout());
	        
	        frame.add(mainPanel);
	        frame.setSize(800, 500);
	        frame.setLocation(100,100);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.addKeyListener(this);
	        frame.addMouseListener(this);
	        /*
	        frame.addKeyListener(new KeyListener(){
	        	//StringBuilder sb = new StringBuilder();
	        	char sb;
	             @Override
	                public void keyPressed(KeyEvent e) {
	                   // if(e.getKeyCode() == KeyEvent.VK_UP){
	                    //	lb1[1].setLocation(430,30);
	                   //     System.out.println("Hi");
	                    //}
	                }

	                @Override
	                public void keyTyped(KeyEvent e) {
	                	sb=e.getKeyChar();
	                   
	                    if(sb=='f')
	                    	lb1[1].setLocation(430,30);
	                    	 System.out.println(sb);
	                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	                }

	                @Override
	                public void keyReleased(KeyEvent e) {
	                	if(e.getKeyCode() == KeyEvent.VK_UP){
	                		lb1[1].setLocation(40,30);
	                        System.out.println("Hi2");
	                    }
	                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	                }
	        });
	             
	             */
	        //
	        rand();
	        //putButton();
	    }
	    
	    public void rand()
        {
	    	for(int i=0;i<check.length;i++)
	    	{
	    		check[i]=0;
	    		//block[i]=0;
	    	}
	    	
	    	boolean finish=false;
	    	int next=0;
	    	while(finish==false)
	    	{
	    		int x=(int) (8 * Math.random());
	    		
	    		if(check[x]==0)
	    		{
	    			//block[next]=x;
	    			check[x]=1;
	    			
	    			
	    				if(x<4)
			    		{
			    			button[next].setLocation(x*100,0);
			    			button[next].setVisible(true);
			    			button[next].setIcon(null);
			    		}
			    		
			    		else if(x>=4)
			    		{
			    			button[next].setLocation((x-4)*100,100);
			    			button[next].setVisible(true);
			    			button[next].setIcon(null);
			    		}
	    			
	    			
	    			next++;
	    		}
	    		int count=0;
	    		for(int i=0;i<check.length;i++)
		    	{
	    			if(check[i]==1)
	    				count++;
		    		
		    	}
	    		if(count==8)
	    		{
	    			finish=true;
	    		}
	    	}
	    	
	    	//System.out.println(lb1[1].getText());
	        }
        	
        	
	    
	    /*
        public String find(int b)
        {
        	int x;
        	String labelx="0c";
        	b=b-1;
        	if(block[b]<8)
        	{
        		x=block[b];
        		labelx=lb1[x].getText();
        	}
        	return labelx;
        	
        	
        }
        */
	    
	    public void putButton()
	    {
	    	for(int i=0;i<8;i++)
	    	{
	    		if(i<4)
	    		{
	    			button[i].setLocation(i*100,0);
	    		}
	    		
	    		else if(i>=4)
	    		{
	    			button[i].setLocation((i-4)*100,100);
	    		}
	    	}
	    }
	    public void showImage(String s)
	    {
	    	
	    }
	    public void findMatch()
	    {
	    	
	    }
	    public void delay(int x)
	    {
	    	
	    		System.out.println("abc");
		    	synchronized (timer){
		    	       try{
		    	          timer.wait(x);
		    	       } catch (InterruptedException f) {
		    	          f.printStackTrace();
		    	       }
		    	    }
		    	System.out.println("ffffc");
	    	
	    }
	    char sb;
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			sb=e.getKeyChar();
			delay(1000);
            if(sb=='f')
            	lb1[1].setLocation(430,30);
            	 System.out.println(sb);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode() == KeyEvent.VK_UP){
                lb1[1].setLocation(430,30);
                   System.out.println("Hi");}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_UP){
        		lb1[1].setLocation(40,30);
        		
        		delay(1000);
                System.out.println("Hi2");
               // change();
            }
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseClicked(MouseEvent e) 
	    {
			System.out.println("id"+e.getID());
			System.out.println("button "+e.getComponent().getName());
			int x=e.getXOnScreen();
			int y=e.getYOnScreen();
			System.out.println("x"+x);
			System.out.println("y"+y);
			
			String s=null;
			s=e.getComponent().getName();
			System.out.println("buttonname "+s);
			int i=Integer.parseInt(s);
			
			//restart
			if(i==10)
			{
				first=-1;second=-1;
				rand();
			}
			if(first==-1&&second==-1&&i!=9&&i!=10)
			{
				first=i;
				button[i].setIcon(ic[i]);
				//tempbutton=button[i];
			}
			else if(first!=-1&&second==-1&&i!=9&&i!=10)
			{
				second=i;
				System.out.println("f s "+first+" "+second);
				button[i].setIcon(ic[i]);
			}
			else if((first!=-1)&&(second!=-1)&&(s.equals("9"))&&i!=10)
			{
				if(first==(second-4)||(first-4)==second)
				{
					button[first].setVisible(false);
					button[second].setVisible(false);
				}
				else
				{
					button[first].setIcon(null);
					button[second].setIcon(null);
				}
				
				first=-1;second=-1;
				//tempbutton=null;
				System.out.println("check ");
			}
			
			//tempbutton=null;
			
			//System.out.println("block "+find(blockcli));
			
			//find(blockcli);
			/*
			if((x>200)&&(x<300)&&(y>200)&&(y<300))
			{
				System.out.println("Hi2");
				lb1[0].setLocation(-100,30);
			}
			*/
			//if(e.getXOnScreen())
	        //statement             
	    }

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println("id"+e.getID());
			int x=e.getXOnScreen();
			int y=e.getYOnScreen();
			System.out.println("x"+x);
			System.out.println("y"+y);
			
			if((x>200)&&(x<300)&&(y>200)&&(y<300))
			{
				System.out.println("Hi2");
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}