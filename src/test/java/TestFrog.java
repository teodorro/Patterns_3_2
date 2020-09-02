import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestFrog {
    @Test
    public void testJump_Negative(){
        Frog frog = new Frog();

        boolean res = frog.jump(-1);

        Assertions.assertTrue(res);
        Assertions.assertEquals(4, frog.getPosition());
    }

    @Test
    public void testJump_TooLeft(){
        Frog frog = new Frog();

        boolean res = frog.jump(-11);

        Assertions.assertFalse(res);
        Assertions.assertEquals(5, frog.getPosition());
    }

    @Test
    public void testJump_TooRight(){
        Frog frog = new Frog();

        boolean res = frog.jump(11);

        Assertions.assertFalse(res);
        Assertions.assertEquals(5, frog.getPosition());
    }
}
