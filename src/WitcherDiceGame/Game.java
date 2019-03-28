package WitcherDiceGame;
import acm.program.DialogProgram;

public class Game extends DialogProgram {

    class Comb {
        int value;
        int extra;



        Comb(int value, int extra) {
            this.value = value;
            this.extra = extra;
        }
    }

    void reroll() {
        println("Choose dices to reroll and press \"Ready\".");
    }

    private void sort(int v[]) {

        for (int i = 0; i < 4; i++) {
            int pos = i;
            int min = v[i];
            for (int j = i + 1; j < 5; j++) {
                if (v[j] < min) {
                    min = v[j];
                    pos = j;
                }
            }

            v[pos] = v[i];
            v[i] = min;
        }
    }

    Comb checkCombination(Dice[] d) {
        int val[] = new int[5];

        for (int i = 0; i < 5; i++) {
            val[i] = d[i].value;
        }

        sort(val);

        int _1 = val[0];
        int _2 = val[1];
        int _3 = val[2];
        int _4 = val[3];
        int _5 = val[4];

        if ((_1 == _2) && (_2 == _3) && (_3 == _4) && (_4 == _5)) { // five-of-a-kind
            return new Comb(100 + _1, 0);
        }

        if (((_1 == _2) && (_2 == _3) && (_3 == _4))) { // four-of-a-kind
            return new Comb(90 + _1, _5);
        }
        if (((_2 == _3) && (_3 == _4) && (_4 == _5))) { // four-of-a-kind
            return new Comb(90 + _2, _1);
        }

        if ((_1 == _2) && ((_3 == _4) && (_3 == _5))) { //Full house
            return new Comb(80 + _3, _1);
        }

        if (_4 == _5 && ((_1 == _2) && (_2 == _3))) {
            return new Comb(80 + _3, _4);
        }

        if ((_1 == 2) && (_2 == 3) && (_3 == 4) && (_4 == 5) && (_5 == 6)) { // Six High Straight
            return new Comb(72, 0);
        }

        if ((_1 == 1) && (_2 == 2) && (_3 == 3) && (_4 == 4) && (_5 == 5)) { // Five High Straight
            return new Comb(71, 0);
        }

        if (((_1 == _2) && (_2 == _3)) || ((_2 == _3) && (_3 == _4)) || ((_3 == _4) && (_4 == _5))) { // Three-of-a-kind
            int max;
            if ((_1 == _2) && (_2 == _3)) {
                max = (_4 > _5 ? _4 : _5);
            } else if ((_2 == _3) && (_3 == _4)) {
                max = (_1 > _5 ? _1 : _5);
            } else {
                max = (_1 > _2 ? _1 : _2);
            }

            return new Comb(60 + _3, max);
        }

        if ((_1 == _2) && (_3 == _4)) { // two pairs
            int max, min;

            if (_1 > _3) {
                max = _1;
                min = _3;
            } else {
                max = _3;
                min = _1;
            }

            return new Comb(50 + max, min * 10 + _5);
        }

        if ((_2 == _3) && (_4 == _5)) { // two pairs
            int max, min;

            if (_2 > _4) {
                max = _2;
                min = _4;
            } else {
                max = _2;
                min = _4;
            }
            return new Comb(50 + max, min * 10 + _5);
        }
        if (_1 == _2) { // pair
            return new Comb(40 + _1, Math.max(_3, Math.max(_4, _5)));
        }

        if (_2 == _3) { // pair
            return new Comb(40 + _2, Math.max(_1, Math.max(_4, _5)));
        }

        if (_3 == _4) { // pair
            return new Comb(40 + _3, Math.max(_1, Math.max(_2, _5)));
        }

        if (_4 == _5) { // pair
            return new Comb(40 + _4, Math.max(_1, Math.max(_2, _3)));
        }
        return new Comb(0, 0);
    }
    boolean winner(Comb a, Comb b) {
        if (a.value > b.value) {
            println("Player 1 has won!");
        } else if (a.value < b.value) {
            println("Player 2 has won!");
        }else {
            if (a.extra > b.extra) {
                println("Player 1 has won!");
            } else if (a.extra < b.extra) {
                println("Player 2 has won!");
            }else {
                return false;
            }
        }
        return true;
    }

}

