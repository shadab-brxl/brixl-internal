package com.app.bxl.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the country database table.
 *
 */
@Entity
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private UUID id;

	private String code;

	@Column(name="created_on")
	private Timestamp createdOn;

	private String name;

	@Column(name="updated_on")
	private Timestamp updatedOn;

//	bi-directional many-to-one association to Address
	@OneToMany(mappedBy="country")
	private List<Address> addresses;

	//bi-directional many-to-one association to City
	@OneToMany(mappedBy="country")
	private List<City> cities;

	//bi-directional many-to-one association to State
	@OneToMany(mappedBy="country")
	private List<State> states;

}