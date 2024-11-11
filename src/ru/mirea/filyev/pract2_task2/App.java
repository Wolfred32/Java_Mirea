package ru.mirea.filyev.pract2_task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {

        GameShop shop = new GameShop();

        shop.addGameToCatalog(new BoardGame("Catan", 3, 4, 90, 10, 299.99f));
        shop.addGameToCatalog(new BoardGame("Carcassonne", 2, 5, 45, 8, 249.99f));
        shop.addGameToCatalog(new BoardGame("Ticket to Ride", 2, 5, 60, 8, 449.99f));
        shop.addGameToCatalog(new BoardGame("Pandemic", 2, 4, 45, 12, 399.99f));
        shop.addGameToCatalog(new BoardGame("7 Wonders", 3, 7, 30, 10, 349.99f));
        shop.addGameToCatalog(new BoardGame("Dominion", 2, 4, 30, 14, 299.99f));
        shop.addGameToCatalog(new BoardGame("Gloomhaven", 1, 4, 120, 14, 999.99f));
        shop.addGameToCatalog(new BoardGame("Terraforming Mars", 1, 5, 120, 12, 499.99f));
        shop.addGameToCatalog(new BoardGame("Scythe", 1, 7, 115, 14, 599.99f));
        shop.addGameToCatalog(new BoardGame("Wingspan", 1, 5, 40, 10, 399.99f));
        shop.addGameToCatalog(new BoardGame("Root", 2, 4, 90, 10, 549.99f));
        shop.addGameToCatalog(new BoardGame("Agricola", 1, 5, 120, 12, 499.99f));
        shop.addGameToCatalog(new BoardGame("Everdell", 1, 4, 60, 13, 399.99f));

        List<Customer> customers = generateCustomers();

        int soldGamesCount = 0;
        for (Customer customer : customers) {
            BoardGame purchasedGame = shop.buyGame(customer.getGameName(), customer.getMoney());
            if (purchasedGame != null) {
                System.out.println("Покупатель купил игру: " + purchasedGame.getName() + " за " + purchasedGame.getPrice() + " RUB");
                soldGamesCount++;
            } else {
                System.out.println("У покупателя недостаточно средств на счету для покупки " + customer.getGameName());
            }

            if (shop.getCatalog().isEmpty()) {
                System.out.println("Все игры проданы!");
                break;
            }
        }

        System.out.println("\nКоличество проданных игр: " + soldGamesCount);
        System.out.println("Общий заработок магазина: " + shop.getEarnings() + " RUB");
    }

    public static List<Customer> generateCustomers() {
        List<String> availableGames = List.of(
                "Catan", "Carcassonne", "Ticket to Ride", "Pandemic", "7 Wonders",
                "Dominion", "Gloomhaven", "Terraforming Mars", "Scythe", "Wingspan",
                "Root", "Agricola", "Everdell"
        );

        List<Customer> customers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            String randomGame = availableGames.get(random.nextInt(availableGames.size()));
            float randomMoney = 100.0f + random.nextFloat() * 1000.0f;
            customers.add(new Customer(randomGame, randomMoney));
        }

        return customers;
    }
}
