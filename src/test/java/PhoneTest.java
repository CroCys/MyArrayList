import org.example.Phone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс для тестирования методов и конструктора класса {@link Phone}.
 */
public class PhoneTest {

	/**
	 * Тестирует работу конструктора класса {@link Phone}.
	 * Проверяет корректность инициализации модели и цены.
	 */
	@Test
	void testPhoneConstructor() {
		Phone phone = new Phone("iPhone", 1000);
		Phone phone1 = new Phone();

		assertEquals("iPhone", phone.getModel(), "Модель должна быть 'iPhone' при создании через конструктор");
		assertEquals(1000, phone.getPrice(), "Цена должна быть 1000 при создании через конструктор");
		assertNull(phone1.getModel());
		assertEquals(0, phone1.getPrice());
	}

	/**
	 * Тестирует метод {@link Phone#getModel()}, который возвращает модель телефона.
	 */
	@Test
	void testGetModel() {
		Phone phone = new Phone("Samsung", 800);

		assertEquals("Samsung", phone.getModel(), "Метод getModel() должен возвращать 'Samsung'");
	}

	/**
	 * Тестирует метод {@link Phone#setModel(String)}, который устанавливает модель телефона.
	 */
	@Test
	void testSetModel() {
		Phone phone = new Phone("Xiaomi", 500);
		phone.setModel("OnePlus");

		assertEquals("OnePlus", phone.getModel(), "Метод setModel() должен установить модель 'OnePlus'");
	}

	/**
	 * Тестирует метод {@link Phone#getPrice()}, который возвращает цену телефона.
	 */
	@Test
	void testGetPrice() {
		Phone phone = new Phone("Nokia", 600);

		assertEquals(600, phone.getPrice(), "Метод getPrice() должен возвращать 600");
	}

	/**
	 * Тестирует метод {@link Phone#setPrice(int)}, который устанавливает цену телефона.
	 */
	@Test
	void testSetPrice() {
		Phone phone = new Phone("Google Pixel", 900);
		phone.setPrice(1200);

		assertEquals(1200, phone.getPrice(), "Метод setPrice() должен установить цену 1200");
	}

	/**
	 * Тестирует метод {@link Phone#toString()} для проверки корректного вывода
	 * строкового представления объекта телефона.
	 */
	@Test
	void testToString() {
		Phone phone1 = new Phone("iPhone", 1000);

		assertEquals("Phone{model='iPhone', price=1000}", phone1.toString());
	}
}