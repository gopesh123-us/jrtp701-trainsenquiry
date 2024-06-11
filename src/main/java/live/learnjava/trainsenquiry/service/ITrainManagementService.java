package live.learnjava.trainsenquiry.service;

import java.util.List;

import org.springframework.stereotype.Service;

import live.learnjava.trainsenquiry.entity.Station;
import live.learnjava.trainsenquiry.entity.Train;

@Service
public interface ITrainManagementService {
	
	//save
	public String addTrain();
	
	//update train information
	public String updateTrain(Train train);
	
	//delete train - hard deletion
	public String deleteTrain(Integer trainId);
	
	//show all trains
	public List<Train> showAllTrains();
	
	//find one train for edit operation
	public Train findTrainById(Integer trainId);
	
	//soft deletion
	public String deactivateTrainRoute(Integer trainId, String status);
	
	//show all train stations
	public List<Station> showAllStations();
	
}
