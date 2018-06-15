package br.com.osnir.services;

import java.sql.Time;
import java.util.List;
import java.util.Map;

import br.com.osnir.models.Wrangle;

public interface WrangleService {

	    Wrangle create(final Wrangle wrangle);
	
	    List<Wrangle> findAll();
	    List<Wrangle> rankingAllGuns();
	    List<Wrangle> rankingPlayers();
	    List<Wrangle> rankingPlayersKiller();
	    List<Wrangle> rankingPlayersKilled();
	    List<Wrangle> rankingGunsByRangeOfTime(Time killtimeStarted , Time killtimeEnd );
	    
	    
	
}
