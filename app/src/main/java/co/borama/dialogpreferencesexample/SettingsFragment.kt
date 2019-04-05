package co.borama.dialogpreferencesexample

import android.os.Bundle
import android.support.v7.preference.Preference
import android.support.v7.preference.PreferenceFragmentCompat
import android.widget.Toast

class SettingsFragment: PreferenceFragmentCompat() {

    override fun onCreatePreferences(p0: Bundle?, p1: String?) {
        setPreferencesFromResource(R.xml.prefs, p1)
    }

    override fun onDisplayPreferenceDialog(preference: Preference?) {
        val clearRecentDialog = preference as? DialogClearRecentSearches
        if (clearRecentDialog != null) {
            val dialogFragment = DialogPrefCompat.newInstance(clearRecentDialog.key)
            dialogFragment.setTargetFragment(this, 0)
            dialogFragment.positiveResult = {
                Toast.makeText(activity, "yes", Toast.LENGTH_LONG).show()
            }
            dialogFragment.show(fragmentManager, null)
        } else {
            super.onDisplayPreferenceDialog(preference)
        }
    }
}