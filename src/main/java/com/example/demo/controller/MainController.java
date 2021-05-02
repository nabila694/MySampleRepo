package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Executive;
import com.example.demo.repository.ExecutiveRepository;

@RestController
public class MainController {
	
	@Autowired
	private ExecutiveRepository executiveRepository;
	
	@GetMapping("/test1")
	public String testApii() 
	{
		return new String("Hello boot");
	} 
	
	@PostMapping("/insert")
	public Executive insertData(@RequestBody Executive executive) {
		
		Executive c=executiveRepository.save(executive);
		
		return c;
	}

	@GetMapping("/executive")
	public List<Executive> getProduct(){
		
		List<Executive> list=executiveRepository.findAll();
		list.stream().forEach(c->System.out.println(c));
		return list;
	}
	
		@GetMapping("/executives/{id}")
	public Executive getSingleProduct(@PathVariable("id") Long id) {
		
			Executive c=executiveRepository.getOne(id);
			return c;
	 		
			
	}
		@PutMapping("/update/{id}")
		public Executive updateProduct(@PathVariable("id") Long id,@RequestBody Executive executiveInput ){
			
			Executive exdb=executiveRepository.getOne(id);
			exdb.setName(executiveInput.getName());
			exdb.setDepartment(executiveInput.getDepartment());
			Executive c=executiveRepository.save(exdb);	
			return c;
		}
		
		@DeleteMapping("/del-pro/{id}")
		public void deleteProduct(@PathVariable("id") Long id) {
			
			executiveRepository.deleteById(id);
			
			
			
		}
	
}
