package fitnesse.wikitext.parser;

import fitnesse.html.HtmlTag;
import util.Maybe;

public class ListToken extends Token {
    public Maybe<String> render(Scanner scanner) {
        String body = new Translator(getPage()).translate(scanner, TokenType.Newline);
        if (scanner.isEnd()) return Maybe.noString;

        HtmlTag list = new HtmlTag("ul");
        list.add(new HtmlTag("li", body));
        return new Maybe<String>(list.html());
    }
}
