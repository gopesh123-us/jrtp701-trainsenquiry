package live.learnjava.trainsenquiry.microservice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import live.learnjava.trainsenquiry.entity.Train;
import live.learnjava.trainsenquiry.service.ITrainManagementService;

@RestController
@RequestMapping("/train/enquiry") // global path
public class TrainOperationsController {

	@Autowired
	private ITrainManagementService service;

	@PostMapping("/addNewTrainRoute")
	public ResponseEntity<String> addNewTrainRoute(@RequestBody Train train) {
		try {
			String msg = service.addTrain(train);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/modifyTrainRoute")
	public ResponseEntity<?> modifyTrainRoute(@RequestBody Train train) {
		// use service
		try {
			String message = service.updateTrain(train);
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteTrainRoute/{trainId}")
	public ResponseEntity<String> deleteTrainRoute(@PathVariable Integer trainId) {
		try {
			String message = service.deleteTrain(trainId);
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/showAllTrainRoutes")
	public ResponseEntity<?> showallTrains() {
		try {
			// use service.
			List<Train> allTrains = service.showAllTrains();
			return new ResponseEntity<List<Train>>(allTrains, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findTrainById/{trainId}")
	public ResponseEntity<?> findTrainById(@PathVariable Integer trainId) {
		try {
			// use service
			Train trainFound = service.findTrainById(trainId);
			return new ResponseEntity<Train>(trainFound, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/changeTrainStatus/{trainId}/{status}")
	public ResponseEntity<String> changeTrainRouteStatus(@PathVariable Integer trainId, @PathVariable String status) {
		try {
			// use service
			String message = service.changeTrainRouteStatus(trainId, status);
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/showAllStations")
	public ResponseEntity<?> showAllStationNames() {
		// use service
		try {
			Map<Integer, String> allStationNames = service.showAllStationNames();
			return new ResponseEntity<Map<Integer, String>>(allStationNames, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/showAllStationCodes")
	public ResponseEntity<?> showAllStationCodes() {
		// use service
		try {
			Map<Integer, String> allCodes = service.showAllStationCodes();
			return new ResponseEntity<Map<Integer, String>>(allCodes, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/showAllStationsWithCodes")
	public ResponseEntity<?> showAllStationNamesAndCodes() {
		// use service
		try {

			Map<String, String> allStationsAndCodes = service.showAllStationNamesAndCodes();
			return new ResponseEntity<Map<String, String>>(allStationsAndCodes, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}