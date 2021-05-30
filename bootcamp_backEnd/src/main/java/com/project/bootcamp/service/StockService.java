package com.project.bootcamp.service;

import static com.project.bootcamp.util.MessageUtil.NO_RECORDS_FOUND;
import static com.project.bootcamp.util.MessageUtil.STOCK_ALREADY_EXISTS;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bootcamp.exceptions.BusinessException;
import com.project.bootcamp.exceptions.NotFoundException;
import com.project.bootcamp.mapper.StockMapper;
import com.project.bootcamp.model.Stock;
import com.project.bootcamp.model.dto.StockDTO;
import com.project.bootcamp.repositoryDAO.IStockRepositoryDAO;

@Service
public class StockService {

	@Autowired
	private IStockRepositoryDAO dao;

	@Autowired
	private StockMapper mapper;

	@Transactional
	public StockDTO save(StockDTO dto) {
		Optional<Stock> sOpt = dao.findByNameAndDate(dto.getName(), dto.getDate());
		if (sOpt.isPresent())
			throw new BusinessException(STOCK_ALREADY_EXISTS);

		Stock stock = mapper.toEntity(dto);
		dao.save(stock);

		return mapper.toDto(stock);
	}

	@Transactional
	public StockDTO update(StockDTO dto) {
		Optional<Stock> sOpt = dao.findByStockUpdate(dto.getName(), dto.getDate(), dto.getId());
		// não permite deixar registros duplicados
		if (sOpt.isPresent())
			throw new BusinessException(STOCK_ALREADY_EXISTS);

		Stock stock = mapper.toEntity(dto);
		dao.save(stock);

		return mapper.toDto(stock);
	}

	@Transactional
	public StockDTO delete(Long id) {
		StockDTO dto = findById(id);
		dao.deleteById(id);;
		return dto;
	}

	@Transactional(readOnly = true)
	public List<StockDTO> findAll() {
		List<Stock> lista = dao.findAll();
		return lista.stream().map(i -> mapper.toDto(i)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public StockDTO findById(Long id) {
		Optional<StockDTO> dto = dao.findById(id).map(i -> mapper.toDto(i));
		if (dto.isPresent())
			return dto.get();
		else
			throw new NotFoundException(NO_RECORDS_FOUND);

	}

	@Transactional(readOnly = true)
	public List<StockDTO> findByToday() {
		return dao.findByToday(LocalDate.now()).stream().map(i -> mapper.toDto(i)).collect(Collectors.toList());		
		
	}


}
