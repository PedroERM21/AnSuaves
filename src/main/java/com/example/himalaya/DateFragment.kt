package com.example.himalaya

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment

class DateFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_date, container, false)
        val regionInfoTextView = view.findViewById<TextView>(R.id.regionInfoTextView)
        val imageView = view.findViewById<ImageView>(R.id.regionImageView)
        val button = view.findViewById<Button>(R.id.buttonToCulture)

        regionInfoTextView.text = "Información sobre La Divina Comedia..."
        imageView.setImageResource(R.drawable.libro)


        var currentScale = 1f
        val scaleIncrement = 0.1f
        val maxScale = 2.0f


        imageView.setOnClickListener {
            if (currentScale < maxScale) {
                currentScale += scaleIncrement
                ObjectAnimator.ofFloat(imageView, "scaleX", currentScale).apply {
                    duration = 300
                    interpolator = DecelerateInterpolator()
                    start()
                }
                ObjectAnimator.ofFloat(imageView, "scaleY", currentScale).apply {
                    duration = 300
                    interpolator = DecelerateInterpolator()
                    start()
                }
            } else {

                currentScale = 1f
                ObjectAnimator.ofFloat(imageView, "scaleX", currentScale).start()
                ObjectAnimator.ofFloat(imageView, "scaleY", currentScale).start()


                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra("imageRes", R.drawable.libro)
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    requireActivity(),
                    imageView,
                    "sharedImageView"
                )
                startActivity(intent, options.toBundle())
            }
        }

        button.setOnClickListener {
            (activity as MainActivity).navigateToFragment(LibFragment())
        }

        return view
    }
}