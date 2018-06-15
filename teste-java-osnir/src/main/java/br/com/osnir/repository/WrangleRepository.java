package br.com.osnir.repository;

import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import br.com.osnir.models.Wrangle;


public interface WrangleRepository extends JpaRepository<Wrangle, Long> {

	  @Query("select w.weapon , count(weapon) from Wrangle w group by w.weapon order by count(weapon) desc")
	  List<Wrangle> findAll();
	  
//	  @Query(" select w.killer , w.killerCount , wa.killedCount , (w.killerCount - wa.killedCount) as point from " +
//      "( select killer , count(killer) as killerCount from wrangle group by killer) as w join " +
//      "( select killed , count(killed) as killedCount from wrangle w group by killed) as wa on w.killer = wa.killed " )
//	  List<Wrangle> rankingPlayers();

	  @Query("select killer , count(killer) from Wrangle group by killer order by count(killer) desc")
	  List<Wrangle> rankingPlayersKiller();
	 
	  @Query("select killed , count(killed) from Wrangle group by killed order by count(killed) desc")
	  List<Wrangle> rankingPlayersKilled();
	  
	  List<Wrangle> findByKilltimeBetween(Time inicio, Time fim);
}
