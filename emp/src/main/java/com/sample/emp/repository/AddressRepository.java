package com.sample.emp.repository;

	import java.util.List;

	import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;

	import com.sample.emp.entity.AddressEntity;
	import com.sample.emp.entity.UserEntity;  


@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, Long>
{
	List<AddressEntity> findAllByUserDetails(UserEntity userEntity);
	AddressEntity findByUserDetailsAndAddressId(UserEntity userEntity,String addressId);
}