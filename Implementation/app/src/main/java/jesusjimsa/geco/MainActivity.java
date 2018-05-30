package jesusjimsa.geco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
	private ImageAdapter image_adapter_main = new ImageAdapter(this);

	GridView connected_devices_grid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ImageView add_button = findViewById(R.id.add_button);
		connected_devices_grid = findViewById(R.id.connected_devices);

		initializeGrid();
		connected_devices_grid.setAdapter(image_adapter_main);

		connected_devices_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				Intent intent = new Intent(MainActivity.this, DeviceDetails.class);
				String device_name = "";

				switch (position){
					case 0:
						device_name = "Computer";
						break;
					case 1:
						device_name = "Kitchen robot";
						break;
					case 2:
						device_name = "TV";
						break;
					case 3:
						device_name = "Washing machine";
						break;
					case 4:
						device_name = "DVD";
						break;
					case 5:
						device_name = "iPod";
						break;
				}

				intent.putExtra("device_name", device_name);
				startActivity(intent);
			}
		});

		add_button.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, AvailableDevices.class);
				startActivity(intent);
			}
		});
	}

	private void initializeGrid(){
		image_adapter_main.addItem(R.drawable.computer);
		image_adapter_main.addItem(R.drawable.kitchen);
		image_adapter_main.addItem(R.drawable.tv);
		image_adapter_main.addItem(R.drawable.washing);
		image_adapter_main.addItem(R.drawable.dvd);

		if(image_adapter_main.getItem(0).equals(0)){
			image_adapter_main.deleteFirstItem();
		}
	}

	@Override
	public void onStart(){
		// call the superclass method first
		super.onStart();
	}

	@Override
	public void onResume() {
		// Always call the superclass method first
		super.onResume();
	}

	@Override
	public void onPause() {
		// Always call the superclass method first
		super.onPause();
	}

	@Override
	protected void onStop() {
		// Always call the superclass method first
		super.onStop();
	}

	@Override
	public void onDestroy(){
		// Always call the superclass method first
		super.onDestroy();
	}
}
