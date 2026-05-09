package mth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mth.models.Users;

@Repository
public interface UsersRespository extends JpaRepository<Users, Long> {

    @org.springframework.data.jpa.repository.Query("select U.id from Users U where U.email = :email")
    public Long checkByEmail(@Param("email") String email);

    @Query("select U.role from Users U where U.email=:username")
    Object validateCredentials(@Param("username") String username ,@Param("password") String password);


    @Query("select U from Users U where U.email=:email")
    public Object findByEmail(@Param("email") String email);
}