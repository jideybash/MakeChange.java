
package makechange;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author jideybash
 */
public class MakeChangeXtra {

    static Scanner sc = new Scanner(System.in);
    public static boolean givehd = false;
    public static void main(String[] args) {
      int cents;
      String choice;
      Random rnd = new Random();
     
        
        System.out.println("Welcome to the Make Change program.");
        System.out.print("Do you want half-dollars? (Y/N):");
        choice = sc.nextLine();
        if (choice.toUpperCase().startsWith("Y")) {
            givehd = true;
        }
        
        cents = getDollar();
        while (cents != 0) {
           int even = rnd.nextInt()%2; 
            if(even==0){
                makeChangeAddMethod(cents);
            }else{
                makeChangeDivMethod(cents);
            }
            
            cents = getDollar();

    }
        System.out.println("Thank you for using the make change Calculator");
    }
     public static int getCents() {
         //get a int value between 0 and 100
         //error trap for bad data...
         int c;
         
         do {
            
            try {
                System.out.print("What value would you like for Change? (1-500, 0=quit): ");
                c = sc.nextInt();
                c = c * 100;
                if (c < 0) {
                    System.out.println("No Negative value");
                } else if (c > 500) {
                    System.out.println("I can only make change for a Dollar");
                }
        
            } catch (Exception e) {
                System.out.println ("Illegal input: integers from 0 to 500 only");
                
                sc.nextLine();
                c = -1;
                        
    }
            } while (c < 0 || c > 500);
        
        return c;
}
     public static int getDollar() {
         //get a int value between 0 and 100
         //error trap for bad data...
         double d;
         int c;
         
         do {
            
            try {
                System.out.print("What value would you like for Change? (1-5, 0=quit): ");
                d = sc.nextDouble();
                c = (int) (d * 100);
                if (c < 0) {
                    System.out.println("No Negative value");
                } else if (c > 500) {
                    System.out.println("I can only make change for a Dollar");
                }
        
            } catch (Exception e) {
                System.out.println ("Illegal input: integers from 0 to 5 only");
                
                sc.nextLine();
                c = -1;
                        
    }
            } while (c < 0 || c > 500);
        
        return c;
}
    public static void makeChangeAddMethod(int cents){
        int q=0,d=0,n=0,p,hd=0;
        int x = 0;
       
         if (givehd == true){
             while(x + 50 <= cents) {
            hd++;   // same as: q+1 or q=q+1
            x += 50;
         } 
     
        }
        
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
        
         System.out.print("By the Additive method, for " + cents + " cents I give: ");
         if (givehd==true && hd>0){
             System.out.print(hd + " halfdollars,");
         }
    System.out.println(q + " quarters, " +
                        d + " dimes, " +
                         n + " nickles, " +
                         p + " pennies. ");    
    }
   public static void makeChangeDivMethod(int cents){
    int q=0,d=0,n=0,p=0,hd=0;
    int x = cents;
    
    if (givehd == true) {
        
        hd = x / 50;
        x = x - (hd * 50);
    }
    q = x / 25;  //integer division
    x = x - (q * 25); // remove from x the value of quarters given
    
    d = x / 10;
    x = x - (d * 10);
    
    n = x / 5;
    x = x - (n * 5);
    
    
    //if give hd == false, don't even mention half-dollars....
    
    System.out.print("By the Div method, for " + cents + " cents I give: ");
     if (givehd==true && hd>0){
             System.out.print(hd + " halfdollars,");
         }
    System.out.println(q + " quarters, " +
                        d + " dimes, " +
                         n + " nickles, "+
                         p + " pennies. ");
        }
    }
