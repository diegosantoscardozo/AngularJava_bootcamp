package com.project.bootcamp.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bootcamp.model.dto.StockDTO;
import com.project.bootcamp.service.StockService;

@CrossOrigin
@RestController
@RequestMapping(value="/stock")
public class StockController {
	
	@Autowired
	private StockService bc;
	
	@PostMapping(consumes = APPLICATION_JSON_VALUE,  produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto){
//		dto.setId(5L);
//		return ResponseEntity.ok(dto);
		
		return ResponseEntity.ok(bc.save(dto));		
	}
	
	
	
	@PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> update(@RequestBody StockDTO dto){
		return ResponseEntity.ok(bc.update(dto));
	}
	
	@GetMapping(produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StockDTO>> findAll(){
		
		List<StockDTO> lista = new ArrayList<>();
		StockDTO dto = new StockDTO();
		dto.setId(1L);
		dto.setName("teste");
		dto.setDate(LocalDate.now());
		dto.setPrice(100D);
		dto.setVariation(100D);
		lista.add(dto);		
		return ResponseEntity.ok(lista);
		
		//return ResponseEntity.ok(bc.findAll());
	}
	
	
	@GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> findById(@PathVariable Long id){
//		List<StockDTO> lista = new ArrayList<>();
//		StockDTO dto = new StockDTO();
//		dto.setId(1L);
//		dto.setName("teste 1");
//		dto.setDate(LocalDate.now());
//		dto.setPrice(100D);
//		dto.setVariation(100D);
//		lista.add(dto);
//		StockDTO dto1 = new StockDTO();
//		dto1.setId(2L);
//		dto1.setName("teste 2");
//		dto1.setDate(LocalDate.now());
//		dto1.setPrice(200D);
//		dto1.setVariation(200D);		
//		lista.add(dto);
//		lista.add(dto1);				
//		StockDTO stockDTO = lista.stream().filter(i -> i.getId().compareTo(id) == 0).findFirst().get();		
//		return ResponseEntity.ok(stockDTO);
		return ResponseEntity.ok(bc.findById(id));
	}
	
	@DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> delete(@PathVariable Long id){
		return ResponseEntity.ok(bc.delete(id));
	}
	
	@GetMapping(value = "/today", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StockDTO>> findByToday(){
		return ResponseEntity.ok(bc.findByToday());
	}
	
	
}