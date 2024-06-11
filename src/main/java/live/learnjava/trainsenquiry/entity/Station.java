package live.learnjava.trainsenquiry.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "STATION")
@Data
public class Station {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STATION_ID")
	private Integer stationId;

	@Column(name = "STATION_CODE", length = 10)
	private String stationCode;

	@Column(name = "STATION_NAME", length = 20)
	private String stationName;
	
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
