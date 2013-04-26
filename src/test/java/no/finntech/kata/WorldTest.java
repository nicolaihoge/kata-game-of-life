package no.finntech.kata;

import org.junit.Test;

public class WorldTest {
    @Test
    public void setupWorld() {
        boolean[][] generation = new boolean[][] {{true, false},{false, true}};
        World world = new World();
        world.nextGeneration(generation);
    }
}
