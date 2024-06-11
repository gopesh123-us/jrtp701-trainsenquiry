package live.learnjava.trainsenquiry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import live.learnjava.trainsenquiry.entity.Station;

public interface IStationRepository extends JpaRepository<Station, Integer>{

}
