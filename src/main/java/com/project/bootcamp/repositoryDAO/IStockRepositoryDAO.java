package com.project.bootcamp.repositoryDAO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.bootcamp.model.Stock;
import com.project.bootcamp.model.dto.StockDTO;

@Repository
public interface IStockRepositoryDAO extends JpaRepository<Stock, Long>{

	//não precisou criar o sql, no nome do metodo colocou os atribuito que serão procurados 
	Optional<Stock> findByNameAndDate(String name, LocalDate date);

	
	@Query("SELECT stock FROM Stock stock "
			+ "WHERE stock.name = :name AND stock.date = :date and stock.id <> :id")
	Optional<Stock> findByStockUpdate(String name, LocalDate date, Long id);


	@Query("SELECT stock FROM Stock stock WHERE stock.date = :data")
	List<Stock> findByToday(LocalDate data);
	

	

}
