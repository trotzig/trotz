package trotz;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;

import org.apache.commons.io.IOUtils;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreFailureException;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.files.AppEngineFile;
import com.google.appengine.api.files.FileReadChannel;
import com.google.appengine.api.files.FileService;
import com.google.appengine.api.files.FileServiceFactory;
import com.google.appengine.api.files.FileWriteChannel;
import com.google.appengine.api.files.LockException;
import com.google.gdata.util.ResourceNotFoundException;
import com.google.gdata.util.common.util.Base64;
import com.google.gdata.util.common.util.Base64DecoderException;

public class BlobStoreUtil {

	@SuppressWarnings("serial")
	public static class UnableToStoreBlobException extends RuntimeException {
		public UnableToStoreBlobException(String message) {
			super(message);
		}

		public UnableToStoreBlobException(String message, Throwable cause) {
			super(message, cause);
		}
	}

	/**
	 * Hämtar data från en URL och sparar ner i blobstoren
	 * 
	 * @param url
	 * @return
	 * @throws ResourceNotFoundException
	 *             in case the provided url is invalid (responds with 404 or
	 *             some 50x response)
	 * @throws MalformedURLException
	 */
	public static BlobKey createBlobFromURL(String url)
			throws UnableToStoreBlobException, IOException,
			ResourceNotFoundException {
		URL theURL;
		String contentType = null;

		theURL = new URL(url);

		HttpURLConnection connection = (HttpURLConnection) theURL
				.openConnection();

		if (connection.getResponseCode() != 200) {
			throw new ResourceNotFoundException("Error response, "
					+ connection.getResponseCode());
		}

		contentType = connection.getContentType();
		InputStream in = connection.getInputStream();
		return createBlobFromInputStream(in, contentType);

	}

	/**
	 * Sparar en blob i blobstoren från en inputstream
	 * 
	 * @param in
	 * @param contentType
	 * @return
	 * @throws IOException
	 */
	public static BlobKey createBlobFromInputStream(InputStream in,
			String contentType) throws UnableToStoreBlobException {
		FileService fService = FileServiceFactory.getFileService();

		try {
			AppEngineFile blobFile = fService.createNewBlobFile(contentType);

			// open channel to blobstore
			FileWriteChannel writeChannel = fService.openWriteChannel(blobFile,
					true);
			OutputStream out = Channels.newOutputStream(writeChannel);

			IOUtils.copy(in, out);

			writeChannel.closeFinally();
			out.close();
			in.close();

			// get blobkey
			return fService.getBlobKey(blobFile);
		} catch (IOException e) {
			throw new UnableToStoreBlobException(e.getMessage(), e);
		}
	}

	/**
	 * Skapar en blob från en base64-encodad sträng
	 * 
	 * @param data
	 * @param contentType
	 * @return
	 * @throws UnableToStoreBlobException
	 */
	public static BlobKey createBlobFromBase64EncodedBytes(String data,
			String contentType) throws UnableToStoreBlobException {
		byte[] bytes;
		try {
			bytes = Base64.decode(data);
		} catch (Base64DecoderException e) {
			throw new UnableToStoreBlobException("Failed to base64 decode", e);
		}
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		return createBlobFromInputStream(in, contentType);
	}

	/**
	 * Hämtar en blob som en bytearray
	 * 
	 * @param blobKey
	 * @return
	 * @throws IOException 
	 * @throws LockException 
	 */
	public static byte[] getBlobAsByteArray(BlobKey blobKey) throws LockException, IOException {
		FileService fService = FileServiceFactory.getFileService();
		AppEngineFile file = fService.getBlobFile(blobKey);
		FileReadChannel readChannel = fService.openReadChannel(file, false);
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		InputStream is = Channels.newInputStream(readChannel);
		IOUtils.copy(is, byteOut);
		readChannel.close();
		byteOut.close();
		return byteOut.toByteArray();
	}

	public static void deleteBlob(BlobKey key) {
		try {
			BlobstoreService blobStore = BlobstoreServiceFactory
					.getBlobstoreService();
			blobStore.delete(key);
		} catch (BlobstoreFailureException e) {
			throw new RuntimeException("error when delete from blobstore  " + e.getMessage(), e);
		}

	}

}
