package curso.springboot.springboot.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import curso.springboot.springboot.model.Pessoa;
import curso.springboot.springboot.repository.PessoaRepository;

@Controller
public class Pessoacontroller {
	
	@Autowired
	private  PessoaRepository pessoaRepository;
	

	

	@GetMapping("/cadastropessoa")
	public ModelAndView inicio() {
		ModelAndView andView = new ModelAndView("cadastro/cadastropessoa");
	
		andView.addObject("pessoaobj",new Pessoa()); 
		
		return andView;
	}
	
	@PostMapping("*/salvarpessoa")
	public ModelAndView salvar(Pessoa pessoa) {
		
		pessoaRepository.save(pessoa);
		
		ModelAndView andView = new ModelAndView("cadastro/cadastropessoa");
		Iterable<Pessoa> pessoait = pessoaRepository.findAll();
		andView.addObject("pessoas", pessoait);
		andView.addObject("pessoaobj",new Pessoa());
		
		return andView;
		
	}
	
	@GetMapping(value = "/listapessoas")
	public ModelAndView pessoas() {
		
		ModelAndView andView = new ModelAndView("cadastro/cadastropessoa");
		Iterable<Pessoa> pessoait = pessoaRepository.findAll();
		andView.addObject("pessoas", pessoait);
		andView.addObject("pessoaobj",new Pessoa());
		
		return andView;
		
	}
	
	@GetMapping("/editarpessoa/{idpessoa}")
	public ModelAndView editar(@PathVariable("idpessoa")Long idpessoa) {
		
		ModelAndView andView = new ModelAndView("cadastro/cadastropessoa");
		
		Optional<Pessoa> pessoa = pessoaRepository.findById(idpessoa);
		
		andView.addObject("pessoaobj",pessoa.get());
		return andView;
	}

}
