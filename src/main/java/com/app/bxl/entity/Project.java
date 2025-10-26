package com.app.bxl.entity;

import com.app.bxl.entity.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnTransformer;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;

	@Column(name="created_on")
	private Timestamp createdOn;

	@Column(name="img_url")
	private String imgUrl;

	@Column(name="is_brix_adv")
	private Boolean isBrixAdv;

	@Column(name="name")
	private String name;

	@Temporal(TemporalType.DATE)
	@Column(name="possession_date")
	private Date possessionDate;

	@Column(name="price_range_lb")
	private BigDecimal priceRangeLb;

	@Column(name="price_range_ub")
	private BigDecimal priceRangeUb;

	@Column(name="rera_approved")
	private Boolean reraApproved;

	@Column(name="rera_id")
	private String reraId;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", columnDefinition = "project_status")
	@ColumnTransformer(write = "?::project_status")
	private ProjectStatusEnum status;

	@Column(name="total_area")
	private BigDecimal totalArea;

	@Column(name="total_units")
	private int totalUnits;

	@Column(name="about")
	private String about;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", columnDefinition = "project_type")
	@ColumnTransformer(write = "?::project_type")
	private ProjectTypeEnum type;

	@Enumerated(EnumType.STRING)
	@Column(name="ub_price_unit_type", columnDefinition = "price_unit_type")
	@ColumnTransformer(write = "?::price_unit_type")
	private PriceUnitTypeEnum ubPriceUnitTypeEnum;

	@Enumerated(EnumType.STRING)
	@Column(name="lb_price_unit_type", columnDefinition = "price_unit_type")
	@ColumnTransformer(write = "?::price_unit_type")
	private PriceUnitTypeEnum lbPriceUnitTypeEnum;

	@Enumerated(EnumType.STRING)
	@Column(name="area_unit_type", columnDefinition = "area_unit_type")
	@ColumnTransformer(write = "?::area_unit_type")
	private AreaUnitTypeEnum areaUnitTypeEnum;

	@Enumerated(EnumType.STRING)
	@Column(name = "tag")
	private ProjectTagEnum tag;

	@Column(name="updated_on")
	private Timestamp updatedOn;

	@OneToOne(fetch = FetchType.LAZY)
	private Address address;

	//bi-directional many-to-one association to Builder
	@ManyToOne(fetch = FetchType.EAGER)
	private Builder builder;

	//bi-directional many-to-one association to ProjectAmenityMap
	@OneToMany(fetch = FetchType.LAZY, mappedBy="project")
	private List<ProjectAmenityMap> projectAmenityMaps;

	//bi-directional many-to-one association to Property
	@OneToMany(fetch = FetchType.LAZY, mappedBy="project")
	private List<Property> properties;

    @Column(name="latitude")
    private BigDecimal latitude;

    @Column(name="longitude")
    private BigDecimal longitude;

    @Column(name="goog_rating")
    private BigDecimal googRating;

    @Column(name = "goog_rev_count")
    private Integer googRevCount;

    @Column(name = "curr_int_count")
    private Integer currIntCount;

	@Column(name="biaapa_approved")
	private Boolean biaapaApproved;

	@Column(name="is_active")
	private Boolean isActive;

}