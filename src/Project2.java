import java.io.BufferedReader;
import java.io.FileReader;
/**
 * Plot Binary Search Tree
 * @author Ephraim Montag
 *
 */

public class Project2 {

   public static void main(String[] args) {
      if(args.length==0) System.out.println("No input file! ");//if no file found with argument to main
      else{
         FileReader theFile;//object to file read
         BufferedReader inFile;//use a BufferedReader
         String line="";//empty string to start off line
         BinaryTree t;
         char[][] array=new char[10][62];//min. size
            try {
               theFile=new FileReader(args[0]);//new FileReader with argument to main
               inFile=new BufferedReader(theFile);//use BufferedReader to read text
               while(line!=null){//while line not return null
                  line=inFile.readLine();//reads next line
                  String[] s=line.split(" ");//splits line
                  setUpArray(array);//sets p array for new input
                  for(int i=0;i<s.length;i++){
                     t=new BinaryTree(Integer.parseInt(s[i]));//new binary tree with integer inside element
                     plotTree(t,array,0,30,8);//plots tree in char array
                  }
                  printArray(array);//prints array
                  if(inFile.readLine()==null) break;//skip empty lines 
                  System.out.println();//empty line
               }//end while
            
            } catch (Exception e) {
               System.err.println(e);//print out any exceptions to console
            }//end catch
            
            
      }//end else

   }
   /*
    * Sets up array with empty spots
    */
   public static void setUpArray(char[][] array){
      for(int i=0;i<array.length;i++)
         for(int j=0;j<array[i].length;j++)
            array[i][j]=' ';//empty space in every spot
   }
   /*
    * Method to print the char array
    */
   public static void printArray(char[][] array){
      for(int i=0;i<array.length;i++){
         for(int j=0;j<array[i].length;j++){
            System.out.print(array[i][j]);//prints each spot
         }
         System.out.println();//go to next line
      }  
   }
   /*
    * plots each tree in 2d char array
    * Arguments: Binary Tree to plot
    * character array to place value of binary tree
    * row in char array
    * column in char array
    * offset to seperate values in plot appropriately
    */
   public static void plotTree(BinaryTree t, char[][] array, int row, int col,int offset){
      if(array[row][col]==' ') {//base case
         //if can fit one spot in array put corresponding char in
         if(((Integer)t.getRootObj()).intValue()<10) array[row][col]=(char)(((Integer)t.getRootObj()).intValue()+48);
         else{
            //split up the number and put in corresponding char
            int number=((Integer)t.getRootObj()).intValue();//get number
            int f=number%10;//first digit from right
            int s=number/10;//second digit from right
            array[row][col]=(char) (s+48);//conversion and placement
            array[row][col+1]=(char)(f+48);
         }  
         return;
      }
      //otherwise move to the right place in array
      int n;
      if(array[row][col+1]==' ') n=(int) array[row][col]-48;//if number less than 10 
      else {
         int f=(int)array[row][col+1]-48;//get first digit
         int s=(int)array[row][col]-48;//get second digit
         n=s*10+f;//put together
      }
      if(((Integer)t.getRootObj()).intValue()<n){//if need go left in array
         if(array[row+1][col-offset]!='/') array[row+1][col-offset]='/';//place if needed
         plotTree(t,array,row+2,col-offset*2,offset/2);//recursively go left in array
      }
      else{//otherwise
         if(array[row+1][col+offset]!='\\') array[row+1][col+offset]='\\';//place if needed
         plotTree(t,array,row+2,col+offset*2,offset/2);//recursively go right in array
      }
      
   }//end plot

}
