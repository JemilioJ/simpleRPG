public class Player
{
   private String name;
   private double hp;
   private String type;
   private String mv1;
   private String mv2;
   
   public Player(String name, String type, double hp, String mv1, String mv2)
   {
      this.name = name;
      this.type = type;
      this.hp = hp;
      this.mv1 = mv2;
      this.mv2 = mv1;
   }
   
   public String getName() 
   {
      return this.name;
   }
   
   public String getType() 
   {
      return this.type;
   }
   
   public double getHP() 
   {
      return this.hp;
   }
   
   public String getMV1() 
   {
      return this.mv1;
   }
   
   public String getMV2() 
   {
      return this.mv2;
   }
   
   
   public String setName(String name) 
   {
      this.name = name;
      return name;
   }
   public String setType(String type) 
   {
      this.type = type;
      return type;
   }
   //______
   public void setHP(double hp) 
   {
      this.hp = hp;
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
             "Moves: "+this.getMV1()+", "+this.getMV2();
   }
   
}
