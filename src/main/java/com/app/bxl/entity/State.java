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
 * The persistent class for the state database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name="State.findAll", query="SELECT s FROM State s")
public class State implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private UUID id;

	private String code;

	@Column(name="created_on")
	private Timestamp createdOn;

	private String name;

	@Column(name="updated_on")
	private Timestamp updatedOn;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="state")
	private List<Address> addresses;

	//bi-directional many-to-one association to City
	@OneToMany(mappedBy="state")
	private List<City> cities;

	//bi-directional many-to-one association to Country
	@ManyToOne
	private Country country;

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setState(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setState(null);

		return address;
	}

}