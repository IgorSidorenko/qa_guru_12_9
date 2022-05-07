package guru.qa;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class DragAndDropTest {
    @Test
    void changeElement() {
        //Открыть сайт
        Selenide.open("https://the-internet.herokuapp.com/drag_and_drop");
        // Перенесим прямоугольник А на место В
        $("#column-a").dragAndDropTo("#column-b");
        // Проверяем как прямоугольники поменялись местами
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
