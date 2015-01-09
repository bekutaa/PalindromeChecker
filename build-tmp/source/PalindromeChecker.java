import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PalindromeChecker extends PApplet {

public void setup()
{
  String lines[] = loadStrings("palindromes.txt");
  println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      println(lines[i] + " IS a palidrome.");
    }
    else
    {
      println(lines[i] + " is NOT a palidrome.");
    }
  }
}

public boolean palindrome(String word)
{
  String temp = word.replaceAll("[^a-zA-Z]","").toLowerCase();
  
  for(int i = 0; i < temp.length(); i++)
  {
    if(temp.charAt(i) != temp.charAt(temp.length()-1-i))
    {
      return false;
    }
  }

  return true;
}

public String noPunc(String s)
{
  String answer = "";

  for(int i = 0; i < s.length(); i++)
  {
    if(s.charAt(i) != ',' && s.charAt(i) != '.' && !(s.substring(i,i+1).equals(" ")) &&
       !(s.substring(i,i+1).equals("'")) && s.charAt(i) != '!')
    {
      answer = answer + s.substring(i,i+1);
    }
  }

  return answer;
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PalindromeChecker" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
