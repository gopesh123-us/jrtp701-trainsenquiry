package live.learnjava.trainsenquiry.service;

import java.util.List;

import org.springframework.stereotype.Service;

import live.learnjava.trainsenquiry.entity.Station;
import live.learnjava.trainsenquiry.entity.Train;

@Service
public interface ITrainManagementService {
	
	public String addTrain();
	public String updateTrain(Train train);
	public String deleteTrain(Integer trainId);
	public List<Train> showAllTrains();
	public Train findTrainById(Integer trainId);
	public String deactivateTrainRoute(Integer trainId, String status);
	public List<Station> showAllStations();
	
}
