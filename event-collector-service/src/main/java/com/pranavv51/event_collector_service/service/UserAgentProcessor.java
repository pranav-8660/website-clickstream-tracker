package com.pranavv51.event_collector_service.service;


import com.pranavv51.event_collector_service.DTO.UserAgent;
import org.springframework.stereotype.Service;

@Service
public class UserAgentProcessor {

    private UserAgent getUserAgentFromHttpRequest(String ua) {
        String os = "Unknown";
        String browser = "Unknown";

        if (ua != null) {
            String uaLower = ua.toLowerCase();

            // OS detection
            if (uaLower.contains("windows nt 10.0")) os = "Windows 10";
            else if (uaLower.contains("windows nt 6.3")) os = "Windows 8.1";
            else if (uaLower.contains("windows nt 6.2")) os = "Windows 8";
            else if (uaLower.contains("windows nt 6.1")) os = "Windows 7";
            else if (uaLower.contains("mac os x") || uaLower.contains("macintosh")) os = "Mac OS";
            else if (uaLower.contains("android")) os = "Android";
            else if (uaLower.contains("iphone") || uaLower.contains("ipad")) os = "iOS";
            else if (uaLower.contains("linux")) os = "Linux";
            else if (uaLower.contains("cros")) os = "Chrome OS";
            else if (uaLower.contains("freebsd")) os = "FreeBSD";
            else if (uaLower.contains("sunos")) os = "Solaris";

            // Browser detection
            if (uaLower.contains("edg/") || uaLower.contains("edge/")) browser = "Edge";
            else if (uaLower.contains("opr/") || uaLower.contains("opera")) browser = "Opera";
            else if (uaLower.contains("chrome/") && !uaLower.contains("edg/") && !uaLower.contains("opr/")) browser = "Chrome";
            else if (uaLower.contains("safari/") && !uaLower.contains("chrome/") && !uaLower.contains("chromium/")) browser = "Safari";
            else if (uaLower.contains("firefox/")) browser = "Firefox";
            else if (uaLower.contains("msie") || uaLower.contains("trident/")) browser = "Internet Explorer";
        }

        return new UserAgent(browser, os);
    }

    public UserAgent getUserAgentProcessed(String userAgentRaw){
        return getUserAgentFromHttpRequest(userAgentRaw);
    }

}
