package br.com.highligth.controllers;

import java.util.List;

import br.com.highligth.models.Codeshare;
import br.com.highligth.repositories.CodeshareRepository;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

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
