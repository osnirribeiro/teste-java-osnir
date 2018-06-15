package br.com.osnir.services.implementations;

import java.sql.Time;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.osnir.models.Matches;
import br.com.osnir.models.Wrangle;
import br.com.osnir.repository.WrangleRepository;
import br.com.osnir.services.WrangleService;

@Service
public class WrangleServiceImpl implements WrangleService{

	@Autowired
	private WrangleRepository wr;

	@Override
	public Wrangle create(Wrangle wrangle) {
		
		return wr.save(wrangle);
	}

	@Override
	public List<Wrangle> findAll() {
		return wr.findAll();
	}

	@Override
	public List<Wrangle> rankingAllGuns() {
		return wr.findAll();
	}

	@Override
	public List<Wrangle> rankingPlayers() {
		//return wr.rankingPlayers();
		return null;
	}

	@Override
	public List<Wrangle> rankingGunsByRangeOfTime(Time killtimeStarted, Time killtimeEnd) {
		// TODO Auto-generated method stub
		return wr.findByKilltimeBetween(killtimeStarted, killtimeEnd);
	}

	@Override
	public List<Wrangle> rankingPlayersKiller() {
		return wr.rankingPlayersKiller();
	}

	@Override
	public List<Wrangle> rankingPlayersKilled() {
		return wr.rankingPlayersKilled();
	}	


}
