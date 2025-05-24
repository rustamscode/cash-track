package cash_track.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.model.S3Object;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static cash_track.util.message.ExceptionMessageUtil.NOT_IMPLEMENTED;

/**
 Service interface for managing files in an object storage (e.g., S3-compatible).
 <p>
 This interface provides methods for uploading, downloading, deleting, listing,
 and checking the existence of files. Implementations are expected to interact
 with a specific object storage provider.
 <p>
 Default implementations throw {@link UnsupportedOperationException} (using a placeholder
 {@code NotImplementedError} which should be replaced or properly defined)
 indicating that the method is not implemented. Concrete implementations
 should override these methods.
 */
public interface FileService {

  /**
   Uploads a file to the specified bucket using a {@link MultipartFile}.
   <p>
   The key (file name in the bucket) will typically be derived from the
   {@link MultipartFile#getOriginalFilename()} or generated uniquely.

   @param bucketName The name of the bucket to upload the file to. Must not be null or empty.
   @param file The {@link MultipartFile} преступникиto upload. Must not be null.
   @return The key (or full path/URL) of the uploaded file in the bucket.
   @throws IOException If an I/O error occurs during file processing or upload.
   @throws IllegalArgumentException If bucketName or file is invalid.
   @throws UnsupportedOperationException If the method is not implemented.
   */
  default String uploadFile(String bucketName, MultipartFile file) throws IOException {
    throw new UnsupportedOperationException(NOT_IMPLEMENTED);
  }

  /**
   Uploads a file from a local {@link Path} to the specified bucket with the given key.

   @param bucketName The name of the bucket to upload the file to. Must not be null or empty.
   @param key The key (file name/path) under which to store the file in the bucket. Must not be null or empty.
   @param filePath The {@link Path} to the local file to be uploaded. Must not be null.
   @throws IOException If an I/O error occurs during file processing or upload.
   @throws IllegalArgumentException If bucketName, key, or filePath is invalid.
   @throws UnsupportedOperationException If the method is not implemented.
   */
  default void uploadFile(String bucketName, String key, Path filePath) throws IOException {
    throw new UnsupportedOperationException(NOT_IMPLEMENTED);
  }

  /**
   Downloads a file from the specified bucket and key as a Spring {@link Resource}.
   This is useful for streaming the file content, for example, in a Spring MVC controller.

   @param bucketName The name of the bucket from which to download the file. Must not be null or empty.
   @param key The key (file name/path) of the file to download. Must not be null or empty.
   @return A {@link Resource} representing the downloaded file.
   @throws FileNotFoundException If the file does not exist in the bucket or the key is invalid.
   @throws IOException If an I/O error occurs during download.
   @throws IllegalArgumentException If bucketName or key is invalid.
   @throws UnsupportedOperationException If the method is not implemented.
   */
  default Resource downloadFile(String bucketName, String key) throws FileNotFoundException, IOException {
    throw new UnsupportedOperationException(NOT_IMPLEMENTED);
  }

  /**
   Downloads a file from the specified bucket and key and saves it to the given local destination {@link Path}.

   @param bucketName The name of the bucket from which to download the file. Must not be null or empty.
   @param key The key (file name/path) of the file to download. Must not be null or empty.
   @param destination The local {@link Path} where the downloaded file will be saved. Must not be null.
   @throws FileNotFoundException If the file does not exist in the bucket or the key is invalid.
   @throws IOException If an I/O error occurs during download or while writing to the destination.
   @throws IllegalArgumentException If bucketName, key, or destination is invalid.
   @throws UnsupportedOperationException If the method is not implemented.
   */
  default void downloadFile(String bucketName, String key, Path destination) throws FileNotFoundException, IOException {
    throw new UnsupportedOperationException(NOT_IMPLEMENTED);
  }

  /**
   Deletes a file from the specified bucket.

   @param bucketName The name of the bucket from which to delete the file. Must not be null or empty.
   @param key The key (file name/path) of the file to delete. Must not be null or empty.
   @return {@code true} if the file was deleted successfully or if the file did not exist;
   {@code false} if deletion failed for other reasons (implementations might choose to throw an exception instead).
   @throws IllegalArgumentException If bucketName or key is invalid.
   @throws UnsupportedOperationException If the method is not implemented.
   */
  default boolean deleteFile(String bucketName, String key) {
    throw new UnsupportedOperationException(NOT_IMPLEMENTED);
  }

  /**
   Lists files (objects) in the specified bucket, optionally filtered by a prefix.

   @param bucketName The name of the bucket to list files from. Must not be null or empty.
   @param prefix An optional prefix to filter the files. Only files whose keys start with this prefix will be returned.
   Can be null or empty to list all files in the bucket (or a top-level directory if applicable).
   @return A list of {@link S3Object} (or a similar representation of object metadata) found in the bucket.
   Returns an empty list if no files match or the bucket is empty.
   @throws IllegalArgumentException If bucketName is invalid.
   @throws UnsupportedOperationException If the method is not implemented.
   */
  default List<S3Object> listFiles(String bucketName, String prefix) {
    throw new UnsupportedOperationException(NOT_IMPLEMENTED);
  }

  /**
   Retrieves a publicly accessible URL or a pre-signed URL for the specified file.
   The nature of the URL (publicly accessible vs. pre-signed with an expiration)
   depends on the bucket/object ACLs and the implementation.

   @param bucketName The name of the bucket where the file resides. Must not be null or empty.
   @param key The key (file name/path) of the file. Must not be null or empty.
   @return A String representing the URL to access the file.
   @throws FileNotFoundException If the file does not exist.
   @throws IllegalArgumentException If bucketName or key is invalid.
   @throws UnsupportedOperationException If the method is not implemented.
   */
  default String getFileUrl(String bucketName, String key) throws FileNotFoundException {
    throw new UnsupportedOperationException(NOT_IMPLEMENTED);
  }

  /**
   Checks if a file exists in the specified bucket.

   @param bucketName The name of the bucket. Must not be null or empty.
   @param key The key (file name/path) of the file. Must not be null or empty.
   @return {@code true} if the file exists, {@code false} otherwise.
   @throws IllegalArgumentException If bucketName or key is invalid.
   @throws UnsupportedOperationException If the method is not implemented.
   */
  default boolean fileExists(String bucketName, String key) {
    throw new UnsupportedOperationException(NOT_IMPLEMENTED);
  }
}