import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


class Test{



  public static void main(String[] s){
     String input="abcdeedcbfgf";
     boolean duplicateFound=false;                 
     removeDuplicates(input,false);
     List l=new ArrayList();
  }

 public static void t(ArrayList arr)
 {
	 
 }
  

public static void removeDuplicates(String input,boolean duplicateFound)
{
   if(input==null)
	   return;
   Set<Integer> indexsToRemove=new LinkedHashSet<>();
   for(int i=0;i<input.length()-1;i++)
   {
     if(input.charAt(i)==input.charAt(i+1))
     {
       duplicateFound=true;
       indexsToRemove.add(i);
       indexsToRemove.add(i+1);
     }
   }
   if(!duplicateFound)
   {
     return;
   }
   String output=null;
   for(Integer i:indexsToRemove)
   {
	   input=input.replaceFirst(String.valueOf(input.charAt(i)),"-");
   }

   System.out.println(output);
   
    removeDuplicates(output,false);
   

 }
}
