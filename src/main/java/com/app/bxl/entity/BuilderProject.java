package com.app.bxl.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;


/**
 * The persistent class for the builder_projects database table.
 * 
 */
@Entity
@Table(name="builder_projects")
@NamedQuery(name="BuilderProject.findAll", query="SELECT b FROM BuilderProject b")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuilderProject implements Serializable {

	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;

	@Column(name="created_on", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createdOn;

	@Column(name="no_new_launches")
	private int noNewLaunches;

	@Column(name="no_ready_to_move")
	private int noReadyToMove;

	@Column(name="no_under_construction")
	private int noUnderConstruction;

	@Column(name="total_projects")
	private int totalProjects;

	@Column(name="unit_types")
	private String unitTypes;

	@Column(name="updated_on", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp updatedOn;

	//bi-directional many-to-one association to Builder
	@OneToOne
	@JoinColumn(name ="builder_id")
	private Builder builder;

}