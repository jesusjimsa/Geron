package jesusjimsa.geco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

public class GestureDetails extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gesture_details);

		Intent intent = getIntent();
		final String device_name = intent.getStringExtra("device_name");
		final String gesture_name = intent.getStringExtra("gesture_name");

		TextView devices_name = findViewById(R.id.device_name);
		devices_name.setText(device_name);

		TextView gesture_action = findViewById(R.id.gesture_action);
		gesture_action.setText(gesture_name);

		ImageView edit_button = findViewById(R.id.edit_button);

		edit_button.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				Intent intent = new Intent(GestureDetails.this, AvailableGestures.class);
				startActivity(intent);
			}
		});
	}
}
