package com.github.hitzaki.skin.constant.resource;

import java.io.File;

import static com.github.hitzaki.skin.constant.resource.ResourcePathConstant.*;

/**
 * resources目录下相关文件路径的枚举
 * @author hitzaki
 */
public enum ResourceCopyPathEnum {

    /**
     * batch目录下的文件
     */
    RESOURCE_PATH_ENUM(BATCH_ABSOLUTE_DIR,
            BATCH_RELATIVE_DIR + File.separator + "deleteIconCache.bat",
            BATCH_ABSOLUTE_DIR + File.separator + "deleteIconCache.bat");


    /**
     * 文件对应的绝对目录, 可以用来创建
     */
    private final String dir;
    /**
     * 相对路径
     */
    private final String relativePath;
    /**
     * 绝对路径
     */
    private final String absolutePath;

    public String getDir() {
        return dir;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    ResourceCopyPathEnum(String dir, String relativePath, String absolutePath) {
        this.dir = dir;
        this.relativePath = relativePath;
        this.absolutePath = absolutePath;
    }
}
