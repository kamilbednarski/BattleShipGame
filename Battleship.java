import java.util.Random;
import java.util.Scanner;

public class Battleship {
    //Setting size of the map:
    public static int rows = 10;
    public static int columns = 10;
    //Creating the map:
    public static String [][] map = new String[rows][columns];
    //Setting static number of ships:
    public static int numberOfPlayersShips = 5;
    public static int numberOfComputersShips = 5;
    //Setting delay options:
    public static int longDelay = 3000;
    public static int shortDelay = 1000;

    public static void main (String args[]) {
        Scanner input = new Scanner(System.in);
        //START
        System.out.println("*** Welcome to Battle Ship game ***");
        System.out.println();
        sleepMethod(shortDelay);

        //STEP 0 - Instructions:
        gameInstructions();
        sleepMethod(shortDelay);
        System.out.println("Right now, the sea is empty:");
        sleepMethod(shortDelay);
        System.out.println();

        //STEP 1 - Creating the ocean map:
        oceanMap();
        sleepMethod(shortDelay);

        //STEP 2 - Deploying player's ships:
        System.out.println("Please choose location for your ships.");
        sleepMethod(longDelay);
        System.out.println("You have to pick co-ordinates for 5 ships.");
        sleepMethod(longDelay);

        //First ship:
        int xFirst = shipLocationX("first");
        sleepMethod(shortDelay);
        int yFirst = shipLocationY("first");
        map[yFirst][xFirst] = "1";
        sleepMethod(shortDelay);
        System.out.println("First ship deployed! ");
        System.out.println();
        sleepMethod(shortDelay);

        //Second ship:
        int xSecond = shipLocationX("second");
        sleepMethod(shortDelay);
        int ySecond = shipLocationY("second");
        while (xSecond == xFirst && ySecond == yFirst) {
            System.out.println("Please pick another co-ordinates. You can't place two ships at one place.");
            System.out.print("Enter X co-ordinate for second ship: ");
            xSecond = input.nextInt();
            System.out.print("Enter Y c-ordinate for second ship: ");
            ySecond = input.nextInt();
        }
        map[ySecond][xSecond] = "1";
        sleepMethod(shortDelay);
        System.out.println("Second ship deployed! ");
        System.out.println();
        sleepMethod(shortDelay);

        //Third ship:
        int xThird = shipLocationX("third");
        sleepMethod(shortDelay);
        int yThird = shipLocationY("third");
        sleepMethod(shortDelay);
        while (xThird == xFirst && yThird == yFirst || xThird == xSecond && yThird == ySecond) {
            System.out.println("Please pick another co-ordinates. You can't place two ships at one place.");
            System.out.print("Enter X co-ordinate for third ship: ");
            xThird = input.nextInt();
            System.out.print("Enter Y c-ordinate for third ship: ");
            yThird = input.nextInt();
        }
        map[yThird][xThird] = "1";
        sleepMethod(shortDelay);
        System.out.println("Third ship deployed! ");
        System.out.println();
        sleepMethod(shortDelay);

        //Fourth ship:
        int xFourth = shipLocationX("fourth");
        sleepMethod(shortDelay);
        int yFourth = shipLocationY("fourth");
        sleepMethod(shortDelay);
        while (xFourth == xFirst && yFourth == yFirst || xFourth == xSecond && yFourth == ySecond || xFourth == xThird && yFourth == yThird) {
            System.out.println("Please pick another co-ordinates. You can't place two ships at one place.");
            System.out.print("Enter X co-ordinate for fourth ship: ");
            xFourth = input.nextInt();
            System.out.print("Enter Y c-ordinate for fourth ship: ");
            yFourth = input.nextInt();
        }
        map[yFourth][xFourth] = "1";
        sleepMethod(shortDelay);
        System.out.println("Fourth ship deployed! ");
        System.out.println();
        sleepMethod(shortDelay);

        //Fifth ship:
        int xFifth = shipLocationX("fifth");
        sleepMethod(shortDelay);
        int yFifth = shipLocationY("fifth");
        sleepMethod(shortDelay);
        while (xFifth == xFirst && yFifth == yFirst || xFifth == xSecond && yFifth == ySecond || xFifth == xThird && yFifth == yThird || xFifth == xFourth && yFifth == yFourth) {
            System.out.println("Please pick another co-ordinates. You can't place two ships at one place.");
            System.out.print("Enter X co-ordinate for fifth ship: ");
            xFifth = input.nextInt();
            System.out.print("Enter Y c-ordinate for fifth ship: ");
            yFifth = input.nextInt();
        }
        map[yFifth][xFifth] = "1";
        sleepMethod(shortDelay);
        System.out.println("Fifth ship deployed! ");
        System.out.println();
        sleepMethod(shortDelay);

        //Printing player's layout:
        System.out.println("Thank you. There's your layout below:");
        sleepMethod(longDelay);
        oceanMap();
        sleepMethod(shortDelay);

        //STEP 3 - Deploying computer's ships:
        System.out.println("Now it's time for computer to set it's layout.");
        sleepMethod(shortDelay);
        System.out.print("Processing ");
        sleepMethod(250);
        System.out.print(". ");
        sleepMethod(250);
        System.out.print(". ");
        sleepMethod(250);
        System.out.println(".");
        System.out.println();
        sleepMethod(shortDelay);

        for (int i = 0; i < 5; i++) {
            int x = computersShipLocation();
            int y = computersShipLocation();
            while (map[y][x] != null || "1".equals(map[y][x]) || "2".equals(map[y][x])) {
                x = computersShipLocation();
                y = computersShipLocation();
            }
            map[y][x] = "2";
        }

        sleepMethod(shortDelay);
        System.out.println("Computer deployed its ships! ");
        System.out.println();

        //STEP 4 - Battle:
        battle();
        sleepMethod(shortDelay);

        //STEP 5 - Game over:
        gameOver();
    }

    public static int shipLocationX(String whichShip) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter X co-ordinate for " + whichShip + " ship: ");
        int xCoordinate = input.nextInt();
        while (xCoordinate < 0 || xCoordinate > 10) {
            System.out.println("Co-ordinate goes beyond map boundaries, please try again. ");
            System.out.print("Enter X co-ordinate for " + whichShip + " ship: ");
            xCoordinate = input.nextInt();
        }
        return xCoordinate;
    }

    public static int shipLocationY(String whichShip) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Y co-ordinate for " + whichShip + " ship: ");
        int yCoordinate = input.nextInt();
        while (yCoordinate < 0 || yCoordinate > 10) {
            System.out.println("Co-ordinate goes beyond map boundaries, please try again. ");
            System.out.print("Enter Y co-ordinate for " + whichShip + " ship: ");
            yCoordinate = input.nextInt();
        }
        System.out.println();
        return yCoordinate;

    }

    public static int computersShipLocation() {
        Random rand = new Random();
        int coordinate = rand.nextInt(10);
        return coordinate;
    }

    public static void oceanMap() {
        //Printing column numbers
        numbersOfColumns();
        System.out.println();

        //Printing grid with row numbers
        for (int row = 0; row < map.length; row++) {
            System.out.print(row + "| ");
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col] == null) {
                    System.out.print("  ");
                }
                else if("2".equals(map[row][col])) {
                    System.out.print("  ");
                }
                else {
                    System.out.print(map[row][col] + " ");
                }
            }
            System.out.print("| " + row);
            System.out.println();
        }
        numbersOfColumns();
        System.out.println();
        sleepMethod(shortDelay);
        System.out.println("__________________________");
        System.out.println("Legend: ");
        System.out.println("1 - Player's ship. ");
        System.out.println("0 - Destroyed player's ship. ");
        System.out.println("@ - Destroyed computer's ship. ");
        System.out.println("X - Missed attack. ");
        System.out.println("__________________________");
        sleepMethod(shortDelay);
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static void battle() {
        Scanner input = new Scanner(System.in);
        System.out.println("It's time to start the battle!");
        sleepMethod(longDelay);

        while (numberOfPlayersShips > 0 && numberOfComputersShips > 0){
            System.out.println();
            System.out.println();
            System.out.println("|||||||||||| PLAYER'S TURN ||||||||||||");
            sleepMethod(shortDelay);
            playersAttack();
            sleepMethod(shortDelay);
            oceanMap();
            sleepMethod(shortDelay);
            shipsCounting();
            sleepMethod(shortDelay);

            switch (numberOfComputersShips) {
                case 0:
                    break;
                default:
                    System.out.println();
                    System.out.println();
                    System.out.println("||||||||||| COMPUTER'S TURN |||||||||||");
                    sleepMethod(shortDelay);
                    computersAttack();
                    sleepMethod(shortDelay);
                    oceanMap();
                    sleepMethod(shortDelay);
                    shipsCounting();
                    sleepMethod(shortDelay);
            }

        }

    }

    public static void gameOver() {
        System.out.println("**** GAME OVER ****");
        if (numberOfComputersShips == 0) {
            System.out.println("Player wins!!! ");
        }
        else {
            System.out.println("Computer wins!!! ");
        }
    }

    public static void playersAttack() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please pick X co-ordinate: ");
        int xCoordinate = input.nextInt();
        sleepMethod(shortDelay);
        System.out.print("Please pick Y coordinate: ");
        int yCoordinate = input.nextInt();
        sleepMethod(shortDelay);
        System.out.println();

        while (xCoordinate < 0 || xCoordinate > 9 || yCoordinate < 0 || yCoordinate > 9) {
            System.out.println("You've reached map's boundaries. Try again. Please pick a number from 0 to 9. ");
            sleepMethod(shortDelay);
            System.out.print("Please pick X co-ordinate: ");
            xCoordinate = input.nextInt();
            sleepMethod(shortDelay);
            System.out.print("Please pick Y coordinate: ");
            yCoordinate = input.nextInt();
            sleepMethod(shortDelay);
            System.out.println();
        }

        if ("1".equals(map[yCoordinate][xCoordinate])) {
            System.out.println("You've destroyed your own ship! ");
            map[yCoordinate][xCoordinate] =  "O";
            numberOfPlayersShips--;
            sleepMethod(shortDelay);
        }
        else if ("2".equals(map[yCoordinate][xCoordinate])) {
            System.out.println("Yeah! You've destroyed computer's ship! ");
            map[yCoordinate][xCoordinate] = "@";
            numberOfComputersShips--;
            sleepMethod(shortDelay);
        }
        else if ("X".equals(map[yCoordinate][xCoordinate])) {
            System.out.println("Missed attack. Watch yourself, somebody already tried those co-ordinations. ");
            sleepMethod(shortDelay);
        }
        else {
            System.out.println("Missed attack. It's marked on the map as \"X\"");
            map[yCoordinate][xCoordinate] = "X";
            sleepMethod(shortDelay);
        }
        System.out.println("__________________________");
        System.out.println();
    }

    public static void computersAttack() {
        Random rand = new Random();
        int xCoordinate = rand.nextInt(10);
        int yCoordinate = rand.nextInt(10);

        while ("X".equals(map[yCoordinate][xCoordinate]) || "2".equals(map[yCoordinate][xCoordinate])) {
            xCoordinate = rand.nextInt(10);
            yCoordinate = rand.nextInt(10);
        }

        if ("1".equals(map[yCoordinate][xCoordinate])) {
            System.out.println("Computer has destroyed your ship! It's marked on the map as \"O\".");
            map[yCoordinate][xCoordinate] =  "O";
            numberOfPlayersShips--;
            sleepMethod(shortDelay);
        }
        else {
            System.out.println("Missed attack. It's marked on the map as \"X\"");
            map[yCoordinate][xCoordinate] = "X";
            sleepMethod(shortDelay);
        }
        System.out.println("__________________________");
        System.out.println();
        sleepMethod(shortDelay);
    }

    public static void numbersOfColumns() {
        System.out.print("   ");
        for (int columnN = 0; columnN < 10; columnN++) {
            System.out.print(columnN + " ");
        }
    }

    public static void shipsCounting() {
        System.out.println("Player's ships: " + numberOfPlayersShips);
        sleepMethod(shortDelay);
        System.out.println("Computer's ships: " + numberOfComputersShips);
        sleepMethod(shortDelay);
    }

    public static void sleepMethod(int howLong) {
        try {
            Thread.sleep(howLong);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void gameInstructions() {
        Scanner input = new Scanner(System.in);
        System.out.print("Would you like to read instructions? Type your answer here: ");
        String answer = input.nextLine();
        if (answer.startsWith("Y") || answer.startsWith("y")) {
            sleepMethod(shortDelay);
            System.out.println("_____________________________________________________________________________________________");
            sleepMethod(longDelay);
            System.out.println("Battleship (also known as Battleships or Sea Battle) is a strategy type guessing game ");
            sleepMethod(longDelay);
            System.out.println("for two players. It is played on ruled grids (paper, board or computer) on which ");
            sleepMethod(longDelay);
            System.out.println("each player's fleet of ships (including battleships) are marked. The locations of the fleets ");
            sleepMethod(longDelay);
            System.out.println("are concealed from the other player. Players alternate turns calling \"shots\" at the other ");
            sleepMethod(longDelay);
            System.out.println("player's ships, and the objective of the game is to destroy the opposing player's fleet.");
            sleepMethod(longDelay);
            sleepMethod(longDelay);
            System.out.println();
            System.out.println("Step by step instruction below: ");
            sleepMethod(shortDelay);
            System.out.println("1. First step is to create your own fleet using 'X' and 'Y' co-ordinates. ");
            sleepMethod(longDelay);
            System.out.println("2. On the second step, computer as a opposite player, is going to deploy its own ships. ");
            sleepMethod(longDelay);
            System.out.println("3. Now its time to battle! Just type 'X' and 'Y' co-ordinates and your fleet is going to strike. ");
            sleepMethod(longDelay);
            System.out.println("4. After you're done, computer's going to do the same but with it's own co-ordinates. ");
            sleepMethod(longDelay);
            System.out.println("5. Game ends when player or computer runs out of ships. ");
            sleepMethod(longDelay);
            System.out.println();
            System.out.println("Good luck! ");
            sleepMethod(shortDelay);
            System.out.println("_____________________________________________________________________________________________");
            System.out.println();
            System.out.println();
            sleepMethod(shortDelay);
        }
        else {
            sleepMethod(shortDelay);
            System.out.println("OK! Lets start the game. ");
        }
    }

}