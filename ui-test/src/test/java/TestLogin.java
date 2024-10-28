import com.codeborne.selenide.Selenide;
import com.socks.api.conditions.Conditions;
import com.socks.api.payloads.UserPayload;
import com.socks.api.services.UserApiService;
import com.socks.ui.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.socks.api.conditions.Conditions.*;

public class TestLogin  {

    private final UserApiService userApiService = new UserApiService();

    @Test
    public void userCanLoginWithValidCredentials() {
        //given
        UserPayload userPayload = (UserPayload) new UserPayload()
                .email("test-admin@mail.com")
                .password("KcLMmxkJMjBD1");

        userApiService.registerUser(userPayload)
                .shouldHave(statusCode(200));

        MainPage.open()
                .loginAs(userPayload.email(), userPayload.password());

    }
}
