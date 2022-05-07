package guru.qa;


import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

    // Вопрос: Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли привести к тому что, поиск найдёт разные элементы?
   // Ответ: В первом случае он будет искать  элемент h1 и в  нём div по всей странице.Во втором случае он будет искать первый h1, и в нем элемент div, которого может и не быть

public class SelenideTest {
    @Test
    void findSoftAssertionsPage() {

                // Откройте страницу Selenide в Github
                Selenide.open("https://github.com/selenide/selenide");
                // Перейдите в раздел Wiki проекта
                $("#wiki-tab").click();
                //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
                $("li.wiki-more-pages-link").$("button").click();
                $(".wiki-rightbar").shouldHave(text("SoftAssertions"));
                // Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
                $(".wiki-rightbar").$(byText("SoftAssertions")).click();
                $("#wiki-wrapper").shouldHave(text("JUnit5 extension"), text("Using JUnit5 extend test class"));
            }
        }
