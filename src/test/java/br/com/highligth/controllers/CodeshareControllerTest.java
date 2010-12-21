package br.com.highligth.controllers;

import static org.springframework.util.Assert.notEmpty;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.util.test.MockValidator;
import br.com.highligth.models.Codeshare;
import br.com.highligth.repositories.CodeshareRepositoryImpl;

/**
 * Testa a classe {@link CodeshareController}
 * @author enok
 *
 */
public class CodeshareControllerTest {
	
	private static CodeshareController controller;
	private static Codeshare codeshare;
	
	@Autowired
	private EntityManager entityManager;
	
	@Before
	public void createTest() {
		
		if (controller == null) {
			
			controller = new CodeshareController(new MockResult(), new CodeshareRepositoryImpl(entityManager), new MockValidator());
			
			if (codeshare == null) {
				
				codeshare = controller.newCodeshare();
				
				codeshare.setName("Um nome de codigo");
				codeshare.setCode("public static void main(String[] args) {}");
				codeshare.setLanguage("java");
				codeshare.setTags("java, hibernate");
			}
		}
		
	}
	
	@Test
	public void indexTest() {
		List<Codeshare> list = controller.index();
		notEmpty(list);
	}
}
