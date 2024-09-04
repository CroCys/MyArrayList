package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E extends Comparable<E>> {
	private Object[] elementData;
	private static final int DEFAULT_CAPACITY = 10;
	private int size = 0;

	public MyArrayList() {
		this.elementData = new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int size) {
		if (size > 0) {
			elementData = new Object[size];
		} else if (size == 0) {
			elementData = new Object[0];
		} else {
			throw new IllegalArgumentException();
		}
	}

	// Увеличить вместимость
	private void expandCapacity() {
		if (size == elementData.length)
			elementData = Arrays.copyOf(elementData, size * 2);
	}

	// Уменьшить вместимость
	private void narrowCapacity() {
		if (size > elementData.length) {
			elementData = Arrays.copyOf(elementData, size / 2);
		}
	}

	// Добавить элемент
	public void add(E e) {
		expandCapacity();
		elementData[size++] = e;
	}

	// Добавить элемент по индексу
	public void add(int index, E e) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		expandCapacity();

		if (size - index > 0) {
			System.arraycopy(elementData, index, elementData, index + 1, size - index);
		}

		elementData[index] = e;
		size++;
	}

	// Получить элемент
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		return (E) elementData[index];
	}

	// Удалить элемент
	public void remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		int numMoved = size - index - 1;
		if (numMoved > 0) {
			System.arraycopy(elementData, index + 1, elementData, index, numMoved);
		}
		elementData[--size] = null;
		narrowCapacity();
	}

	// Очистить всю коллекцию
	public void clear() {
		for (int i = 0; i < size; i++) {
			elementData[i] = null;
		}
		size = 0;
	}

	// Отсортировать
	public void sort() {
		quickSort(0, size - 1);
	}

	private void quickSort(int low, int high) {
		if (low < high) {
			int pivotIndex = partition(low, high);
			quickSort(low, pivotIndex - 1);
			quickSort(pivotIndex + 1, high);
		}
	}

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

	private void swap(int i, int j) {
		E temp = get(i);
		set(i, get(j));
		set(j, temp);
	}

	// Отсортировать через компаратор
	public void sort(Comparator<E> comparator) {
		quickSort(comparator, 0, size - 1);
	}

	private void quickSort(Comparator<E> comparator, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(comparator, low, high);
			quickSort(comparator, low, pivotIndex - 1);
			quickSort(comparator, pivotIndex + 1, high);
		}
	}

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

	// Заменить элемент по индексу
	public E set(int index, E e) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		E oldValue = (E) elementData[index];
		elementData[index] = e;
		return oldValue;
	}

	public int size() {
		return size;
	}
}