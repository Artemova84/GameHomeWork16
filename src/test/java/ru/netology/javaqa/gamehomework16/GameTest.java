package ru.netology.javaqa.gamehomework16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void secondPlayerWinTest() {
        Player vasya = new Player(1, "Вася", 100);
        Player sacha = new Player(2, "Саша", 120);
        Game game = new Game();
        game.register(vasya);
        game.register(sacha);
        int actual = game.round("Саша", "Вася");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerWinTest() {
        Player vasya = new Player(1, "Вася", 150);
        Player sacha = new Player(2, "Саша", 120);
        Game game = new Game();
        game.register(vasya);
        game.register(sacha);
        int actual = game.round("Саша", "Вася");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void drawPlayerTest() {
        Player vasya = new Player(1, "Вася", 120);
        Player sacha = new Player(2, "Саша", 120);
        Game game = new Game();
        game.register(vasya);
        game.register(sacha);
        int actual = game.round("Саша", "Вася");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void PlayerNotExistTest() {
        Player vasya = new Player(1, "Вася", 100);
        Player sacha = new Player(2, "Саша", 120);
        Game game = new Game();
        game.register(vasya);
        game.register(sacha);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Света", "Саша"));
    }

    @Test
    public void PlayerNotExistTest2() {
        Player vasya = new Player(1, "Вася", 100);
        Player sacha = new Player(2, "Саша", 120);
        Game game = new Game();
        game.register(vasya);
        game.register(sacha);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Вася", "Галя"));
    }

    @Test
    public void PlayersNotExistTest() {
        Player vasya = new Player(1, "Вася", 100);
        Player sacha = new Player(2, "Саша", 120);
        Game game = new Game();
        game.register(vasya);
        game.register(sacha);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Света", "Федя"));
    }
}
