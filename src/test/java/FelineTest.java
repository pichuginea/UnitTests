import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FelineTest {

	Feline feline;

	@Before
	public void setUp() {
		feline = new Feline();
	}

	@Test
	public void getKittensReturnsOneTest() {
		Assert.assertEquals(1, feline.getKittens());
	}

	@Test
	public void getKittensWithKittensCountTest() {
		Assert.assertEquals(2, feline.getKittens(2));
	}

	@Test
	public void getFamilyReturnsFelineTest() {
		Assert.assertEquals("Кошачьи", feline.getFamily());
	}

	@Test
	public void eatMeatReturnsFoodForPredatorTest() throws Exception {
		List<String> expectedList = feline.eatMeat();
		List<String> actualList = feline.getFood("Хищник");
		Assert.assertEquals(expectedList, actualList);
	}

	@Test
	public void eatMeatReturnsFoodForHerbivoreTest() throws Exception {
		List<String> expectedList = List.of("Трава", "Различные растения");
		List<String> actualList = feline.getFood("Травоядное");
		Assert.assertEquals(expectedList, actualList);
	}

	@Test(expected = Exception.class)
	public void eatMeatExceptionTest() throws Exception {
		try {
			feline.getFood("null");
		} catch (Exception e) {
			String message = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
			Assert.assertEquals(message, e.getMessage());
			throw e;
		}
	}
}
