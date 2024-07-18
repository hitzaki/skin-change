package com.github.hitzaki.skin.util;

import com.github.hitzaki.skin.constant.InitConstant;
import com.github.hitzaki.skin.constant.resource.ResourceCopyPathEnum;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * 初始化resource相关文件的工具
 * @author hitzaki
 */
public class ResourceInitUtil {

    public static void initWorkResource() throws RuntimeException{
        // 1.初始化工作区
        File resources = new File(InitConstant.WORK_SPACE);
        if ((resources.exists() || resources.mkdirs())){
            // TODO LOG
            System.out.println("工作目标目录已经存在");
        }
        // 2.初始化需要拷贝到工作区的每一个目录和资源
        for (ResourceCopyPathEnum needCopyPathEnum : ResourceCopyPathEnum.values()) {
            // 2.1.初始化目录
            File dir = new File(needCopyPathEnum.getDir());
            if ((dir.exists() || dir.mkdirs())){
                // TODO LOG
                System.out.println("工作目标目录已经存在");
            }
            // 2.2.拷贝文件
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(needCopyPathEnum.getRelativePath());
            if (Objects.isNull(inputStream)){
                return;
            }
            Path destPath = Paths.get(needCopyPathEnum.getAbsolutePath());
            try {
                Files.copy(inputStream, destPath);
            } catch (IOException e) {
                System.out.println("路径异常或重复创建: " + needCopyPathEnum.getAbsolutePath());
            }
        }
    }
}
