package org.example.repository;

@Logged
public class TestImpl implements Test {

	public TestImpl() {}

	public void method1() {
		System.out.println("Testtest called");
	}
}
