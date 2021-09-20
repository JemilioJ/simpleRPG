public class Player
{
   private String name;
   private double hp;
   private int lvl;
   private int xp;
   private String mv1;
   private String mv2;
   
   public Player(double hp, int lvl, int xp, String mv1, String mv2)
   {
      this.name = name;
      this.hp = 10.0;
      this.lvl = 1;
      this.xp = 0;
      this.mv1 = "Scratch";
      this.mv2 = "Growl";
   }
   
   public String getName() 
   {
      return this.name;
   }
   
   public double getHP() 
   {
      return this.hp;
   }
   
   public int getlvl() 
   {
      return this.lvl;
   }
   
   public int getXP() 
   {
      return this.xp;
   }
   
   public String getMV1() 
   {
      return this.name;
   }
   
   public String getMV2() 
   {
      return this.mv2;
   }
   
   
   public boolean setName(String name) 
   {
      if (!name.equals("")) 
      {
         this.name = name;
         return true;
      }
      else {
         return false;
      }
   
   }
   //______
   public void setHP(double hp) 
   {
      this.hp = hp;
   }
   
   public void setlvl(int lvl) 
   {
      this.lvl = lvl;
   }
   
   public void setXP(int xp) 
   {
      this.xp = xp;
   }
   
   public void setMV1(String mv1) 
   {
      this.mv1 = mv1;
   }
   
   public void setMV2(String mv2) 
   {
      this.mv2 = mv2;
   }
   //______
   public String getStats()
   {
      return "Player's name: "+this.getName()+"\n"+
             "HP: "+this.getHP()+"\n"+
             "XP: "+this.getXP()+"\n"+
             "Level: "+this.getlvl()+"\n"+
             "Moves: "+this.getMV1()+", "+this.getMV2();
   }
   
}