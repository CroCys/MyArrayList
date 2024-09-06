package org.example;

/**
 * Класс, представляющий телефон с моделью и ценой. Реализует интерфейс {@link Comparable},
 * что позволяет сравнивать объекты по цене.
 */
public class Phone implements Comparable<Phone> {
	private String model;
	private int price;

	/**
	 * Конструктор без параметров.
	 */
	public Phone() {
	}

	/**
	 * Конструктор с параметрами.
	 *
	 * @param model модель телефона.
	 * @param price цена телефона.
	 */
	public Phone(String model, int price) {
		this.model = model;
		this.price = price;
	}

	/**
	 * Возвращает модель телефона.
	 *
	 * @return модель телефона.
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Устанавливает модель телефона.
	 *
	 * @param model модель телефона.
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Возвращает цену телефона.
	 *
	 * @return цена телефона.
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Устанавливает цену телефона.
	 *
	 * @param price цена телефона.
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Возвращает строковое представление объекта телефона.
	 *
	 * @return строковое представление телефона.
	 */
	@Override
	public String toString() {
		return "Phone{" +
				"model='" + model + '\'' +
				", price=" + price +
				'}';
	}

	/**
	 * Сравнивает текущий объект телефона с другим телефоном по цене.
	 *
	 * @param p объект {@link Phone} для сравнения.
	 * @return отрицательное число, если текущий телефон дешевле, ноль, если цены одинаковы,
	 *         положительное число, если текущий телефон дороже.
	 */
	@Override
	public int compareTo(Phone p) {
		return Integer.compare(this.price, p.price);
	}
}