package com.betacom.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.jpa.models.Messaggi;
import com.betacom.jpa.models.MessaggiID;

public interface IMessaggiRepository extends JpaRepository<Messaggi, MessaggiID>{

}
