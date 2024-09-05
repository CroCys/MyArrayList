import org.example.MyArrayList;
import org.example.Phone;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyArrayListTest {

	// Тест для конструктора
	@Test
	void testConstructor() {
		Phone phone = new Phone("iPhone", 1000);

		assertEquals("iPhone", phone.getModel(), "Модель должна быть 'iPhone' при создании через конструктор");
		assertEquals(1000, phone.getPrice(), "Цена должна быть 1000 при создании через конструктор");
	}

	// Тест для геттера getModel()
	@Test
	void testGetModel() {
		Phone phone = new Phone("Samsung", 800);

		assertEquals("Samsung", phone.getModel(), "Метод getModel() должен возвращать 'Samsung'");
	}

	// Тест для сеттера setModel()
	@Test
	void testSetModel() {
		Phone phone = new Phone("Xiaomi", 500);
		phone.setModel("OnePlus");

		assertEquals("OnePlus", phone.getModel(), "Метод setModel() должен установить модель 'OnePlus'");
	}

	// Тест для геттера getPrice()
	@Test
	void testGetPrice() {
		Phone phone = new Phone("Nokia", 600);

		assertEquals(600, phone.getPrice(), "Метод getPrice() должен возвращать 600");
	}

	// Тест для сеттера setPrice()
	@Test
	void testSetPrice() {
		Phone phone = new Phone("Google Pixel", 900);
		phone.setPrice(1200);

		assertEquals(1200, phone.getPrice(), "Метод setPrice() должен установить цену 1200");
	}

	// Тест для метода compareTo() - когда цена текущего телефона меньше
	@Test
	void testCompareTo_LessThan() {
		Phone phone1 = new Phone("LG", 500);
		Phone phone2 = new Phone("Motorola", 800);

		assertTrue(phone1.compareTo(phone2) < 0, "Phone с ценой 500 должен быть 'меньше' Phone с ценой 800");
	}

	// Тест для метода compareTo() - когда цена текущего телефона больше
	@Test
	void testCompareTo_GreaterThan() {
		Phone phone1 = new Phone("Huawei", 1500);
		Phone phone2 = new Phone("Asus", 1000);

		assertTrue(phone1.compareTo(phone2) > 0, "Phone с ценой 1500 должен быть 'больше' Phone с ценой 1000");
	}

	// Тест для метода compareTo() - когда цена телефонов одинаковая
	@Test
	void testCompareTo_Equals() {
		Phone phone1 = new Phone("Alcatel", 600);
		Phone phone2 = new Phone("Oppo", 600);

		assertEquals(0, phone1.compareTo(phone2), "Два телефона с одинаковой ценой должны быть равны при сравнении");
	}

	// Тест для метода add() (добавление в конец)
	@Test
	void testAdd() {
		MyArrayList<Phone> list = new MyArrayList<>();
		Phone phone1 = new Phone("iPhone", 1000);
		Phone phone2 = new Phone("Samsung", 900);

		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add(phone1);
		list.add(phone2);

		assertEquals(2, list.size(), "Размер списка должен быть 2 после добавления двух телефонов");
		assertEquals(phone1, list.get(0), "Первый элемент должен быть iPhone");
		assertEquals(phone2, list.get(1), "Второй элемент должен быть Samsung");
	}

	@Test
	void testAddString() {
		MyArrayList<String> list = new MyArrayList<>();

		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add("First");
		list.add("Second");

		assertEquals(2, list.size(), "Размер списка должен быть 2 после добавления двух элементов");
		assertEquals("First", list.get(0), "Первый элемент должен быть 'First'");
		assertEquals("Second", list.get(1), "Второй элемент должен быть 'Second'");
	}

	@Test
	void testAddInteger() {
		MyArrayList<Integer> list = new MyArrayList<>();

		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add(1);
		list.add(2);

		assertEquals(2, list.size(), "Размер списка должен быть 2 после добавления двух элементов");
		assertEquals(1, list.get(0), "Первый элемент должен быть 1");
		assertEquals(2, list.get(1), "Второй элемент должен быть 2");
	}

	@Test
	void testAdd1000() {
		MyArrayList<Phone> phoneList = new MyArrayList<>();
		MyArrayList<String> stringList = new MyArrayList<>();
		MyArrayList<Integer> integerList = new MyArrayList<>();
		Phone phone1 = new Phone("iPhone", 1000);

		assertEquals(0, phoneList.size(), "Размер списка должен быть 0");
		assertEquals(0, stringList.size(), "Размер списка должен быть 0");
		assertEquals(0, integerList.size(), "Размер списка должен быть 0");

		for (int i = 0; i < 1000; i++) {
			phoneList.add(phone1);
		}

		for (int i = 0; i < 1000; i++) {
			stringList.add("one");
		}

		for (int i = 0; i < 1000; i++) {
			integerList.add(1);
		}

		assertEquals(1000, phoneList.size(), "Размер списка должен быть 1000 после добавления 1000 элементов");
		assertEquals(1000, stringList.size(), "Размер списка должен быть 1000 после добавления 1000 элементов");
		assertEquals(1000, integerList.size(), "Размер списка должен быть 1000 после добавления 1000 элементов");
	}

	// Тест для метода add() с добавлением по индексу
	@Test
	void testAddByIndex() {
		MyArrayList<Phone> list = new MyArrayList<>();
		Phone phone1 = new Phone("Xiaomi", 500);
		Phone phone2 = new Phone("Huawei", 700);
		Phone phone3 = new Phone("Sony", 600);

		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add(phone1);
		list.add(phone2);
		list.add(1, phone3); // Вставка на позицию 1

		assertEquals(3, list.size(), "Размер списка должен быть 3 после вставки телефона по индексу");
		assertEquals(phone1, list.get(0), "Первый элемент должен быть Xiaomi");
		assertEquals(phone3, list.get(1), "Второй элемент должен быть Sony после вставки");
		assertEquals(phone2, list.get(2), "Третий элемент должен быть Huawei");
	}

	@Test
	void testAddByIndexString() {
		MyArrayList<String> list = new MyArrayList<>();
		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add("First");
		list.add("Second");

		list.add(1, "Inserted");

		assertEquals(3, list.size(), "Размер списка должен быть 3 после вставки элемента по индексу");
		assertEquals("First", list.get(0), "Первый элемент должен быть 'First'");
		assertEquals("Inserted", list.get(1), "Вставленный элемент должен быть на позиции 1");
		assertEquals("Second", list.get(2), "Элемент 'Second' должен быть на позиции 2");
	}

	@Test
	void testAddByIndexInteger() {
		MyArrayList<Integer> list = new MyArrayList<>();
		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add(1);
		list.add(3);

		list.add(1, 2);

		assertEquals(3, list.size(), "Размер списка должен быть 3 после вставки элемента по индексу");
		assertEquals(1, list.get(0), "Первый элемент должен быть 1");
		assertEquals(2, list.get(1), "Вставленный элемент должен быть на позиции 1");
		assertEquals(3, list.get(2), "Элемент 3 должен быть на позиции 2");
	}

	// Тест для метода get() (получение элемента по индексу)
	@Test
	void testGet() {
		MyArrayList<Phone> list = new MyArrayList<>();
		Phone phone1 = new Phone("Nokia", 600);
		Phone phone2 = new Phone("Motorola", 800);

		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add(phone1);
		list.add(phone2);

		assertEquals(phone1, list.get(0), "Первый элемент должен быть Nokia");
		assertEquals(phone2, list.get(1), "Второй элемент должен быть Motorola");
	}

	@Test
	void testGetString() {
		MyArrayList<String> list = new MyArrayList<>();
		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add("First");
		list.add("Second");

		assertEquals("First", list.get(0), "Первый элемент должен быть 'First'");
		assertEquals("Second", list.get(1), "Второй элемент должен быть 'Second'");
	}

	@Test
	void testGetInteger() {
		MyArrayList<Integer> list = new MyArrayList<>();
		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add(10);
		list.add(20);

		assertEquals(10, list.get(0), "Первый элемент должен быть 10");
		assertEquals(20, list.get(1), "Второй элемент должен быть 20");
	}

	// Тест для метода remove() (удаление элемента по индексу)
	@Test
	void testRemove() {
		MyArrayList<Phone> list = new MyArrayList<>();
		Phone phone1 = new Phone("Google Pixel", 1000);
		Phone phone2 = new Phone("LG", 800);
		Phone phone3 = new Phone("OnePlus", 900);

		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add(phone1);
		list.add(phone2);
		list.add(phone3);

		list.remove(1); // Удаляем второй элемент (LG)

		assertEquals(2, list.size(), "Размер списка должен быть 2 после удаления элемента");
		assertEquals(phone1, list.get(0), "Первый элемент должен остаться Google Pixel");
		assertEquals(phone3, list.get(1), "Второй элемент теперь должен быть OnePlus");
	}

	@Test
	void testRemoveString() {
		MyArrayList<String> list = new MyArrayList<>();
		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add("First");
		list.add("Second");
		list.add("Third");

		list.remove(1);

		assertEquals(2, list.size(), "Размер списка должен быть 2 после удаления");
		assertEquals("First", list.get(0), "Первый элемент должен остаться 'First'");
		assertEquals("Third", list.get(1), "Теперь второй элемент должен быть 'Third'");
	}

	@Test
	void testRemoveInteger() {
		MyArrayList<Integer> list = new MyArrayList<>();
		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add(10);
		list.add(20);
		list.add(30);

		list.remove(1);

		assertEquals(2, list.size(), "Размер списка должен быть 2 после удаления");
		assertEquals(10, list.get(0), "Первый элемент должен остаться 10");
		assertEquals(30, list.get(1), "Теперь второй элемент должен быть 30");
	}

	@Test
	void testRemove1000() {
		MyArrayList<Phone> phoneList = new MyArrayList<>();
		MyArrayList<String> stringList = new MyArrayList<>();
		MyArrayList<Integer> integerList = new MyArrayList<>();
		Phone phone1 = new Phone("iPhone", 1000);

		assertEquals(0, phoneList.size(), "Размер списка должен быть 0");
		assertEquals(0, stringList.size(), "Размер списка должен быть 0");
		assertEquals(0, integerList.size(), "Размер списка должен быть 0");

		for (int i = 0; i < 1000; i++) {
			phoneList.add(phone1);
		}

		for (int i = 0; i < 1000; i++) {
			stringList.add("one");
		}

		for (int i = 0; i < 1000; i++) {
			integerList.add(1);
		}

		assertEquals(1000, phoneList.size(), "Размер списка должен быть 1000 после добавления 1000 элементов");
		assertEquals(1000, stringList.size(), "Размер списка должен быть 1000 после добавления 1000 элементов");
		assertEquals(1000, integerList.size(), "Размер списка должен быть 1000 после добавления 1000 элементов");

		for (int i = 0; i < 1000; i++) {
			phoneList.remove(i);
		}

		for (int i = 0; i < 1000; i++) {
			stringList.remove(i);
		}

		for (int i = 0; i < 1000; i++) {
			integerList.remove(i);
		}

		assertEquals(0, phoneList.size(), "Размер списка должен быть 0 после удаления 1000 элементов");
		assertEquals(0, stringList.size(), "Размер списка должен быть 0 после удаления 1000 элементов");
		assertEquals(0, integerList.size(), "Размер списка должен быть 0 после удаления 1000 элементов");
	}

	// Тест для метода set() (замена элемента по индексу)
	@Test
	void testSet() {
		MyArrayList<Phone> list = new MyArrayList<>();
		Phone phone1 = new Phone("HTC", 600);
		Phone phone2 = new Phone("Sony", 700);
		Phone phone3 = new Phone("Samsung", 800);

		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add(phone1);
		list.add(phone2);

		list.set(1, phone3); // Замена второго элемента на Samsung

		assertEquals(2, list.size(), "Размер списка должен остаться 2 после замены элемента");
		assertEquals(phone3, list.get(1), "Второй элемент должен быть заменен на Samsung");
	}

	@Test
	void testSetString() {
		MyArrayList<String> list = new MyArrayList<>();
		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add("First");
		list.add("Second");

		list.set(1, "NewSecond");

		assertEquals(2, list.size(), "Размер списка должен остаться 2 после замены элемента");
		assertEquals("NewSecond", list.get(1), "Второй элемент должен быть заменен на 'NewSecond'");
	}

	@Test
	void testSetInteger() {
		MyArrayList<Integer> list = new MyArrayList<>();
		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add(100);
		list.add(200);

		list.set(1, 300);

		assertEquals(2, list.size(), "Размер списка должен остаться 2 после замены элемента");
		assertEquals(300, list.get(1), "Второй элемент должен быть заменен на 300");
	}

	// Тест для метода clear() (очистка списка)
	@Test
	void testClear() {
		MyArrayList<Phone> list = new MyArrayList<>();
		Phone phone1 = new Phone("Google", 1000);
		Phone phone2 = new Phone("Nokia", 600);

		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add(phone1);
		list.add(phone2);

		list.clear(); // Очистка списка

		assertEquals(0, list.size(), "Размер списка должен быть 0 после очистки");
	}

	@Test
	void testClearString() {
		MyArrayList<String> list = new MyArrayList<>();
		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add("First");
		list.add("Second");

		list.clear();

		assertEquals(0, list.size(), "Размер списка должен быть 0 после очистки");
	}

	@Test
	void testClearInteger() {
		MyArrayList<Integer> list = new MyArrayList<>();
		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add(50);
		list.add(100);

		list.clear();

		assertEquals(0, list.size(), "Размер списка должен быть 0 после очистки");
	}

	// Тест для метода sort() (сортировка списка)
	@Test
	void testSort() {
		MyArrayList<Phone> list = new MyArrayList<>();
		Phone phone1 = new Phone("Huawei", 800);
		Phone phone2 = new Phone("Samsung", 600);
		Phone phone3 = new Phone("Apple", 1000);

		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add(phone1);
		list.add(phone2);
		list.add(phone3);

		list.sort(); // Сортировка по цене

		assertEquals(3, list.size(), "Размер списка должен остаться 3 после сортировки");
		assertEquals(phone2, list.get(0), "Первый элемент должен быть Samsung (цена 600) после сортировки");
		assertEquals(phone1, list.get(1), "Второй элемент должен быть Huawei (цена 800)");
		assertEquals(phone3, list.get(2), "Третий элемент должен быть Apple (цена 1000)");
	}

	@Test
	void testSortInteger() {
		MyArrayList<Integer> list = new MyArrayList<>();

		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add(3);
		list.add(1);
		list.add(2);

		list.sort();

		assertEquals(3, list.size(), "Размер списка должен остаться 3 после сортировки");
		assertEquals(1, list.get(0), "Первый элемент должен быть 1 после сортировки");
		assertEquals(2, list.get(1), "Второй элемент должен быть 2 после сортировки");
		assertEquals(3, list.get(2), "Третий элемент должен быть 3 после сортировки");
	}

	// Тест для метода sort(Comparator) (сортировка с компаратором)
	@Test
	void testSortWithComparator() {
		MyArrayList<Phone> list = new MyArrayList<>();
		Phone phone1 = new Phone("OnePlus", 700);
		Phone phone2 = new Phone("Oppo", 900);
		Phone phone3 = new Phone("Realme", 500);

		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add(phone1);
		list.add(phone2);
		list.add(phone3);

		// Сортировка по убыванию цены
		list.sort(Comparator.comparing(Phone::getPrice).reversed());

		assertEquals(3, list.size(), "Размер списка должен остаться 3 после сортировки по убыванию");
		assertEquals(phone2, list.get(0), "Первый элемент должен быть Oppo (цена 900)");
		assertEquals(phone1, list.get(1), "Второй элемент должен быть OnePlus (цена 700)");
		assertEquals(phone3, list.get(2), "Третий элемент должен быть Realme (цена 500)");
	}

	@Test
	void testSortWithComparatorString() {
		MyArrayList<String> list = new MyArrayList<>();

		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add("C");
		list.add("A");
		list.add("B");

		list.sort(Comparator.naturalOrder());

		assertEquals(3, list.size(), "Размер списка должен остаться 3 после сортировки");
		assertEquals("A", list.get(0), "Первый элемент должен быть 'A' после сортировки");
		assertEquals("B", list.get(1), "Второй элемент должен быть 'B' после сортировки");
		assertEquals("C", list.get(2), "Третий элемент должен быть 'C' после сортировки");
	}
}