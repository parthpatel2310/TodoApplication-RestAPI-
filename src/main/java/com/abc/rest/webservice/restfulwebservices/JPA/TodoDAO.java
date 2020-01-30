package com.abc.rest.webservice.restfulwebservices.JPA;

import com.abc.rest.webservice.restfulwebservices.bean.TodoBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoDAO  extends JpaRepository<TodoBean,Integer> {

    @Query("from TodoBean where userid=:userId")
    List<TodoBean> findByUserId(@Param("userId") int userId);


}
