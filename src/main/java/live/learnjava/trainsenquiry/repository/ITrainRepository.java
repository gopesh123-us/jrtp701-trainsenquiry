package live.learnjava.trainsenquiry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import live.learnjava.trainsenquiry.entity.Train;

public interface ITrainRepository extends JpaRepository<Train, Integer> {

}
