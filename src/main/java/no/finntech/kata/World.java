package no.finntech.kata;

public final class World {

    public boolean[][] nextGeneration(boolean[][] current) {
        boolean[][] nextGeneration = new boolean[current.length][current[0].length];
        for (int x = 0; x < current.length; x++) {
            for (int y = 0; y < current[0].length; y++) {
                int liveNeighbours = livingNeigbours();
                if (liveNeighbours < 2) {
                    nextGeneration[x][y] = false;
                }
            }
        }
        return nextGeneration;
    }

    private int livingNeigbours() {
        return 0;  //To change body of created methods use File | Settings | File Templates.
    }
}
