package it.unibo.deathnote.impl;

import java.util.HashMap;
import java.util.Map;

import it.unibo.deathnote.api.DeathNote;

public class DeathNoteImplementation implements DeathNote{
    final Map<String, HumanInfo> deathnote = new HashMap<>();
    float act;
    String lastName;

    class HumanInfo{
        private String details;
        private String cause; 
        
        private HumanInfo() {
            cause = null;
            details = null;
        };
        
        public String getCause() {
            return cause;
        }
        
        public String getDetails() {
            return details;
        }
        
        public void setDetails(String details) {
            this.details = details;
        }
        
        public void setCause(String cause) {
            this.cause = cause;
        }
    }

    @Override
    public String getRule(int ruleNumber) {
        if(ruleNumber <= 0){
            throw new IllegalArgumentException("This rule does not exist!");
        }
        return RULES.get(ruleNumber);
    }

    @Override
    public void writeName(String name) {
        if(name == null){
            throw new NullPointerException("The given name is null");
        }
        deathnote.put(name, new HumanInfo());
        act = System.currentTimeMillis();
        lastName = name;
    }

    @Override
    public boolean writeDeathCause(String cause) {
        if(cause == null || deathnote.isEmpty()){
            throw new IllegalStateException("0 names in deathnote or cause is null");
        }
        if((System.currentTimeMillis() - act) <= 40){
            if(deathnote.containsKey(lastName)) {
                HumanInfo hi = deathnote.get(lastName);
                hi.setCause(cause);
                deathnote.put(lastName, hi);
            }
            return true;
        }else{
            if(deathnote.containsKey(lastName)) {
                HumanInfo hi = deathnote.get(lastName);
                hi.setCause("heart attack");
                deathnote.put(lastName, hi);
            }
        }
        act = System.currentTimeMillis();
        return false;
    }

    @Override
    public boolean writeDetails(String details) {
        if(details == null || deathnote.isEmpty()){
            throw new IllegalStateException("0 names in deathnote or details is null");
        }
        if((System.currentTimeMillis() - act) <= 6040){
            if(deathnote.containsKey(lastName)) {
                HumanInfo hi = deathnote.get(lastName);
                hi.setDetails(details);
                deathnote.put(lastName, hi);
            }
            return true;
        }
        return false;
    }

    @Override
    public String getDeathCause(String name) {
        if(deathnote.containsKey(name)) {
            return deathnote.get(name).getCause();
        }else{
            throw new IllegalArgumentException("Provider name is not written in this DeathNote");
        }
    }

    @Override
    public String getDeathDetails(String name) {
        if(deathnote.containsKey(name)) {
            return deathnote.get(name).getDetails();
        }else{
            throw new IllegalArgumentException("Provider name is not written in this DeathNote");
        }
    }

    @Override
    public boolean isNameWritten(String name) {
        if(name==null){
            throw new NullPointerException("Given name is null");
        }
        return deathnote.containsKey(name);
    }
}