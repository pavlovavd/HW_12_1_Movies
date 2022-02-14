package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoviesManagerTest {


    @Test
    public void shouldConstructorIfExist() {
        MoviesManager manager = new MoviesManager();
        Movies filmOne = new Movies(1, "one", "comedy", true);
        Movies filmTwo = new Movies(2, "two", "horror", true);
        Movies filmThree = new Movies(3, "three", "documentary ", true);
        Movies filmFour = new Movies(4, "four", "action", false);
        Movies filmFive = new Movies(5, "five", "thriller", false);
        Movies filmSix = new Movies(6, "six", "drama", false);
        Movies filmSeven = new Movies(7, "seven", "animation", false);
        Movies filmEight = new Movies(8, "eight", "cartoon", true);
        Movies filmNine = new Movies(9, "nine", "fiction ", false);
        Movies filmTen = new Movies(10, "ten", "adventure ", true);

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

        Movies[] expected = new Movies[]{filmTen, filmNine, filmEight, filmSeven, filmSix, filmFive,
                filmFour, filmThree, filmTwo, filmOne};
        Movies[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldConstructorOverLimit() {
        MoviesManager manager = new MoviesManager();
        Movies filmOne = new Movies(1, "one", "comedy", true);
        Movies filmTwo = new Movies(2, "two", "horror", true);
        Movies filmThree = new Movies(3, "three", "documentary ", true);
        Movies filmFour = new Movies(4, "four", "action", false);
        Movies filmFive = new Movies(5, "five", "thriller", false);
        Movies filmSix = new Movies(6, "six", "drama", false);
        Movies filmSeven = new Movies(7, "seven", "animation", false);
        Movies filmEight = new Movies(8, "eight", "cartoon", true);
        Movies filmNine = new Movies(9, "nine", "fiction ", false);
        Movies filmTen = new Movies(10, "ten", "adventure ", true);
        Movies filmEleven = new Movies(11, "eleven", "horror ", true);

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
        manager.save(filmEleven);

        Movies[] expected = new Movies[]{filmEleven, filmTen, filmNine, filmEight, filmSeven, filmSix,
                filmFive, filmFour, filmThree, filmTwo,};
        Movies[] actual = manager.getAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldConstructorOwnLimitMovies() {
        MoviesManager manager = new MoviesManager(5);
        Movies filmOne = new Movies(1, "one", "comedy", true);
        Movies filmTwo = new Movies(2, "two", "horror", true);
        Movies filmThree = new Movies(3, "three", "documentary ", true);
        Movies filmFour = new Movies(4, "four", "action", false);
        Movies filmFive = new Movies(5, "five", "thriller", false);

        manager.save(filmOne);
        manager.save(filmTwo);
        manager.save(filmThree);
        manager.save(filmFour);
        manager.save(filmFive);

        Movies[] expected = new Movies[]{filmFive, filmFour, filmThree, filmTwo, filmOne};
        Movies[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {
        MoviesManager manager = new MoviesManager();
        int idToFind = 1;
        Movies filmOne = new Movies(1, "one", "comedy", true);

        manager.findAll();

        Movies[] expected = new Movies[] {filmOne};
        Movies[] actual = manager.findAll();

    }
}