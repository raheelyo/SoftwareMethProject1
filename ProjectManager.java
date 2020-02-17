//package softwaremethproject1;
import java.util.Scanner;
/**
 Reading from standard input, allows users to create and manage teams
 through simple commands.
 @author Eliza Nieves
 @author Raheel Ozair
 */
public class ProjectManager
{
   Scanner stdin = new Scanner(System.in);
   Team cs213 = new Team();

   /**
    * Allows user to input commands and make/edit teams.
    */
   public void run()
   {
     System.out.println("Let's start a new team!");
     boolean done = false;
     while ( !done )
     {
       String command = stdin.next();
       switch (command)
       {
         case "A": add();
         break;

         case "P": print();
         break;

         case "R": remove();
         break;

         case "Q": print();
         System.out.println("The team is ready to go!");
         done = true;
         break;

         default: System.out.println("Command '" + command + "' is not supported!"); //deal with bad command here
       }
     }
      //write java code before you terminate the program
    } //run()

   /**
   Given input of the form "Name xx/xx/xxxx" from stdin, creates a new Team Member,
   checks if they are valid and not already in the team, and then
   adds them to team cs213.
    */
   private void add()
   {
     String currName = stdin.next();
     String inputDate = stdin.next();
     Date currDate = new Date(inputDate);
     //check first if date is valid
     if(currDate.toString().equals("-1/-1/-1")){
       System.out.println(inputDate + " is not a date in the form MM/DD/YYYY.");
       return;
     }
     if(!currDate.isValid()){
       System.out.println(currDate.toString() + " is not a valid date!");
       return;
     }
     //now check if name/start date exists
     TeamMember newMember = new TeamMember(currName,currDate);
     if(cs213.isEmpty()){
       cs213.add(newMember);
       System.out.println(newMember.toString());
     }else if(!cs213.contains(newMember)){
       cs213.add(newMember);
       System.out.println(newMember.toString());
     }else{
       System.out.println(newMember.toString() + " is already in the team.");
     }
   }

   /**
   Given input of the form "Name xx/xx/xxxx" from stdin, checks
   if the date is valid, if the team member with the name and date added
   exists, and, if so, removes said team member from cs213.
    */
   private void remove()
   {
     String currName = stdin.next();
     Date currDate = new Date(stdin.next());
      //must check if the date is valid
      if(!currDate.isValid()){
        System.out.println(currDate.toString() + " is not a valid date!");
        return;
      }
      //now check if member exists in team
      TeamMember member = new TeamMember(currName,currDate);
      if(!cs213.contains(member)){
        System.out.println(member.toString() + " is not a team member.");
      }else{
        boolean wasRemoved = cs213.remove(member);
        //System.out.println(wasRemoved);
        if(wasRemoved){
          System.out.println(member.toString() + " has left the team.");
        }else{
          System.out.println("Removal failed.");
        }

      }
    }

   /**
   Prints out the names and dates added of all team members in cs213.
    */
   private void print()
   {
     if(cs213.isEmpty()){
       System.out.println("We have 0 team members!");
     }else{
       cs213.print();
     }
      //must check if the team has 0 members.
   }
} //ProjectManager
