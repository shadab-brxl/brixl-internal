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
 * The persistent class for the builder database table.
 * 
 */
@Entity
@NamedQuery(name="Builder.findAll", query="SELECT b FROM Builder b")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Builder implements Serializable {

	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;

	@Column(name="builder_code")
	private String builderCode;

	@Column(name="contact")
	private String contact;

	//@Column(name="created_on", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Column(name="created_on")
    private Timestamp createdOn;

	@Column(name="logo_url")
	private String logoUrl;

	@Column(name="is_brix_adv")
	private Boolean isBrixAdv;

	@Column(name="name")
	private String name;

	@Column(name="about_us")
	private String aboutUs;

	@Column(name="registration_code")
	private String registrationCode;

	//@Column(name="updated_on", insertable=false, updatable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Column(name="updated_on")
    private Timestamp updatedOn;

	@Column(name="yoe")
	private int yoe;

	//bi-directional many-to-one association to Address
	@OneToOne
	@JoinColumn(name="registered_addr_id")
	private Address address;

	//bi-directional many-to-one association to BuilderProject
	@OneToOne(mappedBy="builder")
	private BuilderProject builderProject;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="builder")
	private List<Project> projects;


}