package com.project.bootcamp.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StockDTO {
	
	private Long id;
	
	@NotNull
	@NotBlank
	private String name;
	
	@NotNull
	@DecimalMin(value="0.0")
	@Digits(integer=6, fraction = 2)
	private Double price;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd/MM/yy")
	private LocalDate date; 
	
	private Double variation;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getVariation() {
		return variation;
	}

	public void setVariation(Double variation) {
		this.variation = variation;
	}
	
	

}
