package com.interview.evaluationproject.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;
import java.util.HashMap;

import com.interview.evaluationproject.interfaces.ImageLoaderListener;
import com.interview.evaluationproject.manager.AppManager;
import com.interview.evaluationproject.utils.Log;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ImageView;

public class ImageLoader {

	private Context context;
	private static HashMap<String, Bitmap> cache = new HashMap<String, Bitmap>();
	private ImageLoaderListener listener;
	private String url;

	private int mWidth = 100;
	private int mHeight = 100;

	public ImageLoader() {
		context = AppManager.getInstance().getApplicationContext();
	}

	public Bitmap loadImage(String url, ImageLoaderListener listener,
			int width, int height) {
		//mWidth = width;
		//mHeight = height;
		return loadImage(url, listener);
	}

	public Bitmap loadImage(String url, ImageLoaderListener listener) {
		if (url != null) {
			Log.e("Image loader", url);
			this.listener = listener;
			this.url = url;
			String filename = getFileName(url);
			if (filename != null) {
				if (cache.containsKey(generateImageCacheKey(filename))) {
					return cache.get(generateImageCacheKey(filename));
				}
				new LoadImage().execute();

			}
		}
		return null;
	}

	public String getFileName(String url) {
		URL u;
		try {
			if (url.startsWith("http") || url.startsWith("https") || url.startsWith("file")) {
				u = new URL(url);
				url = u.getPath();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url.replaceAll("[.:/,%?&=]", "+").replaceAll("[+]+", "+");
	}

	private String getFullImageUrl(String partUrl) {
		return partUrl;
	}

	public static int calculateInSampleSize(BitmapFactory.Options options,
			int reqWidth, int reqHeight) {
		// Raw height and width of image
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;

		if (height > reqHeight || width > reqWidth) {

			final int halfHeight = height / 2;
			final int halfWidth = width / 2;

			// Calculate the largest inSampleSize value that is a power of 2 and
			// keeps both
			// height and width larger than the requested height and width.
			while ((halfHeight / inSampleSize) > reqHeight
					&& (halfWidth / inSampleSize) > reqWidth) {
				inSampleSize *= 2;
			}
		}
		return inSampleSize;
	}

	private class LoadImage extends AsyncTask<Void, Void, Bitmap> {

		@Override
		protected Bitmap doInBackground(Void... arg0) {
			String filename = getFileName(url);
			Bitmap bitmap = readImageFromFile(filename);
			if (bitmap != null) {
				return bitmap;
			}
			// schedule image for download
			try {
				bitmap = BitmapFactory.decodeStream((InputStream) new URL(
						getFullImageUrl(url)).getContent());
				File filetosave = new File(context.getFilesDir(),
						getFileName(url));
				try {
					filetosave.createNewFile();
				} catch (IOException e) {
					Log.e("ImageLoader", "Not able to create file");
				}
				try {
					FileOutputStream outputstream = new FileOutputStream(
							filetosave);
					bitmap.compress(CompressFormat.PNG, 100, outputstream);
					outputstream.flush();
					outputstream.close();
					bitmap = readImageFromFile(filename);
					return bitmap;
				} catch (FileNotFoundException e) {
					Log.e("ImageLoader", "File not found");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					Log.e("ImageLoader", "IO Exception");
				}
				return bitmap;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Log.e("Error loading image", e.getMessage());
			}
			return null;
		}

		@Override
		protected void onPostExecute(Bitmap bitmap) {
			if (listener != null && bitmap != null) {
				cache.put(generateImageCacheKey(getFileName(url)), bitmap);
				listener.imageLoaded(bitmap);
			}
		}

		private Bitmap readImageFromFile(String filename) {
			File file = new File(context.getFilesDir(), filename);
			BufferedInputStream buffer = null;
			BitmapFactory.Options options = null;
			if (file.exists()) {
				InputStream fileinputstream = null;
				try {
					fileinputstream = new FileInputStream(file);
					buffer = new BufferedInputStream(fileinputstream);
					options = new BitmapFactory.Options();
					options.inJustDecodeBounds = true;
					BitmapFactory.decodeStream(buffer, null, options);
					options.inSampleSize = calculateInSampleSize(options,
							mWidth, mHeight);
					options.inJustDecodeBounds = false;
					//buffer.mark(buffer.available());
					buffer.reset();
					Bitmap bitmap = BitmapFactory.decodeStream(buffer, null,
							options);
					return bitmap;
				} catch (FileNotFoundException e) {
					Log.e("Image loader", "file not found will download image");
				} catch (IOException i) {
					Log.e("Image loader", i.getMessage());
					try {
						buffer.close();
						fileinputstream.close();
						fileinputstream = new FileInputStream(file);
						options.inPreferredConfig = Config.RGB_565;
						//options.inSampleSize = 8;
						if (fileinputstream != null) {
							buffer = new BufferedInputStream(fileinputstream);
							Bitmap bitmap = BitmapFactory.decodeStream(buffer,
									null, options);
							return bitmap;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
			return null;
		}

	}

	private String generateImageCacheKey(String filename) {
		return String.format(filename + "w%sh%s", String.valueOf(mWidth),
				String.valueOf(mHeight));
	}
}
