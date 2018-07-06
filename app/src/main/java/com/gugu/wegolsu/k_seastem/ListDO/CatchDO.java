package com.gugu.wegolsu.k_seastem.ListDO;

public class CatchDO {
    private String strName;
    private String strStart;
    private String strEnd;


    public CatchDO(String name, String start, String end) {
        strName = name;
        strStart = start;
        strEnd = end;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getStrStart() {
        return strStart;
    }

    public void setStrStart(String strStart) {
        this.strStart = strStart;
    }

    public String getStrEnd() {
        return strEnd;
    }

    public void setStrEnd(String strEnd) {
        this.strEnd = strEnd;
    }
}
