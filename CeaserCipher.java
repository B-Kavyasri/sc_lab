import java.util.Scanner;
import java.util.Collections;
public class CeaserCipher{
 public static StringBuffer encrypt(String text,int s){
   StringBuffer result=new StringBuffer();
   for(int i=0;i<text.length();i++){
    if(Character.isLetter(text.charAt(i))){
      if(Character.isUpperCase(text.charAt(i)))
      {
         char ch=(char)(((int)text.charAt(i)+s-65)%26+65);
         result.append(ch);
      }
      else 
      {
       
       char ch=(char)(((int)text.charAt(i)+s-97)%26+97);
       result.append(ch);
      }
    }
    else{
       result.append(text.charAt(i));
    }
  }
  return result;
 }
 public static  void decrypt(String text){
   StringBuffer result=new StringBuffer();
   for(int j=0;j<26;j++){
       for(int i=0;i<text.length();i++){
         if(Character.isLetter(text.charAt(i))){
               if(Character.isUpperCase(text.charAt(i)))
                     {
                         char ch=(char)(((int)text.charAt(i)-j-'A'+26)%26+'A');
                         result.append(ch);
                     }
                     else 
                     {
           
                         char ch=(char)(((int)text.charAt(i)-j-'a'+26)%26+'a');
                         result.append(ch);
                     }
                 
          }
          else 
          {
              result.append(text.charAt(i));
          }        
        
      }
      System.out.println(+j+","+result.toString());
      result.setLength(0);
  }
 
 }
 public static void main(String[] args){
   Scanner sc=new Scanner(System.in);
   System.out.println("Enter the text to be encrypted");
   String text=sc.nextLine();
   System.out.println("Enter the shift key");
   int s=sc.nextInt();
   System.out.println("Text :"+text);
   System.out.println("Shift :"+s);
   System.out.println("Cipher:"+encrypt(text,s));
   System.out.println("CRYPTANALYSIS");
   decrypt(encrypt(text,s).toString());
 }
}