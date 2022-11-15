import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	String sex;
	boolean hasMane;

	public LionTest(String sex, boolean hasMane) {
		this.sex = sex;
		this.hasMane = hasMane;
	}

	@Mock
	Feline feline;

	@Parameterized.Parameters(name = "Пол = {0}, Грива = {1}")
	public static Object[][] getData() {
		return new Object[][]{
				{"Самец", true},
				{"Самка", false},
				{"Unknown", false},
		};
	}

	@Test
	public void doesHaveManeTest() {
		try {
			Lion lion = new Lion(sex, feline);
			Assert.assertEquals(hasMane, lion.doesHaveMane());
		} catch (Exception e) {
			checkErrorMessage(e);
		}
	}

	@Test
	public void getKittensTest() {
		try {
			Lion lion = new Lion(sex, feline);
			Mockito.when(lion.getKittens()).thenReturn(100);
			Assert.assertEquals(100, lion.getKittens());
		} catch (Exception e) {
			checkErrorMessage(e);
		}
	}

	@Test
	public void getFoodTest() {
		try {
			Lion lion = new Lion(sex, feline);
			List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
			Mockito.when(lion.getFood()).thenReturn(expectedList);
			Assert.assertEquals(expectedList, lion.getFood());
		} catch (Exception e) {
			checkErrorMessage(e);
		}
	}

	void checkErrorMessage(Exception e) {
		String message = "Используйте допустимые значения пола животного - самец или самка";
		Assert.assertEquals(message, e.getMessage());
	}
}
