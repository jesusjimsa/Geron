package jesusjimsa.geco;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


/*
* Class implementation inspired by:
* https://www.learn2crack.com/2013/10/android-custom-listview-images-text-example.html
* */
public class CustomList extends ArrayAdapter {
	private final Activity context;
	private final String[] web;
	private final Integer[] imageId;
	private static int image_desc_id = 0;

	public CustomList(Activity context, String[] web, Integer[] imageId) {
		super(context, R.layout.gestures_list_item, web);
		this.context = context;
		this.web = web;
		this.imageId = imageId;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView= inflater.inflate(R.layout.gestures_list_item, null, true);
		TextView txtTitle = rowView.findViewById(R.id.txt);

		ImageView imageView = rowView.findViewById(R.id.img);
		txtTitle.setText(web[position]);

		imageView.setImageResource(imageId[position]);
		imageView.setContentDescription("Gesture image " + String.valueOf(image_desc_id));

		image_desc_id++;

		return rowView;
	}
}
