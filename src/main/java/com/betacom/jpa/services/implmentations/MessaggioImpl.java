package com.betacom.jpa.services.implmentations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.betacom.jpa.models.Messaggi;
import com.betacom.jpa.models.MessaggiID;
import com.betacom.jpa.repositories.IMessaggiRepository;
import com.betacom.jpa.services.interfaces.IMessaggioServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MessaggioImpl implements IMessaggioServices{
	
	private final IMessaggiRepository msgR;
	
	@Value("${lang}")
	private String lang;
	
	@Override
	public String get(String code) {
		log.debug(" get {}",code);
		String r = null;
		Optional<Messaggi> m = msgR.findById(new MessaggiID(lang, code));
		if (m.isEmpty())
			r=code;
		else
			r=m.get().getMessaggio();
		
		return r;
	}
	
	
	
}
