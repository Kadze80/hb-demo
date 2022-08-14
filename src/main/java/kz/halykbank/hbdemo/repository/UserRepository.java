package kz.halykbank.hbdemo.repository;

import kz.halykbank.hbdemo.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    @Query(value = "SELECT * FROM users u WHERE u.per_num = :per_num", nativeQuery = true)
    List<Users> findByPerNum(@Param("per_num") Integer per_num);
}
