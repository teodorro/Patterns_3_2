import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestMain {
    @Test
    public void testValidateCommand(){
        Assertions.assertTrue(Main.validateCommand("!!"));
        Assertions.assertTrue(Main.validateCommand("0"));
        Assertions.assertTrue(Main.validateCommand("+1"));
        Assertions.assertTrue(Main.validateCommand("-1"));

        Assertions.assertFalse(Main.validateCommand("-1" + Frog.MAX_POSITION));
        Assertions.assertFalse(Main.validateCommand("1" + Frog.MAX_POSITION));
        Assertions.assertFalse(Main.validateCommand("1"));
        Assertions.assertFalse(Main.validateCommand("++1"));
        Assertions.assertFalse(Main.validateCommand("qewfr vfd"));

    }
}
