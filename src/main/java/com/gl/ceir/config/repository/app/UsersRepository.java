package com.gl.ceir.config.repository.app;

import com.gl.ceir.config.model.app.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

  //  @Query(value = "select U from Users U where U.userName=?1, and U.password= ?2 and U.parentId=?3", nativeQuery = true)
    public Users getByUsernameAndPasswordAndParentId(String userName, String password, int parentId);

  public Users getByUsernameAndPassword(String userName, String password);

}
