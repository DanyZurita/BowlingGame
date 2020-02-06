
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
        for (int i = 0; i < getScores().length() ; i++) {
            char roll = getScores().charAt(i);
            int value = 0;
            int lastRoll = 0;
            int nextRoll = 0;
            int next2Roll = 0;
            try {
                nextRoll = parseRoll(i, getScores().charAt(i + 1));
                
            }
            catch(Exception e) {
            }
            try {
                lastRoll = parseRoll(i, getScores().charAt(i - 1));
                
            }
            catch(Exception e) {
            }
            try {
                next2Roll = parseRoll(i, getScores().charAt(i + 2));
                
            }   
            catch(Exception e) {
            }
            if (null == String.valueOf(roll)) {
            }
            else switch (String.valueOf(roll)) {
                case "-":
                    break;
                case "/":
                    if (i > getScores().length() - 3) {
                        value = parseRoll(i, roll);
                        totalScore += value;
                    }
                    else {
                        value = 10 - lastRoll + nextRoll;
                        totalScore += value;
                    }
                    break;
                    
                case "X":
                    if (i > getScores().length() - 4) {
                        value = parseRoll(i, roll);
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
