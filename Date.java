import java.util.*;

/**

 @author
 */
public class Date
{
   private int  day;
   private int  month;
   private int  year;

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

   public Date(Date d)
   {
      this.day = d.day;
      this.month = d.month;
      this.year = d.year;
      //this is a constructor
   }

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

   @Override
   public String toString()
   {
      return this.month + "/" + this.day + "/" + this.year;
       //use the format "month/day/year"
   }

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
