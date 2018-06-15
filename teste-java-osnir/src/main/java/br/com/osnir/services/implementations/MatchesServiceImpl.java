package br.com.osnir.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.osnir.models.Matches;
import br.com.osnir.repository.MatchesRepository;
import br.com.osnir.services.MatchesService;

@Service
public class MatchesServiceImpl implements MatchesService	 {

	@Autowired
	private MatchesRepository mr;

	@Override
	public Matches create(Matches matches) {
		return mr.save(matches);
	}

	@Override
	public List<Matches> findAll() {
		List<Matches> listaWrangle = mr.findAll();
		return listaWrangle;
	}

}
