package extensions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Accessories {
    public static String getCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String today = formatter.format(date);
        return today;
    }

    public static int generateNumber(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static void Print(){
        System.out.println("      @@@@@@@@  ,@@@                            @@@,                            ");
        System.out.println("      @@@                                       @@@,                            ");
        System.out.println("      @@@        @@@   @@@@@@@@@@   @@@@@@@@@   @@@,                            ");
        System.out.println("      @@@@@@@@   @@@   @@@    @@@         @@@   @@@,                            ");
        System.out.println("      @@@        @@@   @@@    @@@   @@@&  @@@   @@@,                            ");
        System.out.println("      @@@        @@@   @@@    @@@   @@@  @@@@   @@@,                            ");
        System.out.println("                                      ,&                                        ");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("      @@@@@@@@                           @@@                                    ");
        System.out.println("      @@@   @@@@                                                      @@@.      ");
        System.out.println("      @@@    @@@  .@@@@@@(  @@@@@@@@@    @@@    @@@@@@@@    @@@@@@@@ @@@@@@@    ");
        System.out.println("      @@@@@@@@@   .@@@     @@@     @@@   @@@  .@@&    @@@  @@@        @@@.      ");
        System.out.println("      @@@         .@@@     @@@     @@@   @@@  %@@(@@@@     @@@        @@@.      ");
        System.out.println("      @@@         .@@@     @@@@  ,@@@/   @@@   @@@@    @*  &@@@# %@@  #@@@ #    ");
        System.out.println("      #&           #&         ,@@@       @@@      %@@@        (@@*      /@@     ");
        System.out.println("                                       @@@@&                                    ");
    }

}
