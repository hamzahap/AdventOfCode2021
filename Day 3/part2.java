import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class part2 {
  public static void main(String[] args) {
    try{
      int count = -1;
      int ocount = 0;
      int cocount = 0;
      int prevdata = 0;
      int counter = 0;
      int count1 = 0;
      int count2 = 0;
      String orate = "";
      String corate = "";
      List<String> inputs = new ArrayList<String>();
      List<String> O2Array = new ArrayList<String>(); 
      List<String> COArray = new ArrayList<String>();  
      File myObj = new File("input.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNext()) {
        String data = myReader.nextLine();
        inputs.add(counter, data);
        counter++;    
      }
      myReader.close();
      for(int i=0;i<1;i++)
      {
        for(int j = 0; j<inputs.size(); j++)
        {
            if(inputs.get(j).charAt(i) == '1')
            {
              count1++;
              O2Array.add(ocount, inputs.get(j));
              ocount++;
            }
            else
            {
              COArray.add(cocount, inputs.get(j));
              cocount++;
            }
        }
        count1 = 0;
      }
      orate += "1";
      corate += "0";
        for(int i=1;i<12;i++)
        {
          for(int j=0; j<O2Array.size(); j++)
          {
              if(O2Array.get(j).charAt(i) == '1')
              {
                count1++;
              }
              else
              {
                count2++;
              }
          }

          if (count1 >= count2)
          {
              orate += "1";
              for(int j=0; j<O2Array.size(); j++)
              {
                if(O2Array.get(j).charAt(i) == '0')
                {
                  O2Array.remove(j);
                }
              }
              
          }
          else
          {
              orate += "0";
              for(int j=0; j<O2Array.size(); j++)
              {
                if(O2Array.get(j).charAt(i) == '1')
                {
                  O2Array.remove(j);
                  
                }
              }

          }
          count1 = 0;
          count2 = 0;
        }
      for(int i=1;i<12;i++)
      {
        for(int j=0; j<COArray.size(); j++)
        {
            if(COArray.get(j).charAt(i) == '1')
            {
              count1++;
            }
            else
            {
              count2++;
            }
        }
        if (count2 <= count1)
        {
            corate += "0";
            for(int j=0; j<COArray.size(); j++)
              {
                if(COArray.get(j).charAt(i) == '1')
                {
                  COArray.remove(j);
                }
              }
        }
        else
        {
            corate += "1";
            for(int j=0; j<COArray.size(); j++)
              {
                if(COArray.get(j).charAt(i) == '0')
                {
                  COArray.remove(j);
                }
              }
        }
        count1 = 0;
        count2 = 0;
      }
      System.out.println(Arrays.toString(O2Array.toArray()));
      System.out.println(Arrays.toString(COArray.toArray()));
      
      int result = Integer.parseInt(O2Array.get(0),2) * Integer.parseInt(COArray.get(0),2);
      System.out.println(result);
      //System.out.println("Hello");
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}