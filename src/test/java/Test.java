import controller.Game;
import model.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Team firstTeam;
        Team secondTeam;
        Scanner input = new Scanner(System.in);
        System.out.println("Scegli (con i numeri da 1 a 6) la squadra di casa...\n1. Detroit Tigers\n2. Houston Astros\n3. Kansas City Royals\n4. Los Angeles Dodgers\n5. Washington Nationals\n6. New York Mets");
        String choice = input.nextLine();
        switch (choice) {
            case "1":
                 firstTeam = new Team("Detroit Tigers", 116);
            break;
            case "2":
                 firstTeam = new Team("Houston Astros", 117);
                break;
            case "3":
                 firstTeam = new Team("Kansas City Royals", 118);
                break;
            case "4":
                 firstTeam = new Team("Los Angeles Dodgers", 119);
                break;
            case "5":
                 firstTeam = new Team("Washington Nationals", 120);
                break;
            case "6":
                 firstTeam = new Team("New York Mets", 121);
                break;
            default:
                firstTeam = new Team("New York Mets", 121);
        }
        System.out.println("Scegli (con i numeri da 1 a 6) la squadra ospite...\n1. Detroit Tigers\n2. Houston Astros\n3. Kansas City Royals\n4. Los Angeles Dodgers\n5. Washington Nationals\n6. New York Mets");
         choice = input.nextLine();
        switch (choice) {
            case "1":
                secondTeam = new Team("Detroit Tigers", 116);
                break;
            case "2":
                secondTeam = new Team("Houston Astros", 117);
                break;
            case "3":
                secondTeam = new Team("Kansas City Royals", 118);
                break;
            case "4":
                secondTeam = new Team("Los Angeles Dodgers", 119);
                break;
            case "5":
                secondTeam = new Team("Washington Nationals", 120);
                break;
            case "6":
                secondTeam = new Team("New York Mets", 121);
                break;
            default:
                secondTeam = new Team("New York Mets", 121);
        }

        HashMap<Integer, ArrayList<String>> firstTeamBench = firstTeam.getTeamBench();
        HashMap<Integer, ArrayList<String>> secondTeamBench = secondTeam.getTeamBench();


        Game buono = new Game();
        System.out.println(buono.gameStart(firstTeam, secondTeam));
        System.out.println(buono.printRoster(firstTeam.getName(), firstTeamBench));
        System.out.println(buono.printRoster(secondTeam.getName(), secondTeamBench));


        ArrayList<Integer> pointsforFirstTeam = new ArrayList<>();
        ArrayList<Integer> pointsForSecondTeam = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            Game game = new Game();
            System.out.println(game.playBall(firstTeamBench, secondTeamBench));
            int pointforFirstTeam = game.getRuns();
            pointsforFirstTeam.add(pointforFirstTeam);
            game = new Game();
            System.out.println(game.playBall(secondTeamBench, firstTeamBench));
            int pointforSecondTeam = game.getRuns();
            pointsForSecondTeam.add(pointforSecondTeam);


            //mostro punteggio a fine di ogni ripresa
            int scoreA = game.calcTotalScore(pointsforFirstTeam);
            int scoreB = game.calcTotalScore(pointsForSecondTeam);

            if (scoreA > scoreB)
                System.out.println("Il punteggio è " + scoreA + " a " + scoreB + " per i " + firstTeam.getName() + ".");
            else if (scoreA < scoreB)
                System.out.println("Il punteggio è " + scoreB + " a " + scoreA + " per i " + secondTeam.getName() + ".");
            else
                System.out.println("Il punteggio è di " + scoreA + " pari.");
            System.out.println("-------------------------------");
        }







    }
}
