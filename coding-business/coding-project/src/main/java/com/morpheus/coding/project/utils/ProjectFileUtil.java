package com.morpheus.coding.project.utils;

import com.morpheus.coding.footstone.core.exception.file.FileNameLengthLimitExceededException;
import com.morpheus.coding.footstone.core.exception.file.FileSizeLimitExceededException;
import com.morpheus.coding.footstone.core.exception.file.InvalidExtensionException;
import com.morpheus.coding.footstone.core.utils.file.FileUploadUtils;
import com.morpheus.coding.footstone.security.utils.SecurityUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * @author morpheus
 * @description ProjectFileUtil
 * @date 2025年6月27日21:38:59
 */
public class ProjectFileUtil {
    public static String uploadProjectFile(String baseDir, MultipartFile file, String[] allowedExtension)
            throws FileSizeLimitExceededException, IOException, FileNameLengthLimitExceededException,
            InvalidExtensionException {

        if (Objects.requireNonNull(file.getOriginalFilename()).length() > FileUploadUtils.DEFAULT_FILE_NAME_LENGTH) {
            throw new FileNameLengthLimitExceededException(FileUploadUtils.DEFAULT_FILE_NAME_LENGTH);
        }

        FileUploadUtils.assertAllowed(file, allowedExtension);

        String fileName = FileUploadUtils.extractFileName(SecurityUtils.getUsername(), file);

        String absPath = FileUploadUtils.getAbsoluteFile(baseDir, fileName).getAbsolutePath();
        file.transferTo(Paths.get(absPath));
        return FileUploadUtils.getPathFileName(baseDir, fileName);
    }

    public static String uploadTaskFile(String baseDir, MultipartFile file, String[] allowedExtension)
            throws FileSizeLimitExceededException, IOException, FileNameLengthLimitExceededException,
            InvalidExtensionException {

        int fileNameLength = Objects.requireNonNull(file.getOriginalFilename()).length();
        if (fileNameLength > FileUploadUtils.DEFAULT_FILE_NAME_LENGTH) {
            throw new FileNameLengthLimitExceededException(FileUploadUtils.DEFAULT_FILE_NAME_LENGTH);
        }

        FileUploadUtils.assertAllowed(file, allowedExtension);

        String fileName = FileUploadUtils.extractFileName(SecurityUtils.getUsername(), file);

        String absPath = FileUploadUtils.getAbsoluteFile(baseDir, fileName).getAbsolutePath();
        file.transferTo(Paths.get(absPath));
        return FileUploadUtils.getPathFileName(baseDir, fileName);
    }

    public static String getPathName(String uploadDir, MultipartFile file) throws IOException {
        String fileName = FileUploadUtils.extractFileName(SecurityUtils.getUsername(), file);
        return uploadDir + "/" + fileName;
    }
}
