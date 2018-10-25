package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import hello.controller.WordController;
import hello.dto.WordCheck;

@Service
public class WordService {

	public static final Logger logger = LoggerFactory.getLogger(WordController.class);

	public WordCheck is_AnagramPalindrome(String word) {

		String reverse = new StringBuffer(word).reverse().toString();
		WordCheck wordCheck = new WordCheck();
		wordCheck.setWord(word);
		// check whether the string is palindrome or not
		if (word.equals(reverse)) {
			wordCheck.setPalindrome(true);
			
		} else {
			wordCheck.setPalindrome(false);
			int oddOccur = 0;
			int[] count = new int[256];
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				count[ch]++;
			}

			for (int cnt : count) {
				if (oddOccur > 1) {
					wordCheck.setAnagramOfPalindrome(false);
					return wordCheck;
				}
				if (cnt % 2 == 1) {
					oddOccur++;
				}
			}
		}
		wordCheck.setAnagramOfPalindrome(true);
		return wordCheck;

	}

}
