package com.hanin.parfum.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hanin.parfum.entities.Famille;
import com.hanin.parfum.repos.FamilleRepository;

@RestController
@RequestMapping("/api/fam")
@CrossOrigin("*")
public class FamilleRESTController {
	@Autowired
	FamilleRepository familleRepository;
	@RequestMapping(method=RequestMethod.GET)
	public List<Famille> getAllFamilles()
	{
	return familleRepository.findAll();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Famille getFamilleById(@PathVariable("id") Long id) {
	return familleRepository.findById(id).get();
	}
}
