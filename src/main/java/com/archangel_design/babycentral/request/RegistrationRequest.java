package com.archangel_design.babycentral.request;

public class RegistrationRequest {

    private String email;
    private String firstName;
    private String password;
    private String passwordRepeat;
    private Boolean autoLogin = false;
    private String deviceId;

    public String getEmail() {
        return email;
    }

    public RegistrationRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public RegistrationRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegistrationRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public RegistrationRequest setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
        return this;
    }

    public Boolean getAutoLogin() {
        return autoLogin;
    }

    public RegistrationRequest setAutoLogin(Boolean autoLogin) {
        this.autoLogin = autoLogin;
        return this;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public RegistrationRequest setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }
}
