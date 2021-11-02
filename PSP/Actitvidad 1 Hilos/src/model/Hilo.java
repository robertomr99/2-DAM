package model;

public class Hilo extends Thread{

	 private int iDormir;
	    
	    public Hilo(int iDormir)
	    {
	        this.iDormir = iDormir;
	    }
	    
	    public void run()
	    {
	        for (int i = 1; i < 16; i++) 
	        {
	            System.out.println(""+i);
	            try 
	            {
	                sleep(iDormir);	            } 
	            catch (InterruptedException ex) 
	            {
	                System.out.println("Error: " + ex.toString());
	            }
	        }
	    }
}
