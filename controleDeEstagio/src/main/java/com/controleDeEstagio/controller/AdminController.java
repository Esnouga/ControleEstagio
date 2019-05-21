package com.controleDeEstagio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.controleDeEstagio.models.Aluno;
import com.controleDeEstagio.repository.AlunoRepository;


@Controller
public class AdminController {

	@Autowired
	private AlunoRepository er;
	
	@RequestMapping(value="/indexAdmin", method=RequestMethod.GET)
	public String form(){
		//verificar se o usuario está cadastrado. sim, direciona para a pagina do usuario. não, retorna parao login
		return "evento/indexAdmin";
	}
	
	@RequestMapping("/alunos")
	public ModelAndView listaAlunos() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Aluno> alunos = er.findAll();
		mv.addObject("alunos",alunos );
		return mv;
	}

}
