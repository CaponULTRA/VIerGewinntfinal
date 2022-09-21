public class Brett {
    private char[][] brett;
    private char zugSpieler = 'x';
    private char zugGegenSpieler = 'o';
    char Null = '\u0000';

    Brett() {
        brett = new char[8][8];
    }

    public Brett copier(){
        Brett newBrett = new Brett();
        for (int x = 0; x<8;x++){
            for (int y =0; y<8;y++){
                newBrett.brett[x][y] = this.brett[x][y];
            }
        }
        return newBrett;
    }


    public Brett setzeSteinCalc(int xPos, char spieler) {

        int yPos = 0;
        Brett newBrett = this.copier();
        while (yPos < 8) {

            if (brett[xPos][yPos] == Null) {

                newBrett.brett[xPos][yPos] = spieler;
                return newBrett;
            }
            yPos++;
        }
        return newBrett;

    }
    public void setzeStein(int xPos, char spieler) {

        int yPos = 0;
        ;
        while (yPos < 8) {

            if (brett[xPos][yPos] == Null) {

                brett[xPos][yPos] = spieler;
                return ;
            }
            yPos++;
        }


    }

    public char pruefeGewinn() {
        //horizontal
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 5; x++) {
                if ((brett[x][y] == 'x' || brett[x][y] == 'o') && brett[x][y] == brett[x + 1][y] && brett[x + 1][y] == brett[x + 2][y] && brett[x + 2][y] == brett[x + 3][y]) {
                    return brett[x][y];
                }
            }

        }
        //vertikal
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 5; y++) {
                if ((brett[x][y] == 'x' || brett[x][y] == 'o') && brett[x][y] == brett[x][y + 1] && brett[x][y + 1] == brett[x][y + 2] && brett[x][y + 2] == brett[x][y + 3]) {
                    return brett[x][y];
                }
            }

        }
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if ((brett[x][y] == 'x' || brett[x][y] == 'o') && brett[x][y] == brett[x + 1][y + 1] && brett[x + 1][y + 1] == brett[x + 2][y + 2] && brett[x + 2][y + 2] == brett[x + 3][y + 3]) {
                    return brett[x][y];
                }
            }

        }
        for (int x = 3; x < 8; x++) {
            for (int y = 0; y < 5; y++) {
                if ((brett[x][y] == 'x' || brett[x][y] == 'o') && brett[x][y] == brett[x - 1][y + 1] && brett[x - 1][y + 1] == brett[x - 2][y + 2] && brett[x - 2][y + 2] == brett[x - 3][y + 3]) {
                    return brett[x][y];
                }
            }

        }
        return Null;
    }

    public int pruefepunkte(char zugSpieler,char zugGegenSpieler) {


        int punkte = 0;
        //horizontal 4er
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 5; x++) {
                if (brett[x][y] == zugSpieler && brett[x + 1][y] == zugSpieler && brett[x + 2][y] == zugSpieler && zugSpieler == brett[x + 3][y]) {
                    punkte +=100;
                }
            }

        }
        //vertikal 4er
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 5; y++) {
                if (brett[x][y] == zugSpieler && brett[x][y + 1] == zugSpieler && brett[x][y + 2] == zugSpieler && zugSpieler == brett[x][y + 3]) {
                    punkte+=100;
                }
            }

        }
        //diagonal 4er
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if (zugSpieler == brett[x][y] && zugSpieler == brett[x+1][y+1] && brett[x + 2][y + 2] == zugSpieler && zugSpieler == brett[x + 3][y + 3]) {
                    punkte +=100;
                }
            }

        }
        //diagonal 4er
        for (int x = 3; x < 8; x++) {
            for (int y = 0; y < 5; y++) {
                if ( brett[x][y] == zugSpieler && brett[x - 1][y + 1] == zugSpieler && brett[x - 2][y + 2] == zugSpieler && zugSpieler== brett[x - 3][y + 3]) {
                    punkte +=100;
                }
            }

        }
        //horizontal 3er
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 5; x++) {
                if (brett[x][y] == zugSpieler && brett[x + 1][y] == zugSpieler && brett[x + 2][y] == zugSpieler &&  Null==brett[x+3][y]) {
                    punkte +=10;
                }
            }

        }
        //vertikal 3er
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 5; y++) {
                if (brett[x][y] == zugSpieler && brett[x][y + 1] == zugSpieler && brett[x][y + 2] == zugSpieler && Null == brett[x][y + 3]) {
                    punkte+=10;
                }
            }

        }
        //diagonal 3er
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if (zugSpieler == brett[x][y] && zugSpieler == brett[x+1][y+1] && brett[x + 2][y + 2] == zugSpieler && Null == brett[x + 3][y + 3]) {
                    punkte +=10;
                }
            }

        }
        //diagonal 3er
        for (int x = 3; x < 8; x++) {
            for (int y = 0; y < 5; y++) {
                if ( brett[x][y] == zugSpieler && brett[x - 1][y + 1] == zugSpieler && brett[x - 2][y + 2] == zugSpieler && Null== brett[x - 3][y + 3]) {
                    punkte +=10;
                }
            }

        }
        //horizontal 2er
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 5; x++) {
                if (brett[x][y] == zugSpieler && brett[x + 1][y] == zugSpieler && brett[x + 2][y] == Null &&  Null==brett[x+3][y]) {
                    punkte += 2;
                }
            }

        }
        //vertikal 2er
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 5; y++) {
                if (brett[x][y] == zugSpieler && brett[x][y + 1] == zugSpieler && brett[x][y + 2] == Null && Null == brett[x][y + 3]) {
                    punkte+=2;
                }
            }

        }
        //diagonal 2er
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if (zugSpieler == brett[x][y] && zugSpieler == brett[x+1][y+1] && brett[x + 2][y + 2] == Null && Null == brett[x + 3][y + 3]) {
                    punkte +=2;
                }
            }

        }
        //diagonal 2er
        for (int x = 3; x < 8; x++) {
            for (int y = 0; y < 5; y++) {
                if ( brett[x][y] == zugSpieler && brett[x - 1][y + 1] == zugSpieler && brett[x - 2][y + 2] == Null && Null== brett[x - 3][y + 3]) {
                    punkte +=2;
                }
            }

        }
        //horizontal 4er
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 5; x++) {
                if (brett[x][y] == zugGegenSpieler && brett[x + 1][y] == zugGegenSpieler && brett[x + 2][y] == zugGegenSpieler && zugGegenSpieler == brett[x + 3][y]) {
                    punkte -=100;
                }
            }

        }
        //vertikal 4er
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 5; y++) {
                if (brett[x][y] == zugGegenSpieler && brett[x][y + 1] == zugGegenSpieler && brett[x][y + 2] == zugGegenSpieler && zugGegenSpieler == brett[x][y + 3]) {
                    punkte-=100;
                }
            }

        }
        //diagonal 4er
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if (zugGegenSpieler == brett[x][y] && zugGegenSpieler == brett[x+1][y+1] && brett[x + 2][y + 2] == zugGegenSpieler && zugGegenSpieler == brett[x + 3][y + 3]) {
                    punkte -=100;
                }
            }

        }
        //diagonal 4er
        for (int x = 3; x < 8; x++) {
            for (int y = 0; y < 5; y++) {
                if ( brett[x][y] == zugGegenSpieler && brett[x - 1][y + 1] == zugGegenSpieler && brett[x - 2][y + 2] == zugGegenSpieler && zugGegenSpieler== brett[x - 3][y + 3]) {
                    punkte -=100;
                }
            }

        }
        //horizontal 3er
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 5; x++) {
                if (brett[x][y] == zugGegenSpieler && brett[x + 1][y] == zugGegenSpieler && brett[x + 2][y] == zugGegenSpieler &&  Null==brett[x+3][y]) {
                    punkte -=10;
                }
            }

        }
        //vertikal 3er
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 5; y++) {
                if (brett[x][y] == zugGegenSpieler && brett[x][y + 1] == zugGegenSpieler && brett[x][y + 2] == zugGegenSpieler && Null == brett[x][y + 3]) {
                    punkte-=10;
                }
            }

        }
        //diagonal 3er
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if (zugGegenSpieler == brett[x][y] && zugGegenSpieler == brett[x+1][y+1] && brett[x + 2][y + 2] == zugGegenSpieler && Null == brett[x + 3][y + 3]) {
                    punkte -=10;
                }
            }

        }
        //diagonal 3er
        for (int x = 3; x < 8; x++) {
            for (int y = 0; y < 5; y++) {
                if ( brett[x][y] == zugGegenSpieler && brett[x - 1][y + 1] == zugGegenSpieler && brett[x - 2][y + 2] == zugGegenSpieler && Null== brett[x - 3][y + 3]) {
                    punkte -=10;
                }
            }

        }
        //horizontal 2er
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 5; x++) {
                if (brett[x][y] == zugGegenSpieler && brett[x + 1][y] == zugGegenSpieler && brett[x + 2][y] == Null &&  Null==brett[x+3][y]) {
                    punkte -=2;
                }
            }

        }
        //vertikal 2er
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 5; y++) {
                if (brett[x][y] == zugGegenSpieler && brett[x][y + 1] == zugGegenSpieler && brett[x][y + 2] == Null && Null == brett[x][y + 3]) {
                    punkte-=2;
                }
            }

        }
        //diagonal 2er
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if (zugGegenSpieler == brett[x][y] && zugGegenSpieler == brett[x+1][y+1] && brett[x + 2][y + 2] == Null && Null == brett[x + 3][y + 3]) {
                    punkte -=2;
                }
            }

        }
        //diagonal 2er
        for (int x = 3; x < 8; x++) {
            for (int y = 0; y < 5; y++) {
                if ( brett[x][y] == zugGegenSpieler && brett[x - 1][y + 1] == zugGegenSpieler && brett[x - 2][y + 2] == Null && Null== brett[x - 3][y + 3]) {
                    punkte -=2;
                }
            }

        }
        return punkte;
    }


    public char getZugSpieler() {
        return zugSpieler;
    }

    public void printBrett() {
        for (int y = 7; y >= 0; y--) {
            for (int x = 0; x < 8; x++) {
                System.out.print("| "+brett[x][y]+" ");
            }
            System.out.print("|");
            System.out.println();
        }

        System.out.println("| 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |");System.out.println();
    }

    public void wechselAmZug(){
        if (zugSpieler == 'x')zugSpieler='o';
        else if (zugSpieler == 'o')zugSpieler='x';
    }

    public List<Integer> GetMoeglicheZuege(){
        List<Integer> moeglicheZuege = new List<Integer>();
        for (int i = 0; i< 8; i++){
            if (brett[i][7]==Null){
                moeglicheZuege.append(i);
            }
        }
        return moeglicheZuege;
    }
}

