package jesusjimsa.geco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class AvailableGestures extends AppCompatActivity {
	public ImageAdapter image_adapter_gestures = new ImageAdapter(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_available_gestures);

		GridView available_gestures_grid = findViewById(R.id.available_gestures);

		this.initializeGrid();
		available_gestures_grid.setAdapter(image_adapter_gestures);
		image_adapter_gestures.notifyDataSetChanged();

		available_gestures_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				Toast.makeText(AvailableGestures.this, "Gesture modified correctly", Toast.LENGTH_SHORT).show();
				finish();
			}
		});

	}

	private void initializeGrid(){
		image_adapter_gestures.addItem(R.drawable.gesture_image);
		image_adapter_gestures.addItem(R.drawable.gesture_image);
		image_adapter_gestures.addItem(R.drawable.gesture_image);
		image_adapter_gestures.addItem(R.drawable.gesture_image);
		image_adapter_gestures.addItem(R.drawable.gesture_image);
		image_adapter_gestures.addItem(R.drawable.gesture_image);
		image_adapter_gestures.addItem(R.drawable.gesture_image);

		if(image_adapter_gestures.getItem(0).equals(0)){
			image_adapter_gestures.deleteFirstItem();
		}
	}
}
