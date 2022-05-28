package fr.decade.pfe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.decade.pfe.quote.fils.CreateCsvFileForQuotes;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SeleniumController {
	@GetMapping("/")
	public String tstingSelenium(HttpServletRequest request, @RequestParam(value = "action", required = true)
	 String action) {
		if (request.getParameter("action") != null) {
			CreateCsvFileForQuotes createCsvFileForQuotes = new CreateCsvFileForQuotes();
			createCsvFileForQuotes.createQuoteCsvFile();
			createCsvFileForQuotes.createEntriesCsvFile();
		}
		return "home";
		
	}
	

}
