import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Brett brett = new Brett();
        Bot bot1 = new Bot('x');
        Bot bot2 = new Bot('o');
        Scanner scanner = new Scanner(System.in);
        while (brett.pruefeGewinn()== brett.Null){
            System.out.println("spieler x:");
            brett.setzeStein(bot1.getAction(brett),'x');
            brett.printBrett();
            if (brett.pruefeGewinn() == brett.Null){
                System.out.println("spieler o:");
            brett.setzeStein(bot2.getAction(brett), 'o');
            brett.printBrett();}


        }System.out.println("Spieler "+brett.pruefeGewinn()+" gewinnt!!!");



    }


    }

