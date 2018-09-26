package com.slokam.web.comparator;

import java.util.Comparator;

import com.slokam.web.test.pojo.studentpojo;

public class AgeComparator implements Comparator<studentpojo> {

	@Override
	public int compare(studentpojo s1, studentpojo s2) {
		// TODO Auto-generated method stub
		return s1.getAge()-s2.getAge();
	}

}
