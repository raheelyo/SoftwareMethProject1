
/**
  
 @author  
 */
public class Team 
{
   private final int NOT_FOUND = -1;
   private final int GROW_SIZE = 4; //initial and grow size
   private TeamMember [] team;
   private int numMembers;
   
   public Team()
   {
      this.team = new TeamMember[GROW_SIZE];
      this.numMembers = 0;
      //this is the default constructor
   }
   
   private int find(TeamMember m)
   {
      for(int i = 0; i < this.team.length; i++){
         if(this.team[i].equals(m)){
            return i;
         }
      }
      return NOT_FOUND;
   }
   
   private void grow()
   {
      TeamMember [] remake = new TeamMember [this.team.length + GROW_SIZE];
      for(int i = 0; i < remake.length; i++){
         remake[i] = this.team[i];
      }
      this.team = remake;
   }
   
   public boolean isEmpty()
   {
      if(this.numMembers < 1){
         return true;
      }
      return false;
   }
   
   public void add(TeamMember m)
   {     
      if(!(this.team.length > this.numMembers)){
         this.grow();
      }
      this.team[this.numMembers] = m;
      this.numMembers++;
   }
   
   public boolean remove(TeamMember m)
   {
      int toDelete = this.find(m);
      if(toDelete == -1){
         return false;
      }
      this.team[toDelete] = this.team[this.numMembers - 1];
      this.team[this.numMembers] = null;
      return true;
   } 
   
   public boolean contains(TeamMember m)
   {
      if(this.find(m) == -1){
         return false;
      }
      return true;
   } 
   
   public void print()
   {
      for(int i = 0; i < numMembers; i++){
         System.out.print(this.team[i].toString() + "\n");
      }
      //set up a for loop and call the toString() method
   } 
}
