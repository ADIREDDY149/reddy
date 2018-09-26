package com.slokam.web.comparator;

import java.util.Comparator;

import com.slokam.web.test.pojo.studentpojo;

public class StudentNameComparator implements Comparator<studentpojo> {

	public int compare(studentpojo s1, studentpojo s2) {
		
		return s1.getName().compareTo(s2.getName());
	}

}
