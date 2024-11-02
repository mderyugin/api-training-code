import com.codeborne.selenide.Selenide;
import com.socks.api.conditions.Conditions;
import com.socks.api.payloads.UserPayload;
import com.socks.api.services.UserApiService;
import com.socks.ui.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Sleeper;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;
import static com.socks.api.conditions.Conditions.*;

public class TestLogin  {

    private final UserApiService userApiService = new UserApiService();

    private MainPage mainPage;
    
    @Test
    public void userCanLoginWithValidCredentials() {
        open("https://dev-cinescope.store/");
        //given

        UserPayload userPayload = (UserPayload) new UserPayload()
                .email("test-admin@mail.com")
                .password("KcLMmxkJMjBD1");

        userApiService.registerUser(userPayload)
                .shouldHave(statusCode(403));

        MainPage.open()
                .loginAs(userPayload.email(), userPayload.password());

    }

}
