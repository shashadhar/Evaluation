package com.interview.evaluationproject.view;

import com.interview.evaluationproject.R;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

public class NetworkErrorDialog extends DialogFragment {
	String errorMessage;
	Context m_context;

	public NetworkErrorDialog(Context context, String errorMessage) {
		this.m_context = context;
		this.errorMessage = errorMessage;
	}

	public NetworkErrorDialog(Context context) {
		this.m_context = context;
		this.errorMessage = m_context.getString(
				R.string.network_error_message);
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Use the Builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle(m_context.getString(R.string.network_error_title))
				.setMessage(this.errorMessage)
				.setPositiveButton(
						m_context.getString(R.string.network_settings),
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// open settings
								m_context.startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
							}
						})
				.setNegativeButton(
						m_context.getString(R.string.network_cancel),
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								NetworkErrorDialog.this.getDialog().cancel();
							}
						});

		return builder.create();
	}
}
