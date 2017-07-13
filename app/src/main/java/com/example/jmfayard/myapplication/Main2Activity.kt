package com.example.jmfayard.myapplication

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import butterknife.ButterKnife
import butterknife.OnLongClick
import com.example.jmfayard.myapplication.databinding.ActivityMain2Binding
import dagger.Component
import dagger.Module
import dagger.Provides
import paperparcel.PaperParcel


class Main2Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        ButterKnife.bind(this)
    }

    @OnLongClick(R.id.fab)
    fun submit() : Boolean {
        Toast.makeText(this, "Replace with your own action", Toast.LENGTH_LONG).show()
        return true
    }

    fun dagger() {
        val component = DaggerComponent.create()
        component.hello()
    }


}


@PaperParcel
data class User(
        val id: Long,
        val firstName: String,
        val lastName: String
) : Parcelable {
    companion object {
        @JvmField val CREATOR = PaperParcelUser.CREATOR
    }

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        PaperParcelUser.writeToParcel(this, dest, flags)
    }
}
