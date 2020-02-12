import java.util.*;

/**
 Stores a date by using its day, month, and year.
 @author Eliza Nieves
 @author Raheel Ozair
 */
public class Date
{
   private int  day;
   private int  month;
   private int  year;

   /**
    Default constructor for date.  Parses and tokenizes a string,
    retrieving the day, month, and year.
    * @param d String to convert to a date.
    */
   public Date(String d)
   {

      StringTokenizer input = new StringTokenizer(d, "/");
      if(input.countTokens() != 3){
        this.month = -1;
        this.day = -1;
        this.year = -1;
      }else{
        this.month = stringToInt(input.nextToken());

        this.day = stringToInt(input.nextToken());

        this.year = stringToInt(input.nextToken());
      }



      //use StringTokenizer to parse the String and create a Date object
   }

   /**
    Converts a string made up of integer characters to an int.
    * @param str String to convert to an int.
    * @return integer value of string.
    */
   private int stringToInt(String str){
     //System.out.println(str);
      int sum = 0;
      int place = 1;
      for(int end = str.length() - 1; end >= 0; end--){
         sum += ((str.charAt(end) - '0') * place);
         place*=10;
      }
      return sum;
   }

   /**
    Constructor for date that clones another instance.
    * @param d Date to be cloned.
    */
   public Date(Date d)
   {
      this.day = d.day;
      this.month = d.month;
      this.year = d.year;
      //this is a constructor
   }

   /**
    Checks to see if a given date is valid. (Ex. 1/43/2019 is not valid).
    * @return Boolean as to whether the date is valid -- true if it is.
    */
   public boolean isValid()
   {
      int daysInMonth = 0;

      //yes this is ugly but this is verbatim the algo given in the
      //project description so lol
      if(month == 2){
         if(this.year % 4 == 0){
            if(this.year % 100 == 0){
               if(this.year % 400 == 0){
                  daysInMonth = 29;
               } else{
                  daysInMonth = 28;
               }
            } else{
               daysInMonth = 29;
            }
         } else{
            daysInMonth = 28;
         }
      }

      else if(this.month % 2 == 0){
         daysInMonth = 30;
      }
      else{
         daysInMonth = 31;
      }

      if(this.day > 0 && this.day < (daysInMonth + 1)){
         return true;
      }
      return false;
   }

   /**
    Returns the date as a string of the format "month/day/year"
    @return Date as a string.
    */
   @Override
   public String toString()
   {
      return this.month + "/" + this.day + "/" + this.year;
       //use the format "month/day/year"
   }

   /**
    Checks if an object is equal to this instance of Date,
    by verifying that it is also an instanceof Date,
    and that it shares the same day, month, and year.
    @return Boolean as to whether they are equal -- true if they are.
    */
   @Override
   public boolean equals(Object obj)
   {
      if(!(obj instanceof Date)){
         return false;
      }
      Date test = (Date) obj;
      if(!(test.isValid())){
        return false;
      }
      if(test.day != this.day || test.month != this.month || test.year != this.year){
         return false;
      }

      return true;
   }
}
