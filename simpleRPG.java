import java.util.*;
import java.io.*;
public class simpleRPG
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      
      System.out.println("Battle increasingly difficult monsters to level up!\nIt's up to you to win!");
      System.out.println("What's your character's name?");
      String str0 = kb.nextLine();
      System.out.println("What's your rival's name?");
      String str1 = kb.nextLine();
      System.out.println("Here's your initial stats");
      double hp = 10.0;
      int lvl = 0;
      int xp = 0;
      int mv1 = 1;
      int mv2 = 2;
      
      double hp1 = 10.0;
      
      double hpx = 1;
     
      while (hp1>0 && hp!=0)
      {
         System.out.println(str1+"'s hp is "+hp1+" and your hp is "+hp+".\nPlease select your move: (1) or (2)");
         int move = kb.nextInt();
         if (move == 1)
         {
            hpx = (Math.random()*(2)+1)+1;
            if(hpx==1)
            {
               hp=hp-hpx;
            }
            hp1=hp1-1;
         }
         if (move==2)
         {
            hpx = (Math.random()*(2)+1)+1;
            
            hp1=hp1-1;
            if(hpx==2)
            {
               hp=hp-hpx;
            }
         }
      }
      if (hp1==0)
      {
         System.out.println("Congratulations! You beat "+str1+". On to the next!");
         xp = xp + 10;
      }
      if (xp==30)
      {
         lvl++;
      }
      if (hp==0) 
      {
         System.out.println("Oops! Start again!");
      }     
   }
}
