package com.example.kotlin_practice_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kotlin_practice_2.R

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        var videoView: VideoView = view.findViewById(R.id.videoView);

        videoView.setVideoPath("android.resource://"+ view.context.packageName +"/raw/cat_")
        videoView.start();

        // Кнопка для ручной навигации
        val manualNavigationButton: Button = view.findViewById(R.id.second_to_third)
        manualNavigationButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ThirdFragment())  // Используем replace
                .addToBackStack(null)  // Добавляем в стек
                .commit()
        }

        // Кнопка для навигации через Navigation API
        val apiNavigationButton: Button = view.findViewById(R.id.second_to_third_api)
        apiNavigationButton.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
        }

        return view
    }
}
