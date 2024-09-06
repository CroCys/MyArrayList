package org.example;

import java.util.Comparator;

/**
 * Класс, представляющий компаратор для телефона. Реализует интерфейс {@link Comparable},
 * что позволяет сравнивать объекты по названию.
 */
public class PhoneComparator implements Comparator<Phone> {

	/**
	 * Сравнивает первый объект телефона со вторым объектом телефона по названию.
	 *
	 * @param p1 первый объект {@link Phone} для сравнения.
	 * @param p2 второй объект {@link Phone} для сравнения.
	 * @return отрицательное число, если модель первого телефона лексикографически меньше,
	 * ноль, если модели равны, или положительное число, если модель первого
	 * телефона больше.
	 */
	@Override
	public int compare(Phone p1, Phone p2) {
		return p1.getModel().compareTo(p2.getModel());
	}
}