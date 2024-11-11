package ru.mirea.filyev.pract2_task2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameShop {
    private Map<String, BoardGame> gamesCatalog;
    private float earnings;

    public GameShop() {
        this.gamesCatalog = new HashMap<>();
        this.earnings = 0.0f;
    }

    public BoardGame buyGame(String name, float money) {
        if (gamesCatalog.containsKey(name)) {
            BoardGame game = gamesCatalog.get(name);
            if (money >= game.getPrice()) {
                earnings += game.getPrice();
                gamesCatalog.remove(name);
                return game;
            }
        }
        return null;
    }

    public float getEarnings() {
        return earnings;
    }

    public List<BoardGame> getCatalog() {
        return this.gamesCatalog.values().stream().toList();
    }

    public void addGameToCatalog(BoardGame game) {
        gamesCatalog.put(game.getName(), game);
    }

}
