package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/messages")
public class MessageResource {
	@GetMapping("/simpleMessageWelcome")
    public String simpleMessageWelcome() {
      return "BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT !!!";

    }
	
	@PostMapping("/login")
	public String login(@RequestBody loginObj login) {
		if (login.user.equals(null) || login.user.isBlank() || login.user.isEmpty() ||
				login.password.equals(null) || login.password.isBlank() || login.password.isEmpty()) {
			return "USUÁRIO E SENHA NÃO INFORMADOS";
		}
		if (login.user.length() >= 15 || login.password.length() >= 15) {
			return "USUÁRIO E SENHA INVÁLIDOS";
		}
		return "LOGIN EFETUADO COM SUCESSO !!!";
	}
	
	public static class loginObj {
		public String user;
		public String password;
	}
}
