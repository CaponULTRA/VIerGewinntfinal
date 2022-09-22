public class Bot {
    char player;
    char gegen;
    public Bot(char player){
        if (player == 'x')gegen='o';
        else gegen='x';
        this.player = player;


    }






    int x = 0;


    public int getAction(Brett brett) {
        double val = minmax_value(brett, 7, true);
        //return max_value(st, depth);
        return x;

    }

    public int minmax_value(Brett brett, int d, boolean isMax) {
        List<Integer> moeglicheZuege = new List<Integer>();
        if (d == 0) {
            if (!isMax)return brett.pruefepunkte(player, gegen);
            else return brett.pruefepunkte(gegen,player);
        }
        else if (brett.pruefeGewinn() == player) {
            if (isMax) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }
        else if (brett.pruefeGewinn()==gegen) {
            if (isMax) return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }
        else {
            if (isMax) {
                moeglicheZuege = brett.GetMoeglicheZuege();
                int v = Integer.MIN_VALUE;

                int z;
                //double z;
                moeglicheZuege.toFirst();
                while (moeglicheZuege.hasAccess()) {
                    z = minmax_value(brett.setzeSteinCalc(moeglicheZuege.getContent(), player), d-1, false);
                    if (z >= v) {
                        v = z;
                        this.x = moeglicheZuege.getContent();
                    }
                    moeglicheZuege.next();
                }
                //System.out.println("x: "+this.x);
                return v;
            } else {
                moeglicheZuege = brett.GetMoeglicheZuege();
                int v = Integer.MAX_VALUE;

                int z;
                //double z;
                moeglicheZuege.toFirst();
                while (moeglicheZuege.hasAccess()) {
                    z = minmax_value(brett.setzeSteinCalc(moeglicheZuege.getContent(), gegen), d-1, true);
                    if (z <= v) {
                        v = z;
                        this.x = moeglicheZuege.getContent();
                    }
                    moeglicheZuege.next();
                }
                //System.out.println("x: "+this.x);
                return v;
            }
        }
    }
}