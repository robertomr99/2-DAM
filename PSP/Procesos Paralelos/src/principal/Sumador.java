package principal;

public class Sumador {

	
	    public static int sumar(int numero1, int numero2) 
	    {
	        int suma = 0;
	        for (int i = numero1; i <= numero2; i++) 
	        {
	            suma += i;
	        }
	        return suma;
	    }

	    public static void main(String[] args) 
	    {
	    
	        int numero1 = Integer.valueOf(args[0]);
	        int numero2 = Integer.valueOf(args[1]);
	        
	        System.out.println(sumar(numero1, numero2));
	    }
}
