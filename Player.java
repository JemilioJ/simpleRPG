public class Player
{
   private String name;
   private int hp;
   private String type;
   private String mv1;
   private String mv2;
   
   public Player()
   {
   }
   
   public String getName() 
   {
      return this.name;
   }
   
   public String getType() 
   {
      return this.type;
   }
   
   public int getHP() 
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
   public int setHP(int hp) 
   {
      this.hp = hp;
      return hp;
   }
   
   public String setMV1(String mv1) 
   {
      this.mv1 = mv1;
      return mv1;
   }
   
   public String setMV2(String mv2) 
   {
      this.mv2 = mv2;
      return mv2;
   }
   //______
   public String getStats()
   {
      return "Player's name: "+this.getName()+"\n"+
             "HP: "+this.getHP()+"\n"+
             "Moves: "+this.getMV1()+", "+this.getMV2();
   }
   
}
