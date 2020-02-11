/**
 Class containing the information required to keep track of one unique
 team member--name and date added to the team.
 @author Eliza Nieves
 @author Raheel Ozair
 */
public class TeamMember
{
   private String name;
   private Date   startDate;

   /** 
   Constructor for TeamMember given a name (string) and a date (Date class).
   @param nm name of the TeamMember
   @param date the date the member was added (Date class)
   */
   public TeamMember(String nm, Date date)
   {
      this.name = nm;
      this.startDate = date;
   }

   /**
   Public method to retrieve the private startdate of the team member.
   @return start date of the Team Member instance (Date class)
   */
   public Date getStartDate()
   {
      return this.startDate;
   }

   /** 
   Tests to see if another object is equal to a specific instance of Team Member
   by checking its name and start date (if it is an instance of Team Member).
   @param obj object to compare to the instance of Team Member.
   @return boolean as to whether they are equal -- true if they are, etc.
   */
   public boolean equals(Object obj)
   {
      if(!(obj instanceof TeamMember)){
        System.out.println("instanceof");
         return false;
      }
      TeamMember test = (TeamMember) obj;
      if((!test.name.equals(this.name))||(!test.startDate.equals(this.startDate))){
         return false;
      }
      return true;
      //name and startDate must be the same
   }

   /**
   Returns a string containing the Team Member's name and start date.
   @return string with name and start date.
    */
   public String toString()
   {
      return this.name + " " + this.startDate;
       //name + " " + startDate;
   }

   public static void main(String [] args)
   {
     Date t1Date = new Date("02/28/2019");
     Date t2Date = new Date("03/30/2020");
     Date t3Date = new Date("02/28/2019");
     TeamMember t1 = new TeamMember("John",t1Date); //check constructor
     TeamMember t2 = new TeamMember("Wick",t2Date);
     TeamMember t3 = new TeamMember("John",t3Date); //I'm sorry I'm watching John Wick as I'm doing this // u r so valid
     System.out.println("Test 1: " + t1.toString() + "\n" + "Test 2: " +
      t2.toString() + "\n" + "Test 3: " + t3.toString()); //Check if toString() works

     if(t1.equals(t2)){ //test equals() in negative case
       System.out.println(t1.toString() + " and " + t2.toString() + " are the same.");
     }else{
       System.out.println(t1.toString() + " and " + t2.toString() + " are not the same.");
     }
     if(t1.equals(t3)){ //test equals() in positive case
       System.out.println(t1.toString() + " and " + t3.toString() + " are the same.");
     }else{
       System.out.println(t1.toString() + " and " + t3.toString() + " are not the same.");
     }
     String notATeamMember = "John 02/28/2019";
     if(t1.equals(notATeamMember)){ //check if
       System.out.println("This is surprising.");
     }else{
       System.out.println(t1.toString() + " is a team member variable, but " + notATeamMember + " is a string.");
     }

     System.out.println(t2.name + "'s start date: " + t2.getStartDate());

      //testbed main; you must include test cases that exercise
      //the constructor and all methods in this class.
   }
}
