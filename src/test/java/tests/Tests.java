package tests;

import pages.Page;
import org.testng.annotations.*;

public class Tests {
    Page page=new Page();


    @Test
    public void apiTest(){
        page.gettingSearchListSize();
        page.verifyCategory();
        page.verifyId();
    }

}
