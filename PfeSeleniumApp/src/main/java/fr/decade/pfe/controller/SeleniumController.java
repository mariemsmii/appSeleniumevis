package fr.decade.pfe.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.decade.pfe.quote.fils.CreateCsvFileForQuotes;
import fr.decade.pfe.test.HybrisTests;

@Controller
@RequestMapping("/")
public class SeleniumController {
	HybrisTests y123Tests = new HybrisTests();
	public static final String REDIRECT_PREFIX = "redirect:";
	private static final String REDIRECT_TEST_URL = REDIRECT_PREFIX + "/";
	@RequestMapping(method = RequestMethod.GET)
	public String showMessage() {

		return "home";
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void tstingBackSelenium(@RequestParam(value = "action", required = true) final String action) {
		ResponseEntity<String> result;
		if (action.equals("Run this Back-End test")) {
			CreateCsvFileForQuotes createCsvFileForQuotes = new CreateCsvFileForQuotes();
			createCsvFileForQuotes.createQuoteCsvFile();
			createCsvFileForQuotes.createEntriesCsvFile();
			result =runATest("backTest");
			System.out.println(result);
		} else if (action.equals("Run this Front-End test")) {
			result = runATest("frontTest");
			System.out.println(result);
		}
		//return REDIRECT_TEST_URL;

	}

	public ResponseEntity<String> runATest(@RequestParam(value = "test", defaultValue = "") String methodName) {
		try {

			// if (StringUtils.isNotBlank(methodName)) {
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
