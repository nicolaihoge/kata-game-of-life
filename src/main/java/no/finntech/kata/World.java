package no.finntech.kata;

public final class World {

    public boolean[][] nextGeneration(boolean[][] current) {
        boolean[][] nextGeneration = new boolean[current.length][current[0].length];
        for (int y = 0; y < current.length; y++) {
            for (int x = 0; x < current[0].length; x++) {
                int liveNeighbours = livingNeigbours(y, x, current);
                if (liveNeighbours < 2) {
                    nextGeneration[y][x] = false;
                } else if (living(y, x, current) && (liveNeighbours == 2 || liveNeighbours == 3)) {
                    nextGeneration[y][x] = true;
                } else if (living(y, x, current) && (liveNeighbours > 3)) {
                    nextGeneration[y][x] = false;
                } else if (!living(y, x, current) && liveNeighbours == 3) {
                    nextGeneration[y][x] = true;
                }
            }
        }
        return nextGeneration;
    }

    private int livingNeigbours(int x, int y, boolean[][] current) {
        int result = 0;
        if (living(x-1, y-1, current)) result++;
        if (living(x-1, y, current)) result++;
        if (living(x-1, y+1, current)) result++;
        if (living(x, y-1, current)) result++;
        if (living(x, y+1, current)) result++;
        if (living(x+1, y-1, current)) result++;
        if (living(x+1, y, current)) result++;
        if (living(x+1, y+1, current)) result++;
        return result;
    }

    private boolean living(int x, int y, boolean[][] current) {
        return exists(x, y, current) && current[x][y];
    }

    private boolean exists(int x, int y, boolean[][] current) {
        return !(x < 0 || y < 0 || x > current.length -1 || y > current[0].length - 1);
    }
}
