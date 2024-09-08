import org.example.MyArrayList;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import javax.print.DocFlavor.STRING;

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
		MyArrayList<String> stringList = new MyArrayList<>();
		MyArrayList<String> stringList1 = new MyArrayList<>(5);
		MyArrayList<String> stringList2 = new MyArrayList<>(0);
		MyArrayList<Integer> integerList = new MyArrayList<>();
		MyArrayList<Integer> integerList1 = new MyArrayList<>(5);
		MyArrayList<Integer> integerList2 = new MyArrayList<>(0);

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
	 * Тестирует метод {@link MyArrayList#add(Object)} для добавления строковых
	 * элементов в {@link MyArrayList}.
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
	 * Тестирует метод {@link MyArrayList#add(Object)} для добавления числовых
	 * элементов в {@link MyArrayList}.
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
	 * Тестирует метод {@link MyArrayList#add(Object)} для добавления 1000 элементов
	 * в {@link MyArrayList}.
	 */
	@Test
	void testAdd1000() {
		MyArrayList<String> stringList = new MyArrayList<>();
		MyArrayList<Integer> integerList = new MyArrayList<>();

		assertEquals(0, stringList.size(), "Размер списка должен быть 0");
		assertEquals(0, integerList.size(), "Размер списка должен быть 0");

		for (int i = 0; i < 1000; i++) {
			stringList.add("one");
		}

		for (int i = 0; i < 1000; i++) {
			integerList.add(1);
		}

		assertEquals(1000, stringList.size(), "Размер списка должен быть 1000 после добавления 1000 элементов");
		assertEquals(1000, integerList.size(), "Размер списка должен быть 1000 после добавления 1000 элементов");
	}

	/**
	 * Тестирует исключение для метода {@link MyArrayList#add(Object)} класса
	 * {@link MyArrayList}.
	 */
	@Test
	void testAddException() {
		assertThrows(IndexOutOfBoundsException.class, () -> new MyArrayList<String>().add(-1, "Tom"));
		assertThrows(IndexOutOfBoundsException.class, () -> new MyArrayList<String>().add(100, "Tom"));
	}

	/**
	 * Тестирует метод {@link MyArrayList#add(int, Object)} для добавления строковых
	 * элементов в {@link MyArrayList} по индексу.
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
	 * Тестирует метод {@link MyArrayList#add(int, Object)} для добавления числовых
	 * элементов в {@link MyArrayList} по индексу.
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
	 * Тестирует метод {@link MyArrayList#get(int)} для получения строковых
	 * элементов в {@link MyArrayList} по индексу.
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
	 * Тестирует метод {@link MyArrayList#get(int)} для получения числовых элементов
	 * в {@link MyArrayList} по индексу.
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
	 * Тестирует исключение для метода {@link MyArrayList#get(int)} класса
	 * {@link MyArrayList}.
	 */
	@Test
	void testGetException() {
		assertThrows(IndexOutOfBoundsException.class, () -> new MyArrayList<String>().get(-1));
		assertThrows(IndexOutOfBoundsException.class, () -> new MyArrayList<String>().get(100));
	}

	/**
	 * Тестирует метод {@link MyArrayList#remove(int)} для удаления строковых
	 * элементов в {@link MyArrayList} по индексу.
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
	 * Тестирует метод {@link MyArrayList#remove(int)} для удаления числовых
	 * элементов в {@link MyArrayList} по индексу.
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
	 * Тестирует метод {@link MyArrayList#remove(int)} для удаления 1000 элементов в
	 * {@link MyArrayList} по индексу.
	 */
	@Test
	void testRemove1000() {
		MyArrayList<String> stringList = new MyArrayList<>();
		MyArrayList<Integer> integerList = new MyArrayList<>();

		assertEquals(0, stringList.size(), "Размер списка должен быть 0");
		assertEquals(0, integerList.size(), "Размер списка должен быть 0");

		for (int i = 0; i < 1000; i++) {
			stringList.add("one");
		}

		for (int i = 0; i < 1000; i++) {
			integerList.add(1);
		}

		assertEquals(1000, stringList.size(), "Размер списка должен быть 1000 после добавления 1000 элементов");
		assertEquals(1000, integerList.size(), "Размер списка должен быть 1000 после добавления 1000 элементов");

		for (int i = 0; i < 1000; i++) {
			stringList.remove(i);
		}

		for (int i = 0; i < 1000; i++) {
			integerList.remove(i);
		}

		assertEquals(0, stringList.size(), "Размер списка должен быть 0 после удаления 1000 элементов");
		assertEquals(0, integerList.size(), "Размер списка должен быть 0 после удаления 1000 элементов");
	}

	/**
	 * Тестирует исключение для метода {@link MyArrayList#remove(int)} класса
	 * {@link MyArrayList}.
	 */
	@Test
	void testRemoveException() {
		assertThrows(IndexOutOfBoundsException.class, () -> new MyArrayList<String>().remove(-1));
	}

	/**
	 * Тестирует метод {@link MyArrayList#set(int, Object)} для замены строковых
	 * элементов в {@link MyArrayList} по индексу.
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
	 * Тестирует метод {@link MyArrayList#set(int, Object)} для замены числовых
	 * элементов в {@link MyArrayList} по индексу.
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
	 * Тестирует исключение для метода {@link MyArrayList#set(int, Object)} класса
	 * {@link MyArrayList}.
	 */
	@Test
	void testSetException() {
		assertThrows(IndexOutOfBoundsException.class, () -> new MyArrayList<String>().set(-1, "Tom"));
		assertThrows(IndexOutOfBoundsException.class, () -> new MyArrayList<String>().set(100, "Tom"));
	}

	/**
	 * Тестирует метод {@link MyArrayList#clear()} для очистки всех строковых
	 * элементов в {@link MyArrayList}.
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
	 * Тестирует метод {@link MyArrayList#clear()} для очистки всех числовых
	 * элементов в {@link MyArrayList}.
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
	 * Тестирует метод {@link MyArrayList#sort(Comparator)} для сортировки всех
	 * элементов
	 * в {@link MyArrayList} по возрастанию и по убыванию.
	 */
	@Test
	void testSort() {
		MyArrayList<Integer> list = new MyArrayList<>();
		int a = 50;
		int b = 100;
		int c = 150;

		assertEquals(0, list.size(), "Размер списка должен быть 0");

		list.add(c);
		list.add(a);
		list.add(b);

		list.sort(Comparator.naturalOrder());

		assertEquals(3, list.size(), "Размер списка должен остаться 3 после сортировки по возрастанию");
		assertEquals(a, list.get(0), "Первый элемент должен быть a после сортировки");
		assertEquals(b, list.get(1), "Второй элемент должен быть b");
		assertEquals(c, list.get(2), "Третий элемент должен быть c");

		list.sort(Comparator.reverseOrder());

		assertEquals(3, list.size(), "Размер списка должен остаться 3 после сортировки по убыванию");
		assertEquals(c, list.get(0), "Первый элемент должен быть c");
		assertEquals(b, list.get(1), "Второй элемент должен быть b");
		assertEquals(a, list.get(2), "Третий элемент должен быть a");
	}

	/**
	 * Тестирует метод {@link MyArrayList#sort(Comparator)} для сортировки всех
	 * строковых элементов в {@link MyArrayList}.
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