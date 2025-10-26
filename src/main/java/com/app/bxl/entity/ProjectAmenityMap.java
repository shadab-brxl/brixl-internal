package com.app.bxl.entity;

import com.app.bxl.entity.enums.ProjectAmenityMapCategoryEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;


/**
 * The persistent class for the project_amenity_map database table.
 * 
 */
@Entity
@Table(name="project_amenity_map")
@NamedQuery(name="ProjectAmenityMap.findAll", query="SELECT p FROM ProjectAmenityMap p")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectAmenityMap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(name="created_on")
	private Timestamp createdOn;

	@Column(name="img_url")
	private String imgUrl;

	@Column(name="name")
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name="category")
	private ProjectAmenityMapCategoryEnum category;

	@Column(name = "distance")
	private String distance;

	@Column(name="updated_on")
	private Timestamp updatedOn;

	//bi-directional many-to-one association to Amenity
	@ManyToOne
	private Amenity amenity;

	//bi-directional many-to-one association to Project
	@ManyToOne
	private Project project;

}