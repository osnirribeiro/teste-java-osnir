package br.com.osnir.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "players")
public class Players implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -534926100125650125L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@JsonProperty("name")
	private String name;
	
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "matches_id")
	 private Matches matches;	

	public Players() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Matches getMatches() {
		return matches;
	}

	public void setMatches(Matches matches) {
		this.matches = matches;
	}
}
