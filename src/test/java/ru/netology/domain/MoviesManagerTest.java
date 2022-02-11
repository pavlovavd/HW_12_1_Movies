package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoviesManagerTest {
    private MoviesManager manager = new MoviesManager();
    private Movies filmOne = new Movies(1, "one", "comedy", true);
    private Movies filmTwo = new Movies(2, "two", "horror", true);
    private Movies filmThree = new Movies(3, "three", "documentary ", true);
    private Movies filmFour = new Movies(4, "four", "action", false);
    private Movies filmFive = new Movies(5, "five", "thriller", false);
    private Movies filmSix = new Movies(6, "six", "drama", false);
    private Movies filmSeven = new Movies(7, "seven", "animation", false);
    private Movies filmEight = new Movies(8, "eight", "cartoon", true);
    private Movies filmNine = new Movies(9, "nine", "fiction ", false);
    Movies filmTen = new Movies(10, "ten", "adventure ", true);

    @BeforeEach
    public void setUp() {
        manager.save(filmOne);
        manager.save(filmTwo);
        manager.save(filmThree);
        manager.save(filmFour);
        manager.save(filmFive);
        manager.save(filmSix);
        manager.save(filmSeven);
        manager.save(filmEight);
        manager.save(filmNine);
        manager.save(filmTen);

    }

    @Test
    public void shouldSaveIfExist() {


        Movies[] expected = new Movies[]{filmTen, filmNine, filmEight, filmSeven, filmSix, filmFive,
                filmFour, filmThree, filmTwo, filmOne};
        Movies[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveOverLimit() {
        Movies filmEleven = new Movies(11, "eleven", "horror ", true);

        manager.save(filmEleven);

        Movies[] expected = new Movies[]{filmEleven, filmTen, filmNine, filmEight, filmSeven, filmSix,
                filmFive, filmFour, filmThree, filmTwo,};
        Movies[] actual = manager.getAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindMovie() {

        Movies[] expected = new Movies[]{filmOne, filmTwo, filmThree, filmFour, filmFive, filmSix, filmSeven,
                filmEight, filmNine, filmTen};
        Movies[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }
}