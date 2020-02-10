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
     TeamMember t1 = new TeamMember("John","02/28/2019"); //check constructor
     TeamMember t2 = new TeamMember("Wick","03/30/2020");
     TeamMember t3 = new TeamMember("John","02/28/2019"); //I'm sorry I'm watching John Wick as I'm doing this
     System.out.println("Test 1: " + t1.toString() + "\n" + "Test 2: " +
      t2.toString() + "\n" + "Test 3: " t3.toString()); //Check if toString() works

     if(t1.equals(t2)){ //test equals() in negative case
       System.out.println(t1.toString() + " and " t2.toString() + " are the same.");
     }else{
       System.out.println(t1.toString() + " and " t2.toString() + " are not the same.");
     }
     if(t1.equals(t3)){ //test equals() in positive case
       System.out.println(t1.toString() + " and " t3.toString() + " are the same.");
     }else{
       System.out.println(t1.toString() + " and " t3.toString() + " are not the same.");
     }
     String notATeamMember = "John 02/28/2019";
     if(t1.equals(notATeamMember)){ //check if
       System.out.println("This is surprising.");
     }else{
       System.out.println(t1.toString() + " is a team member variable, but
        " + notATeamMember + " is a string.");
     }

     System.out.println(t2.name + "'s start date: " + t2.getStartDate());

      //testbed main; you must include test cases that exercise
      //the constructor and all methods in this class.
   }//TODO;
}
