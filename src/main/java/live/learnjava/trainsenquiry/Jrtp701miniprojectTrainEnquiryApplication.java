package live.learnjava.trainsenquiry;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import live.learnjava.trainsenquiry.entity.Station;
import live.learnjava.trainsenquiry.entity.Train;
import live.learnjava.trainsenquiry.repository.IStationRepository;
import live.learnjava.trainsenquiry.repository.ITrainRepository;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Jrtp701miniprojectTrainEnquiryApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jrtp701miniprojectTrainEnquiryApplication.class, args);
	}

	@Bean
	public CommandLineRunner insertTrainData(ITrainRepository trainRepository) {
		log.info("Inserting 2 records in the TRAIN table of TRAINSDB database");
		return args -> {
			Train train = new Train();
			train.setTrain_number(9090);
			train.setTrain_name("Vande Bharat");
			train.setOriginStation("New Delhi, JN");
			train.setDestinationStation("Varanasi, JN");
			LocalDateTime departureTime = LocalDateTime.parse("2024-10-10T04:15:00");
			train.setDepartureTime(departureTime);
			LocalDateTime arrivalTime = LocalDateTime.parse("2024-10-11T03:15:00");
			train.setArrivalTime(arrivalTime);
			train.setFare(1980.50);
			train.setRealTimeStatus("Delayed");
			train.setCreatedBy("Rohit Shetty");
			trainRepository.save(train);

			Train train1 = new Train();
			train1.setTrain_number(12728);
			train1.setTrain_name("Godavari Express");
			train1.setOriginStation("Hyderabad, JN");
			train1.setDestinationStation("Vishakapatnam, JN");
			departureTime = LocalDateTime.parse("2024-10-10T20:15:00");
			train1.setDepartureTime(departureTime);
			arrivalTime = LocalDateTime.parse("2024-10-11T21:15:00");
			train1.setArrivalTime(arrivalTime);
			train1.setFare(2050.50);
			train1.setRealTimeStatus("On Time");
			train1.setCreatedBy("Mamta Chaudhary");
			trainRepository.save(train1);

		};

	}

	@Bean
	public CommandLineRunner insertStationData(IStationRepository stationRepository) {
		log.info("Inserting 4 records in STATION table of TRAINSDB database");
		return args -> {
			Station station1 = new Station();
			station1.setStationCode("HYD");
			station1.setStationName("Hyderabad, JN");
			station1.setCreatedBy("STATION_MASTER_1");
			stationRepository.save(station1);
			
			Station station2 = new Station();
			station2.setStationCode("NDLS");
			station2.setStationName("New Delhi, JN");
			station2.setCreatedBy("STATION_MASTER_2");
			stationRepository.save(station2);
			
			Station station3 = new Station();
			station3.setStationCode("VSKP");
			station3.setStationName("Visakhapatnam, JN");
			station3.setCreatedBy("STATION_MASTER_1");
			stationRepository.save(station3);
			
			Station station4 = new Station();
			station4.setStationCode("BSB");
			station4.setStationName("Varanasi, JN");
			station4.setCreatedBy("STATION_MASTER_2");
			stationRepository.save(station4);			
		};
	}

}
