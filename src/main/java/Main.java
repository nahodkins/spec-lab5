import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static String getCharacterInfo(Character character) {
        String start = String.format("Character '%s': ", character);
        if (Character.isDigit(character)) {
            return start + "number";
        } else if (character.equals(' ')) {
            return start + "space";
        }
        return start + CharacterCase.getCharacterCase(character).toString();
    }

    public static void main(String[] args) {
        String str = "Hello world123!";
        System.out.println("Given string: " + str);
        str.chars()
                .mapToObj(i -> (char) i)
                .map(Main::getCharacterInfo)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
