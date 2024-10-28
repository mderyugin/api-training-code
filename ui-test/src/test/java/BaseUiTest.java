import org.junit.jupiter.api.BeforeEach;


import static com.codeborne.selenide.Selenide.open;

public class BaseUiTest {
    @BeforeEach
    void setUp() {
        open("");

    }
}
