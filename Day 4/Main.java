import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Main {

  private int nlines = 601;
  private List<BingoGrid[][]> bingoGrids;
  private int[] markedNumbers;
  int nbingogrids;
  

  public static void main(String[] args)
  {
    Main mn = new Main();
    mn.parsing();
    mn.bingo();
    mn.part2bingo();
  }
  
  public void parsing() 
  {
    try 
    {
      BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
      BingoGrid[][] bingoGridX = new BingoGrid[5][5];
      bingoGrids = new ArrayList<>();
      nbingogrids = 0;
      int row = 0;
      for (int i = 0; i < nlines; i++) 
      {
        String line = reader.readLine();
        if (i == 0) 
        {
          String[] bingoBalls = line.split(",");
          markedNumbers = new int[bingoBalls.length];
          for (int j = 0; j < bingoBalls.length; j++) 
          {
            markedNumbers[j] = Integer.parseInt(bingoBalls[j]);
          }
        } 
        else if (line.isEmpty()) 
        {
          if (i != 1) 
          {
            bingoGrids.add(bingoGrids.size(),bingoGridX);
          }
          bingoGridX = new BingoGrid[5][5];
          nbingogrids++;
          row = 0;
        } 
        else 
        {
          if (line.charAt(0) == ' ') 
          {
            line = line.substring(1);
          }
          String[] numbers = line.split(" ");
          int column = 0;
          for (int j = 0; j < numbers.length; j++) 
          {
            if (!numbers[j].isEmpty()) 
            {
              bingoGridX[row][column] = new BingoGrid(Integer.parseInt(numbers[j]), false);
              column++;
            }
          }
          row++;
          if (i == nlines - 1) 
          {
            bingoGrids.add(bingoGrids.size(), bingoGridX);
          }
        }
      }
      reader.close();
    } catch (IOException e) 
    {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  public void bingo() 
  {
        boolean bingo = false;
        int count = 0;
        int sum = 0;

        while (!bingo && count < markedNumbers.length) {
            //draw a new number and mark that number on all fields as drawn = true
            for (BingoGrid[][] bingoGrid : bingoGrids) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (bingoGrid[i][j].num == markedNumbers[count]) {
                            bingoGrid[i][j].marked = true;
                        }
                    }
                }
            }

            //check if there is a bingo
            for (BingoGrid[][] bingoGrid : bingoGrids) {
                //check for rows
                for (int i = 0; i < 5; i++) {
                    boolean rowBingo = true;
                    for (int j = 0; j < 5; j++) {
                        if (!bingoGrid[i][j].marked) {
                            rowBingo = false;
                        }
                    }
                    if (rowBingo) {
                        bingo = true;
                        break;
                    }
                }

                //check for columns
                for (int i = 0; i < 5; i++) {
                    boolean columnBingo = true;
                    for (int j = 0; j < 5; j++) {
                        if (!bingoGrid[j][i].marked) {
                            columnBingo = false;
                        }
                    }
                    if (columnBingo) {
                        bingo = true;
                        break;
                    }
                }

                //sum
                if (bingo) {
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            if (!bingoGrid[i][j].marked) {
                                sum += bingoGrid[i][j].num;
                            }
                        }
                    }
                    break;
                }
            }

            if (!bingo) {
                count++;
            }
        }
        System.out.println(markedNumbers[count]);
        System.out.println(sum);
        System.out.println(sum*markedNumbers[count]);
  }

  public void part2bingo() 
  {
    boolean finalBingo = false;
    int count = 0;
    int sum = 0;
    int numberOfBingos = 0;
    while (!finalBingo && count < markedNumbers.length) 
    {
      //draw a new number and mark that number on all fields as drawn = true
      for (BingoGrid[][] bingoGrid : bingoGrids) {
        for (int i = 0; i < 5; i++) {
          for (int j = 0; j < 5; j++) {
            if (bingoGrid[i][j].num == markedNumbers[count]) {
              bingoGrid[i][j].marked = true;}}}}
      
      List<BingoGrid[][]> remove = new ArrayList<>();
      //check if there is a bingo
      for (BingoGrid[][] bingoGrid : bingoGrids) {
        boolean bingo = false;
        //check for rows
        for (int i = 0; i < 5; i++) 
        {
          boolean rowBingo = true;
          for (int j = 0; j < 5; j++) {
            if (!bingoGrid[i][j].marked) {
               rowBingo = false;
            }
          }
          if (rowBingo) {
            bingo = true;
            break;
          }
        }
        //check for columns
        for (int i = 0; i < 5; i++) {
          boolean columnBingo = true;
          for (int j = 0; j < 5; j++) {
            if (!bingoGrid[j][i].marked) {
              columnBingo = false;
            }
          }
          if (columnBingo) {
            bingo = true;
            break;
          }
        }
        //sum
        if (bingo) {
          numberOfBingos++;
          remove.add(bingoGrid);
          if (numberOfBingos == nbingogrids) {
            finalBingo = true;
            for (int i = 0; i < 5; i++) {
              for (int j = 0; j < 5; j++) {
                if (!bingoGrid[i][j].marked) {
                  sum += bingoGrid[i][j].num;}}}}}}

      for (BingoGrid[][] bingoGrid : remove) {
        bingoGrids.remove(bingoGrids.indexOf(bingoGrid));
      }
      count++;
      }
    System.out.println(markedNumbers[count - 1]);
    System.out.println(sum);
    System.out.println(sum*markedNumbers[count - 1]);
  }
}