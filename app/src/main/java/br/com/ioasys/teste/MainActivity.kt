package br.com.ioasys.teste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        // Set app toolbar.
        setSupportActionBar(findViewById(R.id.toolbar))
    }

}
