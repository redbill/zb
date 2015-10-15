package com.bianlide.zb.cms.model;

public class TCodeModule {
    private String codeModule;

    private String nameModule;

    public String getCodeModule() {
        return codeModule;
    }

    public void setCodeModule(String codeModule) {
        this.codeModule = codeModule == null ? null : codeModule.trim();
    }

    public String getNameModule() {
        return nameModule;
    }

    public void setNameModule(String nameModule) {
        this.nameModule = nameModule == null ? null : nameModule.trim();
    }
}