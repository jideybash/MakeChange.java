
package makechange;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author jideybash
 */
public class MakeChange {

    static Scanner sc = new Scanner(System.in);
    static boolean givehd = false;
    public static void main(String[] args) {
      int cents;
      String choice;
      Random rnd = new Random();
        
        System.out.println("Welcome to the Make Change program.");
        //System.out.print("Do you want half-dollars? (Y/N):");
        
        cents = getCents();
        while (cents != 0) {
            makeChangeAddMethod(cents);
            
            cents = getCents();

    }
        System.out.println("Thank you for using the make change Calculator");
    }
     public static int getCents() {
         //get a int value between 0 and 100
         //error trap for bad data...
         int c;
         
         do {
            
            try {
                System.out.print("What value would you like for Change? (1-100, 0=quit): ");
                c = sc.nextInt();
                if (c < 0) {
                    System.out.println("No Negative value");
                } else if (c > 100) {
                    System.out.println("I can only make change for a Dollar");
                }
        
            } catch (Exception e) {
                System.out.println ("Illegal input: integers from 0 to 100 only");
                
                sc.nextLine();
                c = -1;
                        
    }
            } while (c < 0 || c > 100);
        
        return c;
}
    public static void makeChangeAddMethod(int cents){
        int q=0,d=0,n=0,p;
        int x = 0;
       
        
        while(x + 25 <= cents) {
            q++;   // same as: q+1 or q=q+1
            x += 25;
        }
        
        while (x + 10 <= cents) {
            d++;
            x += 10;
        }
        
        while (x + 5 <= cents) {
            n++;
            x += 5;
        }
        
        p = cents - x;
        
         System.out.print("For " + cents + " cents I give: ");
    System.out.println(q + " quarters, " +
                        d + " dimes, " +
                         n + " nickles, " +
                         p + " pennies. ");    
    }
   public static void makeChangeDivMethod(int cents){
    int q,d,n,p,hd;
    int x = cents;
    
    if (givehd == false) {
        
        hd = x / 50;
        x = x - (hd * 50);
    }
    q = x / 25;  //integer division
    x = x - (q * 25); // remove from x the value of quarters given
    
    d = x / 10;
    x = x - (d * 10);
    
    n = x / 5;
    x = x - (n * 5);
    
    p = x;
    
    //if give hd == false, don't even mention half-dollars....
    
    System.out.print("By the Div method, for " + cents + " cents I give: ");
    System.out.println(q + " quarters, " +
                        d + " dimes, " +
                         n + " nickles, "+
                         p + " pennies. ");
        }
    }
