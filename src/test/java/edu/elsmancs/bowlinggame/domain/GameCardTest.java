package edu.elsmancs.bowlinggame.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameCardTest {
    
    @Test
    public void emptyCard() {
        GameCard game = new GameCard("");
        assertEquals(game.totalScore(), 0, 0);
        System.out.println("- Test emptyCard score:");
        System.out.println(game.getTotalScore());
    }
    
    @Test
    public void normalCard() {
        GameCard game = new GameCard("12345123451234512345");
        assertEquals(game.totalScore(), 60, 0);
        System.out.println("- Test normalCard score:");
        System.out.println(game.getTotalScore());
    }
    
    @Test
    public void all9rollsCard() {
        GameCard game = new GameCard("9-9-9-9-9-9-9-9-9-9-");
        assertEquals(game.totalScore(), 90, 0);
        System.out.println("- Test all9rollsCard score:");
        System.out.println(game.getTotalScore());
    }
    
    @Test
    public void spareCard() {
        GameCard game = new GameCard("5/5/5/5/5/5/5/5/5/5/5");
        assertEquals(game.totalScore(), 150, 0);
        System.out.println("- Test spareCard score:");
        System.out.println(game.getTotalScore());
    }
    
    @Test
    public void perfectCard() {
        GameCard game = new GameCard("XXXXXXXXXXXX");
        assertEquals(game.totalScore(), 300, 0);
        System.out.println("- Test perfectCard score:");
        System.out.println(game.getTotalScore());
    }
    
    @Test
    public void noBonusBallCard() {
        GameCard game = new GameCard("XXXXXXXXX11");
        assertEquals(game.totalScore(), 272, 0);
        System.out.println("- Test perfectCard score:");
        System.out.println(game.getTotalScore());
    }
}
