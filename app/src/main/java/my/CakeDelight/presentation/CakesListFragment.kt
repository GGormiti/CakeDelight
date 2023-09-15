package my.CakeDelight.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import my.CakeDelight.databinding.FragmentCakesListBinding


@AndroidEntryPoint
class CakesListFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()

    private var _binding: FragmentCakesListBinding? = null
    private val binding get() = _binding!!
    private val cakeAdapter: CakeAdapter = CakeAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCakesListBinding.inflate(inflater, container, false)

        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = cakeAdapter

        viewModel.getLiveDataObserve().observe(viewLifecycleOwner){
            if (it != null){
                cakeAdapter.setListCake(it)
                cakeAdapter.notifyDataSetChanged()
            } else{
                Toast.makeText(
                    requireContext(),
                    "error in getting data from server",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        viewModel.loadCakeList()


    }



}