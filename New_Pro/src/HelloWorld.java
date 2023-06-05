import java.util.Scanner;


public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("Hello World");
		//Scanner sc= new Scanner(System.in);
		int note =0;
		switch (note)
		{
		   case 0:
			   System.out.println("Ouch!");
			   break;
		   case	10:
			   System.out.println("Vous avez juste la moyenne");
			   break;
		   case 20:
			   System.out.println("Parfait");
			   break;
		   default:
			   System.out.println("Il faut d'avantage travailler");
		}

	}

}
