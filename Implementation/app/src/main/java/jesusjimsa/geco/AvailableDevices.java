package jesusjimsa.geco;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Set;

public class AvailableDevices extends AppCompatActivity {
	public ImageAdapter image_adapter_available = new ImageAdapter(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_available_devices);

		GridView connected_devices_grid = findViewById(R.id.available_devices);

		this.initializeGrid();
		connected_devices_grid.setAdapter(image_adapter_available);
		image_adapter_available.notifyDataSetChanged();

		connected_devices_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				Intent intent = new Intent(AvailableDevices.this, DeviceDetailsAdd.class);
				String device_name = "";

				switch (position){
					case 0:
						device_name = "DVD";
						break;
					case 1:
						device_name = "TV";
						break;
					case 2:
						device_name = "Computer";
						break;
					case 3:
						device_name = "Kitchen robot";
						break;
					case 4:
						device_name = "Washing machine";
						break;
					case 5:
						device_name = "iPod";
						break;
				}

				intent.putExtra("device_name", device_name);
				startActivity(intent);
				finish();
			}
		});
	}

	private void initializeGrid(){
		image_adapter_available.addItem(R.drawable.dvd);
		image_adapter_available.addItem(R.drawable.tv);
		image_adapter_available.addItem(R.drawable.computer);
		image_adapter_available.addItem(R.drawable.kitchen);
		image_adapter_available.addItem(R.drawable.washing);
		image_adapter_available.addItem(R.drawable.ipod);

		if(image_adapter_available.getItem(0).equals(0)){
			image_adapter_available.deleteFirstItem();
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
