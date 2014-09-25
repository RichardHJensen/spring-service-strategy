package com.rhjensen.examples.spring.strategies;

import com.rhjensen.examples.spring.domain.Systems;
import org.joda.time.LocalDate;

import java.util.Map;

/**
 * User: rjensen
 * Date: 9/25/14
 * Time: 6:19 AM
 */
public class DynamicSystemChooser implements SystemChooser {
    Map<String, SystemChooser> chooserMap;

    SystemChooser defaultChooser = null;

    public SystemChooser getChooser(String serviceName) {
        SystemChooser chooser = defaultChooser;
        if (chooserMap.containsKey(serviceName)) {
            chooser = chooserMap.get(serviceName);
        }
        return chooser;
    }

    public void setChooserMap(Map chooserMap) {
        this.chooserMap = chooserMap;
    }

    public void setDefaultChooser(SystemChooser defaultChooser) {
        this.defaultChooser = defaultChooser;
    }

    @Override
    public Systems chooseSystem() {
        return defaultChooser.chooseSystem();
    }

    @Override
    public Systems chooseSystem(LocalDate localDate) {
        return defaultChooser.chooseSystem(localDate);
    }

    public Systems chooseSystem(String serviceName) {
        return getChooser(serviceName).chooseSystem();
    }

    public Systems chooseSystem(String serviceName, LocalDate serviceDate) {
        return getChooser(serviceName).chooseSystem(serviceDate);
    }
}
