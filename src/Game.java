import java.util.Scanner;

public class Game {


    Scanner scanner = new Scanner(System.in);
    private Brett brett = new Brett();

    public Game() {

        while (brett.pruefeGewinn() == brett.Null) {
            brett.setzeStein(bot(brett, 1));

            brett.printBrett();
            brett.setzeStein(scanner.nextInt());
            brett.printBrett();
        }


    }


    public int bot(Brett brett, int tiefe) {
        Brett newBrett = new Brett();
        int eval;
        int best = 0;
        int maxeval = Integer.MIN_VALUE;
        List<Integer> list = brett.GetMoeglicheZuege();

        list.toFirst();
        while (list.hasAccess()) {
            //newBrett = brett;
            newBrett.setzeStein(list.getContent());
            eval = minimax(newBrett, tiefe - 1, false);
            if (eval > maxeval) {
                maxeval = eval;
                best = list.getContent();

            }
            list.next();

        }
        return best;


    }


    public int minimax(Brett brett, int tiefe, boolean isMax) {
        Brett newBrett = new Brett();
        if (brett.pruefeGewinn() != brett.Null || tiefe == 0) {
            return brett.pruefepunkte();
        }

        int eval = 0;
        int maxeval = Integer.MIN_VALUE;
        int mineval = Integer.MAX_VALUE;
        List<Integer> list = brett.GetMoeglicheZuege();
        if (isMax) {
            list.toFirst();
            while (list.hasAccess()) {
                eval = minimax(brett.setzeStein(brett, list.getContent()), tiefe - 1, false);
                if (eval > maxeval) {
                    maxeval = eval;
                }
                list.next();

            }
            return maxeval;
        } else {
            list.toFirst();
            while (list.hasAccess()) {


                //          eval = minimax(brett.setzeStein(brett, list.getContent()), tiefe - 1, false);
                if (eval < mineval) {
                    mineval = eval;
                }
                list.next();

            }
            return mineval;

        }

    }
}
