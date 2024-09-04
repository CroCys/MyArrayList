package org.example;

public class Phone implements Comparable<Phone> {
	private String model;
	private int price;

	public Phone(String model, int price) {
		this.model = model;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Phone{" +
				"model='" + model + '\'' +
				", price=" + price +
				'}';
	}

	@Override
	public int compareTo(Phone p) {
		return Integer.compare(this.price, p.price);
	}
}