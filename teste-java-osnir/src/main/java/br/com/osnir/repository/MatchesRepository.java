package br.com.osnir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.osnir.models.Matches;



public interface MatchesRepository extends JpaRepository<Matches, Long> {

}
