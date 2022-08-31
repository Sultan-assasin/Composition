package com.sultan.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.sultan.composition.R
import com.sultan.composition.databinding.FragmentChooseLevelBinding
import com.sultan.composition.domain.entity.Level

class ChooseLevelFragment : Fragment() {
    private lateinit var btn : Button
    private var _binding: FragmentChooseLevelBinding? = null
    private val binding: FragmentChooseLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseLevelBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    private fun launchChooseLevelFragment(level: Level) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, GameFragment().newInstance(level))
            .addToBackStack(null)
            .commit()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun newInstance(): ChooseLevelFragment{
        return ChooseLevelFragment()
    }

}