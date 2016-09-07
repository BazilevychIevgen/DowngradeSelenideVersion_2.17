package helpers;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.actions;

/**
 * Created by barocko on 9/7/2016.
 */
public class Helpers {

    public static void doubleClick(SelenideElement element){
        actions().doubleClick(element).perform();
    }
}
