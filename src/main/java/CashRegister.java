import com.google.common.base.Splitter;

import java.util.Scanner;

import static com.google.common.base.Splitter.*;

public class CashRegister {
    public static final int APPLE_PRICE = 100;
    public static final int BANANA_PRICE = 150;
    public static final int CHERRY_PRICE = 75;
    public int money;
    private int numberOfApples;
    private int numberOfCherry;
    private int numberOfBanana;
    private int numberOfPommes;
    private int numberOfMeles;

    public CashRegister() {
        this.money = 0;
        this.numberOfApples = 0;
        this.numberOfCherry = 0;
        this.numberOfBanana = 0;
        this.numberOfMeles = 0;
        this.numberOfPommes = 0;
    }

    public void listenForInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(">");
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            register(input);
            System.out.println(String.valueOf(this.money));
            System.out.print(">");
        }
    }

    public void register(String input) {
        on(',').trimResults().split(input).forEach(this::registerOne);
    }

    public void registerOne(String input) {
        if (input.toLowerCase().contains("apple")) {
            this.numberOfApples++;
            this.money += APPLE_PRICE;
        }
        if (input.toLowerCase().contains("mele")) {
            this.numberOfMeles++;
            this.money += APPLE_PRICE;
            if (numberOfMeles % 2 == 0) {
                this.money -= APPLE_PRICE * .5;
            }
        }
        if (input.toLowerCase().contains("pomme")) {
            this.numberOfPommes++;
            this.money += APPLE_PRICE;
            if (numberOfPommes % 3 == 0) {
                this.money -= APPLE_PRICE;
            }
        }
        if (input.toLowerCase().contains("banana")) {
            this.numberOfBanana++;
            this.money += BANANA_PRICE;
            if (numberOfBanana % 2 == 0) {
                this.money -= BANANA_PRICE;
            }
        }
        if (input.toLowerCase().contains("cherry")) {
            this.numberOfCherry++;
            this.money += CHERRY_PRICE;
            if (numberOfCherry % 2 == 0) {
                this.money -= 20;
            }
        }
        if ((numberOfPommeFamily() > 0 ) && (numberOfPommeFamily() % 4 == 0)) {
            this.money -= 100;
        }
        if (numberOfProducts() % 5 == 0) {
            this.money -= 200;
        }
    }

    public int numberOfProducts() {
        return numberOfPommeFamily() + numberOfBanana + numberOfCherry;
    }

    public int numberOfPommeFamily() {
        return this.numberOfMeles + this.numberOfPommes + this.numberOfApples;
    }

    public static void main(String[] args) {
        new CashRegister().listenForInput();
    }

}
