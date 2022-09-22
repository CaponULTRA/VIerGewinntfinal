public class Brett {
    private static final String RESET_COLOR = "\u001B[0m";
    private static final String RED_COLOR = "\u001B[31m";
    private static final String GREEN_COLOR = "\u001B[32m";
    private char[][] brett;
    int xLen;
    int yLen;
    private char zugSpieler = 'x';
    private char zugGegenSpieler = 'o';
    char Null = '\u0000';

    Brett(int xLen, int yLen) {
        brett = new char[xLen][yLen];
        this.xLen = xLen;
        this.yLen = yLen;
    }

    public Brett copier() {
        Brett newBrett = new Brett(xLen, yLen);
        for (int x = 0; x < xLen; x++) {
            System.arraycopy(this.brett[x], 0, newBrett.brett[x], 0, yLen);
        }
        return newBrett;
    }


    public Brett setzeSteinCalc(int xPos, char spieler) {

        int yPos = 0;
        Brett newBrett = this.copier();
        while (yPos < yLen) {

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
        while (yPos < yLen) {

            if (brett[xPos][yPos] == Null) {

                brett[xPos][yPos] = spieler;
                return;
            }
            yPos++;
        }


    }

    public char pruefeGewinn() {
        //horizontal
        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen - 3; x++) {
                if ((brett[x][y] == 'x' || brett[x][y] == 'o') && brett[x][y] == brett[x + 1][y] && brett[x + 1][y] == brett[x + 2][y] && brett[x + 2][y] == brett[x + 3][y]) {
                    return brett[x][y];
                }
            }

        }
        //vertikal
        for (int x = 0; x < xLen; x++) {
            for (int y = 0; y < yLen - 3; y++) {
                if ((brett[x][y] == 'x' || brett[x][y] == 'o') && brett[x][y] == brett[x][y + 1] && brett[x][y + 1] == brett[x][y + 2] && brett[x][y + 2] == brett[x][y + 3]) {
                    return brett[x][y];
                }
            }

        }
        for (int x = 0; x < xLen - 3; x++) {
            for (int y = 0; y < yLen - 3; y++) {
                if ((brett[x][y] == 'x' || brett[x][y] == 'o') && brett[x][y] == brett[x + 1][y + 1] && brett[x + 1][y + 1] == brett[x + 2][y + 2] && brett[x + 2][y + 2] == brett[x + 3][y + 3]) {
                    return brett[x][y];
                }
            }

        }
        for (int x = 3; x < xLen; x++) {
            for (int y = 0; y < yLen - 3; y++) {
                if ((brett[x][y] == 'x' || brett[x][y] == 'o') && brett[x][y] == brett[x - 1][y + 1] && brett[x - 1][y + 1] == brett[x - 2][y + 2] && brett[x - 2][y + 2] == brett[x - 3][y + 3]) {
                    return brett[x][y];
                }
            }

        }
        return Null;
    }

    public int pruefepunkte(char zugSpieler, char zugGegenSpieler) {
        int punkte = 0;
        //horizontal
        int positiv4er = 150;
        int positiv3er = 10;
        int positiv2er = 2;
        int negativ4er = 500;
        int negativ3er = 10;
        int negativ2er = 2;
        
        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen - 3; x++) {
                if (brett[x][y] == zugSpieler && brett[x + 1][y] == zugSpieler && brett[x + 2][y] == zugSpieler && zugSpieler == brett[x + 3][y]) {
                    punkte += positiv4er;
                } else if (brett[x][y] == zugSpieler && brett[x + 1][y] == zugSpieler && brett[x + 2][y] == zugSpieler && Null == brett[x + 3][y]) {
                    punkte += positiv3er;
                } else if (brett[x][y] == zugSpieler && brett[x + 1][y] == zugSpieler && brett[x + 2][y] == Null && Null == brett[x + 3][y]) {
                    punkte += positiv2er;
                } else if (brett[x][y] == zugGegenSpieler && brett[x + 1][y] == zugGegenSpieler && brett[x + 2][y] == zugGegenSpieler && zugGegenSpieler == brett[x + 3][y]) {
                    punkte -= negativ4er;
                } else if (brett[x][y] == zugGegenSpieler && brett[x + 1][y] == zugGegenSpieler && brett[x + 2][y] == zugGegenSpieler && Null == brett[x + 3][y]) {
                    punkte -= negativ3er;
                } else if (brett[x][y] == zugGegenSpieler && brett[x + 1][y] == zugGegenSpieler && brett[x + 2][y] == Null && Null == brett[x + 3][y]) {
                    punkte -= negativ2er;
                }


            }

        }
        //vertikal 4er
        for (int x = 0; x < xLen; x++) {
            for (int y = 0; y < yLen- 3; y++) {
                if (brett[x][y] == zugSpieler && brett[x][y + 1] == zugSpieler && brett[x][y + 2] == zugSpieler && zugSpieler == brett[x][y + 3]) {
                    punkte += positiv4er;
                } else if (brett[x][y] == zugSpieler && brett[x][y + 1] == zugSpieler && brett[x][y + 2] == zugSpieler && Null == brett[x][y + 3]) {
                    punkte += positiv3er;
                } else if (brett[x][y] == zugSpieler && brett[x][y + 1] == zugSpieler && brett[x][y + 2] == Null && Null == brett[x][y + 3]) {
                    punkte += positiv2er;
                } else if (brett[x][y] == zugGegenSpieler && brett[x][y + 1] == zugGegenSpieler && brett[x][y + 2] == zugGegenSpieler && zugGegenSpieler == brett[x][y + 3]) {
                    punkte -= negativ4er;
                } else if (brett[x][y] == zugGegenSpieler && brett[x][y + 1] == zugGegenSpieler && brett[x][y + 2] == zugGegenSpieler && Null == brett[x][y + 3]) {
                    punkte -= negativ3er;
                } else if (brett[x][y] == zugGegenSpieler && brett[x][y + 1] == zugGegenSpieler && brett[x][y + 2] == Null && Null == brett[x][y + 3]) {
                    punkte -= negativ2er;
                }
            }

        }
        //diagonal 4er
        for (int x = 0; x < xLen - 3; x++) {
            for (int y = 0; y < yLen - 3; y++) {
                if (zugSpieler == brett[x][y] && zugSpieler == brett[x + 1][y + 1] && brett[x + 2][y + 2] == zugSpieler && zugSpieler == brett[x + 3][y + 3]) {
                    punkte += positiv4er;
                } else if (zugSpieler == brett[x][y] && zugSpieler == brett[x + 1][y + 1] && brett[x + 2][y + 2] == zugSpieler && Null == brett[x + 3][y + 3]) {
                    punkte += positiv3er;
                } else if (zugSpieler == brett[x][y] && zugSpieler == brett[x + 1][y + 1] && brett[x + 2][y + 2] == Null && Null == brett[x + 3][y + 3]) {
                    punkte += positiv2er;
                } else if (zugGegenSpieler == brett[x][y] && zugGegenSpieler == brett[x + 1][y + 1] && brett[x + 2][y + 2] == zugGegenSpieler && zugGegenSpieler == brett[x + 3][y + 3]) {
                    punkte -= negativ4er;
                } else if (zugGegenSpieler == brett[x][y] && zugGegenSpieler == brett[x + 1][y + 1] && brett[x + 2][y + 2] == zugGegenSpieler && Null == brett[x + 3][y + 3]) {
                    punkte -= negativ3er;
                } else if (zugGegenSpieler == brett[x][y] && zugGegenSpieler == brett[x + 1][y + 1] && brett[x + 2][y + 2] == Null && Null == brett[x + 3][y + 3]) {
                    punkte -= negativ2er;
                }
            }

        }
        //diagonal 4er
        for (int x = 3; x < xLen; x++) {
            for (int y = 0; y < yLen - 3; y++) {
                if (brett[x][y] == zugSpieler && brett[x - 1][y + 1] == zugSpieler && brett[x - 2][y + 2] == zugSpieler && zugSpieler == brett[x - 3][y + 3]) {
                    punkte += positiv4er;
                } else if (brett[x][y] == zugSpieler && brett[x - 1][y + 1] == zugSpieler && brett[x - 2][y + 2] == zugSpieler && Null == brett[x - 3][y + 3]) {
                    punkte += positiv3er;
                } else if (brett[x][y] == zugSpieler && brett[x - 1][y + 1] == zugSpieler && brett[x - 2][y + 2] == Null && Null == brett[x - 3][y + 3]) {
                    punkte += positiv2er;
                } else if (brett[x][y] == zugGegenSpieler && brett[x - 1][y + 1] == zugGegenSpieler && brett[x - 2][y + 2] == zugGegenSpieler && zugGegenSpieler == brett[x - 3][y + 3]) {
                    punkte -= negativ4er;
                } else if (brett[x][y] == zugGegenSpieler && brett[x - 1][y + 1] == zugGegenSpieler && brett[x - 2][y + 2] == zugGegenSpieler && Null == brett[x - 3][y + 3]) {
                    punkte -= negativ3er;
                } else if (brett[x][y] == zugGegenSpieler && brett[x - 1][y + 1] == zugGegenSpieler && brett[x - 2][y + 2] == Null && Null == brett[x - 3][y + 3]) {
                    punkte -= negativ2er;
                }
            }

        }
        return punkte;
    }


    public char getZugSpieler() {
        return zugSpieler;
    }

    public void printBrett() {
        String output;
        char field;
        for (int y = yLen - 1; y >= 0; y--) {
            for (int x = 0; x < xLen; x++) {
                field = brett[x][y];
                if (field == Null) output = " ";
                else if (field == 'o') output = GREEN_COLOR + "o" + RESET_COLOR;
                else output = RED_COLOR + "x" + RESET_COLOR;
                System.out.print("| " + output + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        for (int x = 1; x <= xLen; x++) {
            System.out.print("| " + x + " ");
        }
        System.out.print("|");
        System.out.println();

    }


    public List<Integer> GetMoeglicheZuege() {
        List<Integer> moeglicheZuege = new List<Integer>();
        for (int i = 0; i < xLen; i++) {
            if (brett[i][yLen - 1] == Null) {
                moeglicheZuege.append(i);

            }
        }
        return moeglicheZuege;
    }
}

