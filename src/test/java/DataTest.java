import model.services.CarsPark;
import org.junit.Assert;
import org.junit.Test;

public class DataTest {

    @Test
    public void isCorrectData() {
        CarsPark test = new CarsPark(5, 100);
        boolean res = test.correctData(5, 100);

        Assert.assertFalse(res);
    }
}
