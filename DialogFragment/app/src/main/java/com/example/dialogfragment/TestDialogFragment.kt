package com.example.dialogfragment

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TestDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TestDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("타이틀 입니다.")
        builder.setMessage("메시지 입니다")

        var listener = DialogListener()

        builder.setPositiveButton("positive", listener)
        builder.setNeutralButton("neutral", listener)
        builder.setNegativeButton("negative", listener)

        var alert = builder.create()
        
        return alert
    }

    inner class DialogListener : DialogInterface.OnClickListener {
        override fun onClick(p0: DialogInterface?, p1: Int) {
            var main_activity = activity as MainActivity

            when(p1) {
                DialogInterface.BUTTON_POSITIVE -> {
                    main_activity.textView?.text = "positive"
                }
                DialogInterface.BUTTON_NEUTRAL -> {
                    main_activity.textView?.text = "neutral"
                }
                DialogInterface.BUTTON_NEGATIVE -> {
                    main_activity.textView?.text = "negative"
                }
            }
        }
    }

}