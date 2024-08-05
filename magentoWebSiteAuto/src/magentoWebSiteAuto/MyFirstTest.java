package magentoWebSiteAuto;

	import java.time.Duration;
	import java.util.List;
	import java.util.Random;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class MyFirstTest {

		WebDriver driver = new ChromeDriver();
		Random rand = new Random();
		String myWebsite = "https://magento.softwaretestingboard.com/";
		String password = "ILoveCanada!123";
		String logOutPage = "https://magento.softwaretestingboard.com/customer/account/logout/";
		String emailAddressToLogin = "";

		@BeforeTest
		public void mySetup() {
			driver.manage().window().maximize();
			driver.get(myWebsite);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		}

		@Test(priority = 1, enabled = false/* invocationCount = 10 */) // To repeat test 10 times
		public void CreateAnAcount() {

			// by.xpath -- " // tag name [@attrubite ='value'] "
			/*
			 * WebElement websitePage=driver.findElement(By.xpath(
			 * "https://magento.softwaretestingboard.com/" )); websitePage.click();
			 */

			// by. partiallinkTest -- It is case sensitive
			/*
			 * WebElement websitePage=driver.findElement(By.partialLinkText("Account"));
			 * websitePage.click();
			 */

			// by.linkTest -- It is case sensitive
			/*
			 * WebElement websitePage =
			 * driver.findElement(By.linkText("Create an Account")); websitePage.click();
			 */

			// by.cssSelector
			WebElement websitePage = driver
					.findElement(By.cssSelector("header[class='page-header'] li:nth-child(3) a:nth-child(1)"));
			websitePage.click();

			String[] SampleFirstNames = { "Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Hannah", "Ian",
					"Judy" };
			String[] SamplelastNames = { "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson",
					"Moore", "Taylor" };
			// rand.nextInt(7); // Return random number between 0 to n-1

			int RandomIndexOfFirstName = rand.nextInt(SampleFirstNames.length);
			int RandomIndexOfLastName = rand.nextInt(SamplelastNames.length);

			System.out.println(RandomIndexOfFirstName);
			System.out.println(RandomIndexOfLastName);
			String firstName = SampleFirstNames[RandomIndexOfFirstName];
			String lastName = SamplelastNames[RandomIndexOfLastName];
			int randomNumber = rand.nextInt(9821);
			String domainName = "@gmail.com";

			WebElement firstNameInput = driver.findElement(By.id("firstname")); // we must separate between deceleration and
																				// action:"sendkeys"
			WebElement lastNameInput = driver.findElement(By.id("lastname"));
			WebElement emailAddressInput = driver.findElement(By.id("email_address"));
			WebElement passwordInput = driver.findElement(By.id("password"));
			WebElement confirmPassword = driver.findElement(By.id("password-confirmation"));
			WebElement createButton = driver.findElement(By.xpath("//button[@title='Create an Account']"));

			firstNameInput.sendKeys(firstName);
			lastNameInput.sendKeys(lastName);
			emailAddressInput.sendKeys(firstName + lastName + randomNumber + domainName);
			passwordInput.sendKeys(password);
			confirmPassword.sendKeys(password);
			createButton.click(); // we use click action with web elements
			emailAddressToLogin = firstName + lastName + randomNumber + domainName;

		}

		@Test(priority = 2, enabled = false)
		public void logOut() {

			driver.get(logOutPage);// we use .get(string) with Text

		}

		@Test(priority = 3, enabled = false)
		public void logIn() {

			WebElement logInPage = driver.findElement(By.linkText("Sign In"));
			logInPage.click();
			WebElement emailInput = driver.findElement(By.id("email"));
			emailInput.sendKeys(emailAddressToLogin);
			WebElement passwordInput = driver.findElement(By.id("pass"));
			passwordInput.sendKeys(password);

			// WebElement signInButton =driver.findElement(By.className("login"));
			// WebElement signInButton =driver.findElement(By.className("primary"));
			// error when we use .className
			// by.className must value of className without any space
			WebElement signInButton = driver.findElement(By.cssSelector(".action.login.primary"));
			signInButton.click();
		}

		@Test(priority = 4)
		public void addMenItem() {

			WebElement menSection = driver.findElement(By.cssSelector("#ui-id-5"));
			menSection.click();

			WebElement olItemContainer = driver.findElement(By.className("product-items"));
			System.out.println(olItemContainer.findElements(By.tagName("li")).size());
			List<WebElement> Items = olItemContainer.findElements(By.tagName("li"));
			int randomIndex = rand.nextInt(Items.size());
			System.out.println(randomIndex);
			Items.get(randomIndex).click();

			WebElement sizesContainer = driver.findElement(By.cssSelector(".swatch-attribute.size"));
			System.out.println(sizesContainer.findElements(By.tagName("div")));
			List<WebElement> allSize = sizesContainer.findElements(By.tagName("div"));
			int randomSizes = rand.nextInt(allSize.size());
			System.out.println(randomSizes);

			allSize.get(randomSizes).click();

			WebElement colorContainer = driver.findElement(By.xpath("//div[@class='swatch-attribute color']"));
			System.out.println(colorContainer.findElements(By.tagName("div")));
			List<WebElement> allColor = colorContainer.findElements(By.tagName("div"));
			int randomcolorSize = rand.nextInt(allColor.size());
			System.out.println(randomcolorSize);

			allColor.get(randomcolorSize).click();

		

		}

	}


