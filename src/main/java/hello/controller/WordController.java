package hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hello.dto.WordCheck;
import hello.service.WordService;

@RestController
@RequestMapping("/words")
public class WordController {
	// TODO Implement the /words/{word} endpoint
	public static final Logger logger = LoggerFactory.getLogger(WordController.class);
	@Autowired
	private WordService wordservice;

	@RequestMapping(value = "/{word}", method = RequestMethod.GET)
	public ResponseEntity<?> checkWord(@PathVariable("word") String word) {
		
		logger.info("WordController : checkWord called");
		WordCheck check = wordservice.is_AnagramPalindrome(word);
		return new ResponseEntity<>(check, HttpStatus.OK);
	}

}
