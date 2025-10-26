package com.app.bxl.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the city database table.
 * 
 */
@Entity
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private UUID id;

	private String code;

	@Column(name="created_on")
	private Timestamp createdOn;

	@Column(name="is_active")
	private Boolean isActive;

	private String name;

	@Column(name="updated_on")
	private Timestamp updatedOn;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="city")
	private List<Address> addresses;

	//bi-directional many-to-one association to Country
	@ManyToOne
	private Country country;

	//bi-directional many-to-one association to State
	@ManyToOne
	private State state;


	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setCity(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setCity(null);

		return address;
	}

}