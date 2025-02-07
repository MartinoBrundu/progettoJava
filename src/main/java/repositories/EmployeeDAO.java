package repositories;

import entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}