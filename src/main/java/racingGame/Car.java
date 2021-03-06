package racingGame;

import java.util.List;

public class Car {
    private static int maxPosition = 0;
    private static final int START_POSITION = 0;
    private String name;
    private int position;

    public Car(String name){
        this.name = name;
        this.position = START_POSITION;
    }

    public Car(String name, int position){
        this.name = name;
        this.position = position;
    }

    public void move(int random) {
        if (random >= 4){
            position++;

        }
        maxPosition = Integer.max(position, maxPosition);
    }

    public boolean isWinner() {
        return position == maxPosition;
    }

    public boolean isSamePosition(int position) {
        return position == this.position;
    }

    public void addWinnerName(List<String> winners){
        if(isWinner()){
            winners.add(this.name);
        }
    }

    public void passingLog(){
        Output.makeCarLog(name,position);
    }
}
