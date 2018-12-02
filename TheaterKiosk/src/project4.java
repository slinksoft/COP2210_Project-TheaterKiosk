import java.util.Arrays;
import java.util.Scanner;

// Devloped By: SlinkSoft
public class project4
{
    //declare 2 dimensional arraya rows and seats in the movie theater and string for the theaters display table of rows and seats
         int[][] theaterSeats = new int[9][10];
         String theaterTable; 
    // Declare Scanner input for user inputs
         Scanner input = new Scanner(System.in); 
         
    public static void main (String[] args){
       project4 theaterKiosk = new project4();
    }
    public project4(){
          //set the prices for each seat in the row, mainly using Arrays.fill()
        Arrays.fill(theaterSeats[0], 10); Arrays.fill(theaterSeats[1], 10); Arrays.fill(theaterSeats[2], 10);
        Arrays.fill(theaterSeats[3], 0, 2, 10); //Arrays.fill arguments (array var, fromIndex (INCLUSIVE), toIndex (EXCLUSIVE), value to set array to)
        Arrays.fill(theaterSeats[3], 2, 8, 20); Arrays.fill(theaterSeats[3], 8, 10, 10);
        Arrays.fill(theaterSeats[4], 0, 2, 10); Arrays.fill(theaterSeats[4], 2, 8, 20);
        Arrays.fill(theaterSeats[4], 8, 10, 10); Arrays.fill(theaterSeats[5], 0, 2, 10); 
        Arrays.fill(theaterSeats[5], 2, 8, 20); Arrays.fill(theaterSeats[5], 8, 10, 10);
        Arrays.fill(theaterSeats[6], 0, 2, 20); Arrays.fill(theaterSeats[6], 2, 4, 30);
        Arrays.fill(theaterSeats[6], 4, 6, 40); Arrays.fill(theaterSeats[6], 6, 8, 30);
        Arrays.fill(theaterSeats[6], 8, 10, 20); theaterSeats[7][0] = 20;
        Arrays.fill(theaterSeats[7], 1, 3, 30); theaterSeats[7][3] = 40;
        Arrays.fill(theaterSeats[7], 4, 6, 50); theaterSeats[7][6] = 40;
        Arrays.fill(theaterSeats[7], 7,9, 30); theaterSeats[7][9] = 20;
        theaterSeats[8][0] = 30; theaterSeats[8][1] = 40; Arrays.fill(theaterSeats[8], 2, 8, 50);
        theaterSeats[8][8] = 40; theaterSeats[8][9] = 30;
        
        System.out.println("Welcome to the Regal VIP Seating kiosk!");
        updateRows(); // calls method to update the rows and seat price table
        userMenu(); // Calls method to prompt the user to buy and check seats. 
    }
    private void updateRows(){
         // Using for loops to update the table for each row and its seat prices
        //adds labels for each seat number. 1 through 10 
        theaterTable = "#: 1  2  3  4  5  6  7  8  9  l0\n";
         //adds labels for each row. rows A through I
         for (int i = 0; i < 9; i++)
         {
             switch (i)
             {
                 case 0:
                     theaterTable += "A: ";
                     break;
                 case 1:
                     theaterTable += "B: ";
                     break;
                 case 2:
                     theaterTable += "C: ";
                     break;
                 case 3:
                     theaterTable += "D: ";
                     break;
                 case 4:
                     theaterTable += "E: ";
                     break;
                 case 5:
                     theaterTable += "F: ";
                     break;
                  case 6:
                     theaterTable += "G: ";
                     break;
                  case 7:
                     theaterTable += "H: ";
                     break;
                  case 8:
                     theaterTable += "I: ";
                     break;
             }
             //create theater table.
             for (int j = 0; j < 10; j ++)
             {
                 theaterTable += theaterSeats[i][j] + " ";
             }
             theaterTable += "\n";
         }
         //Value -1 indicates a seat that has been bought. For displaying the theater table to the user however, we replace the display value of -1 to 00; so the user is not confused by seeing -1.
         theaterTable = theaterTable.replaceAll("-1", "00");
         theaterTable += "00 = Seat Already Bought";
    }
    private void userMenu(){
        System.out.println("Please select an option.\n1. Choose Seating by Price \n2. Choose Specific Row & Seat \n3. View Available Seating \n4. Exit");
        System.out.print("Option (1-4): ");
        int userOption = input.nextInt();
        switch (userOption){
            case 1:{
                seatByPrice(); // calls method to handle the user buying a seat by price
                break;
            }
            case 2:{
                seatBySpecific(); // calls method to handle the user buying a specific seat
                break;
            }
            case 3:{
                updateRows(); // calls method to update the rows and seat price table
                System.out.println(theaterTable); //print theater table to user in output
                userMenu(); // Calls method to prompt the user to buy and check seats.
                break;
            }
            case 4:{
                System.out.println("Thank you for using Regal VIP Seating kiosk!"); //prompts the user a thank you message
                System.exit(0); // ends the program.
                break;
            }
            default:{
                System.out.println("Invalid Option! Please Try Again. \n\n\n");
                userMenu(); // Calls method to prompt the user to buy and check seats.
            }
        }  
    }
    /*handles input for the user buying a seat by specific price. Also handles filtering the theater table
    so the user knows what seats are available by the price they are requesting */
    private void seatByPrice()
    {
        updateRows(); // calls method to update the rows and seat price table
        System.out.println("Please enter the price you are looking for. \n1. $10 \n2. $20 \n3. $30 \n4. $40 \n5. $50");
        System.out.print("Price: $");
        int price = input.nextInt();
        switch (price){
            case 10:{
                //takes the theaterTable var and filters out prices that are not what the user asked for. Using a for each loop/statement. Storing the filter table into a new string then display to the user in output.
                String printTable = theaterTable;
                String[] excludedPrices = {"20", "30", "40", "50" };
                for (String c : excludedPrices)
                    printTable = printTable.replaceAll(c, "__");
                System.out.println(printTable);
                System.out.println("^^ Available Seats ^^");
                break;
            }
            case 20:{
                //takes the theaterTable var and filters out prices that are not what the user asked for. Using a for each loop/statement. Storing the filter table into a new string then display to the user in output.
                String printTable = theaterTable;
                String[] excludedPrices = {"10", "30", "40", "50" };
                for (String c : excludedPrices)
                    printTable = printTable.replaceAll(c, "__");
                System.out.println(printTable);
                System.out.println("^^ Available Seats ^^");
                break;
            }
            case 30:{
                //takes the theaterTable var and filters out prices that are not what the user asked for. Using a for each loop/statement. Storing the filter table into a new string then display to the user in output.
                String printTable = theaterTable;
                String[] excludedPrices = {"10", "20", "40", "50" };
                for (String c : excludedPrices)
                    printTable = printTable.replaceAll(c, "__");
                System.out.println(printTable);
                break;
            }
            case 40:{
                //takes the theaterTable var and filters out prices that are not what the user asked for. Using a for each loop/statement. Storing the filter table into a new string then display to the user in output.
                String printTable = theaterTable;
                String[] excludedPrices = {"10", "20", "30", "50" };
                for (String c : excludedPrices)
                    printTable = printTable.replaceAll(c, "__");
                System.out.println(printTable);
                System.out.println("^^ Available Seats ^^");
                break;
            }
            case 50:{
                //takes the theaterTable var and filters out prices that are not what the user asked for. Using a for each loop/statement. Storing the filter table into a new string then display to the user in output.
                String printTable = theaterTable;
                String[] excludedPrices = {"10", "20", "30", "40" };
                for (String c : excludedPrices)
                    printTable = printTable.replaceAll(c, "__");
                System.out.println(printTable);
                System.out.println("^^ Available Seats ^^");
                break;
            }
            default:{
                System.out.println("ERROR: Invalid price! Please try again.");
                userMenu(); //returns user to previous menu after selecting an invalid price
            }
        }
        /*
        prompts the user to buy a seat or not. If yes, prompts the user to specify row and seat number.
        If no, returns the user back to the main menu via userMenu();
        */
         System.out.println("Would you like to pick a seat? \n1. Yes \n2. No");
        System.out.print("(Y/N): ");
        String uInput = input.next();
        uInput = uInput.toUpperCase();
        if (uInput.equals("Y")){
            System.out.println("Please Specify Row. (A-I)");
            System.out.print("Row (A-I): ");
            String uRow = input.next();
            uRow = uRow.toUpperCase();
            System.out.println("Please Specify Seat #. (1-10)");
            System.out.print("Seat # (1-10): ");
            int uSeat = input.nextInt();
            /* once the user specifies a row and seat number, will call a method to buy the seat.
            If seat is avaiable for the price the user entered, the seat will be bought.
            If the seat is not available at the price the user entered and/or the seat has been bought
            or the user entered an invalid seat row and/or seat number, the program will throw an error
            and prompt the user back to the previous menu to try buying a valid seat again.
            */
            switch (uRow)
            {
                case "A":
                    buySeatByPrice(price, 0, uSeat - 1);
                    break;
                case "B":
                    buySeatByPrice(price, 1, uSeat - 1);
                    break;
                case "C":
                    buySeatByPrice(price, 2, uSeat - 1);
                    break;
                case "D":
                    buySeatByPrice(price, 3, uSeat - 1);
                    break;
                case "E":
                    buySeatByPrice(price, 4, uSeat - 1);
                    break;
                case "F":
                    buySeatByPrice(price, 5, uSeat - 1);
                    break;
                case "G":
                    buySeatByPrice(price, 6, uSeat - 1);
                    break;
                case "H":
                    buySeatByPrice(price, 7, uSeat - 1);
                    break;
                case "I":
                    buySeatByPrice(price, 8, uSeat - 1);
                    break;
                default:{
                 System.out.println("ERROR: Invalid Row! Please try again.");
                 seatBySpecific(); //returns user to previoud menu after selecting an invalid row
               }
            }
        }
        else
            userMenu();
    }
    
    //handles the user input for buying a specific seat
    private void seatBySpecific(){
        //prompts the user to enter a specifc row and seat number to buy, regardless of price.
         updateRows(); // calls method to update the rows and seat price table
         System.out.println(theaterTable);
         System.out.println("^^ Available Seats ^^");
         System.out.println("Please select a row (A-I).");
         System.out.print("Enter Row (A-I): ");
         String uRow = input.next();
         uRow = uRow.toUpperCase();
         System.out.println("Please Specify Seat #. (1-10)");
         System.out.print("Seat # (1-10): ");
         int uSeat = input.nextInt();
         /*
         If seat is available, the program will allow the user to buy the seat. If the seat is not
         available, the program will return the user to the previous menu to try to buy
         a valid seat again.
         */
         switch (uRow)
         {
             case "A":
                 buySpecificSeat(0, uSeat - 1);
                 break;
              case "B":
                 buySpecificSeat(1, uSeat - 1);
                 break;
              case "C":
                 buySpecificSeat(2, uSeat - 1);
                 break;
              case "D":
                 buySpecificSeat(3, uSeat - 1);
                 break;
              case "E":
                 buySpecificSeat(4, uSeat - 1);
                 break;
              case "F":
                 buySpecificSeat(5, uSeat - 1);
                 break;
              case "G":
                 buySpecificSeat(6, uSeat - 1);
                 break;
              case "H":
                 buySpecificSeat(7, uSeat - 1);
                 break;
               case "I":
                 buySpecificSeat(8, uSeat - 1);
                 break;
               default:{
                 System.out.println("ERROR: Invalid Row! Please try again.");
                 seatBySpecific(); //returns user to previoud menu after selecting an invalid row
               }
         }   
    }
     /* below are the methods that handle buying the seats the user requests to buy. One method is for buying
    specific seats, and the other is for buying a seat by price the user requested.
    */
    
    /*If seat is available, the program will allow the user to buy the seat. If the seat is not
     available, the program will return the user to the previous menu to try to buy
     a valid seat again.
     */
    private void buySpecificSeat(int row, int seatNum){
       if (theaterSeats[row][seatNum] == -1){ //checks if seat is has been bought already before confirming that it can be bought.
                    System.out.println("ERROR: Seat is not available for purchase for it has been bought already!");
                    seatBySpecific(); //returns user to previous menu after selecting unavailable seat
                }
                else{
                    theaterSeats[row][seatNum] = -1; //sets value to indicate seat has been purchased. Changed on the chat to 00 in updateRows method.
                    System.out.println("Seat successfully purhcased! Thank you!");
                    userMenu(); //returns user back to main menu when seat has been purchased
                }
    }
     /*If seat is avaiable for the price the user entered, the seat will be bought.
            If the seat is not available at the price the user entered and/or the seat has been bought
            or the user entered an invalid seat row and/or seat number, the program will throw an error
            and prompt the user back to the previous menu to try buying a valid seat again.
            */
    private void buySeatByPrice (int price, int row, int seatNum){ //using method arguments to hold the value for price, seat, and row that the user entered.
         if (theaterSeats[row][seatNum] == price){ //checks if seat is at right price or has been bought already before confirming that it can be bought. Using the method argument price.
                    theaterSeats[row][seatNum] = -1; //sets value to indicate seat has been purchased. Changed on the chat to 00 in updateRows method.
                    System.out.println("Seat successfully purhcased! Thank you!");
                    userMenu(); //returns user back to main menu when seat has been purchased
                }
                else{
                    System.out.println("ERROR: Seat is not available for purchase on selected price or has been bought already!");
                    seatByPrice(); //returns user to previous menu after selecting unavailable seat
                } 
    }          
}