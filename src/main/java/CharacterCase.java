public enum CharacterCase {


    UPPERCASE("uppercase character"), LOWERCASE("lowercase character");

    private final String caseName;

    CharacterCase(String caseName) {
        this.caseName = caseName;
    }

    public static CharacterCase getCharacterCase(Character character) {
        return Character.isLowerCase(character) ? LOWERCASE : UPPERCASE;
    }


    @Override
    public String toString() {
        return caseName;
    }
}
