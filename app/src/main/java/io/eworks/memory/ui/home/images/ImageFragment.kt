package io.eworks.memory.ui.home.images

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.eworks.common.services.AdworksDataProvider
import io.eworks.memory.R


/**
 * A fragment representing a list of Items.
 */
class ImageFragment : Fragment() {

    private var columnCount = 1

    private var mListener: OnFragmentInteractionListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.image_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.image_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = context?.let { ImageRecyclerViewAdapter(it, AdworksDataProvider.sampleImages) }
//            with(recyclerView) {
//                layoutManager = when {
//                    columnCount <= 1 -> LinearLayoutManager(context)
//                    else -> GridLayoutManager(context, columnCount)
//                }
//                adapter = ImageRecyclerViewAdapter(context, AdworksDataProvider.sampleImages)
//            }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = if (context is OnFragmentInteractionListener) {
            context
        } else {
            throw RuntimeException(
                context.toString()
                        + " must implement OnFragmentInteractionListener"
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        Urls.getRandomUrl(5).httpGet()
//            .responseObject(WikiDataDeserializer()){ req, re, result ->
//                Log.d("Http Wiki API", result.toString())
//            }
//
//        Urls.AdworksImageApiUrl.httpGet()
//            .responseObject(ImageDataDeserializer()){ req, res, result ->
//                Log.d("Http Adworks Image API", result.toString())
//            }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "2"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ImageFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }


    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun messageFromChildFragment(uri: Uri?)
    }
}