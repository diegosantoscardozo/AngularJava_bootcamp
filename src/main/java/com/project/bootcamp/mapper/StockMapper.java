package com.project.bootcamp.mapper;

import org.springframework.stereotype.Component;

import com.project.bootcamp.model.Stock;
import com.project.bootcamp.model.dto.StockDTO;

//mapeamento DTO e entidade
@Component
public class StockMapper {
	
	public Stock toEntity(StockDTO dto) {
		Stock s = new Stock();
		s.setId(dto.getId());
		s.setName(dto.getName());
		s.setDate(dto.getDate());
		s.setPrice(dto.getPrice());
		s.setVariation(dto.getVariation());
		return s;
	}

	public StockDTO toDto(Stock stock) {
		StockDTO dto = new StockDTO();
		dto.setId(stock.getId());
		dto.setName(stock.getName());
		dto.setDate(stock.getDate());
		dto.setPrice(stock.getPrice());
		dto.setVariation(stock.getVariation());
		return dto;
	}

}
