package live.learnjava.trainsenquiry.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TRAIN")
@Data
public class Train {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TRAIN_ID", nullable = false)
	private Integer train_id;

	@Column(name = "TRAIN_NUMBER", nullable = false)
	private Integer train_number;

	@Column(name = "TRAIN_NAME", length = 20)
	private String train_name;

	@Column(name = "ORIGIN_STATION", length = 20)
	private String originStation;

	@Column(name = "DESTINATION_STATION", length = 20)
	private String destinationStation;

	@Column(name = "DEPARTURE_TIME")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime departureTime;

	@Column(name = "ARRIVAL_TIME")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime arrivalTime;

	@Column(name = "FARE")
	private Double fare;

	@Column(name = "REAL_TIME_STATUS", length = 20)
	private String realTimeStatus;

	@Column(name = "ACTIVE_SWITCH", length = 20)
	private String activeSw = "active";

	@Column(name = "CREATED_AT", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate;

	@Column(name = "UPDATED_AT", updatable = true, insertable = false)
	@UpdateTimestamp
	private LocalDateTime updatedDate;

	@Column(name = "CREATED_BY", length = 20)
	private String createdBy;

	@Column(name = "UPDATED_BY", length = 20)
	private String updatedBy;
}
