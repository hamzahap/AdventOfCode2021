import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    try{
      int count = -1;
      int prevdata = 0;
      int counter = 0;
      List<Integer> inputs = new ArrayList<Integer>(); 
      File myObj = new File("input.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNext()) {
        int data = myReader.nextInt();
        if (data > prevdata)
        {
          count++;
        }
        prevdata = data;
        inputs.add(counter, data);
        counter++;
      }
      myReader.close();
      System.out.println(count);
      int part2count = part2(inputs);
      System.out.println(part2count);
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  public static int part2(List<Integer> inputs)
  {
    int counter = 0;
    int count = -1;
    for (int i = 2; i < inputs.size(); ++i) {
        int sum = inputs.get(i)+inputs.get(i-1)+inputs.get(i-2);
        if (count != -1 && count < sum) {
            counter++;
        }
        count = sum;
        }
        return counter;
  }
}
