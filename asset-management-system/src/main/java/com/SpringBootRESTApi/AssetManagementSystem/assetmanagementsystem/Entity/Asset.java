package com.SpringBootRESTApi.AssetManagementSystem.assetmanagementsystem.Entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "asset")
public class Asset {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "asset_name")
	private String assetName;

	@Column(name = "purchase_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date purchaseDate;
	
	@Column(name = "condition_notes")
	private String conditionNotes;

	@Column(name = "categories")
	@JoinColumn
	private Category categories;

	@Column(name = "assignment_status")
	private String assignmentStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getConditionNotes() {
		return conditionNotes;
	}

	public void setConditionNotes(String conditionNotes) {
		this.conditionNotes = conditionNotes;
	}

	public Category getCategories() {
		return categories;
	}

	public void setCategories(Category categories) {
		this.categories = categories;
	}

	public String getAssignmentStatus() {
		return assignmentStatus;
	}

	public void setAssignmentStatus(String assignmentStatus) {
		this.assignmentStatus = assignmentStatus;
	}


	

}
