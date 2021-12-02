import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


class Main {
  public static void main(String[] args) {
    int hor = 0;
    int depth = 0;
    int answer = 0;
    int aim = 0;
    try{
      List<Integer> inputs = new ArrayList<Integer>(); 
      File myObj = new File("input.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNext()) {
        String data = myReader.nextLine();
        String command = data.split(" ")[0];
        if (command.equals("forward"))
        {
          hor += Integer.parseInt(data.split(" ")[1]);
          if(aim > 0)
          {
            depth = depth + (aim*Integer.parseInt(data.split(" ")[1]));
          }
        }
        else if (command.equals("up"))
        {
          //depth -= Integer.parseInt(data.split(" ")[1]);
          aim -= Integer.parseInt(data.split(" ")[1]);
        }
        else if (command.equals("down"))
        {
          //depth += Integer.parseInt(data.split(" ")[1]);
          aim += Integer.parseInt(data.split(" ")[1]);
        }
      }
      myReader.close();
      System.out.println(depth * hor);
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}