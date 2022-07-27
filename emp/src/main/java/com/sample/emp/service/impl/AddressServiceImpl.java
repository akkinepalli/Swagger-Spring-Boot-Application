package com.sample.emp.service.impl;

	import java.util.ArrayList;
	import java.util.List;

	import org.modelmapper.ModelMapper;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.sample.emp.dto.AddressDTO;
	import com.sample.emp.entity.AddressEntity;
	import com.sample.emp.entity.UserEntity;
	import com.sample.emp.repository.AddressRepository;
	import com.sample.emp.repository.UserRepository;
	import com.sample.emp.service.AddressService;

	@Service
	public class AddressServiceImpl implements AddressService
	{
		@Autowired
		UserRepository userRepository;

		@Autowired
		AddressRepository addressRepository;

		@Override
		public List<AddressDTO> getAddresses(String userId)
		{
			List<AddressDTO> addressDTOList = new ArrayList<>();

			UserEntity userEntity = userRepository.findByUserId(userId);

			if (userEntity == null)
			{
				return addressDTOList;
			}

			ModelMapper modelMapper = new ModelMapper();

			List<AddressEntity> addresses = addressRepository.findAllByUserDetails(userEntity);

			for (AddressEntity addressEntity : addresses)
			{
				AddressDTO addressDTO = modelMapper.map(addressEntity, AddressDTO.class);
				addressDTOList.add(addressDTO);
			}

			return addressDTOList;
		}

		@Override
		public AddressDTO getAddress(String userId, String addressId)
		{
			AddressDTO addressDTO = null;
			
			UserEntity userEntity = userRepository.findByUserId(userId);
			AddressEntity addressEntity = addressRepository.findByUserDetailsAndAddressId(userEntity, addressId);

			if (addressEntity != null)
			{
				ModelMapper modelMapper = new ModelMapper();
				addressDTO = modelMapper.map(addressEntity, AddressDTO.class);	
			}

			return addressDTO;
		}

	}

