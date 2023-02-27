package clrAutomation;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.*;
import java.net.*;
import java.util.*;


public class FirstAutomationProcess2 {
    WebDriver driver;

//    @BeforeClass
//    public void setDriver() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://shaam.taxes.gov.il/myz/pages/homepage.aspx");
//        // driver.get("https://taxon.co.il");
//        //driver.get("https://www.lambdatest.com/selenium-playground/");
//    }

    @AfterClass
    public void tearDown() {
        //  driver.close();
//        driver.quit();
    }

    @Test(priority = 3)
    public void shidurShaam1stStep() throws InterruptedException {
        //Action Class enables to perform actions with the mouse ore the keyboard.
        Actions actions = new Actions(driver);
        //Soft assert enables to check things without damaging the whole test process
        SoftAssert softAssert = new SoftAssert();
        Thread.sleep(10500);
        //checking if we landed at the right page or else the shaam system send us to the alternative page
        boolean isRegularOPCNLink = (driver.findElement(By.xpath("//li[@class='dfwp-item']//a[@target='_blank'][contains(text(),'שידור דוח שנתי (OPCN)')]")).isDisplayed());
        if (isRegularOPCNLink == true) {
            Actions act = new Actions(driver);
            String mainPageUrl = driver.getCurrentUrl();
            System.out.println("1)" + driver.getCurrentUrl());
            String mainPageHandle = driver.getWindowHandle();
            // 1) After entering the password manually, find the 'Annual report broadcast' button ('שידור דוח שנתי') and click it
            driver.findElement(By.xpath("//li[@class='dfwp-item']//a[@target='_blank'][contains(text(),'שידור דוח שנתי (OPCN)')]")).click();
            //2) Entering the password and click ENTER
            Thread.sleep(3500);
            // act.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
            //3)Get all the handles that currently available

//            for (String actual : handles) {
//                if (!actual.equalsIgnoreCase(mainPageHandle)) {
//          Switch to the opened tab
//                    driver.switchTo().window(actual);
            //4) Forcing the page to move over to the right screen where the password required
            Set<String> handles = driver.getWindowHandles();
//          Now iterate using Iterator
            Iterator<String> I1 = handles.iterator();
            //As long there is another tab, move to the next tab.
            while (I1.hasNext()) {
                String child_window = I1.next();
                //if the child tab doesn't equal to the main page
                if (mainPageHandle.equals(child_window)) {
                    // switch to the child tab
                    driver.switchTo().window(child_window);
//              Show me the title of the current screen
                    System.out.println(driver.switchTo().window(child_window).getTitle());
                }
                String passwordPage = driver.getCurrentUrl();
                System.out.println("2)" + passwordPage);
                //5) Finding the password slot and CLICK it
                //           driver.findElement(By.id("ContentUsersPage_logon1_txtPassword")).click();

                //6) type the password in it
//                    act.sendKeys("TS5694");
//                    Thread.sleep(7500);
//                    act.sendKeys(Keys.ENTER);
                Thread.sleep(4500);
                //  7) If the current page which suppose to be the password page is indeed the password page then..
                //  if (passwordPage.equals("https://shaam.taxes.gov.il/shopcn/frmLogon.aspx")) {
                System.out.println("I entered the seventh step");
//                    8) Find the password slot and insert password
                //*** Try to force move to password page url
                driver.navigate().to("https://shaam.taxes.gov.il/shopcn/frmLogon.aspx");
                System.out.println("after forcing moving to password page url" + driver.getCurrentUrl());
                driver.findElement(By.xpath("(//input[@id='ContentUsersPage_logon1_txtPassword'])[1]")).sendKeys("TS5694");
                //9) Find the OK button ('אישור') and click it
                Thread.sleep(4500);
                driver.findElement(By.xpath("(//input[@id='ContentUsersPage_logon1_btnSubmit'])[1]")).click();
                String fileUploadUrl = driver.getCurrentUrl();
                System.out.println("3)" + driver.getCurrentUrl());
                // 10) Else, If the current page wasn't the password page' means it jumped forward to the upload file page then...
                // }
//                Iterator<String> I2 = handles.iterator();
//                while (I2.hasNext()) {
//                    String child_window2 = I2.next();
//                    if (!passwordPage.equals(child_window2)) {
//                        // switch to the child tab
//                        driver.switchTo().window(child_window2);
////               Show me the title of the current screen
//                        System.out.println(driver.switchTo().window(child_window).getTitle());
                System.out.println("4)" + driver.getCurrentUrl());
//                        }
//
                //*) !!!after uploading the file /save it / chose it find the Find the OK button ('אישור') and click it
                Thread.sleep(4500);
                //*** Try to force move to upload file page url
                System.out.println("after forcing to move over to upload file page url" + driver.getCurrentUrl());
                driver.get("https://shaam.taxes.gov.il/shopcn/frmUpload.aspx");
                //11) clicking the frame of the clicking file
                driver.findElement(By.xpath("//body[1]/div[2]/form[1]/div[7]/table[1]/tbody[1]/tr[3]/td[1]")).click();
                //             12) Clicking the 'Choose File' button
                driver.findElement(By.xpath("(//input[@id='File1'])[1]")).click();
                Thread.sleep(4500);
                act.sendKeys("https://app.taxon.co.il/admin/tests/tomer/broadcast.txt");
                act.sendKeys(Keys.ENTER);
                Thread.sleep(4500);
                driver.findElement(By.xpath("(//input[@id='btnIshur'])[1]")).click();

            }


//
//        actions.sendKeys("Naama2102!").perform();
//        driver.findElement(By.linkText("Table Sort & Search")).click();
//        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("A.Ramos");
            softAssert.assertAll();// need to write it after the whole process if softAssert has been used

        }
    }

    private static HttpURLConnection connection;

    @Test(priority = 1)
    private static JSONObject gettingEndPoint() throws URISyntaxException, IOException, InterruptedException {

// 1) first option:to get the end point
// URI taxonEndPoint = new URI("https://app.taxon.co.il/admin/tests/tomer.php");
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .GET()
//                .uri(taxonEndPoint)
//                .build();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println("That is  T H E  json: \n"+  response.body());
//
//        //pars JSON into object
//        ObjectMapper mapper = new ObjectMapper();
//        List<UrlEndPointObject> urlEndPointObjects = mapper.readValue(response.body(), new TypeReference<List<UrlEndPointObject>>() {});
//
//     urlEndPointObjects.forEach(System.out::println);
//    }

        // 2) second option to get the end point
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();//append each line and build the response content

        try {
            URL url = new URL("https://app.taxon.co.il/admin/tests/tomer.php");
            connection = (HttpURLConnection) url.openConnection();
            //Request setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            int status = connection.getResponseCode();
            System.out.println("That is the request status :" + status);
            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            System.out.println(responseContent.toString());
            //  parse(responseContent.toString()); // This parse() dos not work...
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
//        ArrayList<ArrayList<Object>> customersInfo = new
//                ArrayList<ArrayList<Object>>();
//        ObjectMapper mapper = new ObjectMapper();
        String jsonEndPointString = responseContent.toString();
//        JSONArray jsonArray = new JSONArray(customersInfoJson);
        JSONObject jsonObjectEndPoint = new JSONObject(jsonEndPointString);
        String broadcastFileLink = new String(jsonObjectEndPoint.get("broadcast").toString());


//        System.out.println("That is my JSONobject" + jsonObjectEndPoint);
//        System.out.println("That is my jsonEndPointString : " + jsonEndPointString);
//        System.out.println("That is my JSONobject.get(\"broadcast\") :" + jsonObjectEndPoint.get("broadcast"));
//        System.out.println("That broadcastFileLink : " + broadcastFileLink);

        return jsonObjectEndPoint;
//        JsonParser jsonParser = new JsonParser() {
//
//        }


        // 3) third option to get the end point // this option have some problem
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://app.taxon.co.il/admin/tests/tomer.php")).build();
//        client.sendAsync(request,HttpResponse.BodyHandlers.ofString())
//              .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println)
//                .join();
//    }
        //  }
//        public static String parse (String responseBody ){
//            JSONArray customersDetails = new JSONArray(responseBody);
//            for (int i = 0; i < customersDetails.length(); i++) {
//                JSONObject customerDetails = customersDetails.getJSONObject(i);
//                int nationalId = customerDetails.getInt("nationalId");
//                int year = customerDetails.getInt("year");
//                String broadcast = customerDetails.getString("broadcast");
//                //List  <String> files= customerDetails.get("files");
//                System.out.println(nationalId + "" + year + "" + broadcast + "");
//            }
//            return null;

//        //4) fourth option to get the end point through converting the response to a List
//        List<Objects> customersInfo=
//                RestAssured
//                .get("https://app.taxon.co.il/admin/tests/tomer/broadcast.txt")
//                .as(List.class);
//        System.out.println(customersInfo.size());
//       Map<String,Objects> customerInfo1 = (Map<String,Object>) customersInfo.get(0);
//        System.out.println(customerInfo1.get("nationalId" + "" + "year" + "" + "broadcast" + ""));
    }

    @Test(priority = 2)
    //FirstAutomationProcess2 process2=new FirstAutomationProcess2;

    public static void saveBroadcastFile () throws URISyntaxException, IOException, InterruptedException {

        String broadcastFileLink = gettingEndPoint().get("broadcast").toString();
        String destBroadcastFile = "C:/Users/User/Desktop/programming/Automation/Selenium and Spring/Shaam/Shaam1/files to broadcast";
        System.out.println("That is the gettingEndPoint() in Test (priority = 2) : "+ gettingEndPoint());
        System.out.println("That is the broadcastFileLink in Test (priority = 2) : "+broadcastFileLink);
        InputStream inputStream = new FileInputStream(broadcastFileLink);
        OutputStream outputStream=new FileOutputStream(destBroadcastFile);
        try {
//            inputStream = new FileInputStream(broadcastFileLink);
//            outputStream = new FileOutputStream(destBroadcastFile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer))>0){
                outputStream.write(buffer,0,length);

            }
        }finally {
            inputStream.close();
            outputStream.close();
        }


//        try {
//            File savedBroadcastFile = new File("C:/Users/User/Desktop/programming/Automation/Selenium and Spring/Shaam/Shaam1/files to broadcast");
//            if (savedBroadcastFile.createNewFile()){
//                System.out.println("File created: "+savedBroadcastFile.getName()+"\nat the location : "+savedBroadcastFile.getPath());
//            }else {
//                System.out.println("File already exists / Failed to save file");
//            }
//        }catch (IOException exception){
//            System.out.println("An error has occurred.");
//            exception.printStackTrace();
//        }

    }

}







