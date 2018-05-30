package jesusjimsa.geco;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.Arrays;

public class ImageAdapter extends BaseAdapter {
	private Context mContext;
	private static int image_desc_id = 0;

	/*
	* The array of Integers has to be declared with at least one element,
	* if it's not done this way, the getView method throws an error.
	*
	* The
	* */
	// references to the images
	private Integer[] mThumbIds = {0};

	public ImageAdapter(Context c) {
		mContext = c;
	}

	public int getCount() {
		return mThumbIds.length;
	}

	public Object getItem(int position) {
		return mThumbIds[position];
	}

	public long getItemId(int position) {
		return 0;
	}

	public void addItem(Integer item){
		mThumbIds = append(mThumbIds, item);
	}

	public void deleteFirstItem(){
		if(mThumbIds[0] == 0){
			final int N = mThumbIds.length;
			Integer[] array = mThumbIds.clone();

			mThumbIds = new Integer[N - 1];

			for(int i = 1; i < N; i++){
				mThumbIds[i-1] = array[i];
			}
		}
	}

	/*
	* Source of this method: https://stackoverflow.com/a/2843373/7071193
	* */
	private static <T> T[] append(T[] arr, T element) {
		final int N = arr.length;

		arr = Arrays.copyOf(arr, N + 1);
		arr[N] = element;

		return arr;
	}

	@Override
	public void notifyDataSetChanged(){
		super.notifyDataSetChanged();
	}

	// create a new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;

		if (convertView == null) {
			// if it's not recycled, initialize some attributes
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new ViewGroup.LayoutParams(300, 300));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(8, 8, 8, 8);
			imageView.setContentDescription("Device icon " + String.valueOf(image_desc_id));

			image_desc_id++;
		}
		else {
			imageView = (ImageView) convertView;
		}

		imageView.setImageResource(mThumbIds[position]);

		return imageView;
	}
}
