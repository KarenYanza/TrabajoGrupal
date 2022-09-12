package com.sinfloo.controler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sinfloo.modelo.Persona;
import com.sinfloo.service.PersonaService;

@RestController
@CrossOrigin(origins = {"http://localhost:3306"})
@RequestMapping("/persona")
public class PersonaControler {
	
	@Autowired
	private PersonaService service;
	
	@GetMapping("/listar")
	public List<Map<String, Object>> listar(Model model) {
		return service.listar();
	}
		
	@PostMapping("/agregar")
	public String save(@RequestBody Persona p,Model model) {
		int id=service.add(p);
		if(id==0) {
			return "No se pudo Regsitrar!";
		}
		return "Se registró con éxito!";
	}
	
	@PostMapping("/actualizar/{id}")
	public String save(@RequestBody Persona p,@PathVariable int id,Model model) {
		p.setId(id);
		int r=service.edit(p);
		if(r==0) {
			return "No se pudo Actualizar!";
		}
		return "Se actualizó con éxito!";
	}
	@PostMapping("/eliminar/{id}")
	public String delete(@PathVariable int id,Model model) {
		int r=service.delete(id);
		if(r==0) {
			return "Registro No Eliminado!";
		}
		return "Registro Eliminado!";
	}
	
}
