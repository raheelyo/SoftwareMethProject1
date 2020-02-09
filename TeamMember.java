/**
 
 @author  
 */
public class TeamMember 
{
   private String name;
   private Date   startDate;
   
   public TeamMember(String nm, Date date)
   {
      this.name = nm;
      this.startDate = date;
   }
   
   public Date getStartDate()
   {
      return this.startDate;
   }
   
   public boolean equals(Object obj)
   {
      if(!(obj instanceof TeamMember)){
         return false;
      }
      TeamMember test = (TeamMember) obj;
      if(test.name != this.name || test.startDate != this.startDate){
         return false;
      }
      return true;
      //name and startDate must be the same
   }  
   
   public String toString()
   {
      return this.name + " " + this.startDate;
       //name + " " + startDate;
   }

   public static void main(String [] args)
   {
      //testbed main; you must include test cases that exercise 
      //the constructor and all methods in this class.
   }//TODO;
}