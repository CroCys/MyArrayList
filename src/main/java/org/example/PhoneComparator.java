package org.example;

import java.util.Comparator;

public class PhoneComparator implements Comparator<Phone> {

	@Override
	public int compare(Phone p1, Phone p2) {
		return p1.getModel().compareTo(p2.getModel());
	}
}