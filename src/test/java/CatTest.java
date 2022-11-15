import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CatTest {

	Feline feline;
	Predator predator;
	Cat cat;

	@Before
	public void setUp() {
		cat = new Cat(feline);
	}

	@Test
	public void getSoundTest() {
		Assert.assertEquals("Мяу", cat.getSound());
	}

	@Test(expected = NullPointerException.class)
	public void getFoodAlwaysNullTest() throws Exception {
		List<String> expectedList = predator.eatMeat();
		List<String> actualList = cat.getFood();
		Assert.assertEquals(expectedList, actualList);
	}
}
