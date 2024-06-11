package live.learnjava.trainsenquiry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import live.learnjava.trainsenquiry.entity.Station;
import live.learnjava.trainsenquiry.entity.Train;
import live.learnjava.trainsenquiry.repository.IStationRepository;
import live.learnjava.trainsenquiry.repository.ITrainRepository;

@Service
public class TrainManagementServiceImpl implements ITrainManagementService {

	@Autowired
	private IStationRepository stationRepository;
	
	@Autowired
	private ITrainRepository trainRepository;
	
	@Override
	public String addTrain() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateTrain(Train train) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteTrain(Integer trainId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Train> showAllTrains() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Train findTrainById(Integer trainId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deactivateTrainRoute(Integer trainId, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Station> showAllStations() {
		// TODO Auto-generated method stub
		return null;
	}

}
