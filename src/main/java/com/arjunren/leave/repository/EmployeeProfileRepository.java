package com.arjunren.leave.repository;
import com.arjunren.leave.entity.EmployeeProfile; import jakarta.persistence.LockModeType; import java.util.Optional; import org.springframework.data.domain.*; import org.springframework.data.jpa.repository.*; import org.springframework.data.repository.query.Param;
public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile,Long>{Optional<EmployeeProfile>findByUserId(Long id);Page<EmployeeProfile>findByManagerId(Long id,Pageable p);@Lock(LockModeType.PESSIMISTIC_WRITE)@Query("select e from EmployeeProfile e join fetch e.user left join fetch e.manager where e.id=:id")Optional<EmployeeProfile>findByIdForUpdate(@Param("id")Long id);}

