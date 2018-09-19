package com.opencv.simpleopencvsample.config;

import org.opencv.core.Core;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: nya
 * @Description:
 * @Date: Created in 15:11 2018/9/19
 * @Modify by:
 */
@Configuration
public class CommonConfig {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

}
