package com.jafa.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAA {

	@Before
	public void setup() {
		System.out.println("====================");
	}

	@After
	public void tead() {
		System.out.println("************************");
	}

	@Test
	public void test1() {
		System.out.println("테스트1");

	}

	@Test
	public void test2() {
		System.out.println("테스트2");

	}

	@Test
	public void test3() {
		System.out.println("테스트3");

	}
}
