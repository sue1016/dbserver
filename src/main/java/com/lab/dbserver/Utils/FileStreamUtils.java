package com.lab.dbserver.Utils;
import org.apache.commons.io.IOUtils;
import org.springframework.mock.web.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileStreamUtils {
    public static byte[] converFileToBytes(File file) throws IOException{
        InputStream inputStream = new FileInputStream(file);
        return IOUtils.toByteArray(inputStream);
    }

    public static Integer saveMultipartFile(MultipartFile multipartFile,String fileDirpath,String filepath)throws IOException{
            if (!new File(fileDirpath).exists()) {
                if (new File(fileDirpath).mkdirs()) {
                    byte[] bytes = multipartFile.getBytes();
                    Path path = Paths.get(filepath);
                    Files.write(path, bytes);
                }
                return -1;
            }
            else {
                byte[] bytes = multipartFile.getBytes();
                Path path = Paths.get(filepath);
                Files.write(path,bytes);
                return 1;
            }
    }
}
