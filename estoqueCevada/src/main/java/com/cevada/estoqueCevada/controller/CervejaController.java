package com.cevada.estoqueCevada.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cevada.estoqueCevada.dao.CervejaDAO;
import com.cevada.estoqueCevada.entities.Cerveja;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@Controller
@RequestMapping("/Cerveja")
public class CervejaController {
	
	
	@Autowired
	private CervejaDAO dao;
	
	@GetMapping("/novo")
	public String novo(ModelMap model) {
		model.addAttribute("cerveja", 
				new Cerveja());
		return "/cerveja/index";
	}
	
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("lista",
				dao.findAll());
		return "/cerveja/listar";
	}
	
	@GetMapping("/prealterar")
	public String preAlterar(
		@RequestParam(name="id") int id, 
		ModelMap model) {
		model.addAttribute("cerveja",
				dao.findById(id));
		
		return "/cerveja/index";
	}
	
	@GetMapping("/excluir")
	public String excluir(@RequestParam(name="id")int id, 
			ModelMap model) {
		try {
			dao.delete(id);
			model.addAttribute("mensagem",
					"Exclusão efetuada");
			model.addAttribute("retorno",true);
		}
		catch (Exception e) {
			model.addAttribute("mensagem",
					"Exclusão não pode ser efetuada!");
			model.addAttribute("retorno",false);
		}
		model.addAttribute("lista", dao.findAll());
		return "/cerveja/listar";
	}
	
	
	@PostMapping("/salvar")
	public String salvar(
			@ModelAttribute("cerveja") 
			Cerveja cat, ModelMap model) {
		try {
		
			Validator validator;
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			validator = factory.getValidator();
			Set<ConstraintViolation<Cerveja>> constraintViolations =
			validator.validate( cat );
			String errors = "";
			for (ConstraintViolation<Cerveja> constraintViolation : constraintViolations) {
			errors = errors + constraintViolation.getMessage() + ". "; }
			if(errors!="")
			{
			model.addAttribute("cerveja",cat);
			model.addAttribute("mensagem", errors);
			model.addAttribute("retorno", false);
			return "/cerveja/index";
			}
			else
			{

				if(cat.getId()==null)
					dao.save(cat);
					else
						dao.update(cat);
					model.addAttribute("mensagem",
							"Salvo com sucesso!");
					model.addAttribute("retorno",
							true);
				
			}
		}
		catch (Exception e) {
			model.addAttribute("mensagem",
					"Erro ao salvar!" 
			+ e.getMessage());
			model.addAttribute("retorno",
					false);
		}
		
		return "/cerveja/index";
	}
	
}
