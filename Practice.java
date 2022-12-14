
@FindBy(xpath = "//ul[@id='menu-all-departments-1']//child::a[@title='Laptops']")
	WebElement laptopButton;
	
	@FindBy(xpath = "//i[@class='departments-menu-v2-icon fa fa-list-ul']")
	WebElement productButton;
	
	@FindBy(xpath = "//ul[@id='menu-all-departments-1']//child::a[@title='Tablet/Watches']")
	WebElement tabletButton;
	
	@FindBy(xpath = "//div[@class='product-loop-body product-item__body']//child::h2[@class='woocommerce-loop-product__title']")
	List<WebElement> tabletNames;
	
	@FindBy(xpath = "//div[@class='product-loop-body product-item__body']//child::div[@class='product-short-description']")
	List<WebElement> tabletDescription;
	
	@FindBy(xpath = "//div[@class='product-loop-footer product-item__footer']//child::span[@class='woocommerce-Price-amount amount']")
	List<WebElement> tabletPrices;s


package Quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Practice {

	public static void main(String[] args) {
		//arrayList();
		Haha();

	}
	public static void arrayList() {
		List<String> list=new ArrayList<String>(); 
		String[] Alphabets = {"aha","hahahah"};
		list.add("HAAHHAHA");
		list.add(0, "wqfawa");
		System.out.println(list);
		for(String i:Alphabets) {
			System.out.println(i);
		}
		System.out.println(Arrays.toString(Alphabets));
		 List<String> fruitList = new ArrayList<>();    
		 fruitList.add("Mango");    
		 fruitList.add("Banana");    
		 fruitList.add("Apple");    
		 fruitList.add("Strawberry"); 
		//Converting ArrayList to Array  
		 String[] array = fruitList.toArray(new String[fruitList.size()]);    
		 System.out.println("Printing Array: "+Arrays.toString(array));  
		 Collections.sort(fruitList);
		 Arrays.sort(array);
		 System.out.println(fruitList);
		 System.out.println(Arrays.toString(array));


	}
	public static void Haha() {
		String one = "Java";
		String two = "Lamguage";
	    String joinedString = one.concat(two);
	    System.out.println(joinedString);
	    System.out.println(one.compareTo(two));
	    //The method returns 0 if the string is equal to the other string. A value less than 0 is returned if the string is less than the other string (less characters) and a value greater than 0 if the string is greater than the other string (more characters).
	    System.out.println(one.indexOf('v'));
	    System.out.println(two.indexOf("uage"));
	    int size = two.length();
	    for(int i = 0; i<size; i++) {
	    	System.out.println(two.charAt(i));
	    }
	    }
	public String ReverseString(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
		    result += s.charAt(s.length() - i - 1);
		}
		return result;
	}
	public Boolean isPrime(Integer n) {
		boolean isPrime = true;
		 for (int i = n - 1; i > 1; i--) {
		     if (n % i == 0) {
		         isPrime = false;
		         break;
		     }
		 }
		 return isPrime;
	}
	public Integer fibonacci(Integer n) {
		if (n == 1) {
		    return 1;
		} else if (n == 0) {
		    return 0;
		} else {
		    return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
	public boolean isPalindrome(String word) {
		int i1 = 0;
		int i2 = word.length() - 1;
		while (i2 > i1) {
		    if (word.charAt(i1) != word.charAt(i2)) {
		        return false;
		    }
		    ++i1;
		    --i2;
		}
		return true;
	}
	public Integer largestPrimeFactor(Integer n) {
		int factor = -1;
		for (int i = 2; i * i <= n; i++) {
		    if (n == 1) { break; }
		    if (n % i != 0) { continue; }
		    factor = i;
		    while (n % i == 0) {
		        n /= i;
		    }
		}
		return n == 1 ? factor : n;
	}
}
