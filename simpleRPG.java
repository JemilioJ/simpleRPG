import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.lang.Math;
public class pokemonBattle 
{

   public static void main(String [] args) 
   {
      int repeat = 0;
      int bet = 0;
      double account = 0;
   //Creates the player's object, has the player battle the computer in a loop, and determines the winner afterwards.
      while(repeat==0){
      double money = 0;
         bet = JOptionPane.showConfirmDialog(null, "Would you like to make a bet?");
         if(bet == JOptionPane.YES_OPTION)
         {
            money = Double.parseDouble(JOptionPane.showInputDialog("How much money will you bet?"));
         }
         Player cpu1 = getOpponentInfo();
         Player p1 = getPlayerChoice();
         int cpuHP = cpu1.getHP();
         int playerHP = p1.getHP();
      
         repeat = battle(p1, cpu1, cpuHP, playerHP);
         if(repeat==1)
         {
            account -= money;
            if(account < 0){
            JOptionPane.showMessageDialog(null, "Better luck next time!\nYou're in debt by $"+String.format("%.2f", ((-1)*account)));
            }
            else if(account > 0){
             JOptionPane.showMessageDialog(null, "Better luck next time!\nYou lost $"+String.format("%.2f", (money))+", but still have $"+String.format("%.2f", (account))+" left.");
            }
            else{
            JOptionPane.showMessageDialog(null, "Better luck next time!");
            }
            
         }
         if(repeat==2)
         {
            account += money;
           
            if(account < 0){
            JOptionPane.showMessageDialog(null, "Congratulations! You win!\nYou're still in debt by $"+String.format("%.2f", ((-1)*account))+", however.");
            }
            else if(account > 0){
             JOptionPane.showMessageDialog(null, "Congratulations! You win!\nYou made $"+String.format("%.2f", (money))+", and now have $"+String.format("%.2f", (account))+" in your account.");
            }
            else{
             JOptionPane.showMessageDialog(null, "Congratulations! You win!");
            }
         }
         
         int again = JOptionPane.showConfirmDialog(null, "Will you play again?");
         if(again == JOptionPane.YES_OPTION)
         {
            repeat = 0;
         }
         else{
            repeat = 1;
         }
      }
   //Moves will have an accuracy percentage, so they can't always land, making the battle more interesting.
   }
   
   public static Player getPlayerChoice() //choose what Pokemon you want, name it, and you're ready.
   {
      Player aPlayer = new Player();
      String name = "";
      String type = "";
      int hp = aPlayer.setHP(40);
      String mv1 = aPlayer.setMV1("Scratch");
      String mv2 = "";
   
      Object[] options = {"Bulbasaur", "Charmander", "Squirtle"}; //bulbasaur is x=0, charmander is x=1, squirtle is x=2
      ImageIcon icon = new ImageIcon("[...]");
      int x = JOptionPane.showOptionDialog(null, "Select your 1st Pokemon!"+"\n\n","Gotta catch 'em all!", 
         JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
      
      if(x==0){
         int a = JOptionPane.showConfirmDialog(null, "Would you like to name your Bulbasaur?");
         if(a == JOptionPane.YES_OPTION){
            name = aPlayer.setName(JOptionPane.showInputDialog("Enter its name: "));
            while(name.equals("") || name == null){
               name = aPlayer.setName(JOptionPane.showInputDialog("Enter a valid name: "));
            } 
         }
         else{
            name = aPlayer.setName("Bulbasaur");
         }
         type = aPlayer.setType("Grass");   
         mv2 = aPlayer.setMV2("Razor leaf");  
      }
      else if(x==1){
         int b = JOptionPane.showConfirmDialog(null, "Would you like to name your Charmander?");
         if(b == JOptionPane.YES_OPTION){
            name = aPlayer.setName(JOptionPane.showInputDialog("Enter its name: "));
            while(name.equals("") || name == null){
               name = aPlayer.setName(JOptionPane.showInputDialog("Enter a valid name: "));
            } 
         }
         else{
            name = aPlayer.setName("Charmander");
         }
         type = aPlayer.setType("Fire");
         mv2 = aPlayer.setMV2("Flamethrower");  
      }
      else{
         int c = JOptionPane.showConfirmDialog(null, "Would you like to name your Squirtle?");
         if(c == JOptionPane.YES_OPTION){
            name = aPlayer.setName(JOptionPane.showInputDialog("Enter its name: "));
            while(name.equals("") || name == null){
               name = aPlayer.setName(JOptionPane.showInputDialog("Enter a valid name: "));
            } 
         }
         else{
            name = aPlayer.setName("Squirtle");
         }
         type = aPlayer.setType("Water");
         mv2 = aPlayer.setMV2("Water gun");  
      }
      return aPlayer;
   }
   
   public static Player getOpponentInfo() //choose what Pokemon you want, name it, and you're ready.
   {
      Player cpu = new Player();
      String name = "";
      String type = "";
      int hp = cpu.setHP(40);
      String mv1 = cpu.setMV1("Scratch");
      String mv2 = "";
      int x = (int)(Math.random()*2)+1;
      
      if(x==1){
         name = cpu.setName("Chikorita");
         type = cpu.setType("Grass");   
         mv2 = cpu.setMV2("Vine whip");  
      }
      else if(x==2){
         name = cpu.setName("Cyndaquil");
         type = cpu.setType("Fire");
         mv2 = cpu.setMV2("Fire spin");  
      }
      else{
         name = cpu.setName("Totodile");
         type = cpu.setType("Water");
         mv2 = cpu.setMV2("Scald");  
      }
      return cpu;
   }
   
   public static int battle(Player p1, Player cpu, int cpuHP, int playerHP)
   {
      int outcome = 0;
      do{
         Object[] options = {p1.getMV1(), p1.getMV2()};
         int x = JOptionPane.showOptionDialog(null, "Fight to be the last one standing!\nSelect your move..."+"\n\n"+p1.getName()+"'s HP: "
            +playerHP+"\n"+cpu.getName()+"'s HP: "+cpuHP,"Gotta catch 'em all!", 
            JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            
         int cpuMove = (int)(Math.random()*2+1);//Opponent chooses a move value for their turn
         int y = 0;
         if(cpuMove == 1)
         {
            y=1;
            if(playerHP > 0 && cpuHP > 0){
               cpuHP = playerMove(p1, cpu, cpuHP, x, y);//cpu moves first
            }
            if(playerHP > 0 && cpuHP > 0){
               playerHP = cpuMove(p1, cpu, playerHP, y);  
            }               
         }
         if(cpuMove == 2)
         {
            y=2;
            if(playerHP > 0 && cpuHP > 0){
               playerHP = cpuMove(p1, cpu, playerHP, y); 
            }
            if(playerHP > 0 && cpuHP > 0){
               cpuHP = playerMove(p1, cpu, cpuHP, x, y);
            }
         }
         
         if(cpuHP <= 0){//if the opponent loses, outcome is one value
            outcome = 2;
         }
         else if(playerHP <= 0){//if you lose, outcome is another value
            outcome = 1;
         }
      }
      while(outcome==0);
      
      return outcome;
   }
   
   public static int playerMove(Player p1, Player cpu, int cpuHP, int x, int cpuMove){
      int accuracy = (int)(Math.random()*99)+1;
      if(x==0){//The player chooses a standard scratch move
         if(accuracy<=95){
            cpuHP = cpuHP - 3;
         }
         else{
            JOptionPane.showMessageDialog(null, "Your attack missed!");
         }
      }
      else if(x==1){//if the player chooses a move based on their pokemon's type
         if(p1.getType().equals("Water") && cpu.getType().equals("Water")){
            if(accuracy<=85){
               cpuHP = cpuHP - 4;
            }
            else{
               JOptionPane.showMessageDialog(null, "Your attack missed!");
            }
         }
         else if(p1.getType().equals("Water") && cpu.getType().equals("Fire")){
            if(accuracy<=85){
               cpuHP = cpuHP - 8;
               if(cpuMove==1){
                  JOptionPane.showMessageDialog(null, "It's super effective!");
               }
               else{
                  JOptionPane.showMessageDialog(null, "You chose "+p1.getMV2()+". It's super effective!");
               }
            }
            else{
               JOptionPane.showMessageDialog(null, "Your attack missed!");
            }
         }
         else if(p1.getType().equals("Water") && cpu.getType().equals("Grass")){
            if(accuracy<=85){
               cpuHP = cpuHP - 2;
               if(cpuMove==1){
                  JOptionPane.showMessageDialog(null, "It's not very effective.");
               }
               else{
                  JOptionPane.showMessageDialog(null, "You chose "+p1.getMV2()+". It's not very effective.");
               }
            }
            else{
               JOptionPane.showMessageDialog(null, "Your attack missed!");
            }
         }
         else if(p1.getType().equals("Fire") && cpu.getType().equals("Water")){
            if(accuracy<=85){
               cpuHP = cpuHP - 2;
               if(cpuMove==1){
                  JOptionPane.showMessageDialog(null, "It's not very effective.");
               }
               else{
                  JOptionPane.showMessageDialog(null, "You chose "+p1.getMV2()+". It's not very effective.");
               }
            }
            else{
               JOptionPane.showMessageDialog(null, "Your attack missed!");
            }
         }
         else if(p1.getType().equals("Fire") && cpu.getType().equals("Grass")){
            if(accuracy<=85){
               cpuHP = cpuHP - 8;
               if(cpuMove==1){
                  JOptionPane.showMessageDialog(null, "It's super effective!");
               }
               else{
                  JOptionPane.showMessageDialog(null, "You chose "+p1.getMV2()+". It's super effective!");
               };
            }
            else{
               JOptionPane.showMessageDialog(null, "Your attack missed!");
            }
         }  
         else if(p1.getType().equals("Fire") && cpu.getType().equals("Fire")){
            if(accuracy<=85){
               cpuHP = cpuHP - 4;
            }
            else{
               JOptionPane.showMessageDialog(null, "Your attack missed!");
            }
         }  
         else if(p1.getType().equals("Grass") && cpu.getType().equals("Water")){
            if(accuracy<=85){
               cpuHP = cpuHP - 8;
               if(cpuMove==1){
                  JOptionPane.showMessageDialog(null, "It's super effective!");
               }
               else{
                  JOptionPane.showMessageDialog(null, "You chose "+p1.getMV2()+". It's super effective!");
               }
            }
            else{
               JOptionPane.showMessageDialog(null, "Your attack missed!");
            }
         }  
         else if(p1.getType().equals("Grass") && cpu.getType().equals("Fire")){
            if(accuracy<=85){
               cpuHP = cpuHP - 2;
               if(cpuMove==1){
                  JOptionPane.showMessageDialog(null, "It's not very effective.");
               }
               else{
                  JOptionPane.showMessageDialog(null, "You chose "+p1.getMV2()+". It's not very effective.");
               }
            }
            else{
               JOptionPane.showMessageDialog(null, "Your attack missed!");
            }
         } 
         else if(p1.getType().equals("Grass") && cpu.getType().equals("Grass")){
            if(accuracy<=85){
               cpuHP = cpuHP - 4;
            }
            else{
               JOptionPane.showMessageDialog(null, "Your attack missed!");
            }
         }  
      }
      return cpuHP;
   }
   
   public static int cpuMove(Player p1, Player cpu, int playerHP, int cpuMove){
      int accuracy = (int)(Math.random()*99)+1;
      if(cpuMove==1)//Opponent chose tackle
      {
         if(accuracy<=95){
            playerHP = playerHP - 3;
            JOptionPane.showMessageDialog(null, "Your opponent used "+cpu.getMV1()+".");
         }
         else{
            JOptionPane.showMessageDialog(null, "Your opponent's attack missed!");
         }
      }
      
      else{//opponent chose a type-based move
         if(p1.getType().equals("Water") && cpu.getType().equals("Water")){
            if(accuracy<=85){
               playerHP = playerHP - 4;
               JOptionPane.showMessageDialog(null, "Your opponent used "+cpu.getMV2()+".");
            }
            else{
               JOptionPane.showMessageDialog(null, "Your opponent's attack missed!");
            }
         }
         else if(p1.getType().equals("Water") && cpu.getType().equals("Fire")){
            if(accuracy<=85){
               playerHP = playerHP - 2;
               JOptionPane.showMessageDialog(null, "Your opponent used "+cpu.getMV2()+". It's not very effective.");
            }
            else{
               JOptionPane.showMessageDialog(null, "Your opponent's attack missed!");
            }
         }
         else if(p1.getType().equals("Water") && cpu.getType().equals("Grass")){
            if(accuracy<=45){
               playerHP = playerHP - 2;
               JOptionPane.showMessageDialog(null, "Your opponent used "+cpu.getMV2()+". It's super effective!");
            }
            else{
               JOptionPane.showMessageDialog(null, "Your opponent's attack missed!");
            }
         }
         else if(p1.getType().equals("Fire") && cpu.getType().equals("Water")){
            if(accuracy<=45){
               playerHP = playerHP - 8;
               JOptionPane.showMessageDialog(null, "Your opponent used "+cpu.getMV2()+". It's super effective!");
            }
            else{
               JOptionPane.showMessageDialog(null, "Your opponent's attack missed!");
            }
         }
         else if(p1.getType().equals("Fire") && cpu.getType().equals("Grass")){
            if(accuracy<=85){
               playerHP = playerHP - 2;
               JOptionPane.showMessageDialog(null, "Your opponent used "+cpu.getMV2()+". It's not very effective.");
            }
            else{
               JOptionPane.showMessageDialog(null, "Your opponent's attack missed!");
            }
         }  
         else if(p1.getType().equals("Fire") && cpu.getType().equals("Fire")){
            if(accuracy<=85){
               playerHP = playerHP - 4;
               JOptionPane.showMessageDialog(null, "Your opponent used "+cpu.getMV2()+".");
            }
            else{
               JOptionPane.showMessageDialog(null, "Your opponent's attack missed!");
            }
         }  
         else if(p1.getType().equals("Grass") && cpu.getType().equals("Water")){
            if(accuracy<=85){
               playerHP = playerHP - 2;
               JOptionPane.showMessageDialog(null, "Your opponent used "+cpu.getMV2()+". It's not very effective.");
            }
            else{
               JOptionPane.showMessageDialog(null, "Your opponent's attack missed!");
            }
         }  
         else if(p1.getType().equals("Grass") && cpu.getType().equals("Fire")){
            if(accuracy<=45){
               playerHP = playerHP - 8;
               JOptionPane.showMessageDialog(null, "Your opponent used "+cpu.getMV2()+". It's super effective!");
            }
            else{
               JOptionPane.showMessageDialog(null, "Your opponent's attack missed!");
            }
         } 
         else if(p1.getType().equals("Grass") && cpu.getType().equals("Grass")){
            if(accuracy<=85){
               playerHP = playerHP - 4;
               JOptionPane.showMessageDialog(null, "Your opponent used "+cpu.getMV2()+".");
            }
            else{
               JOptionPane.showMessageDialog(null, "Your opponent's attack missed!");
            }
         }  
      }
      return playerHP;
   }
}
