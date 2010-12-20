package br.com.highligth.models;

@javax.persistence.Entity
public class Codeshare extends Entity {
	
	private String name;
	private String code;
	private String language;
	private String tags;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	public String getTags() {
		return tags;
	}
	
}
