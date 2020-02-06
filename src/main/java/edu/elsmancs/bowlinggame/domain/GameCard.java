
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
            try {
                nextRoll = parseRoll(position, getScores().charAt(position + 1));
                
            }
            catch(Exception e) {
            }
            try {
                lastRoll = parseRoll(position, getScores().charAt(position - 1));
                
            }
            catch(Exception e) {
            }
            try {
                next2Roll = parseRoll(position, getScores().charAt(position + 2));
                
            }   
            catch(Exception e) {
            }
            if (null == String.valueOf(roll)) {
            }
            else switch (String.valueOf(roll)) {
                case "-":
                    break;
                case "/":
                    if (position > getScores().length() - 4) {
                        value = parseRoll(position, roll);
                        totalScore += value;
                    }
                    else {
                        value = 10 - lastRoll + nextRoll;
                        totalScore += value;
                    }
                    break;
                    
                case "X":
                    if (position > getScores().length() - 4) {
                        value = parseRoll(position, roll);
                        totalScore += value;
                    }
                    else {
                        value = 10 + nextRoll + next2Roll;
                        totalScore += value;
                    }
                    break;
                default:
                    value = Character.getNumericValue(roll);
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
    
    protected int getTotalScore() {
        return totalScore;
    }
}
