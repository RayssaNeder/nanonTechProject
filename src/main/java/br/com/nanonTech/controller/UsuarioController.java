package br.com.nanonTech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.nanonTech.model.Usuario;
import br.com.nanonTech.repository.Usuarios;

@Controller
@RequestMapping
public class UsuarioController {

	@Autowired
	private Usuarios usuariosRepository;

	@GetMapping("/usuarios")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaUsuarios");
		modelAndView.addObject("usuarios", usuariosRepository.findAll());
		modelAndView.addObject(new Usuario());
		return modelAndView;
	}

	@PostMapping("/usuarios")
	public String salvar(Usuario usuario) {
		this.usuariosRepository.save(usuario);
		return "redirect:/usuarios";
	}

	@GetMapping("/usuarios/delete/{id}")
	public String remove(@PathVariable(name = "id") Long id) {
		this.usuariosRepository.delete(id);
		return "redirect:/usuarios";
	}
	@GetMapping(path = "/usuarios/editar/{id}")
	public String editar(Model model, @PathVariable(value = "id") Long id) {
		model.addAttribute("usuario", usuariosRepository.findOne(id));
		return "redirect:/usuarios";

	}

}
