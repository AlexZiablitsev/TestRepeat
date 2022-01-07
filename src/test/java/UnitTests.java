import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTests {
    //a > 0, b > 0 проверить a + b
    @Test
    public void sumTest1() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.sum(2, 3), 5, "Тестовый коментарий");
    }

    //a < 0, b < 0 проверить a + b
    @Test
    public void sumTest2() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.sum(-2, -3), -5);
    }

    //a > 0, b < 0 проверить a + b
    @Test
    public void sumTest3() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.sum(2, -3), -1);
    }

    @Test
    public void divTest1() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.div(4, 2), 2);
    }

    @Test
    public void divTest2() {
        Calculator calculator = new Calculator();
        Assert.assertThrows(java.lang.ArithmeticException.class, () -> calculator.div(4, 0));
    }

    @Test
    public void doubleDivTest() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.div(2.44, 2.0), 1.22);
    }

    @Test
    public void doubleDivTest1() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.div(4.0, 0), Double.POSITIVE_INFINITY);
    }

    @Test
    public void doubleDivTest2() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.div(-4.0, 0), Double.NEGATIVE_INFINITY);
    }

    @Test
    public void squareTest() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.square(16), 4);
    }

    @Test
    public void squareTest1() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.square(-16), 0);
    }
}
