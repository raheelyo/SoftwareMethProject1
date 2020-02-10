/**
  
 @author  
 */
 
public class ProjectManager
{
   Scanner stdin;
   Team cs213;
   public void run()
   {
       
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
		      break;
		 default: //deal with bad command here 
         }  
      }
      //write java code before you terminate the program
   } //run()
   
   private void add()
   {
	   
	   TeamMember currName = new TeamMember(stdin.next(),stdin.next());
	   
      	//must check if the date is valid
	//must call the contains() method to check if a given 
	//team member is in the team already
   }
   
   private void remove()
   {
      //must check if the date is valid
	   
   }
   
   private void print()
   {
      //must check if the team has 0 members. 
   }   
} //ProjectManager
