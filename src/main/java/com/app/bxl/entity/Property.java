package com.app.bxl.entity;

//import com.app.bxl.entity.converter.BHKTypeConverter;
import com.app.bxl.entity.converter.BHKTypeConverter;
import com.app.bxl.entity.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnTransformer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the property database table.
 * 
 */
@Entity
@NamedQuery(name="Property.findAll", query="SELECT p FROM Property p")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property implements Serializable {

	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;

	@Column(name="abs_price")
	private BigDecimal absPrice;

	@Enumerated(EnumType.STRING)
	@Column(name="abs_price_unit_type", columnDefinition = "price_unit_type")
	@ColumnTransformer(write = "?::price_unit_type")
	private PriceUnitTypeEnum absPriceUnitTypeEnum;

	@Column(name="apt_type")
	@Convert(converter = BHKTypeConverter.class)
	private BHKTypeEnum aptType;

    @Column(name="unit_type")
    private String unitType;

	@Column(name="carpet_area")
	private BigDecimal carpetArea;

	@Column(name="created_on")
	private Timestamp createdOn;

	@Enumerated(EnumType.STRING)
	@Column(name="lb_price_unit_type", columnDefinition = "price_unit_type")
	@ColumnTransformer(write = "?::price_unit_type")
	private PriceUnitTypeEnum lbPriceUnitTypeEnum;

	@Column(name="name")
	private String name;

	@Column(name="price_range_lb")
	private BigDecimal priceRangeLb;

	@Column(name="price_range_ub")
	private BigDecimal priceRangeUb;

	@Enumerated(EnumType.STRING)
	@Column(name="property_type", columnDefinition = "property_type")
	@ColumnTransformer(write = "?::property_type")
	private PropertyTypeEnum propertyType;

	@Enumerated(EnumType.STRING)
	@Column(name="status", columnDefinition = "property_status")
	@ColumnTransformer(write = "?::property_status")
	private PropertyStatusEnum status;

	@Column(name="superbuilt_area")
	private BigDecimal superbuiltArea;

	@Enumerated(EnumType.STRING)
	@Column(name="ub_price_unit_type", columnDefinition = "price_unit_type")
	@ColumnTransformer(write = "?::price_unit_type")
	private PriceUnitTypeEnum ubPriceUnitTypeEnum;

	@Column(name="updated_on")
	private Timestamp updatedOn;

	//bi-directional many-to-one association to Project
	@ManyToOne
	private Project project;

	//bi-directional many-to-one association to PropertyAmenityMap
	@OneToMany(mappedBy="property")
	private List<PropertyAmenityMap> propertyAmenityMaps;

}