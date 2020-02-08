
package edu.elsmancs.bowlinggame.domain;

public class GameCard {
    private final String scores;
    private int totalScore = 0;
    private int lastRoll = 0;
    private int nextRoll = 0;
    private int next2Roll = 0;
    
    GameCard(String scores) {
        this.scores = scores;
    }
    
    private String getScores() {
        return this.scores;
    }
    
    protected int totalScore() {
        int frames = 0;
        for (int position = 0; position < getScores().length() ; position++) {
            char rollChar = getScores().charAt(position);
            int rollValue = 0;
            lastRoll = 0;
            nextRoll = 0;
            next2Roll = 0;

            nextRoll = getNextRoll(position);
            
            
            switch (String.valueOf(rollChar)) {
                case "-":
                    frames ++;
                    totalScore += 0;
                    break;
                case "/":
                    if (frames >= 18) {
                        lastRoll = getLastRoll(position);
                        rollValue = parseRoll(position, rollChar);
                        totalScore += rollValue;
                    }
                    else {
                        lastRoll = getLastRoll(position);
                        rollValue = 10 - lastRoll + nextRoll;
                        frames ++;
                        totalScore += rollValue;
                    }
                    break;
                    
                case "X":
                    if (frames >= 18) {
                        rollValue = parseRoll(position, rollChar);
                        totalScore += rollValue;
                    }
                    else {
                        next2Roll = getNext2Roll(position);
                        rollValue = 10 + nextRoll + next2Roll;
                        totalScore += rollValue;
                        frames ++;
                        frames ++;
                    }
                    break;
                default:
                    rollValue = Character.getNumericValue(rollChar);
                    frames ++;
                    totalScore += rollValue;
                    break;
            }   
        }
        return totalScore;    
    }
    
    protected int parseRoll(int i,char roll){
        int rollValue = 0;
        if (null == String.valueOf(roll)) {
        }
        else switch (String.valueOf(roll)) {
            case "-":
                break;
            case "/":
                rollValue = 10 - lastRoll;
                break;
            case "X":
                rollValue = 10;
                break;
            default:
                rollValue = Character.getNumericValue(roll);
                break;
        }
        return rollValue;
    }
    
    int getNextRoll(int position) {
        int nextRollValue = 0;      
        int next = (position + 1);
        
        if ( next < getScores().length()) {
            char nextChar = getScores().charAt(next);
            nextRollValue = parseRoll(position, nextChar);
        }
        return nextRollValue;
    }
        
    int getNext2Roll(int position) {
        int next2RollValue = 0;
        int next2 = (position + 2);
        
        if ( next2 < getScores().length()) {
            char next2Char = getScores().charAt(next2);
            next2RollValue = parseRoll(position, next2Char);

        }
        return next2RollValue;
    }
    
    int getLastRoll(int position) {
        int lastRollsValue = 0;
        int last = (position - 1);
        
        if (  last > 0) {
            char lastChar = getScores().charAt(last);
            lastRollsValue = Character.getNumericValue(lastChar);

        }
        return lastRollsValue; 
    }
    
    protected int getTotalScore() {
        return totalScore;
    }
}
