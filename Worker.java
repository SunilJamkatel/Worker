/**
   @author Sunil Jamkatel
   @version March 10,2016
*/

/** A worker class has details and informations
    about a worker.
*/
public class Worker
{ 
   // Declaring variables
   private String name;
   private String ID;
   private String level;
   private int months;
   private int option;
   
   /**
      Constructs a worker with name, ID, level, and option
      @param name the name of the worker
      @param ID the ID of the worker
      @param level the level of the worker
      @param option the option of the worker
   */
   public Worker(String name, String ID, String level, int option)
   {
      this.name = name;
      this.ID = ID;
      this.level = level;
      this.option = option;
      months = 0;
   }
   
   /**
      Constructs a worker with name, ID, and option
      @param name the name of the worker
      @param ID the ID of the worker
      @param option the option of the worker
   */
   public Worker(String name, String ID, int option)
   {
      this.name = name;
      this.ID = ID;
      this.option = option;
      level = "apprentice";
      months = 0;
   }
   
   /**
      Constructs a worker with all default values
   */
   public Worker()
   {
      name = "Anonymous";
      ID = "000000000";
      level = "apprentice";
      months = 0;
      option = 1;
   }
   /**
      Processes the promotion request by the user
      @return the worker has been promoted or not
   */
   public boolean promote()
   {
      if(level.equals("apprentice"))
      {
         level = "skilled";
      }
      else if(level.equals("skilled"))
      {
         level = "expert";
      }
      else
      {
         return false;
      }
      return true;
   }
   
   /**
      Processes the demotion request by the user
      @return the worker has been demoted or not
   */
   public boolean demote()
   {
      if(level.equals("expert"))
      {
         level = "skilled";
      }
      else if(level.equals("skilled"))
      {
         level = "apprentice";
      }
      else
      {
         return false;
      }
      return true;
   }
   
   /**
      Computes the insurace cost of the worker.
      @return the total cost of insurance for the worker.
   */
   public double calcInsuranceCost()
   {
      final double MEDICAL = 32.50;
      final double DENTAL = 10;
      final double VISION = 10;
      double insuranceCost = 0;
      
      if (option == 1)
      {
         insuranceCost = MEDICAL;
      }
      else if(option == 2)
      {
         insuranceCost =  MEDICAL+DENTAL;
      }
      else if(option == 3)
      {
         insuranceCost = MEDICAL+VISION;
      }
      else if(option == 4)
      {
         insuranceCost = MEDICAL+DENTAL+VISION;
      }  
      return insuranceCost;    
   }
   
   /**
      Calcuates the total gross pay of the worker.
      @param hoursWorked total hours worked by the worker in a week
      @return total weekly pay of the worker
   */
   public double calcGrossPay(double hoursWorked)
   {
      // some constants to avoid magic numbers
      final double HR_APPRENTICE = 17.00; 
      final double HR_SKILLED = 24.00;
      final double HR_EXPERT = 30.00;
      final double HR_BONUS = 1.5;
      final double OVER_HOURS = 40.0;
      double totalPay = 0;
      
      // if-else condition to determine the level and hours of work by the worker
      if (level.equals("apprentice"))
      {
         if (hoursWorked > 0 && hoursWorked <= OVER_HOURS)
         {
            totalPay = HR_APPRENTICE * hoursWorked;
         }
         else if (hoursWorked > OVER_HOURS)
         {
            totalPay = HR_APPRENTICE*(OVER_HOURS+((hoursWorked-40)*HR_BONUS));
         }
         else 
         {
            totalPay = 0;
         }
      }
      else if (level.equals("skilled"))
      {
         if (hoursWorked > 0 && hoursWorked <= OVER_HOURS)
         {
            totalPay = HR_SKILLED * hoursWorked;
         }
         else if (hoursWorked > OVER_HOURS)
         {
            totalPay = HR_SKILLED*(40+((hoursWorked-40)*HR_BONUS));
         }
         else
         {
            totalPay = 0;
         }
      }
      else if (level.equals("expert"))
      {
         if (hoursWorked > 0 && hoursWorked <=OVER_HOURS)
         {
            totalPay = HR_EXPERT * hoursWorked;
         }
         else if (hoursWorked > OVER_HOURS)
         {
            totalPay = HR_EXPERT*(40+((hoursWorked-40)*HR_BONUS));
         }
         else 
         {
            totalPay = 0;
         }
      }
      return totalPay;
}
   
   /**
      Determines the total leave hours for a worker.
      @return the total leave hours for a worker
   */
   public int calcLeave()
   {
      int leaveHours = 0;
      
      // if-else condition to determine the level of worker and
      // to determine his leave hour accordingly.
      if (level.equals("apprentice"))
      {
         if (months>=0 && months<=23)
         {
            leaveHours = 1;
         }
         else if (months>=24 && months <=59)
         {
            leaveHours = 2;
         }
         else if(months>=60)
         {
            leaveHours = 3;
         }
      }else if (level.equals("skilled"))
      {
         if (months>=0 && months<=23)
         {
            leaveHours = 2;
         }
         else if (months>=24 && months <=59)
         {
            leaveHours = 3;
         }
         else if(months>=60)
         {
            leaveHours = 4;
         }
      }else if(level.equals("expert"))
      {
         leaveHours = 5;
      }
      return leaveHours;
   }
   
   /**
      Gives the name of the worker
      @return the name of the worker
   */
   public String getName()
   {
      return name;
   }
   
   /**
      Gives the ID of the worker
      @return the ID of the worker
   */
   public String getID()
   {
      return ID;
   }
   
   /**
      Gives the level of the worker.
      @return the current level of the worker
   */
   public String getLevel()
   {
      return level;
   }
   
   /**
      Gets the month of the worker.
      @return the worker's month
   */
   public int getMonths()
   {
      return months;
   }
   
   /**
      Gets the option for the insurance type
      @return the insurance option
   */
   public int getOption()
   {
      return option;
   }
   
   /**
      Sets the month of the worker
      @param month sets the month of the worker
   */
   public void setMonths(int months)
   {
      this.months = months;
   }
   
   /**
      Formats the output in one line.
      @return the worker's name, ID, level, month and insurance option
   */
   public String toString()
   {
      return ("Name of employee: " + name + "\nID of employee: "+ ID + "\nLevel of employee: " + level + "\nMonths employee has worked: " + months + "\nInsurance Plan: " + option);
   }
   
   
}