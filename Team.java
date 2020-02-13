package project1;
/**
 Team groups a list of Team Members in an array, keeping track of how many
 members are in the team at a time. Has the ability to grow, shrink, and retrieve 
 information about team members.
 @author Eliza Nieves
 @author Raheel Ozair
 */
public class Team
{
   private final int NOT_FOUND = -1;
   private final int GROW_SIZE = 4; //initial and grow size
   private TeamMember [] team;
   private int numMembers;

   /**
   Default constructor for team, with 0 members and a size capacity of 4.
    */
   public Team()
   {
      this.team = new TeamMember[GROW_SIZE];
      this.numMembers = 0;
      //this is the default constructor
   }

   /**
    Searches the array of team members for a specific team member 
    using the Team Member equals function, returning the index of
    where the team member is found. 
    @param m the Team Member to look for in the team array.
    @return the index that the Team Member is stored at in the array.
            returns -1 if not found.
    */
   private int find(TeamMember m)
   {
     //System.out.println(this.toString());
      for(int i = 0; i < numMembers; i++){
         if(this.team[i].equals(m)){
            return i;
         }
      }
      return NOT_FOUND;
   }

   /**
    Increases the size of the team array by GROW_SIZE when
    the array has no more room.
    */
   private void grow()
   {
      TeamMember [] remake = new TeamMember [this.team.length + GROW_SIZE];
      for(int i = 0; i < remake.length; i++){
         remake[i] = this.team[i];
      }
      this.team = remake;
   }

   /**
    Checks to see if there are any Team Members in the team (if
    the number of members is 0).
    @return boolean as to whether the array is empty -- true if it is.
    */
   public boolean isEmpty()
   {
      if(this.numMembers < 1){
         return true;
      }
      return false;
   }

   /**
    Given a Team Member, adds them to the end of the team array.
    @param m Team Member to be added to the array.
    */
   public void add(TeamMember m)
   {
      if(!(this.team.length > this.numMembers)){
         this.grow();
      }
      this.team[this.numMembers] = m;
      this.numMembers++;
   }

   /**
    Removes a given Team Member from the team array.
    @param m Team Member to be removed.
    @return boolean regarding the success of the removal-- if the team
            member was found and removed, returns true. Else, false.
    */
   public boolean remove(TeamMember m)
   {
      int toDelete = this.find(m);
      if(toDelete == -1){
         return false;
      }
      if(this.numMembers == 1){
        this.team[toDelete] = null;
      }else{
        this.team[toDelete] = this.team[this.numMembers - 1];
      }
      this.team[this.numMembers-1] = null;
      this.numMembers -= 1;
      return true;
   }

   /**
    Public method to see if the team array contains a given Team Member.
    @param m Team Member to search for.
    @return boolean returning true if the array contains m, false otherwise.
    */
   public boolean contains(TeamMember m)
   {
      if(this.find(m) == -1){
         return false;
      }
      return true;
   }

   /** 
    Prints out a list of all Team Members in the team list.
   */
   public void print()
   {
      for(int i = 0; i < numMembers; i++){
         System.out.print(this.team[i].toString() + "\n");
      }
      System.out.println("-- end of list --");
      //set up a for loop and call the toString() method
   }
}
