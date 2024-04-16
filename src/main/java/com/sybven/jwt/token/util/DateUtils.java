package com.sybven.jwt.token.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class DateUtils {
    
    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);
    
    @Value("${token.jwt.timezone}")
    private String TIMEZONE;
    
    private SimpleDateFormat simpleDateFormat(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone(TIMEZONE));
        return sdf;
    }
    
    public String getDateString(){
        Date now = new Date();
        String sdf =simpleDateFormat().format(now);
        logger.info("DateUtils getDateString str: " + sdf);
        return sdf;
    }
    
    public long getDateMillis(){
        Date now = new Date();
        String sdfDate = simpleDateFormat().format(now);
        Date sdfNow = new Date();
        try {
            logger.info("DateUtils getDateMillis strNow 1: " + sdfNow);
            sdfNow = simpleDateFormat().parse(sdfDate);
            logger.info("DateUtils getDateMillis strNow 2: " + sdfNow);
        } catch (ParseException ex) {
            logger.error("Error DateUtils getDateMillis: " + ex);
        }
        return sdfNow.getTime();
    }
        
}
