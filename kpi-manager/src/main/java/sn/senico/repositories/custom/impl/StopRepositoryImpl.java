package sn.senico.repositories.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;
import sn.senico.repositories.StopRepository;
import sn.senico.repositories.custom.StopRepositoryCustomer;

public class StopRepositoryImpl implements StopRepositoryCustomer {

    @Autowired
    private StopRepository userRepository;

}
