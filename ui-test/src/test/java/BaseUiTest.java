import org.junit.jupiter.api.BeforeEach;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseUiTest {
    @BeforeEach
    public void setUp() {
        open("");

    }
}
