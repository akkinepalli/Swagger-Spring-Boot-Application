package com.sample.emp.service;

	import java.util.List;

	import com.sample.emp.dto.AddressDTO;

	public interface AddressService
	{
		List<AddressDTO> getAddresses(String userId);
		AddressDTO getAddress(String userId,String addressId);
	}

