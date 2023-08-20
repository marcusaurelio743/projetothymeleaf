package curso.springboot.springboot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import curso.springboot.springboot.model.Pessoa;
import curso.springboot.springboot.repository.PessoaRepository;

@Controller
public class Pessoacontroller {
	
	@Autowired
	private  PessoaRepository pessoaRepository;
	

	

	@GetMapping("/cadastropessoa")
	public String inicio() {
		
		return"cadastro/cadastropessoa";
	}
	
	@PostMapping(value = "/salvarpessoa")
	public ModelAndView salvar(Pessoa pessoa) {
		
		pessoaRepository.save(pessoa);
		
		ModelAndView andView = new ModelAndView("cadastro/cadastropessoa");
		Iterable<Pessoa> pessoait = pessoaRepository.findAll();
		andView.addObject("pessoas", pessoait);
		
		return andView;
		
	}
	
	@GetMapping(value = "/listapessoas")
	public ModelAndView pessoas() {
		
		ModelAndView andView = new ModelAndView("cadastro/cadastropessoa");
		Iterable<Pessoa> pessoait = pessoaRepository.findAll();
		andView.addObject("pessoas", pessoait);
		
		return andView;
		
	}

}
