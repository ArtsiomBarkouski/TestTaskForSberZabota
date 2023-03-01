import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests {

    @BeforeMethod(groups = { "positive", "negative"})
    public void readJson() {
        JsonParser.getSuccess();
        JsonParser.getDetectivesArray();
    }

    @Test(groups = "positive")
    public void firstPositiveTest() {
        System.out.println("First positive test started");
        if (JsonParser.detectives.size() >= 1 && JsonParser.detectives.size() <= 3)
            System.out.println("Detectives array has correct size");
        for (Object o : JsonParser.detectives) {
            JSONObject detective = (JSONObject) o;
            long mainIdValue = (long) detective.get("MainId");
            if (mainIdValue >= 0 && mainIdValue <= 10) {
                System.out.println("MainId has correct value");
            }
        }
        System.out.println("First positive test passed");
        System.out.println("**************************");
    }


    @Test(groups = "positive")
    public void secondPositiveTest() {
        System.out.println("Second positive test started");
        for (Object o : JsonParser.detectives) {
            JSONObject detective = (JSONObject) o;
            JSONArray categoriesArray = (JSONArray) detective.get("categories");
            for (Object category : categoriesArray) {
                JSONObject currentCategory = (JSONObject) category;
                long categoryId = (long) currentCategory.get("CategoryID");
                if (categoryId == 1 || categoryId == 2) {
                    System.out.println("CategoryID has correct value");
                }
            }
        }
        System.out.println("Second positive test passed");
        System.out.println("**************************");
    }

    @Test(groups = "positive")
    public void thirdPositiveTest() {
        System.out.println("Third positive test started");
        for (Object o : JsonParser.detectives) {
            JSONObject detective = (JSONObject) o;
            JSONArray categoriesArray = (JSONArray) detective.get("categories");
            for (Object category : categoriesArray) {
                JSONObject currentCategory = (JSONObject) category;
                long categoryId = (long) currentCategory.get("CategoryID");
                if (categoryId == 2 && currentCategory.get("extra") == null) {
                    System.out.println("Extra can be null for CategoryId = 2");
                    System.out.println("Third positive test passed");
                    System.out.println("**************************");
                }
            }
        }
    }

    @Test(groups = "positive")
    public void fourthPositiveTest() {
        System.out.println("Fourth positive test started");
        for (Object o : JsonParser.detectives) {
            JSONObject detective = (JSONObject) o;
            JSONArray categoriesArray = (JSONArray) detective.get("categories");
            for (Object category : categoriesArray) {
                JSONObject currentCategory = (JSONObject) category;
                long categoryId = (long) currentCategory.get("CategoryID");
                JSONObject extraOfCurrentCategory = (JSONObject) currentCategory.get("extra");
                if (extraOfCurrentCategory == null) {
                    break;
                }
                JSONArray extraArray = (JSONArray) extraOfCurrentCategory.get("extraArray");
                if (categoryId == 1 && extraArray.size() >= 1) {
                    System.out.println("Array extraArray should have at least 1 element if CategoryId = 1");

                }
            }
        }
        System.out.println("Fourth positive test passed");
        System.out.println("**************************");
    }

    @Test(groups = "positive")
    public void fifthPositiveTest() {
        System.out.println("Fifth positive test started");
        for (Object o : JsonParser.detectives) {
            JSONObject detective = (JSONObject) o;
            String detectiveFirstName = (String) detective.get("firstName");
                if (detectiveFirstName == "Sherlock" && JsonParser.success) {
                   break;
            }
        }
        System.out.println("Success is true only if in detectives array present element with firstName = Sherlock");
        System.out.println("Fifth positive test passed**************************");
    }

    @Test(groups = "negative")
    public void firstNegativeTest() {
        System.out.println("First negative test started");
        if (JsonParser.detectives.size() < 1 | JsonParser.detectives.size() > 3) {
            System.out.println("Error : Detectives array has incorrect size");
        }
        for (Object o : JsonParser.detectives) {
            JSONObject detective = (JSONObject) o;
            long mainIdValue = (long) detective.get("MainId");
            if (mainIdValue < 0 | mainIdValue > 10) {
                System.out.println("Error : MainId has incorrect value for " + detective.get("firstName"));
            }
        }
        System.out.println("First negative test passed");
        System.out.println("**************************");

    }

    @Test(groups = "negative")
    public void secondNegativeTest() {
        System.out.println("Second negative test started");
        for (Object o : JsonParser.detectives) {
            JSONObject detective = (JSONObject) o;
            JSONArray categoriesArray = (JSONArray) detective.get("categories");
            for (Object category : categoriesArray) {
                JSONObject currentCategory = (JSONObject) category;
                long categoryId = (long) currentCategory.get("CategoryID");
                if (categoryId != 1 && categoryId != 2) {
                    System.out.println("Error : CategoryID has incorrect value for " + detective.get("firstName"));
                }
            }
        }
        System.out.println("Second negative test passed");
        System.out.println("**************************");
    }

    @Test(groups = "negative")
    public void thirdNegativeTest() {
        System.out.println("Third negative test started");
        for (Object o : JsonParser.detectives) {
            JSONObject detective = (JSONObject) o;
            JSONArray categoriesArray = (JSONArray) detective.get("categories");
            for (Object category : categoriesArray) {
                JSONObject currentCategory = (JSONObject) category;
                long categoryId = (long) currentCategory.get("CategoryID");
                JSONObject extraValue = (JSONObject) currentCategory.get("extra");
                if (categoryId != 2 && extraValue == null) {
                    System.out.println("Error : Extra can be null only for CategoryId = 2. " +detective.get("firstName"));
                }
            }
        }
        System.out.println("Third negative test passed");
        System.out.println("**************************");
    }

    @Test(groups = "negative")
    public void fourthNegativeTest() {
        System.out.println("Fourth negative test started");
        for (Object o : JsonParser.detectives) {
            JSONObject detective = (JSONObject) o;
            JSONArray categoriesArray = (JSONArray) detective.get("categories");
            for (Object category : categoriesArray) {
                JSONObject currentCategory = (JSONObject) category;
                long categoryId = (long) currentCategory.get("CategoryID");
                JSONObject extraOfCurrentCategory = (JSONObject) currentCategory.get("extra");
                if (categoryId == 1 && extraOfCurrentCategory == null) {
                    System.out.println("Error : Array extraArray should have at least 1 element if CategoryId = 1");
                }
            }
        }
        System.out.println("Fourth negative test passed");
        System.out.println("**************************");
}

    @Test(groups = "negative")
    public void fifthNegativeTest() {
        System.out.println("Fifth negative test started");
        for (Object o : JsonParser.detectives) {
            JSONObject detective = (JSONObject) o;
            String detectiveFirstName = (String) detective.get("firstName");
            if (detectiveFirstName != "Sherlock" && JsonParser.success) {
                System.out.println("Error : Success is true only if in detectives array present element with firstName = Sherlock. Current first name is " + detective.get("firstName"));
            }
        }
        System.out.println("Fifth negative test passed");
        System.out.println("**************************");
    }
}
