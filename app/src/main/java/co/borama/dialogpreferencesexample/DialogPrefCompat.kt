package co.borama.dialogpreferencesexample

//DialogPrefCompat.kt
import android.os.Bundle
import android.support.v7.preference.PreferenceDialogFragmentCompat

class DialogPrefCompat : PreferenceDialogFragmentCompat() {

    lateinit var positiveResult: ()->Unit

    override fun onDialogClosed(positiveResult: Boolean) {
        if (positiveResult) {
            positiveResult()
        }
    }

    companion object {
        fun newInstance(key: String): DialogPrefCompat {
            val fragment = DialogPrefCompat()
            val bundle = Bundle(1)
            bundle.putString(PreferenceDialogFragmentCompat.ARG_KEY, key)
            fragment.arguments = bundle
            return fragment
        }
    }
}