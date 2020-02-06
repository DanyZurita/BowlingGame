
package edu.elsmancs.bowlinggame.domain;

public class GameCard {
    private final String scores;
    private int totalScore = 0;
    
    GameCard(String scores) {
        this.scores = scores;
    }
    
    private String getScores() {
        return this.scores;
    }
    
    protected int totalScore() { 
        for (int position = 0; position < getScores().length() ; position++) {
            char roll = getScores().charAt(position);
            int value = 0;
            int lastRoll = 0;
            int nextRoll = 0;
            int next2Roll = 0;
            int frames = 0;
            nextRoll = getNextRoll(position);
            next2Roll = getNext2Roll(position);
            lastRoll = getlastRoll(position);
            switch (String.valueOf(roll)) {
                case "-":
                    break;
                case "/":
                    if (frames >= 9) {
                        value = parseRoll(position, roll);
                        totalScore += value;
                    }
                    else {
                        value = 10 - lastRoll + nextRoll;
                        frames += 0.5;
                        totalScore += value;
                    }
                    break;
                    
                case "X":
                    if (frames >= 9) {
                        value = parseRoll(position, roll);
                        totalScore += value;
                    }
                    else {
                        value = 10 + nextRoll + next2Roll;
                        totalScore += value;
                        frames += 1;
                    }
                    break;
                default:
                    value = Character.getNumericValue(roll);
                    frames += 0.5;
                    totalScore += value;
                    break;
            }   
        }
        return totalScore;    
    }
    
    protected int parseRoll(int i,char roll){
        int value = 0;
        if (null == String.valueOf(roll)) {
        }
        else switch (String.valueOf(roll)) {
            case "-":
                break;
            case "/":
                int lastRoll = Character.getNumericValue(getScores().charAt(i - 1));
                value = 10 - lastRoll;
                break;
            case "X":
                value = 10;
                break;
            default:
                value = Character.getNumericValue(roll);
                break;
        }
        return value;
    }
    
    int getNextRolls(int position) {
        int nextRoll = 0;
        
        if ( (position + 1) <= getScores().length()) {
            nextRoll = parseRoll(position, getScores().charAt(position + 1));
        }
        return nextRoll;
    }
        
    protected int getNext2Rolls(int position) {
        int next2Rolls = 0;
        if ( (position + 2) <= getScores().length()) {
            next2Rolls = parseRoll(position, getScores().charAt(position + 1));

        }
        return next2Rolls;
    }
    
    protected int getLastRolls(int position) {
        int lastRoll = 0;
        
        if ( (position - 1) < 0) {
            lastRoll = parseRoll(position, getScores().charAt(position + 1));

        }
        return lastRoll; 
    }
    
    protected int getTotalScore() {
        return totalScore;
    }
}
