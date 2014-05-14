import com.google.common.collect.Maps;
import com.google.common.util.concurrent.AtomicLongMap;

import java.util.Scanner;

import static com.google.common.base.Splitter.on;

public class CashRegister {
    public static final int TRESHOLD_FOR_PRODUCT_DISCOUNT = 5;
    public static final int POMMEFAMILY_DISCOUNT = 100;
    public static final int PRODUCT_DISCOUNT = 200;
    public long money;
    private final AtomicLongMap<FRUIT> fruitCounter;

    public CashRegister() {
        this.money = 0;
        fruitCounter = AtomicLongMap.create();
        for (FRUIT fruit : FRUIT.values()) {
            fruitCounter.put(fruit, 0);
        }
    }

    public void listenForInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            register(input);
            System.out.println(String.valueOf(this.money));
            System.out.print("> ");
        }
    }

    public void register(String input) {
        on(',').trimResults().split(input).forEach(this::registerOne);
    }

    public void registerOne(String input) {
        FRUIT fruit = FRUIT.valueOf(input.trim().toUpperCase());

        this.money += fruit.priceWithEventualDiscount(fruitCounter.incrementAndGet(fruit));

        if (isElligibleForPommeFamilyDiscount(fruit)) {
            this.money -= POMMEFAMILY_DISCOUNT;
        }
        if (eligibleForProductDiscount()) {
            this.money -= PRODUCT_DISCOUNT;
        }
    }

    private boolean isElligibleForPommeFamilyDiscount(FRUIT fruit) {
        return fruit.pommeFamily && (numberOfPommeFamily() > 0) && (numberOfPommeFamily() % 4 == 0);
    }

    private boolean eligibleForProductDiscount() {
        return numberOfProducts() % TRESHOLD_FOR_PRODUCT_DISCOUNT == 0;
    }

    public long numberOfProducts() {
//        the jdk 8 way, don't rofl
//        return fruitCounter.asMap().values().stream().reduce((x,y) -> x + y).get();
        return fruitCounter.sum();
    }

    public long numberOfPommeFamily() {
        //        the jdk 8 way, don't rofl
        //        return fruitCounter.asMap().entrySet().stream().filter((e) -> e.getKey().pommeFamily).mapToLong((e) -> e.getValue()).sum();

        return Maps.filterEntries(fruitCounter.asMap(), (e) -> e.getKey().pommeFamily).values().stream().reduce( (x,y) -> x+y).get();
    }

    public static void main(String[] args) {
        new CashRegister().listenForInput();
    }

}
