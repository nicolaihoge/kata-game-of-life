package no.finntech.kata;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class WorldTest {
    @Test
    public void setupWorld() {
        boolean[][] generation = new boolean[][] {{true, false},{false, true}};
        World world = new World();
        world.nextGeneration(generation);
    }

    @Test
    public void shouldKillAllLiveCellsWithLessThanTwoLivingNeighbours() {
        boolean[][] board = new boolean[][] {{false, false, false},
                                             {false, true,  false},
                                             {false, false, false}};

        boolean[][] expected = new boolean[][] {
                {false, false, false},
                {false, false, false},
                {false, false, false}};

        assertThat(new World().nextGeneration(board)).isEqualTo(expected);

    }

    @Test
    public void anyLiveCellWithTwoOrThreeLiveNeighboursLivesOnToTheNextGeneration () {
        boolean[][] board = new boolean[][] {
                {true, true, false},
                {true, false,  false},
                {false, false, false}};

        boolean[][] expected = new boolean[][] {
                {true, true, false},
                {true, false, false},
                {false, false, false}};
        assertThat(new World().nextGeneration(board)).isEqualTo(expected);

    }

    @Test
    public void anyLiveCellWithMoreThanThreeLiveNeighboursDies () {
        boolean[][] board = new boolean[][] {
                {true, true, false},
                {true, true,  false},
                {true, false, false}};

        boolean[][] expected = new boolean[][] {
                {true, true, false},
                {true, false, false},
                {true, false, false}};
        assertThat(new World().nextGeneration(board)).isEqualTo(expected);

    }
}
