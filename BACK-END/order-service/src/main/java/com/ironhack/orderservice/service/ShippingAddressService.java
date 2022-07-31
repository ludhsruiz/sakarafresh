package com.ironhack.orderservice.service;

import com.ironhack.orderservice.model.ShippingAddress;
import com.ironhack.orderservice.repository.ShippingAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingAddressService {

    @Autowired
    ShippingAddressRepository shippingAddressRepository;

    public List<ShippingAddress> getAllShippingAddress(){
        return shippingAddressRepository.findAll();
    }

    public Optional<ShippingAddress> getShippingAddressById(Long id) {
        return shippingAddressRepository.findById(id);

    }
    public List<ShippingAddress> getShippingAddressByUserId(Long userId){
        return shippingAddressRepository.getShippingAddressByUserId(userId);
    }

    public void updateShippingAddress(Long id, ShippingAddress shippingAddress) throws Exception {
        Optional<ShippingAddress> maybeShippingAddress= shippingAddressRepository.findById(id);
        if(maybeShippingAddress.isEmpty()){
            throw new Exception("No order found");
        }
        maybeShippingAddress.get().setId(shippingAddress.getId());
        maybeShippingAddress.get().setName(shippingAddress.getName());
        maybeShippingAddress.get().setStreet(shippingAddress.getStreet());
        maybeShippingAddress.get().setStreetDetails(shippingAddress.getStreetDetails());
        maybeShippingAddress.get().setCity(shippingAddress.getCity());
        maybeShippingAddress.get().setState(shippingAddress.getState());
        maybeShippingAddress.get().setZipCode(shippingAddress.getZipCode());
        maybeShippingAddress.get().setPhone(shippingAddress.getPhone());
        maybeShippingAddress.get().setUserId(shippingAddress.getUserId());
        shippingAddressRepository.save(maybeShippingAddress.get());

    }

    public void createNewShippingAddress(ShippingAddress shippingAddress){
        shippingAddressRepository.save(shippingAddress);
    }



}
