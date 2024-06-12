package live.learnjava.trainsenquiry.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import live.learnjava.trainsenquiry.entity.Train;

@Service
public interface ITrainManagementService {

	// save
	public String addTrain(Train train);

	// update train information
	public String updateTrain(Train train);

	// delete train - hard deletion
	public String deleteTrain(Integer trainId);

	// show all trains
	public List<Train> showAllTrains();

	// find one train for edit operation
	public Train findTrainById(Integer trainId);

	// soft deletion
	public String changeTrainRouteStatus(Integer trainId, String status);

	// show all train station names and ids
	public Map<Integer, String> showAllStationNames();

	// show all station codes;
	public Map<Integer, String> showAllStationCodes();

	//show all station name with codes
	public Map<String, String> showAllStationNamesAndCodes();

}
