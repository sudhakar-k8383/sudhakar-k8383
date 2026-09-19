package com.omrbranch.utility;

	import java.io.File;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Set;

	import org.apache.commons.io.FileUtils;
	import org.jspecify.annotations.Nullable;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class BaseClass{
		
		public static WebDriver driver;
		Select select;
		TakesScreenshot takesScreenshot;
		Actions actions;
		Alert alert;
		
		
		//1. Launch Chrome Browser
		
		public static void browserLaunch() {
		driver = new ChromeDriver();
		}
		
		//4. Enter URL
		
		public static void enterApplicationUrl(String url) {
		driver.get(url);
		}
		
		//5. Maximize WIndow
		
		public static void maximizeWindow() {
		driver.manage().window().maximize();
		}
		
		//6. Insert Value in TextBox
		
		public void sendKeysElement(WebElement element, String data) {
		visibilityOfElement(element);
		if (isEnabledElement(element) && isDisplayedElement(element)) {
		clearTextBoxElement(element);
		element.sendKeys(data);
		}
		}
		
		//7. Click
		
		public void clickElement(WebElement element) {
		visibilityOfElement(element);
		if (isEnabledElement(element) && isDisplayedElement(element)) {
		element.click();
		}
		}

		//8. Click Cancel in Alert
		
			public void dismissAlert() {
			alert = driver.switchTo().alert();
			alert.dismiss();
			}
			
			//9. Click OK in Alert
			
			public void acceptAlert() {
			alert = driver.switchTo().alert();
			alert.accept();
			}
			
			//10. Get the Inserted Value Form Text 
			public String getTextFromText(WebElement element) {
				String text = element.getText();
				return text;
			}
			
			//11. Get the Inserted Value From Textbox
			
			public String getDomPropertyValue(WebElement element) {
			String domProperty = element.getDomProperty("value");
			return domProperty;
			}
			

			public String getDomPropertyValue(WebElement element, String attributeName) {
			String domProperty = element.getDomProperty(attributeName);
			return domProperty;
			}
			
			//alert 
				public void clickOk() {
					driver.switchTo().alert().accept();
				}
				public void clickCancel() {
					driver.switchTo().alert().dismiss();
				}
			
			
			//12. close Window
				
				public static void closeCurrentWind() {
					driver.close();
				}
				
				public static void quitAllWind() {
					driver.quit();
				}
				

				//13. Get the Tiltle
				
				public String getApplicationTitle() {
				String title = driver.getTitle();
				return title;
				}
				
				//14. Get the Entered URL
				
				public String getApplicationUrl() {
				String currentUrl = driver.getCurrentUrl();
				return currentUrl;
				}
				
				//15. DropDown Option By Text
				
				public void selectOptionByText(WebElement element, String text) {
				select = new Select(element);
				select.selectByVisibleText(text);
				}
				

				//16. DropDown Option By Value
				
				public void selectOptionByValue(WebElement element, String text) {
				select = new Select(element);
				select.selectByValue(text);
				}
				
				//17. DropDown Option By Index
				
				public void selectOptionByIndex(WebElement element, int index) {
				select = new Select(element);
				select.selectByIndex(index);
				}
				
				//18. Insert value in textbox by JS
		
				public void sendKeysElementJS(WebElement element, String data) {
				JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
				javascriptExecutor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
				}
		
				//19. Click button by JS
				
				public void clickByJS(WebElement element) {
				JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
				javascriptExecutor.executeScript("arguments[0].click", element);
				}
				
				//20. Switch to ChildWindow
				
				public void switchToChildWindo() {
				String windowHandle = driver.getWindowHandle();
				Set<String> windowHandles = driver.getWindowHandles();
				for (String eachWindowId : windowHandles) {
				if (!windowHandle.equals(eachWindowId)) {
				driver.switchTo().window(eachWindowId);
				break;
				}
				}
				}
				
				//21. Frame By Index
				
				public void frameByIndex(int index) {
					driver.switchTo().frame(index);
				}
				
			//22. Frame By Name
				
				public void frameByName(String name) {
					driver.switchTo().frame(name);
				}
			
			//23. Frame By Element 
				
				public void frameByElement(WebElement element) {
					driver.switchTo().frame(element);
				}
				
				//24. Find Locator By Id
				
				public WebElement findLocatorById(String attributeValue) {
				WebElement element = driver.findElement(By.id(attributeValue));
				return element;
				}
				
				//25. Find Locator By Name
				
				public WebElement findLocatorByName(String attributeValue) {
				WebElement element = driver.findElement(By.name(attributeValue));
				return element;
				}
				
				//26. Find Locator By ClassName
				
				public WebElement findLocatorByClassName(String attributeValue) {
				WebElement element = driver.findElement(By.className(attributeValue));
				return element;
				}
				
				//27. Find Locator By Xpath
				
				public WebElement findLocatorByXpath(String exp) {
				WebElement element = driver.findElement(By.xpath(exp));
				return element;
				}
				
				//28. Get All Options From DropDown 
				
				public List<String> getAllOptionsTextFromDropdown(WebElement element) {
				List<String> allOptionsText = new ArrayList<String>();
				select = new Select(element);
				List<WebElement> options = select.getOptions();
				for (WebElement webElement : options) {
				String text = webElement.getText();
				allOptionsText.add(text);
				}
				return allOptionsText;
				}
				
				//29. Get All Options As Value
				
				public List<String> getAllOptionsValueFromDropdown(WebElement element) {
					List<String> allOptionsValue = new ArrayList<String>();
					select = new Select(element);
					List<WebElement> options = select.getOptions();
					for (WebElement webElement : options) {
						String attribute = webElement.getAttribute("value");
						allOptionsValue.add(attribute);
					
					}
					return allOptionsValue;
				}
				
				//30. First Selected Option By DropDown
				
				public WebElement getFirstSelectedOptionsFromDropdown(WebElement element,String options) {
				Select select = new Select(element);
				WebElement firstSelectedOption = select.getFirstSelectedOption();
				return firstSelectedOption;
				}
				
				
				//31. DropDown is MultiSelect Options
				
				public boolean multiselectFromDropdown(WebElement element) {
					select = new Select(element);
					boolean multiple = select.isMultiple();
					return multiple;
				}
				
				//32. ImplicitWait
				public void implicitWait() {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				}
				
				public static void implicitWait(int secs) {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
				}
				
				//33. ExplicitWait for VisibilityOf
				
				public void visibilityOfElement(WebElement element) {
				WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
				driverWait.until(ExpectedConditions.visibilityOf(element));
				}
				
				//35. isDisplayed
				
				public boolean isDisplayedElement(WebElement element) {
				boolean displayed = element.isDisplayed();
				return displayed;
				}
				
				//36. isEnabled
				
				public boolean isEnabledElement(WebElement element) {
				boolean displayed = element.isEnabled();
				return displayed;
				}
				
				//37. isSelected
				
				public boolean isSelectedElement(WebElement element) {
				boolean displayed = element.isSelected();
				return displayed;
				}
				
				//38. DeSelectAll
				
				public void deselectAll(WebElement element) {
					select = new Select(element);
					select.deselectAll();
				}
				
				//39. Clear testbox
				
				public void clearTextBoxElement(WebElement element) {
				element.clear();
				}
				
				//40. TakeScreenShot
				
				public void screenshot(File destFile, WebElement element) throws IOException {
				File sourceFile = element.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(sourceFile, destFile);
				}
				
				//41. TakeScreenShot for Element 
				
				public void screenshot(File destFile) throws IOException {
				takesScreenshot = (TakesScreenshot) driver;
				File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(sourceFile, destFile);
				}
				
				//42. MouseOverAction
				
				public void mouseOverAction(WebElement element) {
					Actions actions = new Actions(driver);
					actions.moveToElement(element).perform();	
				}
				//43. DragAndDrop
				
				public void dragAndDropElement(WebElement sourceElement, WebElement destElement) {
				actions = new Actions(driver);
				actions.dragAndDrop(sourceElement, destElement).perform();
				}
				
				
				//44. RightClick
				
				public void rightClick(WebElement element) {
					actions = new Actions(driver);
					actions.contextClick(element).perform();		
				}
				
				//45.DoubleClick
				
				public void doubleClick(WebElement element) {
					actions = new Actions(driver);
					actions.doubleClick(element).perform();
				}
				
				//46.Insert Vakue In Textbox And ENTER
				
				public void sendKeysElementEnter(WebElement element, String data) {
					element.sendKeys(data, Keys.ENTER);
				}
				
				//47. Navigate Commands
				
				public void navigateTo(String url) {
					driver.navigate().to("url");;	
				}
				
				public void navigateForward() {
					driver.navigate().forward();
				}
				
				public void navigateBackward() {
					driver.navigate().back();
				}
				
				public void navigateRefresh() {
					driver.navigate().refresh();
				}
				
		//48. scrollDown
		
		public void scrollDownByJS(WebElement element) {
			JavascriptExecutor scrollDown = (JavascriptExecutor)driver;
			scrollDown.executeScript("arguments[0].ScrollIntoView(true)",element);
		}
		// scrollUp
			
		public void scrollUpByJS(WebElement element) {
			JavascriptExecutor scrollUp = (JavascriptExecutor)driver;
			scrollUp.executeScript("arguments[0].ScrollIntoView(false)", element);
		//49.Keys Enter
			
			
		}
	}


