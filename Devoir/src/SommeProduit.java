import java.util.ArrayList;


public class SommeProduit {

    public static void main(String[] args) {
    	ArrayList<Integer> tableau = new ArrayList<Integer>();
    	int n = 10; 		
    	while (tableau.size()<20) {
        		++n;
        		if (sommeProduitEgaux(n)) {
        			tableau.add(n);
        			}
            }
   
    	
        for (Integer v:tableau) {
        	int nbre = v;
        	System.out.print(nbre + " ");
        }
}
  static int somme (int y)
   {int x=y;
   	   int m; 
   	   int add = 0;
   	   ArrayList<Integer> rest = new ArrayList<Integer>();
   
    	while (x > 0) {
    		m = x%10;
    		rest.add(m);
    		x = x /10;
      	}
    	for (Integer index: rest) {
    		add = add + index;
    		
     }
    	return add;
   }
  static int produit (int y)
  {
	ArrayList<Integer> tab = new ArrayList<Integer>();
	String h = Integer.toString(y);
	int pr = 1;
	char g=' ';
	for (int a=0; a<=h.length()-1; ++a) {
		g = h.charAt(a);
		String b = String.valueOf(g);
		int e = Integer.parseInt(b);
		tab.add(e);
	}
	for (Integer index:tab)	{
		pr = pr * index;
		
	}
	return pr;
  }
  static boolean sommeProduitEgaux(int n)
  {
	  return (somme(n)==produit(n));
	  }
  }
