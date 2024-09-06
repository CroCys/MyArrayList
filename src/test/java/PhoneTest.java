import org.example.MyArrayList;
import org.example.Phone;
import org.example.PhoneComparator;
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
	 * Тестирует сортировку объектов класса {@link Phone} с использованием
	 * пользовательского компаратора {@link PhoneComparator}.
	 */
	@Test
	void testPhoneComparator() {
		MyArrayList<Phone> phoneList = new MyArrayList<>();
		Phone phone1 = new Phone("iPhone", 1000);
		Phone phone2 = new Phone("Samsung", 900);
		Phone phone3 = new Phone("Nokia", 600);
		Phone phone4 = new Phone("Motorola", 800);
		PhoneComparator comparator = new PhoneComparator();

		phoneList.add(phone1);
		phoneList.add(phone2);
		phoneList.add(phone3);
		phoneList.add(phone4);

		phoneList.sort(comparator);

		assertEquals(phoneList.get(0) == phone4, phoneList.get(0) == phone4);
		assertEquals(phoneList.get(1) == phone3, phoneList.get(1) == phone3);
		assertEquals(phoneList.get(2) == phone2, phoneList.get(2) == phone2);
		assertEquals(phoneList.get(3) == phone1, phoneList.get(3) == phone1);
	}

	/**
	 * Тестирует метод {@link Phone#compareTo(Phone)}.
	 * Сравнивает два телефона, когда текущий телефон дешевле.
	 */
	@Test
	void testCompareTo_LessThan() {
		Phone phone1 = new Phone("LG", 500);
		Phone phone2 = new Phone("Motorola", 800);

		assertTrue(phone1.compareTo(phone2) < 0, "Phone с ценой 500 должен быть 'меньше' Phone с ценой 800");
	}

	/**
	 * Тестирует метод {@link Phone#compareTo(Phone)}.
	 * Сравнивает два телефона, когда текущий телефон дороже.
	 */
	@Test
	void testCompareTo_GreaterThan() {
		Phone phone1 = new Phone("Huawei", 1500);
		Phone phone2 = new Phone("Asus", 1000);

		assertTrue(phone1.compareTo(phone2) > 0, "Phone с ценой 1500 должен быть 'больше' Phone с ценой 1000");
	}

	/**
	 * Тестирует метод {@link Phone#compareTo(Phone)}.
	 * Сравнивает два телефона с одинаковой ценой.
	 */
	@Test
	void testCompareTo_Equals() {
		Phone phone1 = new Phone("Alcatel", 600);
		Phone phone2 = new Phone("Oppo", 600);

		assertEquals(0, phone1.compareTo(phone2), "Два телефона с одинаковой ценой должны быть равны при сравнении");
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