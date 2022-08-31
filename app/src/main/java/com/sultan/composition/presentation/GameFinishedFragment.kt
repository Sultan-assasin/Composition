package com.sultan.composition.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sultan.composition.databinding.FragmentGameFinishedBinding
import java.lang.RuntimeException

private var _binding: FragmentGameFinishedBinding? = null
private val binding: FragmentGameFinishedBinding
    get() = _binding ?: throw RuntimeException("FragmentGameFinishedBinding == null")

class GameFinishedFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameFinishedBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}