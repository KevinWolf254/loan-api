package co.ke.bank.maendeleo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, 
property="id")
@Entity
@Table(name="residence")
public class Residence {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="physical_address")
	private String physicalAddress;
	
	@Column(name="owned")
	private boolean owned;
	
	@Column(name="occupancy_duration")
	private String occupancyDuration;
	
	public Residence() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPhysicalAddress() {
		return physicalAddress;
	}
	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}
	public boolean isOwned() {
		return owned;
	}
	public void setOwned(boolean owned) {
		this.owned = owned;
	}
	public String getOccupancyDuration() {
		return occupancyDuration;
	}
	public void setOccupancyDuration(String occupancyDuration) {
		this.occupancyDuration = occupancyDuration;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Residence [id=").append(id).append(", physicalAddress=").append(physicalAddress)
				.append(", owned=").append(owned).append(", occupancyDuration=").append(occupancyDuration).append("]");
		return builder.toString();
	}
}
