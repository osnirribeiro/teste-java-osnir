package br.com.osnir.models;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "wrangle")
public class Wrangle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5139458147624717566L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "matches_id")
	private Matches matches;	

	private String killer;

	private String killed;

	private String weapon;

	@JsonFormat(pattern = "HH:mm:ss")
	private Time killtime;

	@Column(name="jogo")
	private String match;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKiller() {
		return killer;
	}

	public void setKiller(String killer) {
		this.killer = killer;
	}

	public String getKilled() {
		return killed;
	}

	public void setKilled(String killed) {
		this.killed = killed;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public Time getKilltime() {
		return killtime;
	}

	public void setKilltime(Time killtime) {
		this.killtime = killtime;
	}

	public String getMatch() {
		return match;
	}

	public void setMatch(String match) {
		this.match = match;
	}


	public Matches getMatches() {
		return matches;
	}

	public void setMatches(Matches matches) {
		this.matches = matches;
	}

	@Override
	public String toString() {
		return "Wrangle [id=" + id + ", matches=" + matches + ", killer=" + killer + ", killed=" + killed + ", weapon="
				+ weapon + ", killtime=" + killtime + ", match=" + match + "]";
	}


}
