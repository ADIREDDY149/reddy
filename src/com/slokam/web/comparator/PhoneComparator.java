package com.slokam.web.comparator;

import java.util.Comparator;

import com.slokam.web.test.pojo.studentpojo;

public class PhoneComparator implements Comparator<studentpojo> {

	@Override
	public int compare(studentpojo o1, studentpojo o2) {
		
		return o1.getPhone()-o2.getPhone();
	}

}
