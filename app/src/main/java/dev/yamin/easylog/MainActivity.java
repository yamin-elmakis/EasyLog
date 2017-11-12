package dev.yamin.easylog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import lib.yamin.easylog.EasyLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EasyLog.showLogs(BuildConfig.DEBUG);
        EasyLog.setDefaultText("default");
        EasyLog.setTag("Logger");

        setContentView(R.layout.activity_main);

        EasyLog.d();
        EasyLog.e(new RuntimeException("Exception example"));
        InnerClass test = new InnerClass();
        test.log();

        findViewById(R.id.main_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EasyLog.d();
            }
        });
    }

    private class InnerClass {

        void log(){
            EasyLog.i(this);
        }

        @Override
        public String toString() {
            return "InnerClass{}";
        }
    }
}