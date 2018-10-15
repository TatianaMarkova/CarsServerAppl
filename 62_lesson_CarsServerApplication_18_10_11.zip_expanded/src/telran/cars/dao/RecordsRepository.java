package telran.cars.dao;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import telran.cars.entities.RecordJpa;

public interface RecordsRepository extends
JpaRepository<RecordJpa, Integer> {

	RecordJpa findByCarRegNumberAndReturnDateNull(String carNumber);

	List<RecordJpa> findByCarFlRemovedTrueAndReturnDateBefore(LocalDate dateDelete);

	Stream<RecordJpa> findAllBy();
	@Query(value="select count(*) from carrecords join cars on "
			+ "car_reg_number=reg_number group by model_model_name"
			+ " order by count(*) desc limit 1",nativeQuery=true)
	Long getMaxRecords();
	@Query("select car.model.modelName from RecordJpa group by car.model.modelName "
			+ "having count(*)=:count")
	List<String> findMostPopularModelNames(@Param("count") long count);
	@Query(value="select model_model_name from carrecords join cars on "
			+ "car_reg_number=reg_number group by model_model_name "
			+ "having sum(cost)=(select sum(cost) "
			+ "from carrecords join cars on " + 
			"car_reg_number=reg_number group by model_model_name order by sum(cost) desc limit 1)",nativeQuery=true)
	List<String> getMostProfitModelNames();

}
