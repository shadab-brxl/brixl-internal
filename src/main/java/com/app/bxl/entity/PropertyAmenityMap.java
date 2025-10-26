package com.app.bxl.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;


/**
 * The persistent class for the property_amenity_map database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="property_amenity_map")
@NamedQuery(name="PropertyAmenityMap.findAll", query="SELECT p FROM PropertyAmenityMap p")
public class PropertyAmenityMap implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Id
//	private String id;

	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;

	@Column(name="created_on")
	private Timestamp createdOn;

	@Column(name="img_url")
	private String imgUrl;

	private String name;

	@Column(name="updated_on")
	private Timestamp updatedOn;

	//bi-directional many-to-one association to Amenity
	@ManyToOne
	private Amenity amenity;

	//bi-directional many-to-one association to Property
	@ManyToOne
	private Property property;


}