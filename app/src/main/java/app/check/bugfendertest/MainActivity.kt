package app.check.bugfendertest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bugfender.sdk.Bugfender

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Bugfender.d("Test", "Hello world!") // you can also use Bugfender to log messages
        Log.d("myapp", "MainActivity onCreate")
    }
}
