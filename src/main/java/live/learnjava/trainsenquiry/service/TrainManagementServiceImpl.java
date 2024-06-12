package live.learnjava.trainsenquiry.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
	public String addTrain(Train train) {
		Train savedTrain = trainRepository.save(train);
		return (savedTrain.getTrain_id() != null) ? "Train saved with Id:: " + savedTrain.getTrain_id()
				: "Problem in saving train";

	}

	@Override
	public String updateTrain(Train train) {
		Optional<Train> opt = trainRepository.findById(train.getTrain_id());
		if (opt.isPresent()) {
			trainRepository.save(train);
			return "Train with id:: " + train.getTrain_id() + " updated.";
		} else {
			return "Train with id:: " + train.getTrain_id() + "not found";
		}

	}

	@Override
	public String deleteTrain(Integer trainId) {
		Optional<Train> opt = trainRepository.findById(trainId);
		if (opt.isPresent()) {
			trainRepository.deleteById(trainId);
			return "Train with id:: " + trainId + " deleted.";
		} else
			return "Train with id:: " + trainId + " not found.";
	}

	@Override
	public List<Train> showAllTrains() {
		return trainRepository.findAll();
	}

	@Override
	public Train findTrainById(Integer trainId) {

		Optional<Train> opt = trainRepository.findById(trainId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new IllegalArgumentException("Unknown record - train with id:: " + trainId + " not found");
		}
	}

	@Override
	public String changeTrainRouteStatus(Integer trainId, String status) {
		Optional<Train> opt = trainRepository.findById(trainId);
		if (opt.isPresent()) {
			Train trainfound = opt.get();
			trainfound.setActiveSw(status);
			trainRepository.save(trainfound);
			return "Status of Train with id:: " + trainId + " changed to: " + status;
		} else {
			throw new IllegalArgumentException("Unknown record - train with id:: " + trainId + " not found");
		}

	}

	//show station station id and station names
	@Override
	public Map<Integer, String> showAllStationNames() {

		List<Station> stationsList = stationRepository.findAll();
		Map<Integer, String> stationNamesMap = new HashMap<Integer, String>();
		stationsList.forEach(station -> {
			stationNamesMap.put(station.getStationId(), station.getStationName());
		});
		return stationNamesMap;
	}

	//show station station id and station codes
	@Override
	public Map<Integer, String> showAllStationCodes() {
		List<Station> stationList = stationRepository.findAll();
		Map<Integer, String> stationwithCodeMap = new HashMap<Integer, String>();
		stationList.forEach(station -> {
			stationwithCodeMap.put(station.getStationId(), station.getStationCode());
		});
		;
		return stationwithCodeMap;
	}

	//show station names and station codes -no station id
	@Override
	public Map<String, String> showAllStationNamesAndCodes() {
		List<Station> stationList = stationRepository.findAll();
		Map<String, String> stationNamewithCodeMap = new HashMap<String, String>();
		stationList.forEach(station -> {
			stationNamewithCodeMap.put(station.getStationCode(), station.getStationName());
		});
		return stationNamewithCodeMap;
	}

}
