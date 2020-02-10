/**

 @author
 */

public class ProjectManager
{
   Scanner stdin;
   Team cs213;
   public void run()
   {
     System.out.println("Let's start a new team!");
     boolean done = false;
     while ( !done )
     {
       String command = stdin.next();
       switch (                )
       {
         case 'A': add();
         break;

         case 'P': print();
         break;

         case 'R': remove();
         break;

         case 'Q': print();
         System.out.println("The team is ready to go!");
         done = true;
         break;

         default: System.out.println("Command '" + command + "' is not supported!") //deal with bad command here
       }
     }
      //write java code before you terminate the program
    } //run()

   private void add()
   {
     String currName = stdin.next();
     Date currDate = new Date(stdin.next());
     //check first if date is valid
     if(!currDate.isValid()){
       System.out.println(currDate.toString() + " is not a valid date!");
       return;
     }
     //now check if name/start date exists
     TeamMember newMember = new TeamMember(currName,currDate);
     // memberExists = cs213.find(newMember);
     if(cs213.find(newMember) == -1){
       cs213.add(newMember);
       System.out.println(newMember.print().toString());
     }else{
       System.out.println(newMember.toString() + " is already in the team.")
     }
   }

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
      if(cs213.find(newMember) == -1){
        System.out.println(member.toString() + " is not a team member.");
      }else{
        cs213.remove(member);
        System.out.println(member.toString() + " has left the team.");
      }

   }

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
