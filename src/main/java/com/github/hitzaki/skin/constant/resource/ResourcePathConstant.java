package com.github.hitzaki.skin.constant.resource;

import com.github.hitzaki.skin.constant.InitConstant;

import java.io.File;

/**
 * 存放resources目录下的资源地址映射-相关常数
 * @author hitzaki
 */
public class ResourcePathConstant {
    /**
     * resources目录下的多重目录映射
     */
    public static final String BATCH_RELATIVE_DIR = "batch";
    public static final String BATCH_ABSOLUTE_DIR = InitConstant.WORK_SPACE + File.separator + BATCH_RELATIVE_DIR;

}
