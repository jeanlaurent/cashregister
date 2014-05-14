import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CashRegisterTest {

    @Test
    public void should_handle_multiple_input() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.register("pomme, pomme");
        assertThat(cashRegister.money).isEqualTo(200);
    }

    @Test
    public void should_handle_apple() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.register("pomme");
        assertThat(cashRegister.money).isEqualTo(100);
    }

    @Test
    public void should_handle_meles() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.register("mele");
        assertThat(cashRegister.money).isEqualTo(100);
    }

    @Test
    public void should_handle_meles_reduction() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.register("mele");
        cashRegister.register("mele");
        assertThat(cashRegister.money).isEqualTo(150);
    }

    @Test
    public void should_handle_meles_reduction_twice() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.register("mele");
        cashRegister.register("mele");
        cashRegister.register("mele");
        assertThat(cashRegister.money).isEqualTo(250);
    }

    @Test
    public void should_handle_pommes() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.register("apple");
        assertThat(cashRegister.money).isEqualTo(100);
    }

    @Test
    public void should_handle_pommes_reduction() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.register("apple");
        cashRegister.register("apple");
        cashRegister.register("apple");
        assertThat(cashRegister.money).isEqualTo(200);
    }

    @Test
    public void should_handle_pommes_reduction_twice() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.register("apple");
        cashRegister.register("apple");
        cashRegister.register("apple");
        cashRegister.register("apple");
        assertThat(cashRegister.money).isEqualTo(200);
    }

    @Test
    public void should_handle_cherry() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.register("cerise");
        assertThat(cashRegister.money).isEqualTo(75);
    }

    @Test
    public void should_handle_cherry_reduction() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.register("cerise");
        cashRegister.register("cerise");
        assertThat(cashRegister.money).isEqualTo(130);
    }

    @Test
    public void should_handle_cherry_reduction_twice() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.register("cerise");
        cashRegister.register("cerise");
        cashRegister.register("cerise");
        assertThat(cashRegister.money).isEqualTo(205);
    }

    @Test
    public void should_handle_banana() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.register("banane");
        assertThat(cashRegister.money).isEqualTo(150);
    }

    @Test
    public void should_handle_banana_reduction() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.register("banane");
        cashRegister.register("banane");
        assertThat(cashRegister.money).isEqualTo(150);
    }

    @Test
    public void should_handle_banana_reduction_twice() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.register("banane");
        cashRegister.register("banane");
        cashRegister.register("banane");
        assertThat(cashRegister.money).isEqualTo(300);
    }

    @Test
    public void should_handle_global_products_reduction() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.register("banane");
        cashRegister.register("cerise");
        cashRegister.register("pomme");
        cashRegister.register("apple");
        cashRegister.register("mele");
        assertThat(cashRegister.money).isEqualTo(325);
    }

}