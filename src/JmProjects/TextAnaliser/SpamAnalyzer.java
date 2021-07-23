package day0.JmProjects.TextAnaliser;

/***/
public class SpamAnalyzer extends KeywordAnalyzer {

    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords;
    }

    private String[] keywords;

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }

    @Override
    public Label processText(String text) {
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < getKeywords().length; j++) {
                if (text.contains(getKeywords()[j])) {
                    return getLabel();
                }
            }
        }
        return Label.OK;
    }
}
