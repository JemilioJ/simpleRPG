import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class RPG_Main 
{

   public static void main(String [] args) 
   {
   //Creates the player's object, has the player battle the computer in a loop, and determines the winner afterwards.
   //Moves will have an accuracy percentage, so they can't always land, making the battle more interesting.
   }
   
   public static Player getPlayerChoice() //choose what Pokemon you want, name it, and you're ready.
   {
      Player aPlayer = new Player();
      String name = "";
      String type = "";
      double hp = aPlayer.setHP(30);
      String mv1 = aPlayer.setMV1("Scratch");
      String mv2 = aPlayer.setMV2("Flamethrower");
   
      Object[] options = {"Bulbasaur", "Charmander", "Squirtle"}; //bulbasaur is x=0, charmander is x=1, squirtle is x=2
      ImageIcon icon = new ImageIcon("[...]");
      int x = JOptionPane.showOptionDialog(null, "Select your 1st Pokemon!"+"\nPlayer's Score is: "+pScore+"\nComputer's Score is: "+cScore,"Play Grass-Fire-Water!", 
         JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
      
      if(x==0){
         int a = JOptionPane.showConfirmDialog("Would you like to name your Bulbasaur?");
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
      }
      else if(x==1){
         int b = JOptionPane.showConfirmDialog("Would you like to name your Charmander?");
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
      }
      else{
         int c = JOptionPane.showConfirmDialog("Would you like to name your Squirtle?");
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
      }
      return aPlayer;
   }
   
   
   
}
