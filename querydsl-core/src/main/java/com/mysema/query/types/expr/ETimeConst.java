/*
 * Copyright (c) 2009 Mysema Ltd.
 * All rights reserved.
 * 
 */
package com.mysema.query.types.expr;

import java.sql.Time;
import java.util.Calendar;

import com.mysema.query.types.Visitor;

/**
 * @author tiwe
 *
 */
@SuppressWarnings("serial")
public class ETimeConst extends ETime<java.sql.Time> implements Constant<java.sql.Time>{
    
    public static ETime<java.sql.Time> create(java.sql.Time time){
        return new ETimeConst(time);
    }
    
    private final Calendar calendar;
    
    private final Time time;
    
    public ETimeConst(java.sql.Time time) {
        super(java.sql.Time.class);
        this.calendar = Calendar.getInstance();
        this.time = time;
        calendar.setTime(time);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);        
    }
    
    @Override
    public ENumber<Integer> hour() {
        return ENumberConst.create(calendar.get(Calendar.HOUR_OF_DAY));
    }
    
    @Override
    public ENumber<Integer> minute() {
        return ENumberConst.create(calendar.get(Calendar.MINUTE));
    }
    
    @Override
    public ENumber<Integer> second() {
        return ENumberConst.create(calendar.get(Calendar.SECOND));
    }

    @Override
    public ENumber<Integer> milliSecond() {
        return ENumberConst.create(calendar.get(Calendar.MILLISECOND));
    }
    
    @Override
    public Time getConstant() {
        return time;
    }

}
