package com.z9devs.SpringBootJPAMVCTutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.z9devs.SpringBootJPAMVCTutorial.dao.DocumentRepo;

@Controller
public class DocumentController 
{
	@Autowired
	DocumentRepo repo;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView();
		for(Document d : repo.findAll()) 
			System.out.println(d.getName());
		mv.addObject("documents", repo.findAll());
		mv.setViewName("home.jsp");
		return mv;
	}
	
	@RequestMapping("/addDocument")
	public String addDocument(Document document)
	{
		repo.save(document);
		return "redirect:/";
	}
	
	@RequestMapping("/getDocument")
	public ModelAndView getDocument(@RequestParam String name, @RequestParam String skill)
	{
		ModelAndView mv = new ModelAndView();
		//System.out.println(repo.findBySkillAndName(name, skill));
		mv.addObject("document", repo.findBySkillAndName(name, skill).get(0));
		
		mv.setViewName("singleDoc.jsp");
		return mv;
	}
	
	@RequestMapping("/document/{id}")
	@ResponseBody
	public Optional<Document> getDocData(@PathVariable("id") int id)
	{
		return repo.findById(id);
	}
	
	@RequestMapping("/documents")
	@ResponseBody
	public List<Document> getDocuments()
	{
		return repo.findAll();
	}
}
