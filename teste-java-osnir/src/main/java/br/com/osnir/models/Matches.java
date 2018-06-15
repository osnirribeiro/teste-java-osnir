package br.com.osnir.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "matches")
public class Matches implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5532747113326054583L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "matches", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Wrangle> wrangle;
    
    @JsonIgnoreProperties(ignoreUnknown = true)
	@Column(name="jogo")
    private String match;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date begin;
  
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date  end;	
    
    @OneToMany(mappedBy="matches" ,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Players> players;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}


	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public List<Players> getPlayers() {
		return players;
	}

	public void setPlayers(List<Players> players) {
		this.players = players;
	}

	public String getMatch() {
		return match;
	}

	public void setMatch(String match) {
		this.match = match;
	}

	public Set<Wrangle> getWrangle() {
		return wrangle;
	}

	public void setWrangle(Set<Wrangle> wrangle) {
		this.wrangle = wrangle;
	}




}
