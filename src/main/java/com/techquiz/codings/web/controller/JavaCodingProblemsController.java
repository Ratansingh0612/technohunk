package com.techquiz.codings.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergisitic.it.navigation.CodingsNavigationPage;
import com.synergisitic.it.navigation.UserNavigationPage;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.web.form.UserId;
import com.techquiz.codings.service.CodingProblemsService;
import com.techquiz.codings.web.controller.vo.CodingProblemsVO;

/**
 * 
 * @author VC1
 *
 */
@Controller
@RequestMapping("/codings")
public class JavaCodingProblemsController {
	
	@Autowired
	private CodingProblemsService codingProblemService; 
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/java/diamond-pattern-problem")
	public String diamondPatternProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.DIAMOND_PATTERN_PROBLEM_PAGE;
	}
	
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/java/string-reverse")
	public String javaStringReverse(Model model){
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.STRING_REVERSE_PAGE;
	}
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/java/factorial-num")
	public String factorialNum(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FACTORIAL_NUM_PAGE;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/java/count-number-words-string")
	public String countNumberWordsString(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.COUNT_NUMBER_WORDS_STRING_PAGE;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/java/menu-choice-pattern")
	public String menuChoicePattern(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.MENU_CHOICE_PATTERN_PAGE;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/java/voting-system-app")
	public String votingSystemApp(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.VOTING_SYSTEM_APP_PAGE;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/java/find-longest-pattern")
	public String findLongestPattern(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIND_LONGEST_PATTERN_PAGE;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/java/happy-number")
	public String happyNumberProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.HAPPY_NUMBER_PATTERN_PAGE;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/java/armstrong-number")
	public String armstrongNumberProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.ARMSTRONG_NUMBER_PATTERN_PAGE;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/java/loop-special-pattern")
	public String loopSpecialPatternProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.LOOP_SPECIAL_PATTERN_PAGE;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/java/pangrams-problem")
	public String pangramsProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.PANGRAMS_PROBLEM_PAGE;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/java/tringle-pattern-problem")
	public String tringlePatternProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.TRINGLE_PATTERN_PROBLEM_PAGE;
	}
	
	
	/**
	 * pairs of elements in an array whose sum
	 * @param model
	 * @return
	 */
	@GetMapping("/java/pairs-array-whose-sum")
	public String pairsArrayWhoseSum(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.PAIRS_ARRAY_WHOSE_SUM_PAGE;
	}
	
	@GetMapping("/java/decimal-to-binary-using-stack")
	public String decimalToBinaryUsingStack(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.DECIMAL_TO_BINARY_USING_STACK_PAGE;
	}
	
	@GetMapping("/java/word-multiple-problem")
	public String wordMultipleProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.WORD_MULTIPLE_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/first-repeated-non-repeated-character-in-string")
	public String firstRepeatedNonRepeatedCharacterInString(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIRST_REPEATED_NON_REPEATED_CHARACTER_IN_STRING_PAGE;
	}
	
	@GetMapping("/java/longest-palindrome-in-string")
	public String longestPalindromeInString(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.LONGEST_PALINDROME_IN_STRING_PAGE;
	}
	
	@GetMapping("/java/print-all-permutation-of-string")
	public String printAllPermutationOfString(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.PRINT_ALL_PERMUTATION_OF_STRING_PAGE;
	}
	
	@GetMapping("/java/check-string-all-unique-characters")
	public String checkStringAllUniqueCharacters(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.CHECK_STRING_ALL_UNIQUE_CHARACTERS_PAGE;
	}
	
	@GetMapping("/java/find-top-two-max-nums-int-array")
	public String findTopTwoMaxNumsIntArray(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIND_TOP_TWO_MAX_NUMS_INT_ARRAY_PAGE;
	}
	
	@GetMapping("/java/fizz-buzz-problem")
	public String fizzBuzzProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIZZ_BUZZ_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/string-contains-valid-parentheses")
	public String stringContainsValidParentheses(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.STRING_CONTAINS_VALID_PARENTHESES_PAGE;
	}
	
	@GetMapping("/java/leap-year-problem")
	public String leapYearProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.LEAP_YEAR_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/pairs-array-whose-difference")
	public String pairsArrayWhoseDifference(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.PAIRS_ARRAY_WHOSE_DIFFERENCE_PAGE;
	}
	
	
	@GetMapping("/java/find-longest-substring-without-repeated-chars")
	public String findLongestSubstringWithoutRepeatedChars(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIND_LONGEST_SUBSTRING_WITHOUT_REPEATED_CHARS_PAGE;
	}
	
	@GetMapping("/java/separate-digits-letters-special-char-code")
	public String separateDigitsLettersSpecialCharCode(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.SEPARATE_DIGITS_LETTERS_SPECIAL_CHAR_PAGE;
	}
	
	
	@GetMapping("/java/word-ladder-problem")
	public String wordLadderProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.WORD_LADDER_PROBLEM_PAGE;
	}
	
	
	@GetMapping("/java/string-reverse-using-recursion")
	public String stringReverseUsingRecursion(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.STRING_REVERSE_USING_RECURSION_PAGE;
	}
	
	@GetMapping("/java/check-string-seven-digit-number")
	public String checkStringSevenDigitNumber(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.CHECK_STRING_SEVEN_DIGIT_NUMBER_PAGE;
	}
	
	@GetMapping("/java/run-length-encoding-problem")
	public String runLengthEncodingProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.RUN_LENGTH_ENCODING_PROBLEM_PAGE;
	}
	
	
	@GetMapping("/java/string-index-problem")
	public String stringIndexProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.STRING_INDEX_PROBLEM_PAGE;
	}
	
	
	@GetMapping("/java/string-rotation-problem")
	public String stringRotationProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.STRING_ROTATION_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/find-uncommon-characters-of-two-strings")
	public String findUncommonCharactersOfTwoStrings(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIND_UNCOMMON_CHARACTERS_OF_TWO_STRINGS_PAGE;
	}
	
	
	@GetMapping("/java/missing-number-in-array")
	public String missingNumberInArray(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.MISSING_NUMBER_IN_ARRAY_PAGE;
	}
	
	@GetMapping("/java/count-number-of-unival-subtrees-binary-tree")
	public String countNumberOfUnivalSubtreesBinaryTree(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.COUNT_NUMBER_OF_UNIVAL_SUBTREES_BINARY_TREE_PAGE;
	}
	
	
	@GetMapping("/java/singly-linked-list-implementation")
	public String singlyLinkedListImplementation(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.SINGLY_LINKED_LIST_IMPLEMENTATION_PAGE;
	}
	
	
	@GetMapping("/java/reverse-linked-list-problem")
	public String reverseLinkedListProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.REVERSE_LINKED_LIST_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/find-linked-list-circular-or-not")
	public String findLinkedListCircularOrNot(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIND_LINKED_LIST_CIRCULAR_OR_NOT_PAGE;
	}
	
	@GetMapping("/java/program-to-sort-string-using-insertion-sort")
	public String programToSortStringUsingInsertionSort(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.PROGRAM_TO_SORT_STRING_USING_INSERTION_SORT_PAGE;
	}
	
	
	@GetMapping("/java/write-custom-array-list")
	public String writeCustomArrayList(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.WRITE_CUSTOM_ARRAY_LIST_PAGE;
	}
	
	
	@GetMapping("/java/find-sum-of-all-elements-above-diagonal-in-matrix")
	public String findSumOfAllElementsAboveDiagonalinMatrix(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIND_SUM_OF_ALL_ELEMENTS_ABOVE_DIAGONAL_IN_MATRIX_PAGE;
	}
	
	
	@GetMapping("/java/find-sum-of-all-elements-below-diagonal-in-matrix")
	public String findSumOfAllElementsBelowDiagonalinMatrix(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIND_SUM_OF_ALL_ELEMENTS_BELOW_DIAGONAL_IN_MATRIX_PAGE;
	}
	
	@GetMapping("/java/find-sum-of-both-diagonals-in-matrix")
	public String findSumOfBothDiagonalsInMatrix(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIND_SUM_OF_BOTH_DIAGONALS_IN_MATRIX_PAGE;
	}
	
	
	@GetMapping("/java/find-sum-of-lower-triangle-in-matrix")
	public String findSumOfLowerTriangleInMatrix(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIND_SUM_OF_LOWER_TRIANGLE_IN_MATRIX_PAGE;
	}
	
	@GetMapping("/java/find-sum-of-upper-triangle-in-matrix")
	public String findSumOfUpperTriangleInMatrix(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIND_SUM_OF_UPPER_TRIANGLE_IN_MATRIX_PAGE;
	}
	
	@GetMapping("/java/sort-array-using-quick-sort")
	public String sortArrayUsingQuickSort(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.SORT_ARRAY_USING_QUICK_SORT_PAGE;
	}
	
	
	@GetMapping("/java/pattern-pascal-tringle")
	public String patternPascalTringle(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.PATTERN_PASCAL_TRINGLE_PAGE;
	}
	
	@GetMapping("/java/special-piramid-tringle-pattern")
	public String specialPiramidTringlePattern(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.SPECIAL_PIRAMID_TRINGLE_PATTERN_PAGE;
	}
	
	@GetMapping("/java/program-sort-string-bubble-sort")
	public String programSortStringBubbleSort(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.PROGRAM_SORT_STRING_BUBBLE_SORT_PAGE;
	}
	
	@GetMapping("/java/program-sort-string-selection-sort")
	public String programSortStringSelectionSort(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.PROGRAM_SORT_STRING_SELECTION_SORT_PAGE;
	}
	
	
	
	@GetMapping("/java/find-number-power-of-two")
	public String findNumberPowerOfTwo(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIND_NUMBER_POWER_OF_TWO_PAGE;
	}
	
	
	@GetMapping("/java/hockey-stick-pattern")
	public String hockeyStickPattern(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.HOCKEY_STICK_PATTERN_PAGE;
	}
	
	
	
	@GetMapping("/java/print-elements-matrix-in-diagonal-order")
	public String printElementsMatrixInDiagonalOrder(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.PRINT_ELEMENTS_MATRIX_IN_DIAGONAL_ORDER_PAGE;
	}
	
	
	
	@GetMapping("/java/special-u-pattern-problem")
	public String specialUpatternProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.SPECIAL_U_PATTERN_PROBLEM_PAGE;
	}
	
	
	@GetMapping("/java/count-vowels-in-string")
	public String countVowelsInString(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.COUNT_VOWELS_IN_STRING_PAGE;
	}
	
	@GetMapping("/java/string-valid-password-problem")
	public String stringValidPasswordProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.STRING_VALID_PASSWORD_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/simple-symbols-problem")
	public String simpleSymbolsProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.SIMPLE_SYMBOLS_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/power-of-2triangle-pattern")
	public String powerOf2TrianglePattern(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.POWER_OF_2TRIANGLE_PATTERN_PAGE;
	}
	
	@GetMapping("/java/implement-singleton-design-pattern-threading")
	public String implementSingletonDesignPatternThreading(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.IMPLEMENT_SINGLETON_DESIGN_PATTERN_THREADING_PAGE;
	}
	
	@GetMapping("/java/implement-own-comparator")
	public String implementOwnComparator(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.IMPLEMENT_OWN_COMPARATOR_PAGE;
	}
	
	@GetMapping("/java/program-to-find-occurrence-of-string")
	public String programFindOccurrenceOfString(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.PROGRAM_TO_FIND_OCCURRENCE_OF_STRING_PAGE;
	}
	
	@GetMapping("/java/kth-last-element-of-singly-linked-list")
	public String kthLastElementOfSinglyLinkedList(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.KTH_LAST_ELEMENT_OF_SINGLY_LINKED_LIST_PAGE;
	}
	
	
	@GetMapping("/java/find-smallest-largest-num-from-array")
	public String findSmallestLargestNumFromArray(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIND_SMALLEST_LARGEST_NUM_FROM_ARRAY_PAGE;
	}
	
	@GetMapping("/java/check-number-is-prime-or-not")
	public String checkNumberIsPrimeOrNot(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.CHECK_NUMBER_IS_PRIME_OR_NOT_PAGE;
	}
	
	@GetMapping("/java/remove-duplicate-chars-from-string")
	public String removeDuplicateCharsFromString(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.REMOVE_DUPLICATE_CHARS_FROM_STRING_PAGE;
	}
	
	
	@GetMapping("/java/check-string-is-valid-shuffle-of-two-string")
	public String checkStringIsValidShuffleOfTwoString(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.CHECK_NUMBER_IS_PRIME_OR_NOT_PAGE;
	}
	
	//################## New coding problems
	@GetMapping("/java/longest-word-in-string")
	public String longestWordInString(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.LONGEST_WORDIN_STRING_PAGE;
	}
	
	@GetMapping("/java/reduce-fraction-problem")
	public String reduceFractionProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.REDUCE_FRACTION_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/find-initial-10-prime-numbers")
	public String findInitial10PrimeNumbers(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIND_INITIAL_10_PRIME_NUMBERS_PAGE;
	}
	
	@GetMapping("/java/sum-of-all-prime-numbers-between")
	public String sumOfAllPrimeNumbersBetween(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.SUM_OF_ALL_PRIME_NUMBERS_BETWEEN_PAGE;
	}
	
	@GetMapping("/java/move-zeros-to-end")
	public String movZerosToEnd(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.MOVE_ZEROS_TO_END_PAGE;
	}
	
	@GetMapping("/java/correct-path-problem")
	public String correctPathProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.CORRECT_PATH_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/pentagonal-number-problem")
	public String pentagonalNumberProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.PENTAGONAL_NUMBER_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/kaprekars-constant-problem")
	public String kaprekarsConstantProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.KAPREKARS_CONSTANT_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/alphabet-soup-problem")
	public String alphabetSoupProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.ALPHABET_SOUP_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/delete-alternate-characters")
	public String deleteAlternateCharacters(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.DELETE_ALTERNATE_CHARACTERS_PAGE;
	}
	
	@GetMapping("/java/angle-between-hour-minute")
	public String angleBetweenHourMinute(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.ANGLE_BETWEEN_HOUR_MINUTE_PAGE;
	}
	
	@GetMapping("/java/find-all-the-leaders-in-integer-array")
	public String findAllTheLeadersInIntegerArray(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIND_ALL_THE_LEADERS_IN_INTEGER_ARRAY_PAGE;
	}
	
	@GetMapping("/java/reverse-each-word-of-string")
	public String reverseEachWordOfString(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.REVERSE_EACH_WORD_OF_STRING_PAGE;
	}
	
	@GetMapping("/java/reverse-string-preserving-position-spaces")
	public String reverseStringPreservingPositionSpaces(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.REVERSE_STRING_PRESERVING_POSITION_SPACES_PAGE;
	}
	
	@GetMapping("/java/roman-equivalent-of-decimal-number")
	public String romanEquivalentOfDecimalNumber(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.ROMAN_EQUIVALENT_OF_DECIMAL_NUMBER_PAGE;
	}
	
	@GetMapping("/java/count-square-problem")
	public String countSquareProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.COUNT_SQUARE_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/swap-two-string-without-third-variable")
	public String swapTwoStringWithoutThirdVariable(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.SWAP_TWO_STRING_WITHOUT_THIRD_VARIABLE_PAGE;
	}
	
	@GetMapping("/java/divisors-problem")
	public String divisorsProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.DIVISORS_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/gcd-of-two-numbers")
	public String gcdofTwoNumbers(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.GCD_OF_TWO_NUMBERS_PAGE;
	}
	
	
	
	
	@GetMapping("/java/finding-square-problem")
	public String findSquareProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FINDING_SQUARE_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/split-string-into-fibonacci-sequence")
	public String splitStringIntoFibonacciSequence(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.SPLIT_STRING_INTO_FIBONACCI_SEQUENCE_PAGE;
	}
	
	@GetMapping("/java/number-belongs-to-fibonacci-series-or-not")
	public String numberBelongsToFibonacciSeriesOrNot(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.NUMBER_BELONGS_TO_FIBONACCI_SERIES_OR_NO_PAGE;
	}
	
	@GetMapping("/java/how-to-find-largest-number-less-than-a-given-number")
	public String howtoFindLargestNumberLessThanaGivenNumber(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.HOW_TO_FIND_LARGEST_NUMBER_LESS_THAN_A_GIVEN_NUMBER_PAGE;
	}
	
	@GetMapping("/java/find-sum-of-all-digit-of-number")
	public String findSumOfAllDigitOfNumber(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIND_SUM_OF_ALL_DIGIT_OF_NUMBER_PAGE;
	}
	
	@GetMapping("/java/find-out-number-is-perfect-or-not")
	public String findOutNumberIsPerfectOrNot(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIND_OUT_NUMBER_IS_PERFECT_OR_NOT_PAGE;
	}
	
	@GetMapping("/java/find-number-is-odd-or-even-without-modulus-operator")
	public String findNnumberIsOddOrEvenWithoutModulusOperator(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIND_NUMBER_IS_ODD_OR_EVEN_WITHOUT_MODULUS_OPERATOR_PAGE;
	}
	
	@GetMapping("/java/binary-to-decimal-conversion")
	public String binaryToDecimalConversion(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.BINARY_TO_DECIMAL_CONVERSION_PAGE;
	}
	
	@GetMapping("/java/own-code-to-implement-stack")
	public String ownCodeToImplementStack(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.OWN_CODE_TO_IMPLEMENT_STACK_PAGE;
	}
	
	@GetMapping("/java/median-of-two-sorted-arrays")
	public String medianOfTwoSortedArrays(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.MEDIAN_OF_TWO_SORTED_ARRAYS_PAGE;
	}
	
	@GetMapping("/java/longest-substring-contains-2-unique-chars")
	public String longestSubstringContains2UniqueChars(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.LONGEST_SUBSTRING_CONTAINS_2_UNIQUE_CHARS_PAGE;
	}
	
	@GetMapping("/java/longest-consecutive-sequence")
	public String longestConsecutiveSequence(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.LONGEST_CONSECUTIVE_SEQUENCE_PAGE;
	}
	
	@GetMapping("/java/minimum-window-substring")
	public String minimumWindowSubstring(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.MINIMUM_WINDOW_SUBSTRING_PAGE;
	}
	
	
	@GetMapping("/java/bulls-and-cows-game")
	public String bullsAndCowsGame(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.BULLS_AND_COWS_GAME_PAGE;
	}
	
	@GetMapping("/java/multiply-strings-problem")
	public String multiplyStringsProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.MULTIPLY_STRINGS_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/bulb-switcher-problem")
	public String bulbSwitcherProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.BULB_SWITCHER_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/longest-valid-parentheses")
	public String longestValidParentheses(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.LONGEST_VALID_PARENTHESES_PAGE;
	}
	
	@GetMapping("/java/perfect-squares-problem")
	public String perfectSquaresProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.PERFECT_SQUARES_PROBLEM_PAGE;
	}
	
	
	@GetMapping("/java/print-all-possible-strings-that-can-be-made-by-placing-spaces")
	public String printAllPossibleStringsThatCanBeMadeByPlacingSpaces(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.PRINT_ALL_POSSIBLE_STRINGS_THAT_CAN_BE_MADE_BY_PLACING_SPACES_PAGE;
	}
	
	@GetMapping("/java/find-politeness-of-a-number")
	public String findPolitenessOfANumber(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIND_POLITENESS_OF_A_NUMBER_PAGE;
	}
	
	@GetMapping("/java/concatenate-two-strings-lexically")
	public String concatenateTwoStringsLexically(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.CONCATENATE_TWO_STRINGS_LEXICALLY_PAGE;
	}
	
	@GetMapping("/java/lexicographical-concat-of-all-substrings-of-string")
	public String lexicographicalConcatOfAllSubstringsOfString(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.LEXICOGRAPHICAL_CONCAT_OF_ALL_SUBSTRINGS_OF_STRING_PAGE;
	}
	
	
	@GetMapping("/java/generate-all-rotations-of-given-string")
	public String generateAllRotationsOfGivenString(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.GENERATE_ALL_ROTATIONS_OF_GIVEN_STRING_PAGE;
	}
	
	
	@GetMapping("/java/perfect-reversible-string")
	public String perfectReversibleString(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.PERFECT_REVERSIBLE_STRING_PAGE;
	}
	
	
	@GetMapping("/java/angry-children-problem")
	public String angrChildrenProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.ANGRY_CHILDREN_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/save-prisoner-problem")
	public String savePrisonerProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.SAVE_PRISONER_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/funnel-strings-problem")
	public String funnelStringsProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FUNNEL_STRINGS_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/tally-program-problem")
	public String tallyProgramProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.TALLY_PROGRAM_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/angry-professor-problem")
	public String angryProfessorProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.ANGRY_PROFESSOR_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/puzzle-problem")
	public String puzzleProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.PUZZLE_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/staircase-problem")
	public String staircaseProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.STAIRCASE_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/find-longest-increasing-subsequence")
	public String findLongestIncreasingSubsequence(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIND_LONGEST_INCREASING_SUBSEQUENCE_PAGE;
	}
	
	@GetMapping("/java/is-possible-problem")
	public String isPossibleProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.IS_POSSIBLE_PROBLEM_PAGE;
	}
	
	
	@GetMapping("/java/very-special-multiple-problem")
	public String verySpecialMultipleProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.VERY_SPECIAL_MULTIPLE_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/find-continuous-sequence-with-largest-sum")
	public String findContinuousSequenceWithLargestSum(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIND_CONTINUOUS_SEQUENCE_WITH_LARGEST_SUM_PAGE;
	}
	
	@GetMapping("/java/find-interleavings-of-two-strings")
	public String findInterleavingsOfTwoStrings(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIND_INTERLEAVINGS_OF_TWO_STRINGS_PAGE;
	}
	
	@GetMapping("/java/lexicographic-rank-of-string")
	public String lexicographicRankOfString(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.LEXICOGRAPHIC_RANK_OF_STRING_PAGE;
	}
	
	@GetMapping("/java/help-nobita-problem")
	public String helpNobitaProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.HELP_NOBITA_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/set-bits-problem")
	public String setBitsProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.SET_BITS_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/cube-root-problem")
	public String cubeRootProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.CUBE_ROOT_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/painter-partition-problem")
	public String painterPartitionProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.PAINTER_PARTITION_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/find-indices-of-max-sum-subarray")
	public String findIndicesOfMaxSumSubarray(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIND_INDICES_OF_MAX_SUM_SUBARRAY_PAGE;
	}
	
	@GetMapping("/java/print-maximum-sum-subarray")
	public String printMaximumSumSubarray(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.PRINT_MAXIMUM_SUM_SUBARRAY_PAGE;
	}
	
	@GetMapping("/java/two-sum-problem-in-linear-time")
	public String twoSumProblemInLinearTime(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.TWO_SUM_PROBLEM_IN_LINEAR_TIME_PAGE;
	}
	
	@GetMapping("/java/longest-consecutive-sequence-in-linear-time")
	public String longestConsecutiveSequenceInLinearTime(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.LONGEST_CONSECUTIVE_SEQUENCE_IN_LINEAR_TIME_PAGE;
	}
	
	@GetMapping("/java/search-insert-position-problem")
	public String searchInsertPositionProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.SEARCH_INSERT_POSITION_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/hamming-distance-problem")
	public String hammingDistanceProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.HAMMING_DISTANCE_PROBLEM_PAGE;
				
	}
	
	@GetMapping("/java/intersection-of-two-arrays")
	public String intersectionOfTwoArrays(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.INTERSECTION_OF_TWO_ARRAYS_PAGE;
	}
	
	
	@GetMapping("/java/jump-game-problem")
	public String jumpGameProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.JUMP_GAME_PROBLEM_PAGE;
	}
	
	

	@GetMapping("/java/add-digits-problem")
	public String addDigitsProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.ADD_DIGITS_PROBLEM_PAGE;
	}
	

	@GetMapping("/java/sum-of-two-integers")
	public String sumofTwoIntegers(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.SUM_OF_TWO_INTEGERS_PAGE;
	}
	

	@GetMapping("/java/single-number-problem")
	public String singleNumberProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.SINGLE_NUMBER_PROBLEM_PAGE;
	}
	
	
	@GetMapping("/java/maximum-product-subarray")
	public String maximumProductSubarray(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.MAXIMUM_PRODUCT_SUBARRAY_PAGE;
	}
	
	
	@GetMapping("/java/maximum-gap-problem")
	public String MaxGapProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.MAXIMUM_GAP_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/maximum-circular-subarray-sum")
	public String maximumCircularSubarraySum(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.MAXIMUM_CIRCULAR_SUBARRAY_SUM_PAGE;
	}
	
	@GetMapping("/java/program-to-find-hidden-number")
	public String programToFindHiddenNumber(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.PROGRAM_TO_FIND_HIDDEN_NUMBER_PAGE;
	}
	
	@GetMapping("/java/excel-sheet-column-title-problem")
	public String excelSheetColumnTitle(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.EXCEL_SHEET_COLUMN_TITLE_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/majority-element-problem")
	public String majorityElementProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.MAJORITY_ELEMENT_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/largest-number-problem")
	public String largestNumberProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.LARGEST_NUMBER_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/length-of-last-word")
	public String lengthOfLastWord(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.LENGTH_OF_LAST_WORD_PAGE;
	}
	
	@GetMapping("/java/kth-permutation-sequence")
	public String kthPermutationSequence(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.KTH_PERMUTATION_SEQUENCE_PAGE;
	}
	
	@GetMapping("/java/sort-colors-problem")
	public String sortColorsProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.SORT_COLORS_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/scramble-string")
	public String scrambleString(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.SCRAMBLE_STRING_PAGE;
	}
	
	@GetMapping("/java/grading-students")
	public String gradingStudents(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.GRADING_STUDENTS_PAGE;
	}
	
	
	@GetMapping("/java/super-egg-drop-problem")
	public String superEggDropProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.SUPER_EGG_DROP_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/buddy-strings")
	public String buddystrings(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.BUDDY_STRINGS_PAGE;
	}
	
	@GetMapping("/java/koko-eating-bananas")
	public String kokoEatingBananas(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.KOKO_EATING_BANANAS_PAGE;
	}
	
	@GetMapping("/java/kangaroo-problem")
	public String kangarooProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.KANGAROO_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/stone-game")
	public String stoneGame(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.STONE_GAME_PAGE;
	}
	
	
	@GetMapping("/java/boats-to-save-people")
	public String boatsToSavePeople(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.BOATS_TO_SAVE_PEOPLE_PAGE;
	}
	
	@GetMapping("/java/friends-of-appropriate-ages")
	public String friendsOfAppropriateAges(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FRIENDS_OF_APPROPRIATE_AGES_PAGE;
	}
	
	
	@GetMapping("/java/unique-letter-string")
	public String uniqueLetterString(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.UNIQUE_LETTER_STRING_PAGE;
	}
	
	
	@GetMapping("/java/consecutive-numbers-sum")
	public String consecutiveNumbersSum(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.CONSECUTIVE_NUMBERS_SUM_PAGE;
	}
	

	@GetMapping("/java/hand-of-straights")
	public String handOfStraights(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.HAND_OF_STRAIGHTS_PAGE;
	}
	
	@GetMapping("/java/jewels-and-stones")
	public String JewelsAndStones(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.JEWELS_AND_STONES_PAGE;
	}
	
	
	@GetMapping("/java/rotate-string-problem")
	public String rotateStringProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.ROTATE_STRING_PROBLEM_PAGE;
	}
	

	@GetMapping("/java/house-robber-problem")
	public String houseRobberProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.HOUSE_ROBBER_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/gas-station")
	public String gasStation(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.GAS_STATION_PAGE;
	}
	
	
	@GetMapping("/java/candy-problem")
	public String candyProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.CANDY_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/integer-to-english-words")
	public String integerToEnglishWords(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.INTEGER_TO_ENGLISH_WORDS_PAGE;
	}
	
	
	@GetMapping("/java/reverse-only-letters")
	public String reverseOnlyLetters(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.REVERSE_ONLY_LETTERS_PAGE;
	}
	
	

	@GetMapping("/java/reverse-vowels-of-a-string")
	public String reverseVowelsOfString(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.REVERSE_VOWELS_OF_STRING_PAGE;
	}
	
	@GetMapping("/java/student-attendance-record")
	public String studentAttendanceRecord(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.STUDENT_ATTENDANCE_RECORD_PAGE;
	}
	
	
	@GetMapping("/java/longest-common-prefix")
	public String longestCommonPrefix(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.LONGEST_COMMON_PREFIX_PAGE;
	}
	
	@GetMapping("/java/delete-operation-for-two-strings")
	public String deleteOperationTwoStrings(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.DELETE_OPERATION_FOR_TWO_STRINGS_PAGE;
	}
	
	@GetMapping("/java/product-of-array-except-self")
	public String productofArrayExceptSelf(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.PRODUCT_OF_ARRAY_EXCEPT_SELF_PAGE;
	}
	
	@GetMapping("/java/wiggle-sort")
	public String wiggleSort(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.WIGGLE_SORT_PAGE;
	}
	
	@GetMapping("/java/word-break-problem")
	public String wordBreakProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.WORD_BREAK_PROBLEM_PAGE;
	}
	
	
	@GetMapping("/java/find-peak-element")
	public String findPickElement(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIND_PEAK_ELEMENT_PAGE;
	}
	
	
	@GetMapping("/java/coin-change-problem")
	public String coinChangeProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.COIN_CHANGE_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/unique-paths-problem")
	public String uniquePathsProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.UNIQUE_PATHS_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/pancake-sorting")
	public String pancakeSorting(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.PANCAKE_SORTING_PAGE;
	}
	
	@GetMapping("/java/decode-string")
	public String decodeString(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.DECODE_STRING_PAGE;
	}
	
	@GetMapping("/java/remove-k-digits")
	public String removekDigits(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.REMOVE_K_DIGITS_PAGE;
	}
	
	@GetMapping("/java/one32-pattern")
	public String one32Pattern(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.ONE32_PATTERN_PAGE;
	}
	
	@GetMapping("/java/baseball-game")
	public String baseballGame(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.BASEBALL_GAME_PAGE;
	}
	
	@GetMapping("/java/number-of-atoms")
	public String numberOfAtoms(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.NUMBER_OF_ATOMS_PAGE;
	}
	
	
	@GetMapping("/java/asteroid-collision")
	public String asteroidCollision(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.ASTEROID_COLLISION_PAGE;
	}
	
	@GetMapping("/java/minimum-add-to-make-parentheses-valid")
	public String minimumAddToMakeParenthesesValid(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.MINIMUM_ADD_TO_MAKE_PARENTHESES_VALID_PAGE;
	}
	
	@GetMapping("/java/validate-stack-sequences")
	public String validateStackSequences(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.VALIDATE_STACK_SEQUENCES_PAGE;
	}
	
	@GetMapping("/java/water-and-jug-problem")
	public String waterAndJugProblem(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.WATER_AND_JUG_PROBLEM_PAGE;
	}
	
	@GetMapping("/java/ugly-number")
	public String uglyNumber(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.UGLY_NUMBER_PAGE;
	}
	
	@GetMapping("/java/counting-bits")
	public String countingBits(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.COUNTING_BITS_PAGE;
	}
	
	@GetMapping("/java/integer-break")
	public String integerBreak(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.INTEGER_BREAK_PAGE;
	}
	
	@GetMapping("/java/wiggle-subsequence")
	public String wiggleSubsequence(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.WIGGLE_SUBSEQUENCE_PAGE;
	}
	
	@GetMapping("/java/frog-jump")
	public String frogJump(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FROG_JUMP_PAGE;
	}
	
	@GetMapping("/java/predict-the-winner")
	public String predictTheWinner(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.PREDICT_THE_WINNER_PAGE;
	}
	
	@GetMapping("/java/palindromic-substrings")
	public String palindromicSubstrings(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.PALINDROMIC_SUBSTRINGS_PAGE;
	}
	
	@GetMapping("/java/drawing-book")
	public String drawingBook(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.DRAWING_BOOK_PAGE;
	}
	
	@GetMapping("/java/sock-merchant")
	public String sockMerchant(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.SOCK_MERCHANT_PAGE;
	}
	
	@GetMapping("/java/mini-max-sum")
	public String miniMaxSum(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.MINI_MAX_SUM_PAGE;
	}
	
	@GetMapping("/java/a-very-big-sum")
	public String aVeryBigSum(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.A_VERY_BIG_SUM_PAGE;
	}
	
	
	@GetMapping("/java/dota2-senate")
	public String dota2Senate(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.DOTA2_SENATE_PAGE;
	}
	
	@GetMapping("/java/bag-of-tokens")
	public String bagOfTokens(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.BAG_OF_TOKENS_PAGE;
	}
	
	@GetMapping("/java/birthday-cake-candles")
	public String birthdayCakeCandles(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.BIRTHDAY_CAKE_CANDLES_PAGE;
	}
	
	@GetMapping("/java/time-conversion")
	public String timeConversion(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.TIME_CONVERSION_PAGE;
	}
	
	@GetMapping("/java/birthday-chocolate")
	public String birthdayChocolate(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.BIRTHDAY_CHOCOLATE_PAGE;
	}
	
	
	@GetMapping("/java/divisible-sum-pairs")
	public String divisibleSumPairs(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.DIVISIBLE_SUM_PAIRS_PAGE;
	}
	
	@GetMapping("/java/migratory-birds")
	public String migratoryBirds(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.MIGRATORY_BIRDS_PAGE;
	}
	
	@GetMapping("/java/day-of-the-programmer")
	public String dayoftheProgrammer(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.DAY_OF_THE_PROGRAMMER_PAGE;
	}
	
	@GetMapping("/java/find-k-closest-elements")
	public String findkClosestElements(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.FIND_K_CLOSEST_ELEMENTS_PAGE;
	}
	
	@GetMapping("/java/delete-and-earn")
	public String deleteAndEarn(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.DELETE_AND_EARN_PAGE;
	}
	
	@GetMapping("/java/maximum-swap")
	public String maximumSwap(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.MAXIMUM_SWAP_PAGE;
	}
	
	@GetMapping("/java/rabbits-in-forest")
	public String rabbitsInForest(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.JAVA+ CodingsNavigationPage.RABBITS_IN_FOREST_PAGE;
	}
	
	
	
	/**
	 * 
	 * @param problemId
	 * @param session
	 * @param model
	 */
	private void loadCodingProblemData(long problemId,HttpSession session,Model model){
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		String sproblemId="";
		if(problemId==0){
			sproblemId=userId.getProblemId();
		}else{
			sproblemId=""+problemId;
		}
		CodingProblemsVO codingProblemsVO=codingProblemService.findCodingProblemsByProbId(Long.parseLong(sproblemId));
		model.addAttribute("codingProblemsVO",codingProblemsVO);
		model.addAttribute("item",codingProblemsVO);
	}

}
