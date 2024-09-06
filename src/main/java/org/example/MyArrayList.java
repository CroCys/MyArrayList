package org.example;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Класс реализует собственный динамический массив, похожий на ArrayList.
 *
 * @param <E> тип элементов, которые должны реализовывать интерфейс {@link Comparable}.
 */
public class MyArrayList<E extends Comparable<E>> {
	private Object[] elementData;
	private static final int DEFAULT_CAPACITY = 10;
	private int size = 0;

	/**
	 * Конструктор без параметров. Создает массив с начальной емкостью по умолчанию.
	 */
	public MyArrayList() {
		this.elementData = new Object[DEFAULT_CAPACITY];
	}

	/**
	 * Конструктор с заданным размером.
	 *
	 * @param size начальная емкость массива.
	 * @throws IllegalArgumentException если размер отрицательный.
	 */
	public MyArrayList(int size) {
		if (size > 0) {
			elementData = new Object[size];
		} else if (size == 0) {
			elementData = new Object[0];
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Увеличивает вместимость массива, если это необходимо.
	 */
	private void expandCapacity() {
		if (size == elementData.length)
			elementData = Arrays.copyOf(elementData, size * 2);
	}

	/**
	 * Уменьшает вместимость массива, если это необходимо.
	 */
	private void narrowCapacity() {
		if (size > elementData.length) {
			elementData = Arrays.copyOf(elementData, size / 2);
		}
	}

	/**
	 * Добавляет элемент в конец списка.
	 *
	 * @param e элемент для добавления.
	 */
	public void add(E e) {
		expandCapacity();
		elementData[size++] = e;
	}

	/**
	 * Добавляет элемент на указанный индекс.
	 *
	 * @param index индекс, на который будет добавлен элемент.
	 * @param e     элемент для добавления.
	 * @throws IndexOutOfBoundsException если индекс вне допустимого диапазона.
	 */
	public void add(int index, E e) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}

		expandCapacity();

		if (size - index > 0) {
			System.arraycopy(elementData, index, elementData, index + 1, size - index);
		}

		elementData[index] = e;
		size++;
	}

	/**
	 * Возвращает элемент по индексу.
	 *
	 * @param index индекс элемента для возврата.
	 * @return элемент, находящийся на указанном индексе.
	 * @throws IndexOutOfBoundsException если индекс вне допустимого диапазона.
	 */
	public E get(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		return (E) elementData[index];
	}

	/**
	 * Удаляет элемент по указанному индексу.
	 *
	 * @param index индекс элемента для удаления.
	 * @throws IndexOutOfBoundsException если индекс вне допустимого диапазона.
	 */
	public void remove(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}

		int numMoved = size - index - 1;
		if (numMoved > 0) {
			System.arraycopy(elementData, index + 1, elementData, index, numMoved);
		}
		elementData[--size] = null;
		narrowCapacity();
	}

	/**
	 * Очищает список, удаляя все элементы.
	 */
	public void clear() {
		for (int i = 0; i < size; i++) {
			elementData[i] = null;
		}
		size = 0;
	}

	/**
	 * Сортирует список с использованием алгоритма быстрой сортировки.
	 */
	public void sort() {
		quickSort(0, size - 1);
	}

	/**
	 * Рекурсивная функция быстрой сортировки.
	 *
	 * @param low  начальный индекс.
	 * @param high конечный индекс.
	 */
	private void quickSort(int low, int high) {
		if (low < high) {
			int pivotIndex = partition(low, high);
			quickSort(low, pivotIndex - 1);
			quickSort(pivotIndex + 1, high);
		}
	}

	/**
	 * Разбиение для быстрой сортировки.
	 *
	 * @param low  начальный индекс.
	 * @param high конечный индекс.
	 * @return индекс разделяющего элемента.
	 */
	private int partition(int low, int high) {
		E pivot = get(high);
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (get(j).compareTo(pivot) <= 0) {
				i++;
				swap(i, j);
			}
		}

		swap(i + 1, high);
		return i + 1;
	}

	/**
	 * Меняет местами два элемента в списке.
	 *
	 * @param i индекс первого элемента.
	 * @param j индекс второго элемента.
	 */
	private void swap(int i, int j) {
		E temp = get(i);
		set(i, get(j));
		set(j, temp);
	}

	/**
	 * Сортирует список с использованием заданного компаратора.
	 *
	 * @param comparator компаратор для сортировки.
	 */
	public void sort(Comparator<E> comparator) {
		quickSort(comparator, 0, size - 1);
	}

	/**
	 * Рекурсивная функция быстрой сортировки с компаратором.
	 *
	 * @param comparator компаратор для сортировки.
	 * @param low        начальный индекс.
	 * @param high       конечный индекс.
	 */
	private void quickSort(Comparator<E> comparator, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(comparator, low, high);
			quickSort(comparator, low, pivotIndex - 1);
			quickSort(comparator, pivotIndex + 1, high);
		}
	}

	/**
	 * Разбиение для быстрой сортировки с компаратором.
	 *
	 * @param comparator компаратор для сортировки.
	 * @param low        начальный индекс.
	 * @param high       конечный индекс.
	 * @return индекс разделяющего элемента.
	 */
	private int partition(Comparator<E> comparator, int low, int high) {
		E pivot = get(high);
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (comparator.compare(get(j), pivot) <= 0) {
				i++;
				swap(i, j);
			}
		}

		swap(i + 1, high);
		return i + 1;
	}

	/**
	 * Заменяет элемент на указанном индексе.
	 *
	 * @param index индекс заменяемого элемента.
	 * @param e     новый элемент.
	 * @return старый элемент, который был заменен.
	 * @throws IndexOutOfBoundsException если индекс вне допустимого диапазона.
	 */
	public E set(int index, E e) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}

		E oldValue = (E) elementData[index];
		elementData[index] = e;
		return oldValue;
	}

	/**
	 * Возвращает текущий размер списка.
	 *
	 * @return количество элементов в списке.
	 */
	public int size() {
		return size;
	}
}