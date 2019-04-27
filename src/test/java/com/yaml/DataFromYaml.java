package com.yaml;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DataFromYaml {

    private String caseName;
    private int id;
    private boolean enableAbs;
    private Optional<String> optionalString;
    private List<Integer> list;
    private Map<String, String> map;

    // expected data
    private Integer result;

    @Override
    public String toString() {
        return String.format("%d: %s", id, caseName);
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEnableAbs() {
        return enableAbs;
    }

    public void setEnableAbs(boolean enableAbs) {
        this.enableAbs = enableAbs;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Optional<String> getOptionalString() {
        return optionalString;
    }

    public void setOptionalString(Optional<String> optionalString) {
        this.optionalString = optionalString;
    }
}
