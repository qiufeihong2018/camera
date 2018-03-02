package com.example.camera;

import java.io.IOException;

import android.hardware.Camera;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
Button btn1,btn2;
Camera ca;
SurfaceView sfv;
SurfaceHolder sfh;
boolean ispreview=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn1=(Button) this.findViewById(R.id.button1);
		btn1.setOnClickListener(new mclick());
		btn2=(Button) this.findViewById(R.id.button2);
		btn2.setOnClickListener(new mclick());
	}
	class mclick implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			if(v==btn1){
				initcamera();
			}
			else if(v==btn2){
				
				if(ca!=null||ispreview){
					ca.stopPreview();
					ca.release();
					ca=null;
					ispreview=false;
					
				}
			}
			
		}
		
	}
	public void initcamera(){
		if(!ispreview){
			ca=Camera.open();
			
		}
		if(ca!=null||!ispreview){
			try{
				ca.setPreviewDisplay(sfh);
				ca.startPreview();
			}
			catch(IOException e){
				e.printStackTrace();
			}
			ispreview=true;
			
		}
	}
public void surfaceChanged(SurfaceHolder holder,int format,int width,int height){}
public void surfaceCreated(SurfaceHolder holder){}
public void surfaceDestroyed(SurfaceHolder holder){}
}
