package br.com.osnir.web.controllers;

import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.osnir.models.Wrangle;
import br.com.osnir.services.WrangleService;

@RestController
@RequestMapping("/wrangle/")
public class WrangleControler {

	@Autowired
	private WrangleService wrangleService;

	// 2.0 Ranking de jogadores com numero de kills realizados, mortes sofridas e pontuacao.
	@GetMapping(value = "rankingPlayersKiller" , produces ="application/json")
	public @ResponseBody Iterable<Wrangle> rankingPlayersKiller(){
		return wrangleService.rankingPlayersKiller();
	}
	
	// 2.1 Ranking de jogadores com  mortes sofridas 
		@GetMapping(value = "rankingPlayersKilled" , produces ="application/json")
		public @ResponseBody Iterable<Wrangle> rankingPlayersKilled(){
			return wrangleService.rankingPlayersKilled();
		}
	
	// 3 .Registar o Kill 
	@PostMapping(value="registerKill")
	public Wrangle registerKill(@RequestBody Wrangle wrangle){
		return wrangleService.create(wrangle);
	}
	
	// 4.0 Ranking de Armas todos os tempo
	
		@GetMapping( value="rankingAllGuns" , produces ="application/json")
		public @ResponseBody Iterable<Wrangle> rankingAllGuns(){
			Iterable<Wrangle> listaWrangle = wrangleService.rankingAllGuns();
			return listaWrangle;
		}
	
	// 4.1 Ranking de Armas por um período de tempo
	@GetMapping( value="rankingGunsByRangeOfTime" , produces ="application/json")
	public @ResponseBody Iterable<Wrangle> rankingGunsByRangeOfTime(@RequestParam("killtime") Time killtimeStarted ,@RequestParam("killtime") Time killtimeEnd){
		Iterable<Wrangle> listaWrangle = wrangleService.rankingGunsByRangeOfTime(killtimeStarted , killtimeEnd);
		return listaWrangle;
	}
	
	
	
}
