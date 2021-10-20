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

    @Test
    public void gettingSearchListSize(){
        page.gettingSearchListSize();
    }

    @Test
    public void verifyCategory(){
        page.verifyCategory();
    }

    @Test
    public void verifyId(){
        page.verifyId();
    }

}
