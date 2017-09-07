package br.com.nanonTech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.nanonTech.model.Usuario;
import br.com.nanonTech.repository.Usuarios;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private Usuarios usuarios;
	
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaUsuarios");
		modelAndView.addObject("usuarios", usuarios.findAll());
		modelAndView.addObject(new Usuario());
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(Usuario usuario) {
		this.usuarios.save(usuario);
		return "redirect:/usuarios";
	}

}
