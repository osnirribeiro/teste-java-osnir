package br.com.osnir.services;

import java.util.List;

import br.com.osnir.models.Matches;

public interface MatchesService {

	    Matches create(final Matches matches);
	    List<Matches> findAll();

	    
}
