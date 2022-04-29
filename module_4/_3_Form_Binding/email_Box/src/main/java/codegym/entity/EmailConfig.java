package codegym.entity;

public class EmailConfig {
    private String language;
    private String PageSize;
    private boolean SpamsFillter;
    private String signature;

    public EmailConfig() {
    }

    public EmailConfig(String language, String pageSize, boolean spamsFillter, String signature) {
        this.language = language;
        PageSize = pageSize;
        SpamsFillter = spamsFillter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPageSize() {
        return PageSize;
    }

    public void setPageSize(String pageSize) {
        PageSize = pageSize;
    }

    public boolean isSpamsFillter() {
        return SpamsFillter;
    }

    public void setSpamsFillter(boolean spamsFillter) {
        SpamsFillter = spamsFillter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
