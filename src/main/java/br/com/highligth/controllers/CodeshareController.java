package br.com.highligth.controllers;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.highligth.models.Codeshare;
import br.com.highligth.repositories.CodeshareRepository;

@Resource
public class CodeshareController {

	private final Result result;
	private final CodeshareRepository repository;
	private final Validator validator;
	
	public CodeshareController(Result result, CodeshareRepository repository, Validator validator) {
		this.result = result;
		this.repository = repository;
		this.validator = validator;
	}
	
	@Get
	@Path("/codeshares")
	public List<Codeshare> index() {
		return repository.findAll();
	}
	
	@Post
	@Path("/codeshares/find")
	@SuppressWarnings("unchecked")
	public List<Codeshare> find(Codeshare codeshare) {
		
		Criteria crit = repository.session().createCriteria(Codeshare.class);
		
		String name = codeshare.getName();
		if (StringUtils.hasLength(name)) {
			crit.add(Restrictions.eq("name", name));
		}
		
		String language = codeshare.getLanguage();
		if (StringUtils.hasLength(language)) {
			crit.add(Restrictions.eq("language", language));
		}
		
		String tags = codeshare.getTags();
		if (StringUtils.hasLength(tags)) {
			crit.add(Restrictions.eq("tags", tags));
		}
		
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		crit.addOrder(Order.asc("name"));
		
		List<Codeshare> list = crit.list();
		
		return list;
	}
	
	@Post
	@Path("/codeshares")
	public void create(Codeshare codeshare) {
		validator.validate(codeshare);
		validator.onErrorUsePageOf(this).newCodeshare();
		repository.create(codeshare);
		result.redirectTo(this).index();
	}
	
	@Get
	@Path("/codeshares/new")
	public Codeshare newCodeshare() {
		return new Codeshare();
	}
	
	@Put
	@Path("/codeshares")
	public void update(Codeshare codeshare) {
		validator.validate(codeshare);
		validator.onErrorUsePageOf(this).edit(codeshare);
		repository.update(codeshare);
		result.redirectTo(this).index();
	}
	
	@Get
	@Path("/codeshares/{codeshare.id}/edit")
	public Codeshare edit(Codeshare codeshare) {
		return repository.find(codeshare.getId());
	}

	@Get
	@Path("/codeshares/{codeshare.id}")
	public Codeshare show(Codeshare codeshare) {
		return repository.find(codeshare.getId());
	}

	@Delete
	@Path("/codeshares/{codeshare.id}")
	public void destroy(Codeshare codeshare) {
		repository.destroy(repository.find(codeshare.getId()));
		result.redirectTo(this).index();  
	}
	
}
