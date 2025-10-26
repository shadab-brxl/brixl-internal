package com.app.bxl.entity;

import com.app.bxl.entity.enums.AmenityTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnTransformer;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the amenity database table.
 * 
 */
@Entity
@NamedQuery(name="Amenity.findAll", query="SELECT a FROM Amenity a")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Amenity implements Serializable {

	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;

	@Column(name="created_on")
	private Timestamp createdOn;

	@Column(name = "description")
	private String description;

	@Column(name = "name")
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", columnDefinition = "amenity_type")
	@ColumnTransformer(write = "?::amenity_type")
	private AmenityTypeEnum type;

	@Column(name="updated_on")
	private Timestamp updatedOn;

	//bi-directional many-to-one association to ProjectAmenityMap
	@OneToMany(mappedBy="amenity")
	private List<ProjectAmenityMap> projectAmenityMaps;

	//bi-directional many-to-one association to PropertyAmenityMap
	@OneToMany(mappedBy="amenity")
	private List<PropertyAmenityMap> propertyAmenityMaps;

}