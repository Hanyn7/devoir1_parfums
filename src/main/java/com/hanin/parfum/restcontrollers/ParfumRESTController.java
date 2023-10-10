package com.hanin.parfum.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hanin.parfum.entities.Parfum;
import com.hanin.parfum.service.ParfumService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ParfumRESTController {
@Autowired
ParfumService parfumService;
@RequestMapping(path="all",method = RequestMethod.GET)
public List<Parfum> getAllParfums() {
return parfumService.getAllParfums();
}
@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
public Parfum getParfumById(@PathVariable("id") Long id) {
return parfumService.getParfum(id);
 }
@RequestMapping(path="/addparf",method = RequestMethod.POST)
public Parfum createParfum(@RequestBody Parfum parfumDTO) {
return parfumService.saveParfum(parfumDTO);
}
@RequestMapping(path="/updateparf",method = RequestMethod.PUT)
public Parfum updateParfum(@RequestBody Parfum parfumDTO) {
return parfumService.updateParfum(parfumDTO);
}
@RequestMapping(value="/delparf/{id}",method = RequestMethod.DELETE)
public void deleteParfum(@PathVariable("id") Long id)
{
	parfumService.deleteParfumById(id);
}
@RequestMapping(value="/fam/prodscat/{idFam}",method = RequestMethod.GET)
public List<Parfum> getParfumsByFamId(@PathVariable("idFam") Long idFam) {
return parfumService.findByFamilleIdFam(idFam);
}

@RequestMapping(value="/fam/prodsByName/{nom}",method = RequestMethod.GET)
public List<Parfum> findByNomParfumContains(@PathVariable("nom") String nom) {
return parfumService.findByNomParfumContains(nom);
}




}
