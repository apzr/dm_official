package com.dm.official.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.dm.official.entity.Recent;

/**
 * 注意： 
 * 1.这里这里是interface，不是class 
 * 2.CrudRepository里面的泛型，第一个是实体类，第二个是主键的类型
 * 3.由于crudRepository 里面已经有一些接口了，如deleteAll，findOne等， 我们直接调用即可
 * 4.当然，我们也可以根据自己的情况来实现自己的接口,如下面的getUser()方法，jpql语句和hql语句差不多
 */
public interface RecentRepository extends PagingAndSortingRepository<Recent, Integer> {

	@Query(value = "SELECT id,title,detail,release_time,create_time "
				+ " FROM t_recent r "
				+ " WHERE id = :id", nativeQuery = true)
	public Recent getRecent(@Param("id") Integer id);
	
	@Query(value = "SELECT id,title,detail,release_time,create_time "
				+ " FROM t_recent r "
				+ " ORDER BY create_time DESC limit :limit ", nativeQuery = true)
	public List<Recent> top(@Param("limit") Integer limit);

}
