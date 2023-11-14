package app.plauncher.helper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.plauncher.R

class FakeHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fake_home)
    }
}