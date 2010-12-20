package br.com.highligth.controllers;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CodeshareControllerTest {

	@Test public void fakeTest() {
		assertNotNull("put something real.", new CodeshareController(null, null, null));
 	}
}
