package dev.yamin.easylog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Locale;

import lib.yamin.easylog.EasyLog;
import lib.yamin.easylog.EasyLogFormatter;

public class MainActivity extends AppCompatActivity {

    private EasyLogFormatter easyLogFormatter;

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

        findViewById(R.id.main_btn_format).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (easyLogFormatter == null)
                    easyLogFormatter = new EasyLogFormatter() {
                        @Override
                        public String format(String classname, String methodName, int lineNumber) {
                            return String.format(Locale.getDefault(), "[%d] %s.%s() => ", lineNumber, classname, methodName);
                        }
                    };
                EasyLog.setFormatter(easyLogFormatter);
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