package live.learnjava.trainsenquiry;

import java.time.LocalTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import live.learnjava.trainsenquiry.entity.Train;
import live.learnjava.trainsenquiry.repository.ITrainRepository;

@SpringBootApplication
public class Jrtp701miniprojectTrainEnquiryApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jrtp701miniprojectTrainEnquiryApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner insertData(ITrainRepository repository	) {
		return args -> {
			Train train = new Train();
			train.setTrain_number(9090);
			train.setTrain_name("Vande Bharat");
			train.setOriginStation("New Delhi, JN");
			train.setDestinationStation("Varanasi, JN");
			LocalTime departureTime = LocalTime.parse("03:15:00");	
			train.setDepartureTime(departureTime);
			LocalTime arrivalTime = LocalTime.parse("21:30:00");
			train.setArrivalTime(arrivalTime);
			train.setFare(1980.50);
			train.setRealTimeStatus("On Time");
			train.setUpdatedBy("Rahul Shetty");
			train.setCreatedBy("Rahul Shetty");
			repository.save(train);
			
			Train train1 = new Train();
			train1.setTrain_number(12728);
			train1.setTrain_name("Godavari Express");
			train1.setOriginStation("Hyderabad, JN");
			train1.setDestinationStation("Vishakapatnam, JN");
			departureTime = LocalTime.parse("12:15:00");	
			train1.setDepartureTime(departureTime);
			arrivalTime = LocalTime.parse("09:30:00");
			train1.setArrivalTime(arrivalTime);
			train1.setFare(2050.50);
			train1.setRealTimeStatus("On Time");
			train1.setUpdatedBy("Ashish Chaudhary");
			train1.setCreatedBy("Ashish Chaudhary");
			repository.save(train1);
			
		};
	}

}
