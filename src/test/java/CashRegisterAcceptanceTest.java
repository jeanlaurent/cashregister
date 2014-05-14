import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CashRegisterAcceptanceTest {

    private CashRegister cashRegister;

    @Before
    public void init() {
        cashRegister = new CashRegister();
    }

    @Test
    public void step1() {
        cash("Pommes");
        cash("Cerise");
        cash("Cerise");
        hasMoney(230);
    }

    @Test
    public void step1_2() {
        cash("Cerise");
        cash("Pomme");
        cash("Cerise");
        cash("banane");
        cash("pomme");
        hasMoney(280); // was 500 at start, with cherry and product discount it changes
    }

    @Test
    public void step6() {
        cash("Mele, Pommes, Pommes, Mele");
        hasMoney(250);
        cash("Banane");
        hasMoney(200);
        cash("Mele, Pommes, Pommes, Apple, Mele");
        hasMoney(350);
    }

    private void cash(String input) {
        cashRegister.register(input);
    }

    private void hasMoney(int expected) {
        assertThat(cashRegister.money).isEqualTo(expected);
    }

}
