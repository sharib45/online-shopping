package net.kzn.onlineshopping.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class PageController {
	
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("greeting","Welcome to spring MVC");
		
	
		return mv;				
	}
	
	
	/*@RequestMapping(value ="/test")
public ModelAndView test(@RequestParam(value="greeting",required=false)String greting) {
	if(greting==null) {
		greting="null greting";	
		
	}
	ModelAndView mv = new ModelAndView("page");		
	mv.addObject("greeting",greting);
	return mv;			
	
}
	@RequestMapping(value ="/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting")String greting) {
	if(greting==null) {
			greting="null greting";	
			
		}
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("greeting",greting);
		return mv;			
		
	}*/

}
