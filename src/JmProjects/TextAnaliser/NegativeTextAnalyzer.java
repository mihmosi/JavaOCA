package day0.JmProjects.TextAnaliser;

public class NegativeTextAnalyzer extends KeywordAnalyzer {

    private String[] keywords;

    public NegativeTextAnalyzer() {
        this.keywords = new String[]{":(", "=(", ":|"};
    }

    @Override
    protected String[] getKeywords() {
        return this.keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}
