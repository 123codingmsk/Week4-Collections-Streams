public class ReplaceModify {
    public static void main(String[] args) {
        String text = "This is an  example  with   multiple spaces.";
        String regex = "\\s+";
        String replacedText = text.replaceAll(regex, " ");
        System.out.println(replacedText);
    }
}
