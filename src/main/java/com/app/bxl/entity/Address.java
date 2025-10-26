package com.app.bxl.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private UUID id;

	@Column(name="addr_line1")
	private String addrLine1;

	@Column(name="addr_line2")
	private String addrLine2;

	@Column(name="created_on")
	private Timestamp createdOn;

	private String landmark;

	private BigDecimal lat;

	private BigDecimal lng;

	private String locality;

	private String pincode;

	@Column(name="updated_on")
	private Timestamp updatedOn;

	//bi-directional many-to-one association to City
	@ManyToOne
	private City city;

	//bi-directional many-to-one association to Country
	@ManyToOne
	private Country country;

	//bi-directional many-to-one association to State
	@ManyToOne
	private State state;

	//bi-directional many-to-one association to Builder
	@OneToMany(mappedBy="address")
	private List<Builder> builders;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="address")
	private List<Project> projects;

	//bi-directional many-to-one association to User
//	@OneToMany(mappedBy="address")
//	private List<User> users;


	public Builder addBuilder(Builder builder) {
		getBuilders().add(builder);
		builder.setAddress(this);

		return builder;
	}

	public Builder removeBuilder(Builder builder) {
		getBuilders().remove(builder);
		builder.setAddress(null);

		return builder;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setAddress(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setAddress(null);

		return project;
	}

	@PrePersist
	protected void onCreate() {
		Timestamp now = new Timestamp(System.currentTimeMillis());
		createdOn = now;
		updatedOn = now;
	}

	@PreUpdate
	protected void onUpdate() {
		updatedOn = new Timestamp(System.currentTimeMillis());
	}

}