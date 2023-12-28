import org.testng.annotations.DataProvider;

public class CustomeDataProvider {

    @DataProvider(name="LoginDataProvider")
    public Object[][] getData(){
        Object[][] data ={ {"test1@gmail.com ", "aaaa"}, {"test_2@gmail.com","bababa"},
                {"tettttts@gmail..com","jfwgfgwf"}};
        return data;
    }
}
