package Validators;

public class UserInputValidator {
  private static boolean isValidNumber(String s){
      try{
          int n = Integer.parseInt(s);
          if ( n>=0 && n<8)
              return true;
          else return false;
      }
      catch (NumberFormatException numberFormatException){
          return false;
      }
  }

  private static boolean isValidCharacter(char c){
      boolean b = true;
      c = Character.toLowerCase(c);
      int number  = c-'a';
      if (number >= 0 && number <8)
        return true;
      return false;
  }
 public static boolean isValidInput(String s){
      String[] inputs = s.split(" ");
      if (inputs.length != 2)
          return false;

      char[] startSpot = inputs[0].toCharArray();
      char[] endSpot = inputs[1].toCharArray();

      if (startSpot.length!=2 || endSpot.length!=2)
          return false;

      if (!isValidCharacter(startSpot[0]) || !isValidNumber(String.valueOf(startSpot[1])))
          return false;

      if (!isValidCharacter(endSpot[0]) || !isValidNumber(String .valueOf(endSpot[1])))
         return false;

      return true;


 }

}
