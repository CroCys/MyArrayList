package org.example;

public class Main {
	public static void main(String[] args) {
//		Phone phone = new Phone("iPhone 10", 500);
//		Phone phone1 = new Phone("Samsung S10", 450);
//		Phone phone2 = new Phone("iPhone 8", 450);
//		Phone phone3 = new Phone("Samsung S9", 400);
//		Phone phone4 = new Phone("iPhone 7", 400);
//		Phone phone5 = new Phone("Samsung S8", 350);

		Phone phone = new Phone("A", 500);
		Phone phone1 = new Phone("C", 450);
		Phone phone2 = new Phone("B", 450);
		Phone phone3 = new Phone("E", 400);
		Phone phone4 = new Phone("F", 400);
		Phone phone5 = new Phone("D", 350);

		MyArrayList<Phone> phoneMyArrayList = new MyArrayList<>();
		PhoneComparator comparator = new PhoneComparator();

		phoneMyArrayList.add(phone);
		phoneMyArrayList.add(phone1);
		phoneMyArrayList.add(phone2);
		phoneMyArrayList.add(phone3);
		phoneMyArrayList.add(phone4);
		phoneMyArrayList.add(phone5);

		for (int i = 0; i < phoneMyArrayList.size(); i++) {
			System.out.println(phoneMyArrayList.get(i));
		}

		System.out.println("Размер: " + phoneMyArrayList.size());

		System.out.println();
		phoneMyArrayList.sort();

		for (int i = 0; i < phoneMyArrayList.size(); i++) {
			System.out.println(phoneMyArrayList.get(i));
		}

		System.out.println();
		phoneMyArrayList.sort(comparator);

		for (int i = 0; i < phoneMyArrayList.size(); i++) {
			System.out.println(phoneMyArrayList.get(i));
		}
	}
}