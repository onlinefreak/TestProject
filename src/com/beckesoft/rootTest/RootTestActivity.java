package com.beckesoft.rootTest;

import java.io.DataOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;

public class RootTestActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TextView tv = (TextView) findViewById(R.id.test);
        
        java.lang.Process p;
        try {
           p = Runtime.getRuntime().exec("su");
           DataOutputStream os = new DataOutputStream(p.getOutputStream());
           os.writeBytes("echo 'Hi Mom!!!!!!!!' >/system/ciccio.txtn");
           os.writeBytes("exitn");
           os.flush();
           try {
              p.waitFor();
                   if (p.exitValue() != 255) {
                      //tv.setText("OK!");
                	   boolean b = true;
                	   b = false;
                	   if (b)
                		   p.destroy();
                   }
                   else {
                      //tv.setText("Error");   
                   }
           } catch (InterruptedException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
           }
        } catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
           //fuck off
        }
    }
}