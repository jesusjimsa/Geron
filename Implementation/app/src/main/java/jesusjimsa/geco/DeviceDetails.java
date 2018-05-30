package jesusjimsa.geco;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DeviceDetails extends AppCompatActivity {
	private ListView list;

	private String[] gestures;
	private Integer[] imageId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_device_details);

		Intent intent = getIntent();
		final String device_name = intent.getStringExtra("device_name");

		TextView devices_name = findViewById(R.id.devices_name);
		devices_name.setText(device_name);

		initializeGestures(device_name);

		CustomList adapter = new CustomList(DeviceDetails.this, gestures, imageId);
		list = findViewById(R.id.gestures_list);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(DeviceDetails.this, GestureDetails.class);
				String gesture_name = gestures[position];

				intent.putExtra("gesture_name", gesture_name);
				intent.putExtra("device_name", device_name);

				startActivity(intent);
			}
		});
	}

	private void initializeGestures(String device_type){
		if(device_type.equals("DVD")){
			gestures = new String[4];
			imageId = new Integer[4];

			gestures[0] = "Play";
			gestures[1] = "Pause";
			gestures[2] = "Forward";
			gestures[3] = "Backwards";

			for(int i = 0; i < 4; i++){
				imageId[i] = R.drawable.gesture_image;
			}
		}
		else{
			if(device_type.equals("TV")){
				gestures = new String[4];
				imageId = new Integer[4];

				gestures[0] = "Volume up";
				gestures[1] = "Volume down";
				gestures[2] = "Next channel";
				gestures[3] = "Previous channel";

				for(int i = 0; i < 4; i++){
					imageId[i] = R.drawable.gesture_image;
				}
			}
			else{
				if(device_type.equals("Computer")) {
					gestures = new String[5];
					imageId = new Integer[5];

					gestures[0] = "Back/Undo";
					gestures[1] = "Forward/Redo";
					gestures[2] = "Scroll up";
					gestures[3] = "Scroll down";
					gestures[4] = "Close window";

					for (int i = 0; i < 5; i++) {
						imageId[i] = R.drawable.gesture_image;
					}
				}
				else{
					if(device_type.equals("Kitchen robot")){
						gestures = new String[2];
						imageId = new Integer[2];

						gestures[0] = "Start";
						gestures[1] = "Stop";


						for(int i = 0; i < 2; i++){
							imageId[i] = R.drawable.gesture_image;
						}
					}
					else{
						if(device_type.equals("Washing machine")){
							gestures = new String[2];
							imageId = new Integer[2];

							gestures[0] = "Start";
							gestures[1] = "Stop";


							for(int i = 0; i < 2; i++){
								imageId[i] = R.drawable.gesture_image;
							}
						}
						else{
							if(device_type.equals("iPod")){
								gestures = new String[4];
								imageId = new Integer[4];

								gestures[0] = "Play";
								gestures[1] = "Pause";
								gestures[2] = "Next song";
								gestures[3] = "Previous song";

								for(int i = 0; i < 4; i++){
									imageId[i] = R.drawable.gesture_image;
								}
							}
						}
					}
				}
			}
		}
	}
}
