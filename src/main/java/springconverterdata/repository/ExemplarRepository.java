package springconverterdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springconverterdata.model.Exemplar;

@Repository
public interface ExemplarRepository extends JpaRepository<Exemplar, Integer> {

}
