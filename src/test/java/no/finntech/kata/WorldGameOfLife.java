package no.finntech.kata;

import no.finntech.kata.gameoflife.gui.GameOfLife;

public class WorldGameOfLife implements GameOfLife{
    private final World world = new World();
    private boolean[][] current;

    @Override
    public boolean[][] nextGeneration() {
        current = world.nextGeneration(current);
        return current;
    }

    @Override
    public void init(boolean[][] booleans) {
        current = booleans;
    }

    public static final void main(String[] args) throws InterruptedException {
        GameOfLife gameOfLife = new WorldGameOfLife();
        boolean[][] initialWorld = no.finntech.kata.gameoflife.gui.Worlds.trafficCirle();
        new no.finntech.kata.gameoflife.gui.Gui(gameOfLife, initialWorld).display();
    }
}
