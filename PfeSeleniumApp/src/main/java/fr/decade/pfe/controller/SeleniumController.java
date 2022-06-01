package fr.decade.pfe.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.decade.pfe.quote.fils.CreateCsvFileForQuotes;
import fr.decade.pfe.test.HybrisTests;

@Controller
@RequestMapping("/")
public class SeleniumController {
	HybrisTests y123Tests = new HybrisTests();

	@RequestMapping(method = RequestMethod.GET)
	public String getTests() {

		return "home";
	}

	@RequestMapping(value = "/failedTest", method = RequestMethod.GET)
	public String getFailedFrontTest() {

		return "failedFrontTest";
	}

	@RequestMapping(value = "/failedbackTest", method = RequestMethod.GET)
	public String getFailedBackTest() {

		return "failedBackTest";
	}

	@RequestMapping(value = "/successbackTest", method = RequestMethod.GET)
	public String getsuccessBackTest() {

		return "successBackTest";
	}

	@RequestMapping(value = "/successFrontTest", method = RequestMethod.GET)
	public String getsuccessFrontTest() {

		return "successFrontTest";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String tests() {

		return "test";
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView tstingBackSelenium(@RequestParam(value = "action", required = true) final String action) {
		ResponseEntity<String> result;
		ModelAndView redirect = new ModelAndView(getsuccessBackTest());
		if (action.equals("Run Back-End test")) {
			CreateCsvFileForQuotes createCsvFileForQuotes = new CreateCsvFileForQuotes();
			createCsvFileForQuotes.createQuoteCsvFile();
			createCsvFileForQuotes.createEntriesCsvFile();
			result = runATest("backTest");
			System.out.println(result);
			System.out.println(result.getBody());
			String finalResult = result.getBody();
			if (finalResult == "Fail") {
				redirect = new ModelAndView(getFailedBackTest());
			} else {
				redirect = new ModelAndView(getsuccessBackTest());
			}
		}
		if (action.equals("Run Front-End test")) {
			result = runATest("frontTest");
			System.out.println(result);
			System.out.println(result.getBody());
			String finalResult = result.getBody();
			if (finalResult == "Fail") {
				redirect = new ModelAndView(getFailedFrontTest());
			} else {
				redirect = new ModelAndView(getsuccessFrontTest());
			}
		}
		return redirect;

	}

	public ResponseEntity<String> runATest(@RequestParam(value = "test", defaultValue = "") String methodName) {
		try {
			if (methodName == null) {
				throw new Exception("Unrecognized value: " + methodName);
			}

			Method method = y123Tests.getClass().getMethod(methodName);
			y123Tests.setUp();
			method.invoke(y123Tests);

			if (!methodName.contains("testSuiteIsOnline")) {
				y123Tests.tearDown();
			}
		} catch (InvocationTargetException e) {
			y123Tests.tearDown();
			return new ResponseEntity<>("Fail", HttpStatus.OK);
		} catch (Exception e) {
			y123Tests.tearDown();
			return new ResponseEntity<>("Fail Run from command line to find more details.", HttpStatus.OK);
		} catch (Error e) {
			y123Tests.tearDown();
			return new ResponseEntity<>("Fail Run from command line to find more details.", HttpStatus.OK);
		}
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}

}
