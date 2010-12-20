package br.com.highligth.repositories;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.ioc.Component;
import br.com.highligth.models.Codeshare;

@Component
public class CodeshareRepositoryImpl extends Repository<Codeshare, Long> implements CodeshareRepository {

	public CodeshareRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}
}
