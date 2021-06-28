package com.marks;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MarksController {
	
	   @GetMapping("/Grade")
	   @ResponseBody
	   public ModelAndView htmlView(@RequestParam(name="Physics", required=false, defaultValue="35") int physics,@RequestParam(name="Chemistry", required=false, defaultValue="35") int chemistry,@RequestParam(name="Maths", required=false, defaultValue="35") int maths,Model model)
	  {    
		   StudentMarks marks = new StudentMarks();
		   
		   	  marks.setPhy(physics);
			  marks.setChem(chemistry);
			  marks.setMaths(maths);
			 
			  marks.setTotal(marks.getPhy()+marks.getChem()+marks.getMaths());
			
			  int avg= marks.getTotal()/3;
			  
			  if (avg>=80) {
				  marks.setGrade("A");
			  }
			  else {
				     if (avg>=50&&avg<=80) 
				     {
					  marks.setGrade("B");
				        }
				  
				  else {
					  marks.setGrade("C");
				  }
			  }
	      
	        ModelAndView mav = new ModelAndView();
	        mav.addObject("marks", marks);
	        mav.setViewName("page.html");   
	        return mav;
	  }
	 
	 
	
	

}
