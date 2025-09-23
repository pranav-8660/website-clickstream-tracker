package com.pranavv51.event_collector_service.DTO;

public class SessionMetadata {

    private String sessionId;
    private String locale;
    private String screenResolution;
    private String referrer;

    public SessionMetadata(String sessionId, String locale, String screenResolution, String referrer) {
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
}
