import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    try{
      int count = -1;
      int prevdata = 0;
      int counter = 0;
      int count1 = 0;
      String gammarate = "";
      String eprate = "";
      List<String> inputs = new ArrayList<String>(); 
      File myObj = new File("input.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNext()) {
        String data = myReader.nextLine();
        inputs.add(counter, data);
        counter++;    
      }
      //System.out.println(Arrays.toString(inputs.toArray()));
      for(int i=0;i<inputs.get(0).length();i++)
      {
        for(int j = 0; j<inputs.size(); j++)
        {
            if(inputs.get(j).charAt(i) == '1')
            {
              count1++;
            }
        }
        //System.out.println(count1);
        if (count1 > inputs.size()/2)
        {
            gammarate += "1";
            eprate += "0";
        }
        else
        {
            gammarate += "0";
            eprate += "1";
        }
        count1 = 0;
      }

      myReader.close();
      int result = Integer.parseInt(gammarate,2) * Integer.parseInt(eprate,2);
      //System.out.println(result);
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}