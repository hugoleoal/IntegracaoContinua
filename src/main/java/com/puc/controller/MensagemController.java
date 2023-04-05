package com.puc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MensagemController {
	
	
	@RequestMapping(value = "/mensagem", method = RequestMethod.GET)
	public String listarJogador() {
		return "Nome: XXXXXXXX - Email: XXXXXXXXXXX@XXXXXXX.br - Curso: Cutura e prática DEVOPS";
		
	}
	
}
