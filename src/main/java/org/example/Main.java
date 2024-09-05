package org.example;

public class Main {
	public static void main(String[] args) {
		MyArrayList<Phone> phoneList = new MyArrayList<>();
		MyArrayList<String> stringList = new MyArrayList<>();
		MyArrayList<Integer> integerList = new MyArrayList<>();
		Phone phone1 = new Phone("iPhone", 1000);

		for (int i = 0; i < 1000; i++) {
			phoneList.add(phone1);
			System.out.println("Add " + i);
		}

		for (int i = 0; i < 1000; i++) {
			stringList.add("one");
		}

		for (int i = 0; i < 1000; i++) {
			integerList.add(1);
		}

		System.out.println(phoneList.size());
		System.out.println(stringList.size());
		System.out.println(integerList.size());

		for (int i = 0; i < 1000; i++) {
			phoneList.remove(i);
			System.out.println("Delete " + i);
		}

		for (int i = 0; i < 1000; i++) {
			stringList.remove(i);
		}

		for (int i = 0; i < 1000; i++) {
			integerList.remove(i);
		}

		System.out.println(phoneList.size());
		System.out.println(stringList.size());
		System.out.println(integerList.size());
	}
}