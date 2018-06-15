package br.com.osnir.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.osnir.models.Matches;
import br.com.osnir.services.MatchesService;

@RestController
@RequestMapping("/matches/")
public class MatchesControler {

	@Autowired
	private MatchesService matchesService;
	
	@GetMapping(produces ="application/json")
	public @ResponseBody Iterable<Matches> listaMatches(){
		Iterable<Matches> listaWrangle = matchesService.findAll();
		return listaWrangle;
	}
	
	@PostMapping()
	public Matches cadastraMatches(@RequestBody @Valid Matches wrangle){
		return matchesService.create(wrangle);
	}
	
	
}
