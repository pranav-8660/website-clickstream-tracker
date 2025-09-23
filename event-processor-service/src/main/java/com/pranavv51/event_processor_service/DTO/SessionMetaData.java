package com.pranavv51.event_processor_service.DTO;

public class SessionMetaData {

    private String sessionId;
    private String locale;
    private String screenResolution;
    private String referrer;

    public SessionMetaData(String sessionId, String locale, String screenResolution, String referrer) {
        this.sessionId = sessionId;
        this.locale = locale;
        this.screenResolution = screenResolution;
        this.referrer = referrer;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getLocale() {
        return locale;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }
}
