
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
                lastRoll = Character.getNumericValue(getScores().charAt(i - 1));
                nextRoll = Character.getNumericValue(getScores().charAt(i + 1));
                next2Roll = Character.getNumericValue(getScores().charAt(i + 2));
            }
            catch(Exception e) {
            }
            if (null == String.valueOf(roll)) {
                value = Character.getNumericValue(roll);
                totalScore += value;
            }
            else switch (String.valueOf(roll)) {
                case "-":
                    totalScore += value;
                    break;
                case "/":
                    value = 10 - lastRoll + nextRoll;
                    totalScore += value;
                    break;
                case "X":
                    value = 10 + nextRoll + next2Roll;
                    totalScore += value;
                    break;
                default:
                    value = Character.getNumericValue(roll);
                    totalScore += value;
                    break;
            }
            
        }
        return totalScore;    
    }
    
    protected int getTotalScore() {
        return totalScore;
    }
}
