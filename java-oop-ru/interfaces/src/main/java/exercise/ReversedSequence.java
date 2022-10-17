package exercise;

// BEGIN
public class ReversedSequence implements CharSequence{
    private final String result = "";

    public ReversedSequence(String text) {
        StringBuilder stringBuilder = new StringBuilder(text);
        String result = stringBuilder.reverse().toString();
    }
    @Override
    public int length() {
        return result.length();
    }

    @Override
    public char charAt(int i) {
        return result.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return result.substring(i, i1);
    }

    @Override
    public String toString() {
        return result;
    }
}
// END
