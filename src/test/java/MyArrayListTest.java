import org.example.MyArrayList;
import org.example.Phone;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки функциональности класса {@link MyArrayList}.
 */
public class MyArrayListTest {

	/**
	 * Тестирует работу конструктора класса {@link MyArrayList}.
	 * Проверяет корректность инициализации размера.
	 */
	@Test
	void testConstructor() {
		MyArrayList<Phone> phoneList = new MyArrayList<>();
		MyArrayList<Phone> phoneList1 = new MyArrayList<>(5);
		MyArrayList<Phone> phoneList2 = new MyArrayList<>(0);
		MyArrayList<String> stringList = new MyArrayList<>();
		MyArrayList<String> stringList1 = new MyArrayList<>(5);
		MyArrayList<String> stringList2 = new MyArrayList<>(0);
		MyArrayList<Integer> integerList = new MyArrayList<>();
		MyArrayList<Integer> integerList1 = new MyArrayList<>(5);
		MyArrayList<Integer> integerList2 = new MyArrayList<>(0);

		assertEquals(phoneList.size() == 0, phoneList.size() == 0, "Размер листа должен быть 0");
		assertEquals(phoneList1.size() == 5, phoneList1.size() == 5, "Размер листа должен быть 5");
		assertEquals(phoneList2.size() == 0, phoneList1.size() == 0, "Размер листа должен быть 0");
		assertEquals(stringList.size() == 0, stringList.size() == 0, "Размер листа должен быть 0");
		assertEquals(stringList1.size() == 5, stringList1.size() == 5, "Размер листа должен быть 5");
		assertEquals(stringList2.size() == 0, stringList1.size() == 0, "Размер листа должен быть 0");
		assertEquals(integerList.size() == 0, integerList.size() == 0, "Размер листа должен быть 0");
		assertEquals(integerList1.size() == 5, integerList1.size() == 5, "Размер листа должен быть 5");
		assertEquals(integerList2.size() == 0, integerList1.size() == 0, "Размер листа должен быть 0");
	}

	/**
	 * Тестирует исключение для конструктора класса {@link MyArrayList}.
	 */
	@Test
	void testMyArrayListConstructorExceptions() {
		assertThrows(IllegalArgumentException.class, () -> new MyArrayList<>(-1));
	}

	/**
	 * Тестирует метод {@link MyArrayList#add(Comparable)} для добавления элементов в {@link MyArrayList}.
	 */
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

	/**
	 * Тестирует метод {@link MyArrayList#add(Comparable)} для добавления строковых элементов в {@link MyArrayList}.
	 */
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

	/**
	 * Тестирует метод {@link MyArrayList#add(Comparable)} для добавления числовых элементов в {@link MyArrayList}.
	 */
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

	/**
	 * Тестирует метод {@link MyArrayList#add(Comparable)} для добавления 1000 элементов в {@link MyArrayList}.
	 */
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

	/**
	 * Тестирует исключение для метода {@link MyArrayList#add(Comparable)} класса {@link MyArrayList}.
	 */
	@Test
	void testAddException() {
		Phone phone = new Phone();
		assertThrows(IndexOutOfBoundsException.class, () -> new MyArrayList<Phone>().add(-1, phone));
		assertThrows(IndexOutOfBoundsException.class, () -> new MyArrayList<Phone>().add(100, phone));
	}

	/**
	 * Тестирует метод {@link MyArrayList#add(int, Comparable)} для добавления элементов в {@link MyArrayList} по индексу.
	 */
	@Test
	void testAddByIndex() {
		MyArrayList<Phone> list = new MyArrayList<>();
		Phone phone1 = new Phone("Xiaomi", 500);
		Phone phone2 = new Phone("Huawei", 700);
		Phone phone3 = new Phone("Sony", 600);

		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add(phone1);
		list.add(phone2);
		list.add(1, phone3);

		assertEquals(3, list.size(), "Размер списка должен быть 3 после вставки телефона по индексу");
		assertEquals(phone1, list.get(0), "Первый элемент должен быть Xiaomi");
		assertEquals(phone3, list.get(1), "Второй элемент должен быть Sony после вставки");
		assertEquals(phone2, list.get(2), "Третий элемент должен быть Huawei");
	}

	/**
	 * Тестирует метод {@link MyArrayList#add(int, Comparable)} для добавления строковых элементов в {@link MyArrayList} по индексу.
	 */
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

	/**
	 * Тестирует метод {@link MyArrayList#add(int, Comparable)} для добавления числовых элементов в {@link MyArrayList} по индексу.
	 */
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

	/**
	 * Тестирует метод {@link MyArrayList#get(int)} для получения элементов в {@link MyArrayList} по индексу.
	 */
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

	/**
	 * Тестирует метод {@link MyArrayList#get(int)} для получения строковых элементов в {@link MyArrayList} по индексу.
	 */
	@Test
	void testGetString() {
		MyArrayList<String> list = new MyArrayList<>();
		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add("First");
		list.add("Second");

		assertEquals("First", list.get(0), "Первый элемент должен быть 'First'");
		assertEquals("Second", list.get(1), "Второй элемент должен быть 'Second'");
	}

	/**
	 * Тестирует метод {@link MyArrayList#get(int)} для получения числовых элементов в {@link MyArrayList} по индексу.
	 */
	@Test
	void testGetInteger() {
		MyArrayList<Integer> list = new MyArrayList<>();
		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add(10);
		list.add(20);

		assertEquals(10, list.get(0), "Первый элемент должен быть 10");
		assertEquals(20, list.get(1), "Второй элемент должен быть 20");
	}

	/**
	 * Тестирует исключение для метода {@link MyArrayList#get(int)} класса {@link MyArrayList}.
	 */
	@Test
	void testGetException() {
		assertThrows(IndexOutOfBoundsException.class, () -> new MyArrayList<Phone>().get(-1));
		assertThrows(IndexOutOfBoundsException.class, () -> new MyArrayList<Phone>().get(100));
	}

	/**
	 * Тестирует метод {@link MyArrayList#remove(int)} для удаления элементов в {@link MyArrayList} по индексу.
	 */
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

	/**
	 * Тестирует метод {@link MyArrayList#remove(int)} для удаления строковых элементов в {@link MyArrayList} по индексу.
	 */
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

	/**
	 * Тестирует метод {@link MyArrayList#remove(int)} для удаления числовых элементов в {@link MyArrayList} по индексу.
	 */
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

	/**
	 * Тестирует метод {@link MyArrayList#remove(int)} для удаления 1000 элементов в {@link MyArrayList} по индексу.
	 */
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

	/**
	 * Тестирует исключение для метода {@link MyArrayList#remove(int)} класса {@link MyArrayList}.
	 */
	@Test
	void testRemoveException() {
		assertThrows(IndexOutOfBoundsException.class, () -> new MyArrayList<Phone>().remove(-1));
	}

	/**
	 * Тестирует метод {@link MyArrayList#set(int, Comparable)} для замены элементов в {@link MyArrayList} по индексу.
	 */
	@Test
	void testSet() {
		MyArrayList<Phone> list = new MyArrayList<>();
		Phone phone1 = new Phone("HTC", 600);
		Phone phone2 = new Phone("Sony", 700);
		Phone phone3 = new Phone("Samsung", 800);

		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add(phone1);
		list.add(phone2);

		list.set(1, phone3);

		assertEquals(2, list.size(), "Размер списка должен остаться 2 после замены элемента");
		assertEquals(phone3, list.get(1), "Второй элемент должен быть заменен на Samsung");
	}

	/**
	 * Тестирует метод {@link MyArrayList#set(int, Comparable)} для замены строковых элементов в {@link MyArrayList} по индексу.
	 */
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

	/**
	 * Тестирует метод {@link MyArrayList#set(int, Comparable)} для замены числовых элементов в {@link MyArrayList} по индексу.
	 */
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

	/**
	 * Тестирует исключение для метода {@link MyArrayList#set(int, Comparable)} класса {@link MyArrayList}.
	 */
	@Test
	void testSetException() {
		Phone phone = new Phone();
		assertThrows(IndexOutOfBoundsException.class, () -> new MyArrayList<Phone>().set(-1, phone));
		assertThrows(IndexOutOfBoundsException.class, () -> new MyArrayList<Phone>().set(100, phone));
	}

	/**
	 * Тестирует метод {@link MyArrayList#clear()} для очистки всех элементов в {@link MyArrayList}.
	 */
	@Test
	void testClear() {
		MyArrayList<Phone> list = new MyArrayList<>();
		Phone phone1 = new Phone("Google", 1000);
		Phone phone2 = new Phone("Nokia", 600);

		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add(phone1);
		list.add(phone2);

		list.clear();

		assertEquals(0, list.size(), "Размер списка должен быть 0 после очистки");
	}

	/**
	 * Тестирует метод {@link MyArrayList#clear()} для очистки всех строковых элементов в {@link MyArrayList}.
	 */
	@Test
	void testClearString() {
		MyArrayList<String> list = new MyArrayList<>();
		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add("First");
		list.add("Second");

		list.clear();

		assertEquals(0, list.size(), "Размер списка должен быть 0 после очистки");
	}

	/**
	 * Тестирует метод {@link MyArrayList#clear()} для очистки всех числовых элементов в {@link MyArrayList}.
	 */
	@Test
	void testClearInteger() {
		MyArrayList<Integer> list = new MyArrayList<>();
		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add(50);
		list.add(100);

		list.clear();

		assertEquals(0, list.size(), "Размер списка должен быть 0 после очистки");
	}

	/**
	 * Тестирует метод {@link MyArrayList#sort()} для сортировки всех элементов в {@link MyArrayList}.
	 */
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

		list.sort();

		assertEquals(3, list.size(), "Размер списка должен остаться 3 после сортировки");
		assertEquals(phone2, list.get(0), "Первый элемент должен быть Samsung (цена 600) после сортировки");
		assertEquals(phone1, list.get(1), "Второй элемент должен быть Huawei (цена 800)");
		assertEquals(phone3, list.get(2), "Третий элемент должен быть Apple (цена 1000)");
	}

	/**
	 * Тестирует метод {@link MyArrayList#sort()} для сортировки всех числовых элементов в {@link MyArrayList}.
	 */
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

	/**
	 * Тестирует метод {@link MyArrayList#sort(Comparator)} для сортировки всех элементов в {@link MyArrayList}.
	 */
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

		list.sort(Comparator.comparing(Phone::getPrice).reversed());

		assertEquals(3, list.size(), "Размер списка должен остаться 3 после сортировки по убыванию");
		assertEquals(phone2, list.get(0), "Первый элемент должен быть Oppo (цена 900)");
		assertEquals(phone1, list.get(1), "Второй элемент должен быть OnePlus (цена 700)");
		assertEquals(phone3, list.get(2), "Третий элемент должен быть Realme (цена 500)");
	}

	/**
	 * Тестирует метод {@link MyArrayList#sort(Comparator)} для сортировки всех строковых элементов в {@link MyArrayList}.
	 */
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